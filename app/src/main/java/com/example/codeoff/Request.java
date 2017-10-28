package com.example.codeoff;

import java.util.ArrayList;

/**
 * Created by adsrc on 28/10/17.
 */

public class Request {

    private String _title;
    private ArrayList<String> _tags;
    private String _description;
    private String _uploader;
    private ArrayList<PostComment> _comments;


    public String get_title() {
        return _title;
    }

    public ArrayList<String> get_tags() {
        return _tags;
    }


    public String get_description() {
        return _description;
    }

    public String get_uploader() {
        return _uploader;
    }

    public ArrayList<PostComment> get_comments() {
        return _comments;
    }


    public void set_title(String _title) {
        this._title = _title;
    }

    public void set_tags(ArrayList<String> _tags) {
        this._tags = _tags;
    }

    public void set_description(String _description) {
        this._description = _description;
    }

    public void set_uploader(String _uploader) {
        this._uploader = _uploader;
    }

    public void set_comments(ArrayList<PostComment> _comments) {
        this._comments = _comments;
    }



}
