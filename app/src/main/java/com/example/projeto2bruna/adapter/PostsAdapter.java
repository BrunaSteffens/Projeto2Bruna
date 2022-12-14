package com.example.projeto2bruna.adapter;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.example.projeto2bruna.R;
import com.example.projeto2bruna.model.Posts;

import java.util.List;

public class PostsAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private static final String TAG = "PostsAdapter";
    private List<Posts> postsList;

    public PostsAdapter(List<Posts> postsList){
        this.postsList = postsList;
    }


    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        Log.d(TAG, "onCreateViewHolder: iniciando a viewHolder do postsAdapter");
        View layoutVH = LayoutInflater.from(parent.getContext()).inflate(R.layout.layout_posts_vh, parent, false);
        return new PostsViewHolder(layoutVH);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        Posts objeto = postsList.get(position);
        ((TextView) holder.itemView.findViewById(R.id.postId)).setText(objeto.getPostId() + "");
        ((TextView) holder.itemView.findViewById(R.id.postTitle)).setText(objeto.getPostTitle());
        ((TextView) holder.itemView.findViewById(R.id.postBody)).setText(objeto.getPostBody());
        ((TextView) holder.itemView.findViewById(R.id.tvPostsEmail)).setText(objeto.getUser().getEmail());

    }

    @Override
    public int getItemCount() {
        return postsList.size();
    }
}

class PostsViewHolder extends RecyclerView.ViewHolder{
    public View view;


    public PostsViewHolder(@NonNull View itemView) {
        super(itemView);
        view = itemView;
    }
}