package md.vcroitor.licenta.client.fragment;

import android.os.Bundle;
import android.support.v4.app.ListFragment;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import md.vcroitor.licenta.client.R;
import md.vcroitor.licenta.client.activity.PagerSlidingActivity;
import md.vcroitor.licenta.client.adapter.FavoriteListAdapter;
import md.vcroitor.licenta.client.domain.Favorite;

import java.util.ArrayList;
import java.util.List;

/**
 * User: Vitalie Croitor
 * Date: 5/3/13
 * Time: 11:46 AM
 */
public class FavoriteFragment extends ListFragment {

    private FavoriteListAdapter adapter;
    private PagerSlidingActivity parent;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        List<Favorite> favorites = new ArrayList<Favorite>();


        Favorite game = new Favorite();
        game.setName("Game World");
        game.setUri("http://s.zumzi.com/md/place/a/0/a0bb35776dcb1924b984d3b4c03850b8_1_square.jpg");

        Favorite cinema = new Favorite();
        cinema.setName("Autocinema");
        cinema.setUri("http://s.zumzi.com/md/provider/square/c4e69b3070c8ae3a3617e0037667923b.jpg");

        Favorite passo = new Favorite();
        passo.setName("El Paso");
        passo.setUri("http://s.zumzi.com/md/place/b/6/b6f43027a4b86bb1538fc6d06dfc7683_1_square.jpg");

        favorites.add(passo);
        favorites.add(cinema);
        favorites.add(game);

        parent = (PagerSlidingActivity) getActivity();
        adapter = new FavoriteListAdapter(getActivity(), favorites);
        setListAdapter(adapter);
        parent.getSearchField().addTextChangedListener(watcher);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout containing a title and body text.
        return inflater.inflate(R.layout.favorite_fragment, container, false);
    }

    private TextWatcher watcher = new TextWatcher() {
        @Override
        public void beforeTextChanged(CharSequence s, int start, int count, int after) {
        }

        @Override
        public void onTextChanged(CharSequence s, int start, int before, int count) {
        }

        @Override
        public void afterTextChanged(Editable s) {
            doFavoriteSearch(s.toString().trim());
        }
    };

    private void doFavoriteSearch(String key) {
        adapter.getFilter().filter(key);
    }
}
