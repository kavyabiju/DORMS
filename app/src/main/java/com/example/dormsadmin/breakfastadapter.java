package com.example.dormsadmin;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;

public class breakfastadapter extends RecyclerView.Adapter<breakfastadapter.ViewHolder> {
    ArrayList<model>mlist;
    Context context;
    public breakfastadapter(Context context,ArrayList<model>mlist){
        this.context = context;
        this.mlist = mlist;
    }
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(context).inflate(R.layout.itemb,parent,false);
        return  new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Glide.with(context).load(mlist.get(position).getImg_url()).into(holder.i1);

    }

    @Override
    public int getItemCount() {
        return mlist.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder{
        ImageView i1;
        TextView text_itemname,text_price;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            i1 = itemView.findViewById(R.id.breakimage);
            text_itemname = itemView.findViewById(R.id.text_itemname);
            text_price = itemView.findViewById(R.id.text_price);

        }
    }
}
