package com.example.codeoff;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

/**
 * Created by HP on 28-10-2017.
 */

public class ResourcesFragment extends Fragment {

    private DatabaseReference mDatabase;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        //returning our layout file
        //change R.layout.yourlayoutfilename for each of your fragments
        return inflater.inflate(R.layout.fragment_resources, container, false);
    }


    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        //you can set the title for your toolbar here for different fragments different titles
        getActivity().setTitle("Resources");

        mDatabase = FirebaseDatabase.getInstance().getReference();

        final LinearLayout mainLayout = (LinearLayout) view.findViewById(R.id.verticalLayout);
        final LayoutInflater inflater = getActivity().getLayoutInflater();
        mDatabase.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                for (DataSnapshot d : dataSnapshot.child("Resource").getChildren()) {

                    for (DataSnapshot e : d.getChildren()) {

                        Resource r = e.getValue(Resource.class);
                        View v = inflater.inflate(R.layout.inflator_resource, null);
                        TextView heading = (TextView) v.findViewById(R.id.resourceName);
                        TextView link = (TextView) v.findViewById(R.id.resourceLink);
                        TextView name = (TextView) v.findViewById(R.id.uploaderName);
                        TextView type = (TextView) v.findViewById(R.id.resourceType);
                        TextView description = (TextView) v.findViewById(R.id.resourceDescription);
                        heading.setText(r.get_title());
                        link.setText(r.get_link());
                        name.setText(r.get_uploader());
                        type.setText(r.getType());
                        description.setText(r.get_description());

                        mainLayout.addView(v);
                    }

//                    LinearLayout commentsLayout = (LinearLayout) v.findViewById(R.id.scrollViewLayout);
//
//
//                    for (int i = 0; i < r.get_comments().size(); i++) {
//
//                        TextView tv = new TextView(getActivity());
//                        tv.setText(r.get_comments().get(i).get_text());
//
//
//                    }


                }
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });


    }
}