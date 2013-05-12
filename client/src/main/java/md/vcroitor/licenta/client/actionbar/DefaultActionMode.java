package md.vcroitor.licenta.client.actionbar;

import com.actionbarsherlock.view.ActionMode;
import com.actionbarsherlock.view.Menu;
import com.actionbarsherlock.view.MenuItem;
import md.vcroitor.licenta.client.R;

/**
 * User: Vitalie Croitor
 * Date: 5/12/13
 * Time: 12:34 PM
 */
public class DefaultActionMode implements ActionMode.Callback {
    @Override
    public boolean onCreateActionMode(ActionMode actionMode, Menu menu) {
        menu.add("Test").setIcon(R.drawable.icon).setShowAsAction(MenuItem.SHOW_AS_ACTION_ALWAYS);
        return true;
    }

    @Override
    public boolean onPrepareActionMode(ActionMode actionMode, Menu menu) {
        return false;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public boolean onActionItemClicked(ActionMode actionMode, MenuItem menuItem) {
        return false;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public void onDestroyActionMode(ActionMode actionMode) {
        //To change body of implemented methods use File | Settings | File Templates.
    }
}
