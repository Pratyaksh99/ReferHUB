package com.example.kaushik.referhub;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;
import android.widget.EditText;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;


public class newUser extends AppCompatActivity {
    //EditText loginEmail,loginPassword;
    Button loginButton, registerButton, newPassButton, forgotButton;
    FirebaseAuth firebaseAuth;
    EditText email;
    EditText password;
    DatabaseReference my_database;

    //Map<String,User> users = new HashMap<>();

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_);

        firebaseAuth = FirebaseAuth.getInstance();
        my_database = FirebaseDatabase.getInstance().getReference();

        email = (EditText) findViewById(R.id.email);
        password = (EditText) findViewById(R.id.password);
        //loginButton = (Button) findViewById(R.id.login);
        //forgotButton = (Button) findViewById(R.id.forgotpassword);
        //signInButton = (SignInButton) findViewById(R.id.g_signin);
        registerButton =(Button) findViewById(R.id.register) ;
        registerButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final String email1 = email.getText().toString();
                final String password1 = password.getText().toString();

                if (TextUtils.isEmpty(email1)) {
                    Toast.makeText(getApplicationContext(), "Please fill in the required fields", Toast.LENGTH_SHORT).show();
                    return;
                }
                if (TextUtils.isEmpty(password1)) {
                    Toast.makeText(getApplicationContext(), "Please fill in the required fields", Toast.LENGTH_SHORT).show();
                }

                if (password1.length() < 6) {
                    Toast.makeText(getApplicationContext(), "Password must be at least 6 characters", Toast.LENGTH_SHORT).show();
                }

                User new_User = new User(email1, password1);

                my_database.child("Users").push().setValue(new_User);

                firebaseAuth.createUserWithEmailAndPassword(email1, password1)
                        .addOnCompleteListener(new OnCompleteListener<AuthResult>() {

                            @Override
                            public void onComplete(@NonNull Task<AuthResult> task) {
                                if (task.isSuccessful()) {
//                                    my_database.child("Users").child().setValue(new_User);

                                    startActivity(new Intent(getApplicationContext(), MainActivity.class));
                                    finish();
                                } else {
                                    Toast.makeText(getApplicationContext(), "E-mail or password is wrong", Toast.LENGTH_SHORT).show();
                                }
                            }
                        });
            }
        });


    }

}