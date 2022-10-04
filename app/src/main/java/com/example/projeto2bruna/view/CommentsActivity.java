package com.example.projeto2bruna.view;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.projeto2bruna.R;
import com.example.projeto2bruna.adapter.CommentsAdapter;
import com.example.projeto2bruna.databinding.ActivityCommentsBinding;
import com.example.projeto2bruna.model.Comments;
import com.example.projeto2bruna.repository.CommentsRepository;

import android.os.Bundle;
import android.util.Log;

public class CommentsActivity extends AppCompatActivity {
    private ActivityCommentsBinding layout;
    private static final String TAG = "CommentsActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_comments);

        layout = DataBindingUtil.setContentView(this, R.layout.activity_comments);
        Comments c = getIntent().getParcelableExtra("objetoUsuario");
        layout.setComments(c);
        Log.d(TAG, "onCreate: Pegamos o objeto usuário dos posts " + c.getName());

        RecyclerView rv = findViewById(R.id.recyclerViewComments);
        CommentsAdapter adapter = new CommentsAdapter(CommentsRepository.getInstance(this).getComments(c));
        rv.setAdapter(adapter);
        LinearLayoutManager llm = new LinearLayoutManager(this);
        rv.setLayoutManager(llm);

    }
}