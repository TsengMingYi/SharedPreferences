package com.example.registerloginpractice;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private EditText nameEdit;
    private EditText passwordEdit;
    private Button loginBtn;
    private Button registerBtn;
    private AccountManager accountManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        findView();

        accountManager = AccountManager.getInstance();
        accountManager.setContext(this);


        nameEdit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });


        passwordEdit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });


        loginBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (AccountManager.getInstance().login(nameEdit.getText().toString(),
                        passwordEdit.getText().toString())) {
                    startActivity(new Intent(MainActivity.this, HomeActivity.class));
                    Utils.toast(MainActivity.this, getResources().getString(R.string.login_success));
                } else {
                    Utils.toast(MainActivity.this, getResources().getString(R.string.login_fail));
                }
            }
        });

        registerBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (AccountManager.getInstance().register(
                        nameEdit.getText().toString(), passwordEdit.getText().toString())) {
                    Utils.toast(MainActivity.this, getResources().getString(R.string.register_success_hint));
                    // todo jump hint
                } else {
                    Utils.toastAccountAlreadyExist(MainActivity.this);
                    // todo jump hint
                }

            }
        });


    }


    private void findView() {
        nameEdit = findViewById(R.id.name_tedit);
        passwordEdit = findViewById(R.id.password_tedit);
        loginBtn = findViewById(R.id.login_btn);
        registerBtn = findViewById(R.id.register_btn);
    }

}
