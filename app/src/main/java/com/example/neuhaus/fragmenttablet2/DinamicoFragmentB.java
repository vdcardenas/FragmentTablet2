package com.example.neuhaus.fragmenttablet2;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by neuhaus on 25/11/2016.
 */

public class DinamicoFragmentB extends Fragment {

    public DinamicoFragmentB() {}


    public View onCreateView (LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){
        View rootView = inflater.inflate(R.layout.fragment_dinamico_b, container, false);
        return rootView;
    }
}
