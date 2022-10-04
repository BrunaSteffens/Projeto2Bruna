package com.example.projeto2bruna.view;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.projeto2bruna.R;
import android.os.Bundle;
import android.util.Log;

import com.example.projeto2bruna.adapter.PostsAdapter;
import com.example.projeto2bruna.databinding.ActivityPostsBinding;
import com.example.projeto2bruna.model.Posts;
import com.example.projeto2bruna.repository.PostsRepository;

public class PostsActivity extends AppCompatActivity {
    private static final String TAG = "PostsActivity";
    private ActivityPostsBinding layout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_posts);

        layout = DataBindingUtil.setContentView(this, R.layout.activity_posts);
        Posts p = getIntent().getParcelableExtra("objetoUsuario");
        layout.setPosts(p);
        Log.d(TAG, "onCreate: Aqui pegou o usuário do post");

        RecyclerView rv = findViewById(R.id.recyclerPosts);
        PostsAdapter adapter = new PostsAdapter(PostsRepository.getInstance(this).getPosts(p));
        rv.setAdapter(adapter);
        LinearLayoutManager llm = new LinearLayoutManager(this);
        rv.setLayoutManager(llm);
    }
}