package com.autorost.myfavoritecar;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

import java.util.Arrays;
import java.util.List;

public class InvoiceForma extends AppCompatActivity implements View.OnClickListener {
    ArrayAdapter<String> adapter;

    private EditText invoiceFormaEditTextDate;
    private Spinner invoiceFormaSpinnerService;
    private EditText invoiceFormaEditTextSeller;
    private EditText invoiceFormaEditTextSum;
    private EditText invoiceFormaEditTextMileage;

    private Button invoiceFormaButtonSave;
    Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_invoice_forma);
        intent = getIntent();

        invoiceFormaButtonSave = (Button) findViewById(R.id.invoiceFormaButtonSave);
        invoiceFormaButtonSave.setOnClickListener(this);

        //Date
        invoiceFormaEditTextDate = (EditText) findViewById(R.id.invoiceFormaEditTextDate);

        //Service
        invoiceFormaSpinnerService = (Spinner) findViewById(R.id.invoiceFormaSpinnerService);
        List<String> list = Arrays.asList(getResources().getStringArray(R.array.services_array));
        adapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, list);
        invoiceFormaSpinnerService.setAdapter(adapter);

        //Seller
        invoiceFormaEditTextSeller = (EditText) findViewById(R.id.invoiceFormaEditTextSeller);

        //Sum
        invoiceFormaEditTextSum = (EditText) findViewById(R.id.invoiceFormaEditTextSum);

        //Mileage
        invoiceFormaEditTextMileage = (EditText) findViewById(R.id.invoiceFormaEditTextMileage);

        //если не ввод нового
        if (intent.getStringExtra("action") != "1") {
            invoiceFormaEditTextDate.setText(intent.getStringExtra("dateInvoice"));
            invoiceFormaSpinnerService.setSelection(list.indexOf(intent.getStringExtra("services")));
            invoiceFormaEditTextSeller.setText(intent.getStringExtra("seller"));
            invoiceFormaEditTextSum.setText(intent.getStringExtra("sumInvoice"));
            invoiceFormaEditTextMileage.setText(intent.getStringExtra("mileageInvoice"));
        }
    }

    @Override
    public void onClick(View v) {
        intent = new Intent();
        if (v.getId() == R.id.invoiceFormaButtonSave) {

            intent.putExtra("dateInvoice", invoiceFormaEditTextDate.getText().toString());
            intent.putExtra("services", invoiceFormaSpinnerService.getSelectedItem().toString());
            intent.putExtra("seller", invoiceFormaEditTextSeller.getText().toString());
            intent.putExtra("sumInvoice", invoiceFormaEditTextSum.getText().toString());
            intent.putExtra("mileageInvoice", invoiceFormaEditTextMileage.getText().toString());
            setResult(RESULT_OK, intent);
            finish();
        }
    }
}
