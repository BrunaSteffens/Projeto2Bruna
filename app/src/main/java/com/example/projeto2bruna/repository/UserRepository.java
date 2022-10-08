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
import com.example.projeto2bruna.view.AlbumActivity;
import com.google.android.material.snackbar.Snackbar;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

import javax.xml.transform.ErrorListener;
import javax.xml.transform.TransformerException;

public class UserRepository {
    private final List<User> users;
    private static UserRepository instance;
    private Context contexto;
    private final String TAG = "UserRepository";

    private UserRepository(Context contexto){
        super();
        users = new ArrayList<>();
        this.contexto = contexto;


        RequestQueue queue = Volley.newRequestQueue(contexto);
        JsonArrayRequest jaRequest =
                new JsonArrayRequest(Request.Method.GET,
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
                                json.getString("username"), json.getString("username"), json.getString("email"), json.getString("phone")));

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

    public User getUserByUserId(int id) {
        User ret = null;
        Log.d(TAG, "getUserByUserLogin: " + users.size());
        for(User u : users) {
            Log.d(TAG, "getUserByUserLogin: "+id+"  ->"+u.getUserLogin());
            if (u.getId()==id) {
                ret = u;
            }
        }
        return ret;
    }

}
