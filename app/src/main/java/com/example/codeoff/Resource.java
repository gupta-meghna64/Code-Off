package com.example.codeoff;

import java.util.ArrayList;

/**
 * Created by adsrc on 28/10/17.
 */

public class Resource {

    private String _title;
    private ArrayList<String> _tags;
    private int _upvotes;
    private int _downvotes;
    private String _description;
    private String _uploader;
    private ArrayList<String> _topics;
    private String type;
    private String _link;
    private ArrayList<PostComment> _comments;


    public String get_title() {
        return _title;
    }

    public ArrayList<String> get_tags() {
        return _tags;
    }

    public int get_upvotes() {
        return _upvotes;
    }

    public int get_downvotes() {
        return _downvotes;
    }

    public String get_description() {
        return _description;
    }

    public String get_uploader() {
        return _uploader;
    }

    public void set_title(String _title) {
        this._title = _title;
    }

    public void set_tags(ArrayList<String> _tags) {
        this._tags = _tags;
    }

    public void set_upvotes(int _upvotes) {
        this._upvotes = _upvotes;
    }

    public void set_downvotes(int _downvotes) {
        this._downvotes = _downvotes;
    }

    public void set_description(String _description) {
        this._description = _description;
    }

    public void set_uploader(String _uploader) {
        this._uploader = _uploader;
    }

    public void set_topics(ArrayList<String> _topics) {
        this._topics = _topics;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void set_link(String _link) {
        this._link = _link;
    }

    public void set_comments(ArrayList<PostComment> _comments) {
        this._comments = _comments;
    }

    public ArrayList<String> get_topics() {
        return _topics;
    }

    public String getType() {
        return type;
    }


    public ArrayList<PostComment> get_comments() {
        return _comments;
    }


    public String get_link() {
        return _link;
    }



}
