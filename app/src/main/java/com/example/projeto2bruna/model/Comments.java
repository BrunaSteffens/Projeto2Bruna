package com.example.projeto2bruna.model;

import android.os.Parcel;
import android.os.Parcelable;

import com.example.projeto2bruna.repository.PostsRepository;

public class Comments implements Parcelable {

    private Posts post;
    private int commentId;
    private String commentTitle;
    private String commentEmail;
    private String commentBody;

    public Comments() {    }

    public Comments(int idPost, int commentId, String commentTitle, String commentEmail, String commentBody) {
        this.post = PostsRepository.getInstance().getPostById(idPost);
        this.commentId = commentId;
        this.commentTitle = commentTitle;
        this.commentEmail = commentEmail;
        this.commentBody = commentBody;
    }

    public Comments(int commentId, String commentTitle, String commentEmail, String commentBody) {
        this.commentId = commentId;
        this.commentTitle = commentTitle;
        this.commentEmail = commentEmail;
        this.commentBody = commentBody;
    }

    protected Comments(Parcel in){
        post = in.readParcelable(Posts.class.getClassLoader());
        commentId = in.readInt();
        commentTitle = in.readString();
        commentEmail = in.readString();
        commentBody = in.readString();
    }

    @Override
    public void writeToParcel(Parcel parcel, int i){
        parcel.writeParcelable(post, 1);
        parcel.writeInt(commentId);
        parcel.writeString(commentTitle);
        parcel.writeString(commentEmail);
        parcel.writeString(commentBody);
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

    public Posts getPost() { return post; }
}
