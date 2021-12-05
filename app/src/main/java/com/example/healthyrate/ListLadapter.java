package com.example.healthyrate;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.List;

public class ListLadapter extends ArrayAdapter {
    private Activity mContext;
    List<pData> pdatalist;

    public ListLadapter(Activity mContext, List<pData> pdatalist){
        super(mContext,R.layout.activity_retrive_lab_data,pdatalist);
        this.mContext = mContext;
        this.pdatalist=pdatalist;

    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        LayoutInflater inflater = mContext.getLayoutInflater();
        View listItemview = inflater.inflate(R.layout.activity_retrive_lab_data,null,true);

        TextView nic = listItemview.findViewById(R.id.textView4);
        TextView name = listItemview.findViewById(R.id.textView5);
        TextView gender = listItemview.findViewById(R.id.textView6);
        TextView date = listItemview.findViewById(R.id.textView7);
        TextView time = listItemview.findViewById(R.id.textView8);
        TextView age = listItemview.findViewById(R.id.textView9);
        TextView blood = listItemview.findViewById(R.id.textView10);
        TextView diseases = listItemview.findViewById(R.id.textView11);
        TextView connum = listItemview.findViewById(R.id.textView12);


        pData pdata = pdatalist.get(position);

        nic.setText(pdata.getNic());
        name.setText(pdata.getName());
        gender.setText(pdata.getGen());
        date.setText(pdata.getDate());
        time.setText(pdata.getTime());
        age.setText(pdata.getAge());
        blood.setText(pdata.getBlood());
        diseases.setText(pdata.getDiseases());
        connum.setText(pdata.getConnum());

        return listItemview;

    }
}
