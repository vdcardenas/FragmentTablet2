package com.example.neuhaus.fragmenttablet2;

import android.app.Activity;
import android.app.Fragment;
import android.os.Bundle;

/**
 * Created by neuhaus on 25/11/2016.
 */

public class PantallasEstrechasActivity extends Activity {
    public final static String KEY_FLAG_FRAGMENT_ENVIADO = "Clave atributo que recibe este fragment";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pantallas_estrechas);
        if (savedInstanceState == null) {
            Bundle extras = getIntent().getExtras();
            int flagFragment = extras.getInt(KEY_FLAG_FRAGMENT_ENVIADO);
            Fragment fragmentElegido = null;
            switch (flagFragment) {
                case EstaticoFragment.FLAG_FRAGMENT_A: {
                    fragmentElegido = new DinamicoFragmentA();
                    break;
                }
                case EstaticoFragment.FLAG_FRAGMENT_B: {
                    fragmentElegido = new DinamicoFragmentB();
                    break;
                }
            }
            getFragmentManager().beginTransaction().add(R.id.frameLayout$activity_pantallas_estrechas$contenedorFragmentsDinamicos, fragmentElegido).commit();
        }
    }
}