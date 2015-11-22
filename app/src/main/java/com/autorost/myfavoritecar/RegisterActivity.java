package com.autorost.myfavoritecar;


import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;


public class RegisterActivity extends AppCompatActivity implements View.OnClickListener {
    private Button register_buttonRegister;
    private EditText register_editTextEMail, register_editTextPassword, register_editTextReenterPassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        register_buttonRegister = (Button) findViewById(R.id.register_bottonRegister);
        register_editTextEMail = (EditText) findViewById(R.id.register_editTextEmail);
        register_editTextPassword = (EditText) findViewById(R.id.register_editTextPassword);
        register_editTextReenterPassword = (EditText) findViewById(R.id.register_editTextReEnterPassword);
        register_buttonRegister.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }


}
