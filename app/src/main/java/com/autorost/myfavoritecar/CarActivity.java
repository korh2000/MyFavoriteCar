package com.autorost.myfavoritecar;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Collection;
import java.util.Currency;
import java.util.Date;
import java.util.List;
import java.util.Set;


public class CarActivity extends AppCompatActivity implements View.OnClickListener {


    ArrayAdapter<String> adapter;
    private Spinner carSpinnerBrand;
    private EditText carEditTextModel;
    private EditText carEditTextYear;
    private EditText carEditTextVin;
    private EditText carEditTextMileageStart;
    private EditText carEditTextDate;

    private Spinner carSpinnercarMileageUnit;
    private Spinner carSpinnerCurrency;

    private Spinner carSpinnerFuel;
    private Button carButtonSave;
    Intent intent;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_car);

        intent = getIntent();
        Bundle bundle = intent.getExtras();
        carButtonSave = (Button) findViewById(R.id.carButtonSave);
        carButtonSave.setOnClickListener(this);

        //Brand
        carSpinnerBrand = (Spinner) findViewById(R.id.carSpinnerBrand);
        List<String> list = Arrays.asList(getResources().getStringArray(R.array.brand_array));
        adapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, list);
  /*      ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.brand_array, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);*/
        carSpinnerBrand.setAdapter(adapter);
        carSpinnerBrand.setSelection(list.indexOf(intent.getStringExtra("brand")));

        //Model
        carEditTextModel = (EditText) findViewById(R.id.carEditTextModel);
        carEditTextModel.setText(intent.getStringExtra("model"));

        //Year
        carEditTextYear = (EditText) findViewById(R.id.carEditTextYear);
        carEditTextYear.setText(intent.getStringExtra("year"));

        //Vin
        carEditTextVin = (EditText) findViewById(R.id.carEditTextVin);
        carEditTextVin.setText(intent.getStringExtra("vin"));

        //Mileage
        carEditTextMileageStart = (EditText) findViewById(R.id.carEditTextMileageStart);
        carEditTextMileageStart.setText(intent.getStringExtra("mileageStart"));

        //Date
        carEditTextDate = (EditText) findViewById(R.id.carEditTextDate);
        carEditTextDate.setText(intent.getStringExtra("dateStart"));


        //MileageUnit
        carSpinnercarMileageUnit = (Spinner) findViewById(R.id.carSpinnercarMileageUnit);
        list = Arrays.asList(getResources().getStringArray(R.array.mileageUnit_array));
        adapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, list);
        carSpinnercarMileageUnit.setAdapter(adapter);
        carSpinnercarMileageUnit.setSelection(list.indexOf(intent.getStringExtra("mileageUnit")));

        //Currency
        carSpinnerCurrency = (Spinner) findViewById(R.id.carSpinnerCurrency);
        list = Arrays.asList(getResources().getStringArray(R.array.currency_array));
        adapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, list);
        carSpinnerCurrency.setAdapter(adapter);
        carSpinnerCurrency.setSelection(list.indexOf(intent.getStringExtra("currency")));

        //Fuel
        carSpinnerFuel = (Spinner) findViewById(R.id.carSpinnerFuel);
        list = Arrays.asList(getResources().getStringArray(R.array.fuels_array));
        adapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, list);
        carSpinnerFuel.setAdapter(adapter);
        carSpinnerFuel.setSelection(list.indexOf(intent.getStringExtra("fuel")));

    }

    @Override
    public void onClick(View v) {
        intent = new Intent();
        if (v.getId() == R.id.carButtonSave) {

            intent.putExtra("brand", carSpinnerBrand.getSelectedItem().toString());
            intent.putExtra("model", carEditTextModel.getText().toString());
            intent.putExtra("year", carEditTextYear.getText().toString());
            intent.putExtra("vin", carEditTextVin.getText().toString());
            intent.putExtra("mileageStart", carEditTextMileageStart.getText().toString());
            intent.putExtra("dateStart", carEditTextDate.getText().toString());
            intent.putExtra("mileageUnit", carSpinnercarMileageUnit.getSelectedItem().toString());
            intent.putExtra("currency", carSpinnerCurrency.getSelectedItem().toString());
            intent.putExtra("fuel", carSpinnerFuel.getSelectedItem().toString());


            setResult(RESULT_OK, intent);
            finish();
        }
    }
}


