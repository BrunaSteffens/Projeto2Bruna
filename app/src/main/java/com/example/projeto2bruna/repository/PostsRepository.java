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
import com.example.projeto2bruna.model.User;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class PostsRepository {
    private final List<Posts> posts;
    private static PostsRepository instance;
    private Context contexto;
    private final String TAG = "PostsRepository";

    private PostsRepository(Context contexto) {
        super();
        posts = new ArrayList<>();
        this.contexto = contexto;

        RequestQueue queue = Volley.newRequestQueue(contexto);
        JsonArrayRequest jaRequest =
                new JsonArrayRequest(Request.Method.GET,
                        "https://jsonplaceholder.typicode.com/posts",
                        null,
                        new Response.Listener<JSONArray>() {
                            @Override
                            public void onResponse(JSONArray response) {
                                response.length();
                                for (int i = 0; i < response.length(); i++) {
                                    try {
                                        JSONObject json = response.getJSONObject(i);
                                        posts.add(new Posts(json.getInt("userId"), json.getInt("id"), json.getString("title"),
                                                json.getString("body")));
                                        //(int id, int postId, String postName, String postBody)
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

    public static PostsRepository getInstance(Context contexto){
        if(instance == null){
            instance = new PostsRepository(contexto);
        }
        return instance;
    }

    public List<Posts> getPosts(Posts p){ return posts; }

    public Posts getPostById(int id){
        Posts ret = null;
        for(Posts p : posts){
            if (p.getPostId() == id){
                ret = p;
            }
        }
        return ret;
    }

    public Posts getPostByUserId(int id){
        Posts ret = null;
        Log.d(TAG, "getPostByUserId: qtd de posts do user" +posts.size());
        for(Posts p: posts){
            if(p.getId() == id){
                Log.d(TAG, "getPostByUserId: buscando os posts do userId"+p.getId());
                ret = p;
            }
        }
        return ret;
    }

}
