package md.vcroitor.licenta.client.http;

import android.os.AsyncTask;
import org.apache.http.impl.client.DefaultHttpClient;
import org.springframework.http.*;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.http.converter.StringHttpMessageConverter;
import org.springframework.web.client.RestTemplate;

/**
 * User: Vitalie Croitor
 * Date: 5/4/13
 * Time: 4:44 PM
 */
public class AsyncHttpRequest extends AsyncTask<String, Void, String> {

    private AsyncHttpResponseListener listener;

    public AsyncHttpRequest(AsyncHttpResponseListener listener) {
        this.listener = listener;
    }

    @Override
    protected String doInBackground(String... params) {
        String url = params[0];
        String data = params[1];
        String method = params[2];

        try{
        final HttpHeaders requestHeaders = new HttpHeaders();
        requestHeaders.setContentType(MediaType.APPLICATION_JSON);
        final HttpEntity requestEntity = new HttpEntity(data, requestHeaders);
        final RestTemplate restTemplate = new RestTemplate();
        HttpComponentsClientHttpRequestFactory factory = new HttpComponentsClientHttpRequestFactory();
        factory.setReadTimeout(10000);
        factory.setConnectTimeout(10000);
        restTemplate.setRequestFactory(factory);
        restTemplate.getMessageConverters().add(new StringHttpMessageConverter());

        final ResponseEntity<String> httpResponse = restTemplate.exchange(url, HttpMethod.valueOf(method), requestEntity, String.class);

        if (httpResponse.getStatusCode() == HttpStatus.OK) {
            return httpResponse.getBody();
        }
        } catch (Exception ex){
            ex.printStackTrace();
        }
        return null;
    }

    @Override
    protected void onPostExecute(final String response) {
       listener.onResult(response);
    }
}
