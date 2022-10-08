package com.example.projeto2bruna.model;

import android.os.Parcel;
import android.os.Parcelable;

import com.example.projeto2bruna.repository.UserRepository;

public class Posts implements Parcelable {

    private User user;
    private int postId;
    private String postTitle;
    private String postBody;

    public Posts(){    }


    public Posts(int idUser, int postId, String postTitle, String postBody) {
        this.user = UserRepository.getInstance().getUserById(idUser);
        this.postId = postId;
        this.postTitle = postTitle;
        this.postBody = postBody;
    }

    public Posts(int postId, String postTitle, String postBody) {
        this.postId = postId;
        this.postTitle = postTitle;
        this.postBody = postBody;
    }

    protected Posts(Parcel in){
        user = in.readParcelable(User.class.getClassLoader());
        postId = in.readInt();
        postTitle = in.readString();
        postBody = in.readString();
    }

    @Override
    public void writeToParcel(Parcel parcel, int i){
        parcel.writeParcelable(user, 1);
        parcel.writeInt(postId);
        parcel.writeString(postTitle);
        parcel.writeString(postBody);
    }

    public static final Creator<Posts> CREATOR = new Creator<Posts>() {
        @Override
        public Posts createFromParcel(Parcel in) {
            return new Posts(in);
        }

        @Override
        public Posts[] newArray(int size) {
            return new Posts[size];
        }
    };

    public Posts(int postId) {
        this.postId = postId;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public int getPostId() {
        return postId;
    }

    public String getPostTitle() {
        return postTitle;
    }

    public String getPostBody() {
        return postBody;
    }

    public User getUser() {return user; }
}
