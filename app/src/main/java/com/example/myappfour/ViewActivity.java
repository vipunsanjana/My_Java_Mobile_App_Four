package com.example.myappfour;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class ViewActivity extends AppCompatActivity {
    RecyclerView rv_students_marks;
    UserAdapter userAdapter;
    ArrayList<StudentsClass> nameList = new ArrayList<>();

    FirebaseDatabase firebaseDatabase;
    DatabaseReference databaseReference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view);

        rv_students_marks = findViewById(R.id.rv_marks);
        firebaseDatabase = FirebaseDatabase.getInstance();
        databaseReference = firebaseDatabase.getReference("StudentInfo");
        databaseReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {

                Log.d("TAG", "onDataChange: " + snapshot);

                for (DataSnapshot data : snapshot.getChildren()){

                    StudentsClass studentsClass =  data.getValue(StudentsClass.class);
                    nameList.add(studentsClass);

                }

                Log.d("TAG", "onDataChange: " + nameList);

                userAdapter = new UserAdapter(ViewActivity.this, nameList);
                rv_students_marks.setAdapter(userAdapter);
                rv_students_marks.setLayoutManager(new LinearLayoutManager(getApplicationContext()));

            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
    }
}