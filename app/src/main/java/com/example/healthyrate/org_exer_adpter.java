package com.example.healthyrate;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.firebase.database.FirebaseDatabase;
import com.orhanobut.dialogplus.DialogPlus;
import com.orhanobut.dialogplus.ViewHolder;

import org.jetbrains.annotations.NotNull;

import java.util.HashMap;
import java.util.Map;

public class org_exer_adpter extends FirebaseRecyclerAdapter <orgExer,org_exer_adpter.myViewHolder> {
    /**
     * Initialize a {@link RecyclerView.Adapter} that listens to a Firebase query. See
     * {@link FirebaseRecyclerOptions} for configuration options.
     *
     * @param options
     */
    public org_exer_adpter(@NonNull @NotNull FirebaseRecyclerOptions<orgExer> options) {
        super(options);
    }

    @Override
    protected void onBindViewHolder(@NonNull @NotNull myViewHolder holder, final int position, @NonNull @NotNull orgExer model) {
        holder.date.setText(model.getDate());
        holder.from.setText(model.getFrom());
        holder.to.setText(model.getTo());
        holder.description.setText(model.getDescription());






        holder.btnEdit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final DialogPlus dialogPlus = DialogPlus.newDialog(holder.description.getContext())
                        .setContentHolder(new ViewHolder(R.layout.update_popup))
                        .setExpanded(true,1200)
                        .create();

                //dialogPlus.show();
                //View view = dialogPlus.getHolderView();



                View view = dialogPlus.getHolderView();
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

                        Map<String,Object> map = new HashMap<>();
                        map.put("date",date.getText().toString());
                        map.put("from",from.getText().toString());
                        map.put("to",to.getText().toString());
                        map.put("description",description.getText().toString());


                        FirebaseDatabase.getInstance().getReference().child("eeData")
                                .child(getRef(position).getKey()).updateChildren(map)
                                .addOnSuccessListener(new OnSuccessListener<Void>() {
                                    @Override
                                    public void onSuccess(Void unused) {
                                        Toast.makeText(holder.date.getContext(),"Data Updated Successfully",Toast.LENGTH_SHORT).show();
                                        dialogPlus.dismiss();
                                    }
                                })
                                .addOnFailureListener(new OnFailureListener() {
                                    @Override
                                    public void onFailure(Exception e) {
                                        Toast.makeText(holder.date.getContext(),"Error While Updating",Toast.LENGTH_SHORT).show();
                                        dialogPlus.dismiss();
                                    }
                                });





                    }
                });




            }
        });



        holder.btnDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder builder = new AlertDialog.Builder(holder.description.getContext());
                builder.setTitle("Are you Sure?");
                builder.setMessage("Deleted data can't be undo");
                builder.setPositiveButton("Delete", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        FirebaseDatabase.getInstance().getReference().child("eeData")
                                .child(getRef(position).getKey()).removeValue();
                    }
                });
                builder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Toast.makeText(holder.description.getContext(),"Cancel",Toast.LENGTH_SHORT).show();
                    }
                });
                builder.show();

            }
        });



    }

    @NonNull
    @NotNull
    @Override
    public myViewHolder onCreateViewHolder(@NonNull @NotNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.org_exe_item,parent,false);
        return new myViewHolder(view);
    }

     class myViewHolder extends RecyclerView.ViewHolder{


        TextView date,from,to,description;
         //Button btnDelete;
         FloatingActionButton btnEdit,btnDelete;

        public myViewHolder(@NonNull @NotNull View itemView) {
            super(itemView);


            date =(TextView)itemView.findViewById(R.id.txttdate);
            from =(TextView)itemView.findViewById(R.id.txttfrom);
            to =(TextView)itemView.findViewById(R.id.txttto);
            description =(TextView)itemView.findViewById(R.id.txttdes);


            btnEdit =(FloatingActionButton) itemView.findViewById(R.id.btnEditt);
            btnDelete=(FloatingActionButton) itemView.findViewById(R.id.btnDeletee);



        }
    }
}
