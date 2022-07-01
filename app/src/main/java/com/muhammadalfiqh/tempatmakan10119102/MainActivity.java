package com.muhammadalfiqh.tempatmakan10119102;
/*
    nim                 : 10119102
    nama                : Muhammad Alfiqh Nugraha
    kelas               : IF-3
*/
import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.FragmentManager;

import android.os.Bundle;
import android.view.MenuItem;
import android.view.WindowManager;
import android.widget.Toolbar;

import com.google.android.material.navigation.NavigationView;
import com.muhammadalfiqh.tempatmakan10119102.view.carikuliner.CariKulinerFragment;
import com.muhammadalfiqh.tempatmakan10119102.view.informasi.InformasiFragment;
import com.muhammadalfiqh.tempatmakan10119102.view.lokasisaya.LokasiSayaFragment;
import com.muhammadalfiqh.tempatmakan10119102.view.profile.ProfileFragment;

public class MainActivity extends AppCompatActivity {
    DrawerLayout drawerLayout;
    NavigationView navigationView;
    Toolbar toolbar;
    ActionBarDrawerToggle actionBarDrawerToggle;

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if (actionBarDrawerToggle.onOptionsItemSelected(item)){
            return true;
        }
        return super.onOptionsItemSelected(item);
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Navigation Logic
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        ActionBar ab = getSupportActionBar();

        if (ab != null)  ab.setTitle("Profile");
        FragmentManager fm = getSupportFragmentManager();
        fm.beginTransaction()
                .replace(R.id.container, new ProfileFragment())
                .commit();

        drawerLayout = findViewById(R.id.drawer_layout);
        navigationView = findViewById(R.id.navigationView);
        actionBarDrawerToggle = new ActionBarDrawerToggle(this, drawerLayout, R.string.menu_open, R.string.menu_close);
        drawerLayout.addDrawerListener(actionBarDrawerToggle);
        actionBarDrawerToggle.syncState();


        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()){
                    case R.id.nav_profile:
                        if (ab != null) ab.setTitle("Profile Mahasiswa");
                        fm.beginTransaction()
                                .replace(R.id.container, new ProfileFragment())
                                .commit();
                        drawerLayout.closeDrawer(GravityCompat.START);
                        break;
                    case R.id.nav_carikuliner:
                        if (ab != null) ab.setTitle("Rekomendasi Tempat");
                        fm.beginTransaction()
                                .replace(R.id.container, new CariKulinerFragment())
                                .commit();
                        drawerLayout.closeDrawer(GravityCompat.START);
                        break;
                    case R.id.nav_lokasisaya:
                        if (ab != null) ab.setTitle("Lokasi Saya");
                        fm.beginTransaction()
                                .replace(R.id.container, new LokasiSayaFragment())
                                .commit();
                        drawerLayout.closeDrawer(GravityCompat.START);
                        break;

                    case R.id.nav_informasi:
                        if (ab != null)  ab.setTitle("Informasi Aplikasi");
                        fm.beginTransaction()
                                .replace(R.id.container, new InformasiFragment())
                                .commit();
                        drawerLayout.closeDrawer(GravityCompat.START);
                        break;
                }
                return false;
            }
        });
    }
}