package com.example.codeoff;

import java.util.ArrayList;

/**
 * Created by jains on 28-10-2017.
 */

public class Blog {

    private String _title;
    private String _description;
    private String _uploader;
    private ArrayList<PostComment> _comments;

    public String get_title() {
        return _title;
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
