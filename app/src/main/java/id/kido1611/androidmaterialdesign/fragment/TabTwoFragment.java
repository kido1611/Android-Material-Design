package id.kido1611.androidmaterialdesign.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import id.kido1611.androidmaterialdesign.BaseFragment;
import id.kido1611.androidmaterialdesign.R;

/**
 * Created by Kido1611 on 23-Apr-16.
 */
public class TabTwoFragment extends BaseFragment {

    public TabTwoFragment(){

    }

    private FloatingActionButton fab;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.fragment_tab_two, container, false);
        fab = (FloatingActionButton)rootView.findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showSnackBar("Tombol floating diklik");
            }
        });
        return rootView;
    }
}
