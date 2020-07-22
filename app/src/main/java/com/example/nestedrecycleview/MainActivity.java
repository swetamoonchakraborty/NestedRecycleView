package com.example.nestedrecycleview;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private RecyclerView recyclerView;
    NestedRecycleviewAdapter adapter;
    ArrayList<VerticalMode>arrayListvertical;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        arrayListvertical=new ArrayList<>();
        recyclerView = findViewById(R.id.nestedrecycleview);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext(), LinearLayoutManager.VERTICAL, false));

        adapter=new NestedRecycleviewAdapter(this,arrayListvertical);
        recyclerView.setAdapter(adapter);
        setData();
    }

    private void setData()
    {
        for(int i= 1; i<=5 ; i++)
        {
            VerticalMode mverticalMode=new VerticalMode();
            mverticalMode.setTitle("Title :"+i);
            ArrayList<HorizontalMode> marrayList=new ArrayList<>();

            for(int j= 0 ; j<=5 ; j++){

                HorizontalMode mhorizontalMode=new HorizontalMode();
                mhorizontalMode.setDesc("Description :"+j);
                mhorizontalMode.setName("Name :"+j);

                marrayList.add(mhorizontalMode);
            }
            mverticalMode.setArrayList(marrayList);
        }
        adapter.notifyDataSetChanged();
    }
}
