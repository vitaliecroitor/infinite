package md.vcroitor.licenta.client.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import md.vcroitor.licenta.client.R;

public class MainActivity extends Activity {

    private static String TAG = "client";

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.i(TAG, "onCreate");
        setContentView(R.layout.main);

        int secondsDelayed = 5;
        new Handler().postDelayed(new Runnable() {
            public void run() {
                startActivity(new Intent(MainActivity.this, PagerSlidingActivity.class));
                finish();
            }
        }, secondsDelayed * 1000);
    }
}
