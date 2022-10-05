package com.example.projeto2bruna.model;

import android.os.Parcel;
import android.os.Parcelable;

public class Photos extends Albums implements Parcelable {
    private int photoId;
    private String photoTitle;
    private String photoUrl;
    private String photoThumbnailUrl;

    public Photos() {
        super();
    }

    public Photos(int id, String name, String userLogin, String password, String email, String phone,
                  int photoId, String photoTitle, String photoUrl, String photoThmbnailUrl) {
        super(id, name, userLogin, password, email, phone);
        this.photoId = photoId;
        this.photoTitle = photoTitle;
        this.photoUrl = photoUrl;
        this.photoThumbnailUrl = photoThumbnailUrl;
    }

    public Photos(int id, String name, String userLogin, String password, String email, String phone,
                  int albumId, String title,
                  int photoId, String photoTitle, String photoUrl, String photoThumbnailUrl) {
        super(id, name, userLogin, password, email, phone, albumId, title);
        this.photoId = photoId;
        this.photoTitle = photoTitle;
        this.photoUrl = photoUrl;
        this.photoThumbnailUrl = photoThumbnailUrl;
    }

    public Photos(Parcel in, int photoId, String photoTitle, String photoUrl, String photoThumbnailUrl) {
        super(in);
        this.photoId = photoId;
        this.photoTitle = photoTitle;
        this.photoUrl = photoUrl;
        this.photoThumbnailUrl = photoThumbnailUrl;
    }

    protected Photos(Parcel in){
        super(in);
        photoId = in.readInt();
        photoTitle = in.readString();
        photoUrl = in.readString();
        photoThumbnailUrl = in.readString();
    }

    public static final Creator<Photos> CREATOR = new Creator<Photos>() {
        @Override
        public Photos createFromParcel(Parcel in) {

            return new Photos(in);
        }

        @Override
        public Photos[] newArray(int size) {

            return new Photos[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i){
        parcel.writeInt(photoId);
        parcel.writeString(photoTitle);
        parcel.writeString(photoUrl);
        parcel.writeString(photoThumbnailUrl);
    }


}
