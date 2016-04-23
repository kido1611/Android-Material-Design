package id.kido1611.androidmaterialdesign;

import android.support.design.widget.CoordinatorLayout;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;

import id.kido1611.androidmaterialdesign.fragment.FragmentDrawer;
import id.kido1611.androidmaterialdesign.fragment.FragmentTab;
import id.kido1611.androidmaterialdesign.fragment.PageFragment;
import id.kido1611.androidmaterialdesign.model.NavDrawerItem;

public class MainActivity extends AppCompatActivity implements FragmentDrawer.FragmentDrawerListener{

    private Toolbar mToolbar;
    private FragmentDrawer drawerFragment;
    private CoordinatorLayout coordinatorLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mToolbar = (Toolbar)findViewById(R.id.toolbar);
        setSupportActionBar(mToolbar);
        getSupportActionBar().setDisplayShowHomeEnabled(true);

        coordinatorLayout = (CoordinatorLayout)findViewById(R.id.coordinatorLayout);
        drawerFragment = (FragmentDrawer)getSupportFragmentManager().findFragmentById(R.id.fragment_navigation_drawer);
        drawerFragment.setUp(R.id.fragment_navigation_drawer, (DrawerLayout)findViewById(R.id.drawer_layout), mToolbar);
        drawerFragment.setDrawerListener(this);
        displayView(0, new NavDrawerItem(getString(R.string.nav_item_home), new FragmentTab()));
    }

    public void showSnackBar(String message){
        Snackbar snackbar = Snackbar.make(coordinatorLayout, message, Snackbar.LENGTH_SHORT);
        snackbar.show();
    }

    @Override
    public void onDrawerItemSelected(View view, int position, NavDrawerItem item) {
        displayView(position, item);
    }

    private void displayView(int position, NavDrawerItem item){
        Fragment fragment = null;
        String title = getString(R.string.app_name);

        if(!item.isSeparator()){
            fragment = item.getFragment();
            if(fragment==null){
                fragment = PageFragment.newInstance(item.getTitle());
            }
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
