package com.example.neuhaus.fragmenttablet2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import android.app.Activity;
import android.app.Fragment;
import android.app.FragmentTransaction;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends Activity implements EstaticoFragment.OnMiClickListener {
    private boolean mDosFragmentos = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        View frameLayoutContenedor = findViewById(R.id.frameLayout$activity_main$contenedorFragmentsDinamicos);
        mDosFragmentos = frameLayoutContenedor != null && frameLayoutContenedor.getVisibility() == View.VISIBLE;
        if (mDosFragmentos) {
            this.onClickCambiarFragmentDinamico(EstaticoFragment.FLAG_FRAGMENT_A);
        }
    }

    @Override
    public void onClickCambiarFragmentDinamico(int flagFragment) {
        if (mDosFragmentos) {
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
            getFragmentManager().beginTransaction().replace(R.id.frameLayout$activity_main$contenedorFragmentsDinamicos, fragmentElegido).setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE).commit();
        } else {
            Intent intent = new Intent();
            intent.setClass(this, PantallasEstrechasActivity.class);
            intent.putExtra(PantallasEstrechasActivity.KEY_FLAG_FRAGMENT_ENVIADO, flagFragment);
            startActivity(intent);
        }
    }
}