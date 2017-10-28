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

    public ArrayList<String> get_topics() {
        return _topics;
    }

    public String getType() {
        return type;
    }
    

    public ArrayList<PostComment> get_comments() {
        return _comments;
    }







}
