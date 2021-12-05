package com.example.healthyrate;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.SearchView;

import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.firebase.database.FirebaseDatabase;

public class org_Exer_show extends AppCompatActivity {

    RecyclerView recyclerView;
    org_exer_adpter orgAdapter;

    FloatingActionButton floatingActionButton;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_org_exer_show);

        recyclerView = (RecyclerView)findViewById(R.id.recycleview);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        FirebaseRecyclerOptions<orgExer> options =
                new FirebaseRecyclerOptions.Builder<orgExer>()
                .setQuery(FirebaseDatabase.getInstance().getReference().child("eeData"),orgExer.class)
                .build();



        orgAdapter = new org_exer_adpter(options);
        recyclerView.setAdapter(orgAdapter);

        floatingActionButton =(FloatingActionButton)findViewById(R.id.floatingActionButton);

        floatingActionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(),org_add_exercise.class));
            }
        });


    }


   @Override
   protected void onStart(){
        super.onStart();
        orgAdapter.startListening();
   }


   @Override
    protected void onStop(){
        super.onStop();
        orgAdapter.startListening();
   }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        getMenuInflater().inflate(R.menu.esearch,menu);
        MenuItem item = menu.findItem(R.id.esearch);
        SearchView searchView =(SearchView)item.getActionView();

        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                txtSearch(query);
                return false;
            }

            @Override
            public boolean onQueryTextChange(String query) {
                txtSearch(query);
                return false;
            }
        });


        return super.onCreateOptionsMenu(menu);
    }

    private void txtSearch (String str){
        FirebaseRecyclerOptions<orgExer> options =
                new FirebaseRecyclerOptions.Builder<orgExer>()
                        .setQuery(FirebaseDatabase.getInstance().getReference().child("eeData").orderByChild("description").startAt(str).endAt(str+"~"),orgExer.class)
                        .build();

        orgAdapter = new org_exer_adpter(options);
        orgAdapter.startListening();
        recyclerView.setAdapter(orgAdapter);

    }
}