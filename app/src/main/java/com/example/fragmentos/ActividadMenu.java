package com.example.fragmentos;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

import com.example.fragmentos.fragments.ConfigFragmento;
import com.example.fragmentos.fragments.DetailsFragmento;
import com.example.fragmentos.fragments.HomeFragment;

public class ActividadMenu extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.actividad_menu);

        HomeFragment fh = new HomeFragment();
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.id_fragmento,fh).commit();

        BottomNavigationView bn = findViewById(R.id.navigationView);

        bn.setOnNavigationItemSelectedListener(listener);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_ejemplo, menu);
        return true;
    }

    private BottomNavigationView.OnNavigationItemSelectedListener listener =

    new BottomNavigationView.OnNavigationItemSelectedListener() {
        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            FragmentManager fr = getSupportFragmentManager();
            Fragment dt=null;
            switch (item.getItemId()) {
                case R.id.details:
                    dt = new DetailsFragmento();
                    break;
                case R.id.home:
                    dt = new HomeFragment();
                    break;
                case R.id.config:
                    dt = new ConfigFragmento();
                    break;
            }
            fr.beginTransaction().replace(R.id.id_fragmento,dt).commit();
            return true;
        }
    };


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        FragmentManager fr = getSupportFragmentManager();
        Fragment dt=null;
        switch (item.getItemId()) {
            case R.id.details:
                dt = new DetailsFragmento();
                break;
            case R.id.home:
                dt = new HomeFragment();
                break;
            case R.id.config:
                dt = new ConfigFragmento();
                break;
        }
        fr.beginTransaction().replace(R.id.id_fragmento,dt).commit();
        return true;
    }
}
