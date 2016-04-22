package id.kido1611.androidmaterialdesign.fragment;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import id.kido1611.androidmaterialdesign.R;

/**
 * Created by Kido1611 on 22-Apr-16.
 */
public class TabFragment extends Fragment {

    public static final String KEY_TITLE_FRAGMENT = "title";

    public static TabFragment newInstance(String title){
        TabFragment mFragment = new TabFragment();
        Bundle mBundle = new Bundle();
        mBundle.putString(KEY_TITLE_FRAGMENT, title );
        mFragment.setArguments(mBundle);
        return mFragment;
    }

    public TabFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_tab_page, container, false);
        ((TextView)rootView.findViewById(R.id.label)).setText(getArguments().getString(KEY_TITLE_FRAGMENT));

        // Inflate the layout for this fragment
        return rootView;
    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
    }

    @Override
    public void onDetach() {
        super.onDetach();
    }
}
