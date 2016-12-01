package com.example.neuhaus.fragmenttablet2;

import android.app.Activity;
import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

/**
 * Created by neuhaus on 25/11/2016.
 */

public class EstaticoFragment extends Fragment {
    public final static int FLAG_FRAGMENT_A = 1;
    public final static int FLAG_FRAGMENT_B = 2;

    public interface OnMiClickListener {
        public void onClickCambiarFragmentDinamico(int flagFragment);
    }

    private static OnMiClickListener mListnerVacio = new OnMiClickListener() {
        @Override
        public void onClickCambiarFragmentDinamico(int flagFragment) {
        }
    };
    private OnMiClickListener mListener = mListnerVacio;

    public EstaticoFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_estatico, container, false);
        Button botonA = (Button) rootView.findViewById(R.id.button$fragment_estatico$cargarFragmentDinamicoA);
        botonA.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mListener.onClickCambiarFragmentDinamico(FLAG_FRAGMENT_A);
            }
        });
        Button botonB = (Button) rootView.findViewById(R.id.button$fragment_estatico$cargarFragmentDinamicoB);
        botonB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mListener.onClickCambiarFragmentDinamico(FLAG_FRAGMENT_B);
            }
        });
        return rootView;
    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        try {
            mListener = (OnMiClickListener) activity;
        } catch (ClassCastException e) {
            throw new IllegalStateException("La clase " + activity.toString() + " debe implementar de la interfaz " + OnMiClickListener.class.getName() + " del Fragment al que quiere escuchar");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = mListnerVacio;
    }
}