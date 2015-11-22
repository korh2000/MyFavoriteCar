package com.autorost.myfavoritecar;


import android.content.Intent;
import android.nfc.Tag;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;


import com.autorost.myfavoritecar.adapter.Adapter;
import com.autorost.myfavoritecar.entity.Invoice;

import java.util.ArrayList;
import java.util.Date;
import java.util.GregorianCalendar;


public class InvoiceActivity extends AppCompatActivity implements View.OnClickListener {
    private final int REQUEST_CODE_ADD = 1;
    private final int REQUEST_CODE_EDIT = 2;
    private ListView invocesListView;
    private static Adapter adapter;
    private static ArrayList<Invoice> invoices = new ArrayList<Invoice>();

    private Invoice invoice1 = new Invoice("FILLING", "OKKO-15", new GregorianCalendar(2015, 10, 25), 120.25, 60950);
    private Invoice invoice2 = new Invoice("BUYPARTS", "LOSK", new GregorianCalendar(2015, 11, 1), 250.0, 61200);
    private Invoice invoice3 = new Invoice("REPAIR", "MIRAG", new GregorianCalendar(2015, 11, 2), 200.0, 61250);

    private Button invocesButtonAdd;
    private Button invocesButtonBack;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_invoice);

        //delete
        if (invoices.size() == 0) {
            invoices.add(invoice1);
            invoices.add(invoice2);
            invoices.add(invoice3);
        }
        //delete

        invocesButtonAdd = (Button) findViewById(R.id.invocesButtonAdd);
        invocesButtonBack = (Button) findViewById(R.id.invocesButtonBack);

        invocesButtonAdd.setOnClickListener(this);
        invocesButtonBack.setOnClickListener(this);




        setAdapter();
    //   invocesListView.setOnItemClickListener((AdapterView.OnItemClickListener) this);

        /*invocesListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View itemClicked, int position,
                                    long id) {
                Toast.makeText(getApplicationContext(), ((TextView) itemClicked).getText(),
                        Toast.LENGTH_SHORT).show();
            }
        });*/


    }

    @Override
    public void onClick(View v) {
        Intent intent = new Intent();
        int id = v.getId();

        if (id == R.id.invocesButtonAdd) {
            intent = new Intent(this, InvoiceForma.class);
            intent.putExtra("action", REQUEST_CODE_ADD);
            startActivityForResult(intent, REQUEST_CODE_ADD);
        } else if (id == R.id.invocesButtonBack) {
            finish();
        } else if (id == R.id.invocesListView) {
            intent = new Intent(this, InvoiceForma.class);
            intent.putExtra("action", REQUEST_CODE_EDIT);

            startActivityForResult(intent, REQUEST_CODE_EDIT);
        }
    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);


        if (resultCode == RESULT_OK) {
            switch (requestCode) {
                case REQUEST_CODE_ADD: {
                    //   data.getStringExtra("dateInvoice");
                    Invoice invoice = new Invoice(data.getStringExtra("services"),
                            data.getStringExtra("seller"),
                            new GregorianCalendar(2015, 11, 30),
                            Double.parseDouble(data.getStringExtra("sumInvoice")),
                            Integer.parseInt(data.getStringExtra("mileageInvoice"))
                    );
                    invoices.add(invoice);
                    setAdapter();
                    break;

                }
            }
        } else

        {
            Toast.makeText(InvoiceActivity.this, "Invoice don't EDIT", Toast.LENGTH_SHORT).show();
        }
    }

    protected void setAdapter() {
        invocesListView = (ListView) findViewById(R.id.invocesListView);
        adapter = new Adapter(this, R.layout.list_item, invoices);
        //  registerForContextMenu(listView);
        invocesListView.setAdapter(adapter);

    }
}


