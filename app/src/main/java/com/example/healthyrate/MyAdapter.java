package com.example.healthyrate;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

import org.jetbrains.annotations.NotNull;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyViewHolder> {

    ArrayList<Model> mList;
    Context context;

    public MyAdapter(Context context,ArrayList<Model>mList){

        this.mList = mList;
        this.context=context;
    }

    @NonNull
    @NotNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull @NotNull ViewGroup parent, int viewType) {
       View v = LayoutInflater.from(context).inflate(R.layout.item,parent,false);
       return  new MyViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull @NotNull MyViewHolder holder, int position) {

        Model model = mList.get(position);
        holder.name.setText(model.getName());
        holder.age.setText(model.getAge());
        holder.phone.setText(model.getPhone());
        holder.address.setText(model.getAddress());
        holder.date.setText(model.getDate());
        holder.type.setText(model.getType());

    }

    @Override
    public int getItemCount() {
        return mList.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder{

        TextView name,age,phone,address,date,type;

        public MyViewHolder(@NonNull @NotNull View itemView) {
            super(itemView);

            name = itemView.findViewById(R.id.tvname);
            age = itemView.findViewById(R.id.tvage);
            phone = itemView.findViewById(R.id.tvphone);
            address = itemView.findViewById(R.id.tvaddress);
            date = itemView.findViewById(R.id.tvdate);
            type = itemView.findViewById(R.id.tvtype);

        }
    }
}
