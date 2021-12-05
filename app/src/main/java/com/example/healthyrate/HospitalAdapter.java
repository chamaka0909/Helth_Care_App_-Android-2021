package com.example.healthyrate;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;

public class HospitalAdapter extends RecyclerView.Adapter<HospitalAdapter.MyViewHolder> {

    Context context;

    ArrayList<HospitalProvince> hospitalList;

    public HospitalAdapter(Context context, ArrayList<HospitalProvince> hospitalList) {
        this.context = context;
        this.hospitalList = hospitalList;
    }

    @NonNull
    @NotNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull @NotNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(context).inflate(R.layout.hospital_item,parent, false);
        return new MyViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull @NotNull MyViewHolder holder, int position) {
        HospitalProvince hp = hospitalList.get(position);
        holder.firstName.setText(hp.gethName());
        holder.lastName.setText(hp.getAddress());
        holder.age.setText(hp.getConNo().toString());
        holder.desc.setText(hp.getDesc());
    }

    @Override
    public int getItemCount() {
        return hospitalList.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder {

        TextView firstName, lastName, age, desc;

        public MyViewHolder(@NonNull @NotNull View itemView) {
            super(itemView);

            firstName = itemView.findViewById(R.id.tvFirstName);
            lastName = itemView.findViewById(R.id.tvLastName);
            age = itemView.findViewById(R.id.tvAge);
            desc = itemView.findViewById(R.id.tvDesc);
        }
    }

}
