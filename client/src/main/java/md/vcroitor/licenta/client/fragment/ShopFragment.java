package md.vcroitor.licenta.client.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import md.vcroitor.licenta.client.R;
import md.vcroitor.licenta.client.helper.Logger;
import md.vcroitor.licenta.client.http.AsyncHttpRequest;
import md.vcroitor.licenta.client.http.AsyncHttpResponseListener;
import md.vcroitor.licenta.common.dto.PromotionDTO;
import md.vcroitor.licenta.common.dto.Request;
import md.vcroitor.licenta.common.dto.Response;
import org.springframework.http.HttpMethod;

import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

import static md.vcroitor.licenta.client.helper.JsonSkipper.fromJsonSet;

/**
 * User: Vitalie Croitor
 * Date: 5/1/13
 * Time: 2:51 PM
 */
public class ShopFragment extends Fragment {

    private static final Logger log = new Logger(ShopFragment.class);
    Button button;
    View.OnClickListener btnClick = new View.OnClickListener() {

        @Override
        public void onClick(View v) {
            makeRequest();
        }
    };

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout containing a title and body text.
        View view = inflater.inflate(R.layout.shop_fragment, container, false);
        button = (Button) view.findViewById(R.id.btn_req);
        button.setOnClickListener(btnClick);
        return view;
    }

    private void makeRequest() {
        AsyncHttpRequest asyncHttpRequest = new AsyncHttpRequest(new AsyncHttpResponseListener() {
            @Override
            public void onResult(String response) {
                try {
                    Response<Set<PromotionDTO>> result = fromJsonSet(response, new TypeReference<Response<HashSet<PromotionDTO>>>() {
                    });
                    result.getObject();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });
        Request<String> request = new Request<String>("5185539d44ae65d09ed693fb");
        ObjectMapper objectMapper = new ObjectMapper();
        String json = "";
        try {
            json = objectMapper.writeValueAsString(request);
        } catch (JsonProcessingException e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        }
        asyncHttpRequest.execute(getResources().getString(R.string.basic_url) + "/promotion/getByShop", json, HttpMethod.POST.toString());
    }

}
