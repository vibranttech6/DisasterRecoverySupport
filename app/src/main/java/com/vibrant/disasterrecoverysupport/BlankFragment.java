package com.vibrant.disasterrecoverysupport;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;


/**
 * A simple {@link Fragment} subclass.
 */
public class BlankFragment extends Fragment {
    String name = "";
    TextView textView;

    public BlankFragment() {
        // Required empty public constructor
    }

    public BlankFragment(String name){
        this.name = name;
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_blank, container, false);
        textView = (TextView)  v.findViewById(R.id.fragtextname);
        textView.setText(name);

        String[] victimList = {"Blanket", "Food", "Shoes", "Clothes", "Medicine"};
        ListAdapter buckysAdapter = new ArrayAdapter<String>(MainActivity.getInstance(), android.R.layout.simple_list_item_1, victimList);
        ListView buckysListView = (ListView) v.findViewById(R.id.list_requirements);
        buckysListView.setAdapter(buckysAdapter);

        return v;



    }

}
