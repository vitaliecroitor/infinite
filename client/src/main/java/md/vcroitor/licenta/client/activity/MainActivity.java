package md.vcroitor.licenta.client.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import md.vcroitor.licenta.client.R;

public class MainActivity extends Activity {

    private static String TAG = "client";

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.i(TAG, "onCreate");
        setContentView(R.layout.main);
        startActivity(new Intent(MainActivity.this, PagerSlidingActivity.class));
    }
}
