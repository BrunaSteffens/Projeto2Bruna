package com.example.projeto2bruna.presenter;

import android.content.Intent;
import android.content.res.Resources;
import android.util.Log;
import com.example.projeto2bruna.R;
import com.example.projeto2bruna.model.User;
import com.example.projeto2bruna.repository.UserRepository;
import com.example.projeto2bruna.view.MainActivity;

public class LoginPresenter implements LoginPresenterContract.presenter{

    private LoginPresenterContract.view view;


    public LoginPresenter(LoginPresenterContract.view view){
        this.view = view;
    }

    @Override
    public void checkLogin(String login, String password) {
        UserRepository repo = UserRepository.getInstance(view.getActivity(), null);
        User u = repo.getUserByUserLogin(login);
        if (u== null || !u.getPassword().equals(password)){
            view.message("Usuário ou senha inválidos");
            //Testar usar dentro da mensagem: Resources.getSystem().getString(R.string.userpassinvalid)
        } else {
            validLogin(u);
        }
    }

    @Override
    public void validLogin(User user) {
        Intent intent = new Intent(view.getActivity(), MainActivity.class);
        //substituído devido ao parcelable   intent.putExtra("userId", user.getId());
        intent.putExtra("userObj", user);
        view.getActivity().startActivity(intent);
    }

}
