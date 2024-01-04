package com.example.myappfour;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private Button btn_logout;
    private Button btn_add_data;
    private Button btn_view_data;
    private String user_id = "";
    private String log_out = "Log Out User...";
    private FirebaseAuth firebaseAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn_add_data = findViewById(R.id.btn_add);
        btn_view_data = findViewById(R.id.btn_view);
        btn_logout = findViewById(R.id.btn_logout);

        btn_add_data.setOnClickListener(this);
        btn_view_data.setOnClickListener(this);
        btn_logout.setOnClickListener(this);

        firebaseAuth = FirebaseAuth.getInstance();
        user_id = firebaseAuth.getCurrentUser().getUid();

        if( user_id == null ){
            Toast.makeText(getApplicationContext(), user_id, Toast.LENGTH_SHORT).show();
        }

    }

    @Override
    public void onClick(View view) {
        int id = view.getId();

        if (id == R.id.btn_add) {
            Intent intentAdd = new Intent(getApplicationContext(), AddDataActivity.class);
            startActivity(intentAdd);
        } else if (id == R.id.btn_view) {
            Intent intentView = new Intent(getApplicationContext(), ViewActivity.class);
            startActivity(intentView);
        } else if (id == R.id.btn_logout) {
            firebaseAuth.signOut();
            Intent intentEmail = new Intent(getApplicationContext(), LoginActivity.class);
            startActivity(intentEmail);
            Toast.makeText(getApplicationContext(), log_out, Toast.LENGTH_SHORT).show();
        }

    }

}