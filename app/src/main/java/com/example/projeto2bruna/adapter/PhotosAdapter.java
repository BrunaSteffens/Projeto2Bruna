package com.example.projeto2bruna.adapter;

import android.provider.ContactsContract;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.projeto2bruna.R;
import com.example.projeto2bruna.model.Photos;

import java.util.List;

public class PhotosAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private List<Photos> photos;
    private static final String TAG = "PhotosAdapter";

    public PhotosAdapter(List<Photos> photos) { this.photos = photos; }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        Log.d(TAG, "onCreateViewHolder: Iniciando VH do photos adapter");
        View layoutVHPhotos = LayoutInflater.from(parent.getContext()).inflate(R.layout.layout_photos_vh, parent, false);
        return new AlbumsViewHolder(layoutVHPhotos);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        Log.d(TAG, "onBindViewHolder: VH das photos");
        Photos objeto = photos.get(position);

    }

    @Override
    public int getItemCount() {
        return photos.size();
    }
}

class PhotosViewHolder extends RecyclerView.ViewHolder{
    public View view;
    public PhotosViewHolder(@NonNull View itemView){
        super(itemView);
        view = itemView;
    }
}