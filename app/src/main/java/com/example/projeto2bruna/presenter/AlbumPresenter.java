package com.example.projeto2bruna.presenter;

import android.content.Intent;

import com.example.projeto2bruna.model.Albums;
import com.example.projeto2bruna.model.User;
import com.example.projeto2bruna.repository.AlbumRepository;

import java.util.List;

public class AlbumPresenter {
    private List<Albums> albumsList;
    private PresenterContract.view view;

    public Albums setUser(User user){
        AlbumRepository aRepo = AlbumRepository.getInstance(view.getActivity());
        Albums a = aRepo.getAlbumByUserId(user.getId());
        return a;
    }

}

