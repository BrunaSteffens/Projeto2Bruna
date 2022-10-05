package com.example.projeto2bruna.repository;

import static android.net.Uri.writeToParcel;

import android.content.Context;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.Volley;
import com.example.projeto2bruna.adapter.UserAdapter;
import com.example.projeto2bruna.model.Albums;
import com.example.projeto2bruna.model.Posts;
import com.example.projeto2bruna.view.AlbumActivity;

import android.util.Log;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class AlbumRepository {
    private final String TAG = "Album Repository";
    private final List<Albums> albums;
    private static AlbumRepository instance;
    private Context context;

    private AlbumRepository(Context context){
        super();
        albums = new ArrayList<>();
        this.context = context;

        RequestQueue albumQueue = Volley.newRequestQueue(context);
        JsonArrayRequest jsonArrayRequest = new JsonArrayRequest(Request.Method.GET,
                "https://jsonplaceholder.typicode.com/albums",
                null,
                new Response.Listener<JSONArray>() {
                    @Override
                     public void onResponse(JSONArray response) {
                        Log.e(TAG, "onResponse: "+response.length());

                        for(int i=0; i< response.length(); i++){
                            try {
                                JSONObject json = response.getJSONObject(i);
                                Log.d(TAG, "onResponse: "+json.toString());
                                albums.add(new Albums(json.getInt("userId"),
                                        json.getInt("id"), json.getString("title")));

                            } catch (JSONException e) {
                                e.printStackTrace();
                            }
                        }
                        Log.e(TAG, "onResponse: Inclusão dos álbuns finalizada");
                    }
                },
                new Response.ErrorListener(){
                        @Override
                        public void onErrorResponse (VolleyError error){
                        Log.e(TAG, "onErrorResponse: " + error.getMessage());
                    }
                });

        albumQueue.add(jsonArrayRequest);

        Log.e(TAG, "AlbumRepository: Repositório de álbuns lançado");
    }


    public static AlbumRepository getInstance(Context context){
        if (instance == null){
            instance = new AlbumRepository(context);
        }
        return instance;
    }

    public List<Albums> getAlbums(){ return albums; }


    public Albums getAlbumById(int albumId){
        Albums ret = null;
        Log.d(TAG, "getAlbumByTitle: "+albums.size());
        for(Albums a : albums){
            Log.d(TAG, "getAlbumById: " + albumId+ " ->" +a.getAlbumId());
            if(a.getAlbumId()==albumId){
                ret = a;
            }
        }
        return ret;
    }

    public Albums getAlbumByUserId(int id){
        Albums ret = null;
        Log.d(TAG, "getAlbumByUserId: qtd de posts do user" +albums.size());
        for(Albums a: albums){
            if(a.getId() == id){
                Log.d(TAG, "getPostByUserId: buscando os posts do userId"+a.getId());
                ret = a;
            }
        }
        return ret;
    }
}