package com.example.codeoff;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.ScrollView;

/**
 * Created by HP on 28-10-2017.
 */

public class ResourcesFragment extends Fragment {

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

        LinearLayout mainLayout = (LinearLayout) view.findViewById(R.id.verticalLayout);
        LayoutInflater inflater = getActivity().getLayoutInflater();
        View v_1 = inflater.inflate(R.layout.inflator_resource,null);
        v_1.setPadding(0,0,0,16);
        View v_2 = inflater.inflate(R.layout.inflator_resource,null);

        mainLayout.addView(v_1);
        mainLayout.addView(v_2);

    }
}