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

        findViewById(R.id.buttonUsers).setOnClickListener(
                (view)->{
                    Intent intentUsers = new Intent(this, UsersActivity.class);
                    startActivity(intentUsers);
                    Log.d(TAG, "onCreate: Partiu para activity dos usuários");
                }

        );

        findViewById(R.id.buttonAlbums).setOnClickListener(
                (view) ->{
                    Intent intentAlbum = new Intent(this, AlbumActivity.class);
                    startActivity(intentAlbum);
                    Log.d(TAG, "onCreate: Partiu para activity dos Album");
                }
        );

        findViewById(R.id.buttonPosts).setOnClickListener(
                (view) ->{
                    Intent intentPosts = new Intent(this, PostsActivity.class);
                    startActivity(intentPosts);
                    Log.d(TAG, "onCreate: Partiu para activity dos Posts");
                }
        );

        findViewById(R.id.buttonTodos).setOnClickListener(
                (view) ->{
                    Intent intentTodos = new Intent(this, TodosActivity.class);
                    startActivity(intentTodos);
                    Log.d(TAG, "onCreate: Partiu para activity das Tarefas");
                }
        );


        findViewById(R.id.buttonComments).setOnClickListener(
                (view) ->{
                    Intent intentComments = new Intent(this, CommentsActivity.class);
                    startActivity(intentComments);
                    Log.d(TAG, "onCreate: Partiu para activity dos Comentarios");
                }
        );


        findViewById(R.id.buttonPhotos).setOnClickListener(
                (view) ->{
                    Intent intentPhotos = new Intent(this, PhotosActivity.class);
                    startActivity(intentPhotos);
                    Log.d(TAG, "onCreate: Partiu para activity das Fotos");
                }
        );


    }
}
