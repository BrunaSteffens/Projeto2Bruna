package com.example.projeto2bruna.model;

import android.os.Parcel;

public class Albums extends User{

    private int albumId;
    private String title;

    public Albums(int id, String name, String userLogin, String password, String email, String phone, int albumId, String title) {
        super(id, name, userLogin, password, email, phone);
        this.albumId = albumId;
        this.title = title;
    }

    public Albums(int id, String name, String userLogin, String password, String email, String phone) {
        super(id, name, userLogin, password, email, phone);
    }

    public Albums(){
        super();
    }

    public int getAlbumId() { return albumId; }

    public String getTitle() { return title;}

    public Albums(int id, int albumId, String title) {
        super(id);
        this.albumId = albumId;
        this.title = title;
    }

    protected Albums(Parcel in){
        super(in);
        albumId = in.readInt();
        title = in.readString();
    }

    public static final Creator<Albums> CREATOR = new Creator<Albums>() {
        @Override
        public Albums createFromParcel(Parcel in) {
            return new Albums(in);
        }

        @Override
        public Albums[] newArray(int size) {
            return new Albums[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i){
        parcel.writeInt(albumId);
        parcel.writeString(title);
    }


}
