package com.example.projeto2bruna.model;

import android.os.Parcel;
import android.os.Parcelable;

import com.example.projeto2bruna.repository.UserRepository;

public class Albums implements Parcelable{

    private User user;
    private int albumId;
    private String title;

    public Albums(){    }

    public Albums(int userId, int albumId, String title) {
        this.user = UserRepository.getInstance().getUserById(userId);
        this.albumId = albumId;
        this.title = title;
    }

    public Albums(int albumId) {
        this.albumId = albumId;
    }


    @Override
    public void writeToParcel(Parcel parcel, int i){
        parcel.writeParcelable(user, 1);
        parcel.writeInt(albumId);
        parcel.writeString(title);
    }

    protected Albums(Parcel in){
        user = in.readParcelable(User.class.getClassLoader());
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

    public int getAlbumId() { return albumId; }

    public String getTitle() { return title;}

    public User getUser() { return user; }

    public String getUserName() {
        return getUser().getName();
    }
}
