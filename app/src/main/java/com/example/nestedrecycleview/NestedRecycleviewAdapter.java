package com.example.nestedrecycleview;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class NestedRecycleviewAdapter extends RecyclerView.Adapter<NestedRecycleviewAdapter.ViewHolder> {
        Context context;
        ArrayList<VerticalMode>arrayList;

    public NestedRecycleviewAdapter(Context context, ArrayList<VerticalMode> arrayList) {
        this.context = context;
        this.arrayList = arrayList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType)
    {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.nestedrecyclerview,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

        final VerticalMode verticalMode=arrayList.get(position);
        String title=verticalMode.getTitle();
        ArrayList<HorizontalMode> Singleitem=verticalMode.getArrayList();

        holder.textviewTtl.setText(title);
        HorizontalRecycleViewAdapter horizontalrecycleviewadapter=new HorizontalRecycleViewAdapter(context,Singleitem);
        holder.recyclerView.setHasFixedSize(true);
        holder.recyclerView.setLayoutManager(new LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL,false));

        holder.Button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(context,verticalMode.getTitle(),Toast.LENGTH_SHORT).show();
            }
        });


    }


    @Override
    public int getItemCount() {
        return arrayList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder
    {
        RecyclerView recyclerView;
        TextView textviewTtl;
        Button Button1;
        public ViewHolder(@NonNull View itemView)
        {
            super(itemView);
            recyclerView = itemView.findViewById(R.id.recycler1);
            textviewTtl = itemView.findViewById(R.id.textTtl);
            Button1 = itemView.findViewById(R.id.btn);
        }
    }
}
