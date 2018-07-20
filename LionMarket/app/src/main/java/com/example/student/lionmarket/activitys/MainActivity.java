package com.example.student.lionmarket.activitys;

import android.app.FragmentManager;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;

import com.example.student.lionmarket.fragments.MainFragment;
import com.example.student.lionmarket.R;
import com.example.student.lionmarket.adapters.GamesAdapter;
import com.example.student.lionmarket.fragments.InfoFragment;
import com.example.student.lionmarket.providers.AllItemDatas;


public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    static FragmentManager fragmentManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        fragmentManager = getFragmentManager();
        fragmentManager.beginTransaction().replace(R.id.container_content, new MainFragment()).addToBackStack(null).commit();

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                MainFragment.recyclerView.setAdapter(new GamesAdapter(MainActivity.this, AllItemDatas.getBuyItems()));
            }
        });

        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();


        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
        navigationView.setBackgroundResource(R.drawable.side_nav_bar);


    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();
        switch (id) {
            case R.id.nav_all:
                MainFragment.recyclerView.setAdapter(new GamesAdapter(MainActivity.this, AllItemDatas.list));
                break;
            case R.id.nav_pc:
                MainFragment.recyclerView.setAdapter(new GamesAdapter(MainActivity.this, AllItemDatas.getItemsByType("PC Game")));
                break;
            case R.id.nav_ps4:
                MainFragment.recyclerView.setAdapter(new GamesAdapter(MainActivity.this, AllItemDatas.getItemsByType("PS4 Game")));
                break;
            case R.id.nav_xbox:
                MainFragment.recyclerView.setAdapter(new GamesAdapter(MainActivity.this, AllItemDatas.getItemsByType("XBox One Game")));
                break;
            case R.id.nav_liked:
                MainFragment.recyclerView.setAdapter(new GamesAdapter(MainActivity.this, AllItemDatas.getLikedItems()));
                break;
            case R.id.nav_buy:
                MainFragment.recyclerView.setAdapter(new GamesAdapter(MainActivity.this, AllItemDatas.getBuyItems()));
                break;

        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }


    public static void setFragment() {
        fragmentManager.beginTransaction().replace(R.id.container_content, new InfoFragment()).addToBackStack(null).commit();
    }
}
