package com.example.projeto2bruna.view;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.projeto2bruna.R;
import com.example.projeto2bruna.adapter.PhotosAdapter;
import com.example.projeto2bruna.adapter.UserAdapter;
import com.example.projeto2bruna.databinding.ActivityPhotosBinding;
import com.example.projeto2bruna.model.Photos;
import com.example.projeto2bruna.repository.PhotosRepository;
import com.example.projeto2bruna.repository.UserRepository;

import android.os.Bundle;
import android.util.Log;

public class PhotosActivity extends AppCompatActivity {

    private static final String TAG = "PhotosActivity";
    private ActivityPhotosBinding layout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_photos);

        Log.d(TAG, "onCreate:  Iniciando a activity das fotos");

        layout = DataBindingUtil.setContentView(this, R.layout.activity_photos);
        Photos photos = getIntent().getParcelableExtra("objetoUsuario");
        layout.setPhotos(photos);

        RecyclerView rv = findViewById(R.id.recyclerPhotos);
        PhotosAdapter adapter = new PhotosAdapter(PhotosRepository.getInstance(this).getPhotos());
        rv.setAdapter(adapter);
        LinearLayoutManager llm = new LinearLayoutManager(this);
        rv.setLayoutManager(llm);
    }
}