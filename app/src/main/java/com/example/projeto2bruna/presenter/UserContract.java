package com.example.projeto2bruna.presenter;

import android.app.Activity;
import com.example.projeto2bruna.model.User;

public class UserContract {
     public interface view {
            public void message(String msg);
            public Activity getActivity();
        }

        public interface presenter {
            public void getUserData(User user);
        }
}