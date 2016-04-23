package id.kido1611.androidmaterialdesign.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

import id.kido1611.androidmaterialdesign.R;

/**
 * Created by Kido1611 on 23-Apr-16.
 */
public class FragmentTab extends Fragment {

    public FragmentTab(){

    }

    private TabLayout tabLayout;
    private ViewPager viewPager;

    private ViewPagerAdapter adapter;
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setupViewPager();
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.fragment_tab, container, false);

        viewPager = (ViewPager) rootView.findViewById(R.id.viewpager);
        viewPager.setAdapter(adapter);
        tabLayout = (TabLayout) rootView.findViewById(R.id.tabs);
        tabLayout.setupWithViewPager(viewPager);

        adapter.notifyDataSetChanged();
        return rootView;
    }

    private void setupViewPager() {
        adapter = new ViewPagerAdapter(getChildFragmentManager());
        adapter.addFragment(TabFragment.newInstance(getString(R.string.tab_item_one)), getString(R.string.tab_item_one));
        adapter.addFragment(new TabTwoFragment(), getString(R.string.tab_item_two));
        adapter.addFragment(TabFragment.newInstance(getString(R.string.tab_item_three)), getString(R.string.tab_item_three));
        adapter.addFragment(TabFragment.newInstance(getString(R.string.tab_item_four)), getString(R.string.tab_item_four));
    }

    class ViewPagerAdapter extends FragmentPagerAdapter {
        private final List<Fragment> mFragmentList = new ArrayList<>();
        private final List<String> mFragmentTitleList = new ArrayList<>();

        public ViewPagerAdapter(FragmentManager manager) {
            super(manager);
        }

        @Override
        public Fragment getItem(int position) {
            return mFragmentList.get(position);
        }

        @Override
        public int getCount() {
            return mFragmentList.size();
        }

        public void addFragment(Fragment fragment, String title) {
            mFragmentList.add(fragment);
            mFragmentTitleList.add(title);
        }

        @Override
        public CharSequence getPageTitle(int position) {
            return mFragmentTitleList.get(position);
        }
    }
}
