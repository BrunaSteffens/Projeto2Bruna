package com.example.projeto2bruna.model;

import android.os.Parcel;
import android.os.Parcelable;

public class Todos extends User implements Parcelable {

    private int todoId;
    private String todoTitle;
    private String todoStatus;

    public Todos() {
        super();
    }

    public Todos(int id, String name, String userLogin, String password, String email, String phone, int todoId, String todoTitle, String todoStatus) {
        super(id, name, userLogin, password, email, phone);
        this.todoId = todoId;
        this.todoTitle = todoTitle;
        this.todoStatus = todoStatus;
    }

    public Todos(int id, int todoId, String todoTitle, String todoStatus) {
        super(id);
        this.todoId = todoId;
        this.todoTitle = todoTitle;
        this.todoStatus = todoStatus;
    }

    protected Todos(Parcel in){
        super(in);
        todoId = in.readInt();
        todoTitle = in.readString();
        todoStatus = in.readString();
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

    @Override
    public void writeToParcel(Parcel parcel, int i){
        parcel.writeInt(todoId);
        parcel.writeString(todoTitle);
        parcel.writeString(todoStatus);
    }

}
