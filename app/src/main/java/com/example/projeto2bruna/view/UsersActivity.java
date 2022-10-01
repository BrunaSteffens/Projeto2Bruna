package com.example.projeto2bruna.view;

import static com.example.projeto2bruna.BR.user;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import com.example.projeto2bruna.R;
import com.example.projeto2bruna.adapter.UserAdapter;
import com.example.projeto2bruna.databinding.ActivityUsersBinding;
import com.example.projeto2bruna.model.User;
import com.example.projeto2bruna.presenter.UserContract;
import com.example.projeto2bruna.presenter.UserPresenter;
import com.example.projeto2bruna.repository.UserRepository;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.TextView;

public class UsersActivity extends AppCompatActivity{
    private final String TAG = "UsersActivity";
    private ActivityUsersBinding layout;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Log.d(TAG, "onCreate: Aqui ele seleciona de qual usuário vai mostrar o conteúdo");
        layout = DataBindingUtil.setContentView(this, R.layout.activity_users);
        User user1 = getIntent().getParcelableExtra("objetoUsuario");
        layout.setUser(user1);
        Log.d(TAG, "onCreate: Aqui já pegou o usuário");


        Log.d(TAG, "onCreate: tenho o id do usuário "+user1.getId());
        ((TextView) findViewById(R.id.userLogin)).setText(user1.getName());

        findViewById(R.id.buttonAlbums).setOnClickListener(
                (view) ->{

                    Intent intentAlbum = new Intent(this, AlbumActivity.class);
                    intentAlbum.putExtra("objetoUsuario", user1);
                    startActivity(intentAlbum);
                    Log.d(TAG, "onCreate: Activity do Album");
                }
        );

        /*findViewById(R.id.buttonPosts).setOnClickListener(
                (view) ->{
                    Intent intentPosts = new Intent(this, PostsActivity.class);
                    intentPosts.putExtra("id",user1.getId());
                    startActivity(intentPosts);
                    Log.d(TAG, "onCreate: Activity dos Posts");
                }
        );*/


    }

}