package com.example.expandablelistview;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import android.widget.ExpandableListView;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    ExpandableListView expandableListView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        expandableListView = findViewById(R.id.ExpandableListView);
        List<String> Headings = new ArrayList<>();
        List<String> L1 = new ArrayList<>();
        List<String> L2 = new ArrayList<>();
        List<String> L3 = new ArrayList<>();
        HashMap<String,List<String>> ChildList = new HashMap<>();

        String[] heading_items = getResources().getStringArray(R.array.headerTitles);
        String[] header_1_Items = getResources().getStringArray(R.array.header_1_Items);
        String[] header_2_Items = getResources().getStringArray(R.array.header_2_Items);
        String[] header_3_Items = getResources().getStringArray(R.array.header_3_Items);

        Collections.addAll(Headings,heading_items);
        Collections.addAll(L1,header_1_Items);
        Collections.addAll(L2,header_2_Items);
        Collections.addAll(L3,header_3_Items);

        ChildList.put(Headings.get(0),L1);
        ChildList.put(Headings.get(1),L2);
        ChildList.put(Headings.get(2),L3);

        MyAdapter myAdapter = new MyAdapter(this, Headings, ChildList);
        expandableListView.setAdapter(myAdapter);
    }
}
