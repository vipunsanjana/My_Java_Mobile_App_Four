package com.example.myappfour;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.DatabaseReference;

public class AddDataActivity extends AppCompatActivity {


    private EditText et_name;
    private EditText et_marks;
    private Button btn_add;

    String name;
    String marks;

    private FirebaseDatabase firebaseDatabse;
    private DatabaseReference databaseReferance;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_data);

        et_name = findViewById(R.id.et_name);
        et_marks = findViewById(R.id.et_marks);
        btn_add = findViewById(R.id.btn_add);

        firebaseDatabse = FirebaseDatabase.getInstance();
        databaseReferance = firebaseDatabse.getReference("StudentInfo");

        btn_add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                name = et_name.getText().toString().trim();
                marks = et_marks.getText().toString().trim();

                StudentsClass studentsClass = new StudentsClass(name, marks);
                Log.d("TAG", "onClick" + studentsClass);

                databaseReferance.child(studentsClass.name).setValue(studentsClass).addOnSuccessListener(new OnSuccessListener<Void>() {
                    @Override
                    public void onSuccess(Void unused) {
                        Intent intentEmail = new Intent(getApplicationContext(), MainActivity.class);
                        startActivity(intentEmail);
                        Toast.makeText(getApplicationContext(), "Student Add Success...", Toast.LENGTH_SHORT).show();
                    }
                }).addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        Intent intentEmail = new Intent(getApplicationContext(), MainActivity.class);
                        startActivity(intentEmail);
                        Toast.makeText(getApplicationContext(), "Student Add failed...", Toast.LENGTH_SHORT).show();
                    }
                });
            }
        });
    }
}