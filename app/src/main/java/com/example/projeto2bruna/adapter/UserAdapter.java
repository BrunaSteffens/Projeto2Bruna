package com.example.projeto2bruna.adapter;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.example.projeto2bruna.R;
import com.example.projeto2bruna.model.User;
import com.example.projeto2bruna.view.Activity2;

import java.util.List;

public class UserAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private List<User> dados;

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View layoutVH = LayoutInflater.from(parent.getContext()).inflate(R.layout.layout_user_vh, parent, false);
        return new UserViewHolder(layoutVH);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        User objeto = dados.get(position);
        TextView tv1 = holder.itemView.findViewById(R.id.textViewId);
        tv1.setText(objeto.getId()+" ");
        ((TextView) holder.itemView.findViewById(R.id.textViewName)).setText(objeto.getName());
        holder.itemView.setOnClickListener((view) ->{
            Intent intent = new Intent(view.getContext(), Activity2.class);
            intent.putExtra("id", objeto.getId());
            view.getContext().startActivity(intent);
        });
    }

    @Override
    public int getItemCount() {
        return dados.size();
    }
}

class UserViewHolder extends RecyclerView.ViewHolder{
    public View view;
    public UserViewHolder(@NonNull View itemView) {
        super(itemView);
        view = itemView;
    }
}
