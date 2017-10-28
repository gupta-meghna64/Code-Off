package com.example.codeoff;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

/**
 * Created by HP on 28-10-2017.
 */

public class AddResourceFragment  extends Fragment {

    private EditText typeResource;
    private EditText linkResource;
    private EditText descriptionResource;
    private EditText tagsResource;
    private long count;
    private FirebaseAuth mFirebaseAuth;
    private FirebaseUser mFirebaseUser;
    private DatabaseReference mDatabase;
    private String mUserId;
    private String name;
    private Button share;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        //returning our layout file
        //change R.layout.yourlayoutfilename for each of your fragments
        return inflater.inflate(R.layout.fragment_add_resource, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        //you can set the title for your toolbar here for different fragments different titles
        getActivity().setTitle("Requests");
        share = (Button) getView().findViewById(R.id.shareResourceButton);
        mFirebaseAuth = FirebaseAuth.getInstance();
        mFirebaseUser = mFirebaseAuth.getCurrentUser();
        mDatabase = FirebaseDatabase.getInstance().getReference();
        typeResource = (EditText) getView().findViewById(R.id.typeResource);
        linkResource = (EditText) getView().findViewById(R.id.linkResource);
        descriptionResource = (EditText) getView().findViewById(R.id.descriptionResource);
        tagsResource = (EditText) getView().findViewById(R.id.tagsResource);

        if (mFirebaseUser == null) {
            // Not logged in, launch the Log In activity
            loadLogInView();
        } else {
            mUserId = mFirebaseUser.getUid();

            mDatabase.addListenerForSingleValueEvent(new ValueEventListener() {
                @Override
                public void onDataChange(DataSnapshot dataSnapshot) {
                    int k = 0;
                    for (DataSnapshot d : dataSnapshot.child("Private User Data").child(mUserId).getChildren()) {
                        if (k == 0) {
                            User c = d.getValue(User.class);
                            String nameVal = c.getName();
                            name = nameVal;
                            k++;
                        }
                    }
                    count = dataSnapshot.child("Resource").getChildrenCount();
                }

                @Override
                public void onCancelled(DatabaseError databaseError) {

                }
            });
        }


        share.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Resource res = new Resource();
                res.setType(typeResource.getText().toString());
                res.set_description(descriptionResource.getText().toString());
                res.set_link(linkResource.getText().toString());
                res.set_uploader(name);
                ArrayList<String> a = new ArrayList<String>();
                a.add("java");
                a.add("android");
                res.set_tags(a);

                PostComment c = new PostComment();
                c.set_commenter("Arpit Bhatia");
                c.set_text("Comment");

                ArrayList<PostComment> al = new ArrayList<PostComment>();
                al.add(c);

                res.set_comments(al);
                res.set_downvotes(1);
                res.set_upvotes(100);
                mDatabase = FirebaseDatabase.getInstance().getReference();
                mDatabase.child("Resource").child(Long.toString(count+1)).push().setValue(res);

            }
        });




        }
    private void loadLogInView() {
        Intent intent = new Intent(getActivity(), SignIn.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK);
        startActivity(intent);
    }
}
