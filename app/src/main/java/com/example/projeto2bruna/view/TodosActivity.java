package com.example.projeto2bruna.view;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.projeto2bruna.R;
import com.example.projeto2bruna.adapter.TodosAdapter;
import com.example.projeto2bruna.databinding.ActivityTodosBinding;
import com.example.projeto2bruna.model.Posts;
import com.example.projeto2bruna.model.Todos;
import com.example.projeto2bruna.repository.TodosRepository;

import android.os.Bundle;
import android.util.Log;

public class TodosActivity extends AppCompatActivity {
    private static final String TAG = "TodosActivity";
    private ActivityTodosBinding layout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_todos);
        Log.d(TAG, "onCreate: Iniciando a activity das tarefas");

        RecyclerView rv = findViewById(R.id.recyclerTodos);
        TodosAdapter adapter = new TodosAdapter(TodosRepository.getInstance(this).getTodos());
        rv.setAdapter(adapter);
        LinearLayoutManager llm = new LinearLayoutManager(this);
        rv.setLayoutManager(llm);

    }


}