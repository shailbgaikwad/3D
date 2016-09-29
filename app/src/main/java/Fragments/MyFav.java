package Fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.ProgressBar;

import com.android.volley.toolbox.StringRequest;

import in.sap.viewer.R;

/**
 * Created by shailb on 04/05/16.
 */
public class MyFav extends Fragment {
    StringRequest postRequest;
    ProgressBar progressBar;
    ListView orderhistlist;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.about, container, false);

        return view;
    }


}
