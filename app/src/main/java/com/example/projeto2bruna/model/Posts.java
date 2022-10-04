package com.example.projeto2bruna.model;

import android.os.Parcel;
import android.os.Parcelable;

public class Posts extends User implements Parcelable {

    private int postId;
    private String postName;
    private String postBody;

    public Posts(){
        super();
    }

    public Posts(int id, int postId, String postName, String postBody) {
        super(id);
        this.postId = postId;
        this.postName = postName;
        this.postBody = postBody;
    }

    public Posts(int id, String name, String userLogin, String password, String email, String phone, int postId, String postName, String postBody) {
        super(id, name, userLogin, password, email, phone);
        this.postId = postId;
        this.postName = postName;
        this.postBody = postBody;
    }

    public Posts(Parcel in, int postId, String postName, String postBody) {
        super(in);
        this.postId = postId;
        this.postName = postName;
        this.postBody = postBody;
    }

    public Posts(int postId, String postName, String postBody) {
        this.postId = postId;
        this.postName = postName;
        this.postBody = postBody;
    }

    protected Posts(Parcel in){
        super(in);
        postId = in.readInt();
        postName = in.readString();
        postBody = in.readString();
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

    @Override
    public void writeToParcel(Parcel parcel, int i){
        parcel.writeInt(postId);
        parcel.writeString(postName);
        parcel.writeString(postBody);
    }

    public int getPostId() {
        return postId;
    }

    public String getPostName() {
        return postName;
    }

    public String getPostBody() {
        return postBody;
    }
}
