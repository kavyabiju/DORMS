package com.example.dormsadmin;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyViewHolder> {

    Context context;
    ArrayList<Rooms_data> userArrayList;

    public MyAdapter(Context context, ArrayList<Rooms_data> userArrayList) {
        this.context = context;
        this.userArrayList = userArrayList;
    }




    @NonNull
    @Override
    public MyAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View v = LayoutInflater.from(context).inflate(R.layout.item,parent,false);

        return new MyViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull MyAdapter.MyViewHolder holder, int position) {
        Rooms_data user = userArrayList.get(position);

        holder.Roomname.setText(user.name);
        holder.no_of_beds.setText(user.beds);
        holder.rent.setText(String.valueOf(user.rent));

    }

    public void updateList(ArrayList<Rooms_data> lists){
        this.userArrayList = lists;
        notifyDataSetChanged();
    }

    @Override
    public int getItemCount() {
        return userArrayList.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder{

        TextView Roomname, no_of_beds, rent;


        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            Roomname = itemView.findViewById(R.id.rroom_name);
            no_of_beds = itemView.findViewById(R.id.rbeds);
            rent = itemView.findViewById(R.id.rrent);
        }
    }
}
