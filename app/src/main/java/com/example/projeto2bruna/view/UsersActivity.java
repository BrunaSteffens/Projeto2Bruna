package com.example.projeto2bruna.view;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.example.projeto2bruna.R;
import com.example.projeto2bruna.adapter.UserAdapter;
import com.example.projeto2bruna.repository.UserRepository;
import android.os.Bundle;
import android.util.Log;

public class UsersActivity extends AppCompatActivity{
    private final String TAG = "UsersActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_users);

        Log.d(TAG, "onCreate: Construindo o recycler view dos usuários");
        RecyclerView rv = findViewById(R.id.recyclerUser);
        UserAdapter adapter = new UserAdapter(UserRepository.getInstance(this).getUsers());
        rv.setAdapter(adapter);
        LinearLayoutManager llm = new LinearLayoutManager(this);
        rv.setLayoutManager(llm);

    }
}