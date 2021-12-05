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
import com.google.firebase.database.FirebaseDatabase;
import com.orhanobut.dialogplus.DialogPlus;
import com.orhanobut.dialogplus.ViewHolder;

import org.jetbrains.annotations.NotNull;

import java.util.HashMap;
import java.util.Map;

public class ManageAppointmentAdapter extends FirebaseRecyclerAdapter<Appointment,ManageAppointmentAdapter.myViewHolder> {

    /**
     * Initialize a {@link RecyclerView.Adapter} that listens to a Firebase query. See
     * {@link FirebaseRecyclerOptions} for configuration options.
     *
     * @param options
     */
    public ManageAppointmentAdapter(@NonNull @NotNull FirebaseRecyclerOptions<Appointment> options) {
        super(options);
    }

    @Override
    protected void onBindViewHolder(@NonNull @NotNull myViewHolder holder, final int position, @NonNull @NotNull Appointment model) {
        holder.dName.setText(model.getDoctorName());
        holder.bookingDate.setText(model.getBookingDate());
        holder.pName.setText(model.getPatientName());
        holder.pAge.setText(model.getPatientAge());
        holder.pAddress.setText(model.getPatientAddress());
        holder.pConNo.setText(model.getPatientConNo());


        // Update Appointment Details
        holder.btnEdit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final DialogPlus dialogPlus = DialogPlus.newDialog(holder.pConNo.getContext())
                        .setContentHolder(new ViewHolder(R.layout.update_popup_lh)).setExpanded(true,1400)
                        .create();

                //dialogPlus.show();

                View view = dialogPlus.getHolderView();

                EditText pName = view.findViewById(R.id.newPatientNameUpdate);
                EditText pAge = view.findViewById(R.id.newPatientAgeUpdate);
                EditText pAddress = view.findViewById(R.id.newPatientAddressUpdate);
                EditText pConNo = view.findViewById(R.id.newPatientConNoUpdate);

                Button btnUpdateChanged = view.findViewById(R.id.btn_updateChangedAppointment);

                pName.setText(model.getPatientName());
                pAge.setText(model.getPatientAge());
                pAddress.setText(model.getPatientAddress());
                pConNo.setText(model.getPatientConNo());

                dialogPlus.show();

                btnUpdateChanged.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Map<String,Object> map = new HashMap<>();

                        map.put("patientName",pName.getText().toString());
                        map.put("patientAge",pAge.getText().toString());
                        map.put("patientAddress",pAddress.getText().toString());
                        map.put("patientConNo",pConNo.getText().toString());

                        FirebaseDatabase.getInstance().getReference().child("Appointment")
                                .child(getRef(position).getKey()).updateChildren(map)
                                .addOnSuccessListener(new OnSuccessListener<Void>() {
                                    @Override
                                    public void onSuccess(Void unused) {
                                        Toast.makeText(holder.pName.getContext(), "Data Updated Successfully", Toast.LENGTH_SHORT).show();
                                        dialogPlus.dismiss();
                                    }
                                })
                                .addOnFailureListener(new OnFailureListener() {
                                    @Override
                                    public void onFailure(Exception e) {
                                        Toast.makeText(holder.pName.getContext(), "Error Updating Data", Toast.LENGTH_SHORT).show();
                                        dialogPlus.dismiss();
                                    }
                                });
                    }
                });
            }
        });

        // Delete Appointment
        holder.btnDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder builder = new AlertDialog.Builder(holder.pName.getContext());
                builder.setTitle("Are you sure to cancel appointment?");
                builder.setMessage("Deleted data con not be undo.");

                builder.setPositiveButton("Delete", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        FirebaseDatabase.getInstance().getReference().child("Appointment")
                                .child(getRef(position).getKey()).removeValue();
                    }
                });

                builder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Toast.makeText(holder.pName.getContext(), "Cancelled", Toast.LENGTH_SHORT).show();
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
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.appointment_item,parent,false);
        return new myViewHolder(view);
    }

    class myViewHolder extends RecyclerView.ViewHolder {

        TextView dName, bookingDate, pName, pAge, pAddress, pConNo;
        Button btnEdit, btnDelete;

        public myViewHolder(@NonNull @NotNull View itemView) {
            super(itemView);

            dName = (TextView)itemView.findViewById(R.id.newDoctorName);
            bookingDate = (TextView)itemView.findViewById(R.id.newBookingDate);
            pName = (TextView)itemView.findViewById(R.id.newPatientName);
            pAge = (TextView)itemView.findViewById(R.id.newPatientAge);
            pAddress = (TextView)itemView.findViewById(R.id.newPatientAddress);
            pConNo = (TextView)itemView.findViewById(R.id.newPatientConNo);

            btnEdit = (Button)itemView.findViewById(R.id.btn_editAppointment);
            btnDelete = (Button)itemView.findViewById(R.id.btn_cancelAppointment);


        }
    }
}
