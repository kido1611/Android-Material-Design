package id.kido1611.drawerwithrecyclerview;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;

import id.kido1611.drawerwithrecyclerview.fragment.FragmentDrawer;
import id.kido1611.drawerwithrecyclerview.fragment.PageFragment;
import id.kido1611.drawerwithrecyclerview.model.NavDrawerItem;

public class MainActivity extends AppCompatActivity implements FragmentDrawer.FragmentDrawerListener{

    private Toolbar mToolbar;
    private FragmentDrawer drawerFragment;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mToolbar = (Toolbar)findViewById(R.id.toolbar);
        setSupportActionBar(mToolbar);
        getSupportActionBar().setDisplayShowHomeEnabled(true);

        drawerFragment = (FragmentDrawer)getSupportFragmentManager().findFragmentById(R.id.fragment_navigation_drawer);
        drawerFragment.setUp(R.id.fragment_navigation_drawer, (DrawerLayout)findViewById(R.id.drawer_layout), mToolbar);
        drawerFragment.setDrawerListener(this);
        displayView(0, new NavDrawerItem(getString(R.string.nav_item_home)));
    }

    @Override
    public void onDrawerItemSelected(View view, int position, NavDrawerItem item) {
        displayView(position, item);
    }

    private void displayView(int position, NavDrawerItem item){
        Fragment fragment = null;
        String title = getString(R.string.app_name);

        if(!item.isSeparator()){
            fragment = PageFragment.newInstance(item.getTitle());
            title = item.getTitle();
        }

        if (fragment != null) {
            FragmentManager fragmentManager = getSupportFragmentManager();
            FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
            fragmentTransaction.replace(R.id.container_body, fragment);
            fragmentTransaction.commit();

            // set the toolbar title
            getSupportActionBar().setTitle(title);
        }
    }
}
