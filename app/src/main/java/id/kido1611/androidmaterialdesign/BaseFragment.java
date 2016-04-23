package id.kido1611.androidmaterialdesign;

import android.support.v4.app.ActivityCompat;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;

/**
 * Created by Kido1611 on 23-Apr-16.
 */
public class BaseFragment extends Fragment {

    public void showSnackBar(int resId){
        showSnackBar(getString(resId));
    }

    public void showSnackBar(String message){
        ((MainActivity)getActivity()).showSnackBar(message);
    }
}
