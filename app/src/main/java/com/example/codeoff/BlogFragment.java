package com.example.codeoff;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import org.w3c.dom.Text;

/**
 * Created by jains on 28-10-2017.
 */

public class BlogFragment extends Fragment {

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
        getActivity().setTitle("Community Blog");

        mDatabase = FirebaseDatabase.getInstance().getReference();

        final LinearLayout mainLayout = (LinearLayout) view.findViewById(R.id.verticalLayout);
        final LayoutInflater inflater = getActivity().getLayoutInflater();
        mDatabase.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                for (DataSnapshot d : dataSnapshot.child("Blogs").getChildren()) {

                    for (DataSnapshot e : d.getChildren()) {

                        Blog b = e.getValue(Blog.class);
                        View v = inflater.inflate(R.layout.inflator_blog, null);
                        TextView title = (TextView) v.findViewById(R.id.blogName);
                        TextView name = (TextView) v.findViewById(R.id.uploaderName);
                        TextView description = (TextView) v.findViewById(R.id.blogDescription);
                        name.setText(b.get_uploader());
                        description.setText(b.get_description());

                        LinearLayout commentsLayout = (LinearLayout) v.findViewById(R.id.scrollViewLayout);

                        for (int i = 0; i < b.get_comments().size(); i++) {

                            TextView tv = new TextView(getActivity());
                            tv.setText(b.get_comments().get(i).get_text() + "\n" + b.get_comments().get(i).get_commenter());
                            commentsLayout.addView(tv);
                        }


                        v.setPadding(0, 0, 0, 16);
                        mainLayout.addView(v);
                    }


                }
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });


    }
}