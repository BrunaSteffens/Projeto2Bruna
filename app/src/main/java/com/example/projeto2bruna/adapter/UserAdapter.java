package com.example.projeto2bruna.adapter;

import android.content.Intent;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.example.projeto2bruna.R;
import com.example.projeto2bruna.model.Albums;
import com.example.projeto2bruna.model.User;
import com.example.projeto2bruna.view.AlbumActivity;
import com.example.projeto2bruna.view.UsersActivity;

import java.util.List;

public class UserAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private List<User> dados;
    private final String TAG = "UserAdapter";


    public UserAdapter(List<User> dados) {
        this.dados = dados;
    }


    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        Log.d(TAG, "onCreateViewHolder: iniciando a viewholder do useradapter");
        View layoutVH = LayoutInflater.from(parent.getContext()).inflate(R.layout.layout_user_vh, parent, false);
        return new UserViewHolder(layoutVH);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, final int position) {
        Log.d(TAG, "onBindViewHolder: O onBindViewHolder está sendo trazido agora");
        User objeto = dados.get(position);
        ((TextView) holder.itemView.findViewById(R.id.textViewId)).setText(objeto.getId() + "");
        ((TextView) holder.itemView.findViewById(R.id.textViewName)).setText(objeto.getName());

        holder.itemView.setOnClickListener((view) -> {
            Intent intent = new Intent(view.getContext(), UsersActivity.class);
            intent.putExtra("objetoUsuario", objeto);
            intent.putExtra("username", objeto.getUserLogin());
            view.getContext().startActivity(intent);
            Log.d(TAG, "onBindViewHolder: Página do usuário " + objeto.getName());
            }
        );

    }

    @Override
    public int getItemCount() {
        return dados.size();
    }
}
class UserViewHolder extends RecyclerView.ViewHolder  {
        public View view;

        public UserViewHolder(@NonNull View itemView) {
            super(itemView);
            view = itemView;
        }
}


