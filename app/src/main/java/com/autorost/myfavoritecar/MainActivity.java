package com.autorost.myfavoritecar;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.NavigationView;
import android.support.design.widget.Snackbar;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import com.autorost.myfavoritecar.entity.Car;
import com.autorost.myfavoritecar.entity.Invoice;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Currency;
import java.util.Date;
import java.util.GregorianCalendar;

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {
    private final int REQUEST_CODE_CAR = 1;
    private Car car = new Car("MERSEDES", "modelX 160", 2010, "VR345677FR456", 60780, new Date(15 / 10 / 22), "KM", "USD", "PETROL95");


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
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
        getMenuInflater().inflate(R.menu.menu_main, menu);
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
        Intent intent = new Intent();
        int id = item.getItemId();

        if (id == R.id.nav_car) {
            intent = new Intent(this, CarActivity.class);
            intent.putExtra("brand", car.getBrand());
            intent.putExtra("model", car.getModel());
            intent.putExtra("year", "" + car.getYear());
            intent.putExtra("vin", car.getVin());
            intent.putExtra("mileageStart", "" + car.getMileageStart());
            intent.putExtra("dateStart", "" + car.getDateStart());
            intent.putExtra("mileageUnit", car.getMileageUnit());
            intent.putExtra("currency", car.getCurrency());
            intent.putExtra("fuel", car.getFuel());
            startActivityForResult(intent, REQUEST_CODE_CAR);

        } else if (id == R.id.nav_invoice) {
            intent = new Intent(this, InvoiceActivity.class);
            startActivity(intent);
        } else if (id == R.id.nav_report) {


        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);


        if (resultCode == RESULT_OK) {
            switch (requestCode) {
                case REQUEST_CODE_CAR: {
                    car.setBrand(data.getStringExtra("brand"));
                    car.setModel(data.getStringExtra("model"));
                    car.setVin(data.getStringExtra("vin"));
                    try {
                        car.setYear(Integer.parseInt(data.getStringExtra("year")));
                    } catch (Exception e) {
                        car.setYear(0);
                    }
                    try {
                        car.setMileageStart(Integer.parseInt(data.getStringExtra("mileageStart")));
                    } catch (Exception e) {
                        car.setMileageStart(0);
                    }
                 /*   try {

                        SimpleDateFormat format = new Simplmat();
                        format.applyPattern("yyyy/MM/dd");
                        Date docDate = format.parse(data.getStringExtra("dateStart"));
                        car.setDateStart(docDate);
                    } catch (ParseException e) {
                        e.printStackTrace();
                    }*/
                    car.setMileageUnit(data.getStringExtra("mileageUnit"));
                    car.setCurrency(data.getStringExtra("currency"));
                    car.setFuel(data.getStringExtra("fuel"));


                    break;

                }
            }
        } else

        {
            Toast.makeText(MainActivity.this, "Car don't EDIT", Toast.LENGTH_SHORT).show();
        }
    }
}

