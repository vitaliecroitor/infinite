package md.vcroitor.licenta.client.activity;

import android.os.Bundle;
import android.widget.HorizontalScrollView;
import com.actionbarsherlock.app.SherlockActivity;
import md.vcroitor.licenta.client.R;
import md.vcroitor.licenta.client.adapter.PromotionImagePageAdapter;

import java.util.ArrayList;
import java.util.List;

/**
 * User: Vitalie Croitor
 * Date: 5/10/13
 * Time: 1:31 PM
 */
public class PromotionActivity extends SherlockActivity {

    private HorizontalScrollView horizontalScrollView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.promotion_activity);
        HorizontalScrollView horizontalScrollView = (HorizontalScrollView) findViewById(R.id.pager);
        List<String> list = new ArrayList<String>();
        list.add("dsfasdf");
        list.add("fdsafg");
        list.add("dsfasdf");
        list.add("fdsafg");
        list.add("dsfasdf");
        list.add("fdsafg");

    }
}
