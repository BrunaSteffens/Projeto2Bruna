package com.example.projeto2bruna.view;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import com.example.projeto2bruna.R;
import com.example.projeto2bruna.adapter.UserAdapter;
import com.example.projeto2bruna.model.User;
import com.example.projeto2bruna.repository.UserRepository;

import java.net.URLStreamHandlerFactory;

public class MainActivity extends AppCompatActivity {
    private final String TAG = "MainActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.d(TAG, "onCreate: Iniciando a MainActivity");
        setContentView(R.layout.activity_main);



        //Colocar aqui o novo recycler view que eu fiz

        Log.d(TAG, "onCreate: Construindo o recycler view dos usuários");
        RecyclerView rv = findViewById(R.id.recyclerUser);
        UserAdapter adapter = new UserAdapter(UserRepository.getInstance(this).getUsers());
        rv.setAdapter(adapter);
        LinearLayoutManager llm = new LinearLayoutManager(this);
        rv.setLayoutManager(llm);
    }
}
