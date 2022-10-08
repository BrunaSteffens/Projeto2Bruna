package com.example.projeto2bruna.model;

import android.os.Parcel;
import android.os.Parcelable;

import com.example.projeto2bruna.repository.UserRepository;

public class Todos implements Parcelable {

    private User user;
    private int todoId;
    private String todoTitle;
    private String todoStatus;

    public Todos() { }

    public Todos(int idUser, int todoId, String todoTitle, String todoStatus) {
        this.user = UserRepository.getInstance().getUserById(idUser);
        this.todoId = todoId;
        this.todoTitle = todoTitle;
        this.todoStatus = todoStatus;
    }

    public Todos(int todoId, String todoTitle, String todoStatus) {
        this.todoId = todoId;
        this.todoTitle = todoTitle;
        this.todoStatus = todoStatus;
    }

    protected Todos(Parcel in){
        user = in.readParcelable(User.class.getClassLoader());
        todoId = in.readInt();
        todoTitle = in.readString();
        todoStatus = in.readString();
    }

    @Override
    public void writeToParcel(Parcel parcel, int i){
        parcel.writeParcelable(user, 1);
        parcel.writeInt(todoId);
        parcel.writeString(todoTitle);
        parcel.writeString(todoStatus);
    }

    public int getTodoId() {
        return todoId;
    }

    public String getTodoTitle() {
        return todoTitle;
    }

    public String getTodoStatus() {
        return todoStatus;
    }

    public User getUser() { return user; }

    public static final Creator<Todos> CREATOR = new Creator<Todos>() {
        @Override
        public Todos createFromParcel(Parcel in) {
            return new Todos(in);
        }

        @Override
        public Todos[] newArray(int size) {
            return new Todos[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

}
