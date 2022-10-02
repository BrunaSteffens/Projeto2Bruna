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
import com.example.projeto2bruna.model.Posts;
import com.example.projeto2bruna.model.Todos;
import com.example.projeto2bruna.view.PostsActivity;
import com.example.projeto2bruna.view.TodosActivity;

import java.util.List;

public class TodosAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private static final String TAG = "TodosAdapter";
    private List<Todos> todosList;

    public TodosAdapter(List<Todos> todosList){ this.todosList = todosList;}


    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        Log.d(TAG, "onCreateViewHolder: iniciando a viewHolder do todosAdapter");
        View layoutVH = LayoutInflater.from(parent.getContext()).inflate(R.layout.layout_todos_vh, parent, false);
        return new TodosViewHolder(layoutVH);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {

        Todos objeto = todosList.get(position);
        ((TextView) holder.itemView.findViewById(R.id.vhTodoId)).setText(objeto.getTodoId() + "");
        ((TextView) holder.itemView.findViewById(R.id.vhTodoTitle)).setText(objeto.getTodoTitle());
        ((TextView) holder.itemView.findViewById(R.id.vhTodoStatus)).setText(objeto.getTodoStatus());

        holder.itemView.setOnClickListener(
                (view) ->{
                    Intent intent = new Intent(view.getContext(), TodosActivity.class);
                    intent.putExtra("id", objeto.getTodoId());
                    intent.putExtra("userId", objeto.getId());
                    view.getContext().startActivity(intent);
                    Log.d(TAG, "onBindViewHolder: Todos do usuário" + objeto.getName());
                }
        );

    }

    @Override
    public int getItemCount() {
        return todosList.size();
    }
}

class TodosViewHolder extends RecyclerView.ViewHolder{
    public View view;


    public TodosViewHolder(@NonNull View itemView) {
        super(itemView);
        view = itemView;
    }
}
