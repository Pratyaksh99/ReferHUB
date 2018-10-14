package com.example.prats.referhub;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class IncorrectLogin extends AppCompatActivity {

    Button tryAgain;
    TextView incorrectLogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_incorrect_login);

        tryAgain = (Button) findViewById(R.id.tryAgain);
        incorrectLogin = (TextView) findViewById(R.id.incorrectLogin);

        tryAgain.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                startActivity(new Intent(IncorrectLogin.this, LoginActivity.class));

            }
        });


    }
}
