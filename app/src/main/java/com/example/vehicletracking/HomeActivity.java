package com.example.vehicletracking;

import android.os.Bundle;
import android.view.MenuItem;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class HomeActivity extends AppCompatActivity {
    private BottomNavigationView bottomNavigationView;

    private final Fragment profileFragment = new ProfileFragment();
    private final Fragment garageFragment = new GarageFragment();
    private final Fragment addBusInfoFragment = new AddBusInfoAdapter();
    private final Fragment mapFragment = new MapFragment();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        bottomNavigationView = findViewById(R.id.bottom_navigation);
        bottomNavigationView.setOnNavigationItemSelectedListener(navListener);

        // Set the default fragment
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.container, profileFragment)
                .commit();



    }

    private BottomNavigationView.OnNavigationItemSelectedListener navListener =
            new BottomNavigationView.OnNavigationItemSelectedListener() {
                @Override
                public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                    Fragment selectedFragment = null;

                    if (item.getItemId() == R.id.nav_profile) {
                        selectedFragment = profileFragment;
                    } else if (item.getItemId() == R.id.nav_buses) {
                        selectedFragment = garageFragment;
                    } else if (item.getItemId() == R.id.nav_addbus) {
                        selectedFragment = addBusInfoFragment;
                    } else if (item.getItemId() == R.id.nav_map) {
                        selectedFragment = mapFragment;
                    }

                    // Load selected fragment
                    LoadandReplaceFragment(selectedFragment);
                    return true;
                }
            };

    private void LoadandReplaceFragment(Fragment fragment) {
        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.container, fragment)
                .setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE)
                .commit();
    }
}
