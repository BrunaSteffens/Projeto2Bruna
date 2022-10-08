package com.example.projeto2bruna.repository;

import android.content.Context;
import android.util.Log;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.Volley;
import com.example.projeto2bruna.model.Posts;
import com.example.projeto2bruna.model.Todos;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class TodosRepository {
    private final List<Todos> todosList;
    private static TodosRepository instance;
    private Context contexto;
    private final String TAG = "TodosRepository";

    private TodosRepository(Context contexto) {
        super();
        todosList = new ArrayList<>();
        this.contexto = contexto;

        RequestQueue queue = Volley.newRequestQueue(contexto);
        JsonArrayRequest jaRequest =
                new JsonArrayRequest(Request.Method.GET,
                        "https://jsonplaceholder.typicode.com/todos",
                        null,
                        new Response.Listener<JSONArray>() {
                            @Override
                            public void onResponse(JSONArray response) {
                                response.length();
                                for (int i = 0; i < response.length(); i++) {
                                    try {
                                        ;
                                        JSONObject json = response.getJSONObject(i);
                                        todosList.add(new Todos(json.getInt("userId"), json.getInt("id"), json.getString("title"),
                                                json.getString("completed")));
                                        //(int id, int todoId, String title, String status)
                                    } catch (JSONException e) {
                                        e.printStackTrace();
                                    }
                                 }
                            }
                        }, new Response.ErrorListener() {
                            @Override
                            public void onErrorResponse(VolleyError error) {
                                Log.e(TAG, "onErrorResponse: " + error.getMessage());

                            }
                        });
        queue.add(jaRequest);

    }

    public static TodosRepository getInstance(Context contexto){
        if(instance == null){
            instance = new TodosRepository(contexto);
        }
        return instance;
    }

    public List<Todos> getTodos(){ return todosList; }

    public Todos getTodoById(int id){
        Todos ret = null;
        for(Todos t : todosList){
            if (t.getTodoId() == id){
                ret = t;
            }
        }
        return ret;
    }
}
