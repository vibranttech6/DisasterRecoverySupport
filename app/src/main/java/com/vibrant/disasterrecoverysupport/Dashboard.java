package com.vibrant.disasterrecoverysupport;

import android.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.Toast;

public class Dashboard extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);

        String[] victimList = {"Tia", "Anna", "Maise", "Candy", "Maya", "Zara"};
        ListAdapter buckysAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, victimList);
        ListView buckysListView = (ListView) findViewById(R.id.list_of_victims);
        buckysListView.setAdapter(buckysAdapter);

        buckysListView.setOnItemClickListener(
                new AdapterView.OnItemClickListener(){
                    @Override
                    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                        String victim = String.valueOf(parent.getItemAtPosition(position));
                        Toast.makeText(MainActivity.getInstance(), victim, Toast.LENGTH_LONG).show();
                        BlankFragment myf = new BlankFragment(victim);

                        android.support.v4.app.FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
                        transaction.replace(R.id.fragLayout, myf);
                        transaction.commit();
                    }
                }
        );




    }
}
