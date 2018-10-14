package com.example.kaushik.referhub;

import android.app.Application;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import android.app.Activity;
import android.view.View;
import android.widget.Button;
import android.widget.Spinner;

import java.util.ArrayList;

public class AddCoupon extends AppCompatActivity {
    private DatabaseReference mDatabase;
    private Spinner spinner;
    private static final String[] brands = {"Uber", "Lyft", "Uber Eats","Bird", "Zomato" };
    TextView desc_Text, url_text;
    Button cancelButton, saveButton;
    User currUser;


    //@Override
    protected void addCoupon(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_coupon);

        Bundle myBundle = getIntent().getExtras();

        if(myBundle!=null){

            currUser = (User) myBundle.get("CurrUser");

        }


        mDatabase = FirebaseDatabase.getInstance().getReference();
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(AddCoupon.this, android.R.layout.simple_spinner_dropdown_item, brands);
        spinner=(Spinner) findViewById(R.id.category_spinner);
        spinner.setAdapter(adapter);

        desc_Text = (TextView) findViewById(R.id.desc_Text);
        url_text = (TextView) findViewById(R.id.url_Text);
        cancelButton = (Button) findViewById(R.id.cancel_btn);
        saveButton = (Button) findViewById(R.id.save_btn);

        saveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String desc = desc_Text.getText().toString();
                String url = url_text.getText().toString();
                //final String category = adapter.getText().toString(); //how to get adapter text?
                String category = spinner.getSelectedItem().toString();



                Coupon new_Coupon = new Coupon(desc, url, category);

                currUser.setCoupon(new_Coupon);

                mdatabase.child("Users").push().setValue(currUser);
            }
        });
    }
}


//        mFirebaseBtn.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//
//                mDatabase.child("Name   ").setValue("Niharika");
//
//            }
//        });


//public class MainActivity extends Activity {
//    private Button mFirebaseBtn;
//    private DatabaseReference mDatabase;
//    //making a spinner
//    private Spinner spinner;
//    private static final String[] brands = {"Uber", "Lyft", "Ubereats"};
//
//
//    //@Override
//    protected void onCreate1(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_add_coupon);
//
//        /*String[] brands={"Uber","Bird","Lyft","UberEats","Audible"};
//        ArrayAdapter<String> adapter=new ArrayAdapter<String>(getListView().getContext(),android.R.layout.simple_list_item_1,brands);
//        getListView().setAdapter(adapter); */
//        spinner = (Spinner) findViewById(R.id.spinner1);
//        ArrayAdapter<String> adapter = new ArrayAdapter<String>(MainActivity.this, android.R.layout.simple_spinner_item, brands);
//        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
//        spinner.setAdapter(adapter);
//        //spinner.setOnItemSelectedListener(this);
//
//    }
//
//
//    //@Override
//    protected void onCreate2(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_add_coupon);
//
//        mFirebaseBtn = (Button) findViewById(R.id.firebase_btn);
//        mDatabase = FirebaseDatabase.getInstance().getReference();
//
//
//        mFirebaseBtn.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//
//                mDatabase.child("Name").setValue("Niharika");
//
//            }
//        });
//
//    }
//}

//public class AddCoupon extends AppCompatActivity{
//    private DatabaseReference my_database;
//   // private TextView textView1;
//    private ListView coupon_List;
//
//    private ArrayList<String> coupon_List_Array = new ArrayList<>();
//
//    protected void onCreate(Bundle savedInstanceState){
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_add_coupon);
//
//        my_database = FirebaseDatabase.getInstance().getReference();
//        coupon_List = (ListView) findViewById(R.id.userList);
//
//        final ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_List_item_1, coupon_List_Array);
//
//        coupon_List.setAdapter(arrayAdapter);
//
//        my_database.addChildEventListener(new ChildEventListener() {
//            @Override
//            public void onChildAdded(DataSnapshot dataSnapshot, String s) {
//
//                String value = dataSnapshot.getValue(String.class);
//                coupon_List_Array.add(value);
//                arrayAdapter.notifyDataSetChanged();
//            }
//
//            @Override
//            public void onChildChanged(DataSnapshot dataSnapshot, String s) {
//
//            }
//
//            @Override
//            public void onChildRemoved(DataSnapshot dataSnapshot) {
//
//            }
//
//            @Override
//            public void onChildMoved(DataSnapshot dataSnapshot, String s) {
//
//            }
//
//            @Override
//            public void onCancelled(DatabaseError databaseError) {
//
//            }
//        })
//}
