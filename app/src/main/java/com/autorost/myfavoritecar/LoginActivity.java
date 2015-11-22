package com.autorost.myfavoritecar;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;

import android.provider.Settings;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class LoginActivity extends AppCompatActivity implements View.OnClickListener {
    private Button login_buttonLogin, login_buttonRegister, login_buttonForgotLogin;
    private EditText login_editTextEMail, login_editTextPassword;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        login_buttonLogin = (Button) findViewById(R.id.login_buttonLogin);
        login_buttonRegister = (Button) findViewById(R.id.login_buttonRegister);
        login_buttonForgotLogin = (Button) findViewById(R.id.login_buttonForgotLogin);
        login_editTextEMail = (EditText) findViewById(R.id.login_editTextEmail);
        login_editTextPassword = (EditText) findViewById(R.id.login_editTextPassword);

        login_buttonLogin.setOnClickListener(this);
        login_buttonRegister.setOnClickListener(this);
        login_buttonForgotLogin.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {

        Intent intent;
        switch (v.getId()) {
            case R.id.login_buttonRegister:

                intent = new Intent(this, RegisterActivity.class);
                startActivity(intent);
                break;
            case R.id.login_buttonLogin:


                break;
            case R.id.login_buttonForgotLogin:

                break;

            default:
        }
    }
}


