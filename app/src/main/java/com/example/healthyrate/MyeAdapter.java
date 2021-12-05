package com.example.healthyrate;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;


import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.orhanobut.dialogplus.DialogPlus;
import com.orhanobut.dialogplus.ViewHolder;

import org.jetbrains.annotations.NotNull;
import org.w3c.dom.Document;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class MyeAdapter extends RecyclerView.Adapter<MyeAdapter.MyViewHolder>{

//new
  private MyeAdapter activity;
    DatabaseReference dbRef;


    ArrayList<eModel> mList;
    Context context;

    public MyeAdapter(Context context, ArrayList<eModel> mList){
        this.mList=mList;
        this.context=context;




    }



//new
/*
    public void updateData(int position){
        eModel item = mList.get(position);
        Bundle bundle = new Bundle();
        bundle.putString("uDate",item.getDate());
        bundle.putString("uFrom",item.getFrom());
        bundle.putString("uTo",item.getTo());
        bundle.putString("uDes",item.getDescription());

        Intent intent =new Intent(activity , Add_New_Exercise.class);
        intent.putExtras(bundle);
        activity.startActivity(intent);

    }
    


 */
//new








    @NonNull
    @NotNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull @NotNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(context).inflate(R.layout.exitem,parent,false);
        return new MyViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull @NotNull MyViewHolder holder, int position) {
        eModel model = mList.get(position);
        holder.date.setText(model.getDate());
        holder.from.setText(model.getFrom());
        holder.to.setText(model.getTo());
        holder.description.setText(model.getDescription());



        //new



        holder.btnEdit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final DialogPlus dialogPlus = DialogPlus.newDialog(holder.description.getContext())
                        .setContentHolder(new ViewHolder(R.layout.update_popup))
                        .setExpanded(true,1200)
                        .create();
                //dialogPlus.show();

                View view=dialogPlus.getHolderView();
                EditText date =view.findViewById(R.id.txtDate);
                EditText from =view.findViewById(R.id.txtfrom);
                EditText to =view.findViewById(R.id.txtto);
                EditText description =view.findViewById(R.id.txtdes);

                Button btnUpdate=view.findViewById(R.id.btnUpdate);

                date.setText(model.getDate());
                from.setText(model.getFrom());
                to.setText(model.getTo());
                description.setText(model.getDescription());

                dialogPlus.show();


                btnUpdate.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {


                       // dbRef = FirebaseDatabase.getInstance().getReference().child("eData");
                       //String key = dbRef.push().getKey();



/*
                       Map<String,Object> map = new HashMap<>();
                       map.put("date",date.getText().toString());
                       map.put("from",from.getText().toString());
                       map.put("to",to.getText().toString());
                       map.put("description",description.getText().toString());


 */

                       //new


                        String key = dbRef.push().getKey();
                        DatabaseReference upRef = FirebaseDatabase.getInstance().getReference().child("eData");
                        upRef.addListenerForSingleValueEvent(new ValueEventListener() {
                            @Override
                            public void onDataChange(@NonNull @NotNull DataSnapshot snapshot) {
                                if(snapshot.hasChild(key)){



                                    Map<String,Object> map = new HashMap<>();
                                    map.put("date",date.getText().toString());
                                    map.put("from",from.getText().toString());
                                    map.put("to",to.getText().toString());
                                    map.put("description",description.getText().toString());



                                    dbRef = FirebaseDatabase.getInstance().getReference().child("eData");
                                    dbRef.updateChildren(map);


                                   Toast.makeText(context.getApplicationContext(), "Data Updated Successfully",Toast.LENGTH_SHORT).show();
                                }
                                else{
                                    Toast.makeText(context.getApplicationContext(), "Not Updated", Toast.LENGTH_SHORT).show();
                                }



                            }

                            @Override
                            public void onCancelled(@NonNull @NotNull DatabaseError error) {

                            }
                        });


                     // dbRef.setValue(map);

/*
                       eModel model1 = mList.get(position);
                       holder.date.setText(date.getText().toString());
                        holder.from.setText(from.getText().toString());
                        holder.to.setText(to.getText().toString());
                        holder.description.setText(description.getText().toString());


                        dbRef.push().setValue(model1);

*/

/*

                       dbRef.child("eData").child("date").setValue(date.getText().toString());
                        dbRef.child("eData").child("description").setValue(description.getText().toString());
                        dbRef.child("eData").child("from").setValue(from.getText().toString());
                        dbRef.child("eData").child("to").setValue(to.getText().toString());

*/

                        /*
                        dbRef.push().setValue(map).addOnCompleteListener(new OnCompleteListener<Void>() {
                            @Override
                            public void onComplete(@NonNull @NotNull Task<Void> task) {
                                if(task.isSuccessful()){
                                    Toast.makeText(context.getApplicationContext(),"Updated Successfully", Toast.LENGTH_SHORT).show();
                                    dialogPlus.dismiss();
                                }else{
                                    Toast.makeText(context.getApplicationContext(),"Updating Unsuccesfully",Toast.LENGTH_SHORT).show();
                                    dialogPlus.dismiss();
                                }
                            }
                        });

                         */


                        //dbRef.child().(map);




/*
                        Map<String,Object> map = new HashMap<>();
                        map.put("date",date.getText().toString());
                        map.put("from",from.getText().toString());
                        map.put("to",to.getText().toString());
                        map.put("description",description.getText().toString());


*/

                       //FirebaseDatabase.getInstance().getReference().child("eData")
                       //.child(getRef(position).getKey()).updateChildren(map);


                             /*   dbRef.child("eData").updateChildren(map).addOnSuccessListener(new OnSuccessListener<Void>() {
                                   @Override
                                   public void onSuccess(Void unused) {
                                       Toast.makeText(context.getApplicationContext(), "Updated Succesfully",Toast.LENGTH_SHORT).show();
                                        dialogPlus.dismiss();
                                   }
                               })
                        .addOnFailureListener(new OnFailureListener() {
                            @Override
                            public void onFailure(Exception e) {
                                Toast.makeText(context.getApplicationContext(),"Error",Toast.LENGTH_SHORT).show();
                            }
                        });

                              */
                       /* dbRef.updateChildren(map).addOnCompleteListener(new OnCompleteListener<Void>() {
                            @Override
                            public void onComplete(@NonNull @NotNull Task<Void> task) {
                                if(task.isSuccessful()){
                                    Toast.makeText(context.getApplicationContext(),"Updated Successfully", Toast.LENGTH_SHORT).show();
                                }else{
                                    Toast.makeText(context.getApplicationContext(),"Updating Unsuccesfully",Toast.LENGTH_SHORT).show();
                                }
                            }
                        });       */





                    }
                });




                holder.btnDelete.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        AlertDialog.Builder builder=new AlertDialog.Builder(holder.date.getContext());
                        builder.setTitle("Are You Sure ?");
                        builder.setMessage("Deleted data can't be undo");

                        builder.setPositiveButton("Delete", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {


                                dbRef.removeValue();
                                Toast.makeText(holder.date.getContext(),"Canselled",Toast.LENGTH_SHORT).show();
                            }
                        });
                        builder.setNegativeButton("Cansel", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                Toast.makeText(holder.date.getContext(),"Canselled ",Toast.LENGTH_SHORT).show();
                            }
                        });
                        builder.show();

                    }
                });




            }
        });



    }

    @Override
    public int getItemCount() {
        return mList.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder{

        TextView date,from,to,description;
        //new
        Button btnEdit,btnDelete;





        public MyViewHolder(@NonNull @NotNull View itemView) {
            super(itemView);

            date = itemView.findViewById(R.id.txttdate);
            from = itemView.findViewById(R.id.txttfrom);
            to = itemView.findViewById(R.id.txttto);
            description = itemView.findViewById(R.id.txttdes);


            //new
            btnEdit =(Button)itemView.findViewById(R.id.btnEditt);
            btnDelete=(Button)itemView.findViewById(R.id.btnDeletee);
        }
    }
}
