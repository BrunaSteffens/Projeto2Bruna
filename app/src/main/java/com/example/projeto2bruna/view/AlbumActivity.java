package com.example.projeto2bruna.view;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.projeto2bruna.R;
import com.example.projeto2bruna.adapter.AlbumsAdapter;
import com.example.projeto2bruna.databinding.ActivityAlbumBinding;
import com.example.projeto2bruna.model.Albums;
import com.example.projeto2bruna.model.User;
import com.example.projeto2bruna.repository.AlbumRepository;

import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import java.util.List;

public class AlbumActivity extends AppCompatActivity  {
    private final String TAG = "AlbumActivity";
    private ActivityAlbumBinding layout;
    private List<Albums> albumsList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_album);

        Log.d(TAG, "onCreate: Iniciando a activity dos álbuns");
        //setContentView(R.layout.activity_album);

        layout = DataBindingUtil.setContentView(this, R.layout.activity_album);
        //Albums album = getIntent().getParcelableExtra("idUsuario");


        //AlbumRepository aRepo = AlbumRepository.getInstance(this);
        User user1 = getIntent().getParcelableExtra("objetoUsuario");
       ((TextView) findViewById(R.id.textViewNomeUsuarioAlbum)).setText(user1.getName());

        //albumsList = aRepo.getAlbumByUserId(user1.getId());
        // Albums album = aRepo.getAlbumByUserId(user1.getId());
        // layout.setAlbums(album);
        //Log.d(TAG, "onCreate: Album id" + album.getAlbumId());


        Log.d(TAG, "onCreate: Iniciando o recycler dos albuns do usuário");
        RecyclerView rv = findViewById(R.id.recyclerAlbums);
        AlbumsAdapter adapter = new AlbumsAdapter(AlbumRepository.getInstance(this).getAlbums(user1.getId()));
        rv.setAdapter(adapter);
        LinearLayoutManager llm = new LinearLayoutManager(this);
        rv.setLayoutManager(llm);
    }

}
