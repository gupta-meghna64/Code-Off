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


}
