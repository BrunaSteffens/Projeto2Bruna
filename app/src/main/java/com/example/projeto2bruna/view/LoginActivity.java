package com.example.projeto2bruna.view;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.example.projeto2bruna.R;
import com.example.projeto2bruna.model.User;
import com.example.projeto2bruna.presenter.LoginPresenter;
import com.example.projeto2bruna.presenter.LoginPresenterContract;
import com.example.projeto2bruna.repository.UserRepository;
import com.google.android.material.snackbar.Snackbar;

public class LoginActivity extends AppCompatActivity implements LoginPresenterContract.view {

    private LoginPresenterContract.presenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        UserRepository.getInstance(this);
        setContentView(R.layout.activity_login);


        this.presenter = new LoginPresenter(this);
        findViewById(R.id.buttonLogin).setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        presenter.checkLogin(
                                ((TextView) findViewById(R.id.editTextUser)).getText().toString(),
                                ((TextView) findViewById(R.id.editTextTextPassword)).getText().toString()
                        );
                    }
                }
        );
    }

    @Override
    public void message(String msg) {
        Snackbar.make(this, findViewById(R.id.editTextTextPassword), msg, Snackbar.LENGTH_LONG).show();
    }

    @Override
    public Activity getActivity() {
        return this;
    }

}