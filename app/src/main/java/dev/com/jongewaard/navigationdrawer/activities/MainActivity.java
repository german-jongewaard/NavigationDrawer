package dev.com.jongewaard.navigationdrawer.activities;


import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.widget.Toast;

import dev.com.jongewaard.navigationdrawer.R;
import dev.com.jongewaard.navigationdrawer.fragments.AlertsFragment;
import dev.com.jongewaard.navigationdrawer.fragments.EmailFragment;
import dev.com.jongewaard.navigationdrawer.fragments.InfoFragment;


public class MainActivity extends AppCompatActivity {

    private DrawerLayout drawerLayout;
    private NavigationView navigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setToolBar();

        drawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
        navigationView = (NavigationView) findViewById(R.id.navview);

        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {

                boolean fragmentTransaction = false;

                Fragment fragment = null;



                switch (item.getItemId()){

                    case R.id.menu_mail:

                        fragment = new EmailFragment();
                        fragmentTransaction = true;
                        break;
                    case R.id.menu_alert:
                        fragment = new AlertsFragment();
                        fragmentTransaction = true;
                        break;
                    case R.id.menu_info:
                        fragment = new InfoFragment();
                        fragmentTransaction = true;
                        break;
                    case R.id.menu_opcion_1:
                        Toast.makeText(getApplicationContext(), "Has cloqueado en la opcion 1", Toast.LENGTH_SHORT).show();
                        break;
                    case R.id.menu_opcion_2:
                        Toast.makeText(getApplicationContext(), "Has cloqueado en la opcion 2", Toast.LENGTH_SHORT).show();
                        break;
                    case R.id.menu_opcion_3:
                        Toast.makeText(getApplicationContext(), "Has cloqueado en la opcion 3", Toast.LENGTH_SHORT).show();
                        break;




                }

                if(fragmentTransaction){

                    getSupportFragmentManager()
                            .beginTransaction()
                            .replace(R.id.content_frame, fragment)
                            .commit();
                //Muestra que esta activo, que se hizo el check!
                    item.setChecked(true);
                //aqui obtengo el titulo
                    getSupportActionBar().setTitle(item.getTitle());
                //cierra el drawer Layout
                    drawerLayout.closeDrawers();

                }

                return true;
            }
        });
    }

    private void setToolBar(){

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);

        setSupportActionBar(toolbar);
        //habilita un icono en la barra al lado del nombre
        getSupportActionBar().setHomeAsUpIndicator(R.drawable.ic_home);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case android.R.id.home:
                //abrir el menu lateral
                drawerLayout.openDrawer(GravityCompat.START);
                return true;
        }



        return super.onOptionsItemSelected(item);
    }
}
