package com.example.projeto2bruna.presenter;

import android.app.Activity;
import android.content.Context;
import android.view.View;

import com.example.projeto2bruna.model.Albums;
import com.example.projeto2bruna.model.Posts;
import com.example.projeto2bruna.model.User;
import com.example.projeto2bruna.repository.AlbumRepository;
import com.example.projeto2bruna.repository.PostsRepository;
import com.example.projeto2bruna.repository.UserRepository;

public class UserPresenter {
    private Context contexto;
    private UserContract.view view;

    public UserPresenter(UserContract.view view) { this.view = view;}

    public void getUserData(User user){
        UserRepository uRepo = UserRepository.getInstance(contexto);
        User u = uRepo.getUserById(user.getId());
        AlbumRepository aRepo = AlbumRepository.getInstance(contexto);
        Albums a = aRepo.getAlbumByUserId(user.getId());
        PostsRepository pRepo = PostsRepository.getInstance(contexto);
        Posts p = pRepo.getPostByUserId(user.getId());
    }
}