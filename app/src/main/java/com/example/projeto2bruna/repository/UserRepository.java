package com.example.projeto2bruna.repository;

import android.app.DownloadManager;
import android.content.Context;
import android.util.Log;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.example.projeto2bruna.model.User;
import com.google.android.material.snackbar.Snackbar;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

import javax.xml.transform.ErrorListener;
import javax.xml.transform.TransformerException;

public class UserRepository {
    private List<User> users;
    private static UserRepository instance;
    private Context contexto;
    private final String TAG = "UserRepository";

    private UserRepository(Context contexto){
        super();
        users = new ArrayList<>();
        this.contexto = contexto;

        RequestQueue queue = Volley.newRequestQueue(contexto);
        JsonArrayRequest jaRequest = new JsonArrayRequest(Request.Method.GET,
                "https://jsonplaceholder.typicode.com/users",
                null,
                new Response.Listener<JSONArray>() {
            @Override
            public void onResponse(JSONArray response) {
                response.length();
                for(int i=0; i<response.length(); i++){
                    try {
                        JSONObject json = response.getJSONObject(i);
                        users.add( new User(json.getInt("id"), json.getString("name"),
                                json.getString("username"), json.getString("username")));

                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                }
            }
        }, new Response.ErrorListener() {

            @Override
            public void onErrorResponse(VolleyError error) {
                Log.e(TAG, "onErrorResponse: " );

            }
        });

        queue.add(jaRequest);

        //String url = "";
        /*
        users.add( new User(1, "Jean", "jp1", "1234"));
        users.add( new User(2, "Jean 2", "jp2", "1234"));
        users.add( new User(3, "Jean 3", "jp3", "1234"));
        users.add( new User(4, "Jean 4", "jp4", "1234"));
        users.add( new User(11, "Jean 11", "jp1", "1234"));
        users.add( new User(12, "Jean 12", "jp2", "1234"));
        users.add( new User(13, "Jean 13", "jp3", "1234"));
        users.add( new User(14, "Jean 14", "jp4", "1234"));
         */
    }

    public static UserRepository getInstance(Context contexto){
        if (instance== null){
            instance = new UserRepository(contexto);
        }
        return instance;
    }

    public List<User> getUsers() {
        return users;
    }
    public User getUserById(int id) {
        User ret = null;
        for(User u : users) {
            if (u.getId() == id) {
                ret = u;
            }
        }
        return ret;
    }


    public User getUserByUserLogin(String login) {
        User ret = null;
        Log.d(TAG, "getUserByUserLogin: " + users.size());
        for(User u : users) {
            Log.d(TAG, "getUserByUserLogin: "+login+"  ->"+u.getUserLogin());
            if (u.getUserLogin().equals(login)) {
                ret = u;
            }
        }
        return ret;
    }

}
