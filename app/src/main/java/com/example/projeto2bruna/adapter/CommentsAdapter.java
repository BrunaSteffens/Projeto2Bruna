package com.example.projeto2bruna.adapter;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.projeto2bruna.R;
import com.example.projeto2bruna.model.Comments;

import java.util.List;

public class CommentsAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private static final String TAG = "CommentsAdapter";
    private List<Comments> commentsList;

    public CommentsAdapter(List<Comments> commentsList){
        this.commentsList = commentsList;
    }


    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        Log.d(TAG, "onCreateViewHolder: iniciando viewHolder do commentAdapter");
        View layoutVH = LayoutInflater.from(parent.getContext()).inflate(R.layout.layout_todos_vh, parent, false);
        return new CommentsViewHolder(layoutVH);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        Comments objeto = commentsList.get(position);
        ((TextView) holder.itemView.findViewById(R.id.com))



    }

    @Override
    public int getItemCount() {
        return commentsList.size();
    }
}

class CommentsViewHolder extends RecyclerView.ViewHolder{
    public View view;


    public CommentsViewHolder(@NonNull View itemView) {
        super(itemView);
        view = itemView;
    }
}