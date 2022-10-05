package com.example.projeto2bruna.model;

import static java.lang.System.in;

import android.os.Parcel;
import android.os.Parcelable;

public class User implements Parcelable {

    private int id;
    private String name;
    private String userLogin;
    private String password;
    private String email;
    private String phone;

    public User(int id) {
        this.id = id;
    }

    public User(int id, String name, String userLogin, String password, String email, String phone) {
        this.id = id;
        this.name = name;
        this.userLogin = userLogin;
        this.password = password;
        this.email = email;
        this.phone = phone;
    }

    protected User(Parcel in) {
        id = in.readInt();
        name = in.readString();
        userLogin = in.readString();
        password = in.readString();
        email = in.readString();
        phone = in.readString();
    }

    @Override
    public int describeContents() {

        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(id);
        parcel.writeString(name);
        parcel.writeString(userLogin);
        parcel.writeString(password);
        parcel.writeString(email);
        parcel.writeString(phone);
    }

    public static final Creator<User> CREATOR = new Creator<User>() {
        @Override
        public User createFromParcel(Parcel in) {

            return new User(in);
        }

        @Override
        public User[] newArray(int size) {

            return new User[size];
        }
    };

    public User() {
    }

    public int getId() { return id; }

    public String getName() { return name; }

    public String getTitulo() {
        return userLogin+" - "+name+" ("+id+")";
    }

    public String getPassword() {
        return password;
    }

    public String getUserLogin() {
        return userLogin;
    }

    public String getEmail() {
        return email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPassword(String password) {
        this.password = password;
    }


}
