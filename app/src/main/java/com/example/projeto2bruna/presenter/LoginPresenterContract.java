package com.example.projeto2bruna.presenter;

import android.app.Activity;
import android.content.Context;

import com.example.projeto2bruna.model.User;

import java.security.PublicKey;

public class LoginPresenterContract {

    //Criando as interfaces, que são os 'contratos' para serem implementados por alguém.

    //Um é o método que vai apresentar a mensagem e o outro é o método que vai pegar os
    // dados da activity, levar até o método de login e executá-lo para checar o login
    public interface view{
        public void message(String msg);
        public Activity getActivity();

    }

    public interface presenter{
        public void checkLogin(String login,String password);
        public void validLogin(User user);
    }


}
