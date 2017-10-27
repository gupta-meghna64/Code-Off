package com.example.codeoff;

/**
 * Created by adsrc on 28/10/17.
 */

public class PostComment {


    private User _commenter;
    private String _text;


    public User get_commenter() {
        return _commenter;
    }

    public void set_commenter(User _commenter) {
        this._commenter = _commenter;
    }

    public String get_text() {
        return _text;
    }

    public void set_text(String _text) {
        this._text = _text;
    }


}
