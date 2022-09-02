package com.example.electronicstore;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;

import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import com.google.android.material.navigation.NavigationView;

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    Fragment _CurrentFragment;
    CategoryFragment categoryFragment;
    Toolbar toolbar;
    DrawerLayout drawerLayout;
    ActionBarDrawerToggle actionBarDrawerToggle;
    NavigationView navigationView;
    Bundle bundle;
    String serachValue;
    Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        toolbar = findViewById(R.id.toolbar);
        toolbar.setTitle("Category");
        setSupportActionBar(toolbar);

        drawerLayout = findViewById(R.id.drawerLayout);
        actionBarDrawerToggle = new ActionBarDrawerToggle(this, drawerLayout, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawerLayout.addDrawerListener(actionBarDrawerToggle);
        actionBarDrawerToggle.syncState();
        navigationView = findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        displaySelectedItem(R.id.nav_category);

    }
    public void displaySelectedItem(int itemID) {
        Fragment fragment = null;

        switch (itemID) {
            case R.id.nav_category:
                serachValue = null;
                fragment = new CategoryFragment();
                toolbar.setTitle("Category");
                break;

            case R.id.nav_Television:
                serachValue = "Television";
                fragment = new ProductsFragment();
                toolbar.setTitle("Televisions");
                break;

            case R.id.nav_Laptop:
                serachValue = "Laptop";
                fragment = new ProductsFragment();
                toolbar.setTitle("Laptop");
                break;

            case R.id.nav_MobilePhone:
                serachValue = "MobilePhone";
                fragment = new ProductsFragment();
                toolbar.setTitle("MobilePhone");
                break;

            case R.id.nav_Smartwatch:
                serachValue = "Smartwatch";
                fragment = new ProductsFragment();
                toolbar.setTitle("Smartwatch");
                break;

            case R.id.nav_Headphone:
                serachValue = "Headphone";
                fragment = new ProductsFragment();
                toolbar.setTitle("Headphone");
                break;

            case R.id.nav_Mouse:
                serachValue = "Mouse";
                fragment = new ProductsFragment();
                toolbar.setTitle("Mouse");
                break;

            case R.id.nav_contact:


                intent = new Intent(this, ContactActivity.class);
                startActivity(intent);
                break;

            case R.id.nav_AboutStore:


                intent = new Intent(this, AboutStoreActivity.class);
                startActivity(intent);
                break;

        }

            if (fragment != null) {
                bundle = new Bundle();
                bundle.putString("SearchValue",serachValue);
                FragmentTransaction ft= getSupportFragmentManager().beginTransaction();
                fragment.setArguments(bundle);
                ft.replace(R.id.fragment_container, fragment);

                if (_CurrentFragment != categoryFragment) {
                    ft.addToBackStack(null);
                }

                ft.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE);
                ft.commit();

                _CurrentFragment = fragment;

            }

            drawerLayout.closeDrawer(GravityCompat.START);

    }

    public boolean onNavigationItemSelected(MenuItem menuItem) {
        displaySelectedItem(menuItem.getItemId());
        return true;
    }

    @Override
    public void onBackPressed() {
        if (drawerLayout.isDrawerOpen(GravityCompat.START))
            drawerLayout.closeDrawer(GravityCompat.START);
        else
            super.onBackPressed();
    }
}