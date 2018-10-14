package com.example.kaushik.referhub;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.Spinner;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    ListView myList;
    static myAdapter adapter;
    ImageButton addCoupon;
    ArrayList<User> users;

    //    private Spinner sortSpinner;
//    private static final String[] brands = {"Uber", "Lyft", "Uber Eats","Bird", "Zomato" };

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Bundle myBundle = getIntent().getExtras();

        if(myBundle!=null){

            users = (ArrayList<User>) myBundle.get("Users");

        }

        addCoupon = (ImageButton) findViewById(R.id.addCoupon);

        addCoupon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent myIntent = new Intent(MainActivity.this, AddCoupon.class);
                myIntent.putExtra("Users", users);
                startActivity(myIntent);

            }
        });

        myList = (ListView) findViewById(R.id.item_list);

        adapter = new myAdapter(MainActivity.this,users);

        myList.setAdapter(adapter);



//        sortSpinner = (Spinner) findViewById(R.id.category_spinner);
//        ArrayAdapter<String> adapter = new ArrayAdapter<String>(MainActivity.this, android.R.layout.simple_spinner_dropdown_item, brands);
//        sortSpinner.setAdapter(adapter);

    }
}
