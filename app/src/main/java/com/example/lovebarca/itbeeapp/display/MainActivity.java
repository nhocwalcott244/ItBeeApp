package com.example.lovebarca.itbeeapp.display;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;

import com.example.lovebarca.itbeeapp.R;
import com.example.lovebarca.itbeeapp.company.companyActivity;
import com.example.lovebarca.itbeeapp.company.createCompanyActivity;
import com.example.lovebarca.itbeeapp.company.createJobActivity;
import com.example.lovebarca.itbeeapp.user.profileActivity;
import com.example.lovebarca.itbeeapp.user.registerActivity;
import com.example.lovebarca.itbeeapp.user.LoginActivity;
import com.example.lovebarca.itbeeapp.user.applyJobAvtivity;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        assert fab != null;
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
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
        if (id == R.id.Login) {
            Intent myIntet12 = new Intent(this,LoginActivity.class);
            startActivity(myIntet12);
            return true;
        }
        if (id == R.id.Register) {
            Intent myIntent13 = new Intent(this,registerActivity.class);
            startActivity(myIntent13);
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.goodJog) {
            Intent myIntent = new Intent(this, goodJobActivity.class);
            startActivity(myIntent);
        } else if (id == R.id.suggestJob) {
            Intent myIntent2 = new Intent(this,suggestionJobActivity.class);
            startActivity(myIntent2);
        } else if (id == R.id.introJog) {
            Intent myIntet3 = new Intent(this,introduceJobActivity.class);
            startActivity(myIntet3);
        } else if (id == R.id.applyJob) {
            Intent myIntent4 = new Intent(this,applyJobAvtivity.class);
            startActivity(myIntent4);
        } else if (id == R.id.topBee) {
            Intent myIntet5 = new Intent(this,topBeeActivity.class);
            startActivity(myIntet5);
        } else if (id == R.id.topCompany) {
            Intent myIntent6 = new Intent(this,topCompanyActivity.class);
            startActivity(myIntent6);
        }else if (id == R.id.profile){
            Intent myIntent7 = new Intent(this,profileActivity.class);
            startActivity(myIntent7);
        }else if(id == R.id.friend){
            Intent myIntent8 = new Intent(this,friendActivity.class);
            startActivity(myIntent8);
        }else if(id == R.id.createCompany){
            Intent myIntent9 = new Intent(this, createCompanyActivity.class);
            startActivity(myIntent9);
        }else if(id == R.id.createJob){
            Intent myIntent10 = new Intent(this, createJobActivity.class);
            startActivity(myIntent10);
        }else if(id == R.id.company){
            Intent myIntent11 = new Intent(this,companyActivity.class);
            startActivity(myIntent11);
        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}
