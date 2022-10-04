package com.example.projeto2bruna.adapter;

import android.content.Intent;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.projeto2bruna.R;
import com.example.projeto2bruna.model.Comments;
import com.example.projeto2bruna.view.CommentsActivity;

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
        View layoutVH = LayoutInflater.from(parent.getContext()).inflate(R.layout.layout_comments_vh, parent, false);
        return new CommentsViewHolder(layoutVH);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        Comments objeto = commentsList.get(position);
        ((TextView) holder.itemView.findViewById(R.id.commentId)).setText(objeto.getCommentId()+"");
        ((TextView) holder.itemView.findViewById(R.id.commentEmail)).setText(objeto.getCommentEmail());
        ((TextView) holder.itemView.findViewById(R.id.commentTitle)).setText(objeto.getCommentTitle());
        ((EditText) holder.itemView.findViewById(R.id.commentBody)).setText(objeto.getCommentBody());

        holder.itemView.setOnClickListener(
                (view) ->{
                    Intent intent = new Intent(view.getContext(), CommentsActivity.class);
                    intent.putExtra("objetoUsuario", objeto);
                    view.getContext().startActivity(intent);
                    Log.d(TAG, "onBindViewHolder: Comments do post do usuário" + objeto.getName());
                }
        );

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