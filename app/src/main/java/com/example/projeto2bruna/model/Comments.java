package com.example.projeto2bruna.model;

import android.os.Parcel;
import android.os.Parcelable;

public class Comments extends Posts implements Parcelable {

    private int commentId;
    private String commentTitle;
    private String commentEmail;
    private String commentBody;

    public Comments() {
        super();
    }

    public Comments(int id, String name, String userLogin, String password, String email, String phone,
                    int postId, String postName, String postBody,
                    int commentId, String commentTitle, String commentEmail, String commentBody) {
        super(id, name, userLogin, password, email, phone, postId, postName, postBody);
        this.commentId = commentId;
        this.commentTitle = commentTitle;
        this.commentEmail = commentEmail;
        this.commentBody = commentBody;
    }

    public Comments(Parcel in,
                    int commentId, String commentTitle, String commentEmail, String commentBody) {
        super(in);
        this.commentId = commentId;
        this.commentTitle = commentTitle;
        this.commentEmail = commentEmail;
        this.commentBody = commentBody;
    }

    protected Comments(Parcel in){
        super(in);
        commentId = in.readInt();
        commentTitle = in.readString();
        commentEmail = in.readString();
        commentBody = in.readString();
    }

    public static final Creator<Comments> CREATOR = new Creator<Comments>() {
        @Override
        public Comments createFromParcel(Parcel in) {
            return new Comments(in);
        }

        @Override
        public Comments[] newArray(int size) {
            return new Comments[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i){
        parcel.writeInt(commentId);
        parcel.writeString(commentTitle);
        parcel.writeString(commentEmail);
        parcel.writeString(commentBody);
    }

    public int getCommentId() {
        return commentId;
    }

    public String getCommentTitle() {
        return commentTitle;
    }

    public String getCommentEmail() {
        return commentEmail;
    }

    public String getCommentBody() {
        return commentBody;
    }
}
