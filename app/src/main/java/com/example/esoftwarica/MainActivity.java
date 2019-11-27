package com.example.esoftwarica;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
private RecyclerView recyclerView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView=findViewById(R.id.recyclerView);

        List<Student>StudentList = new ArrayList<>();
        StudentList.add(new Student("Ishika Pradhan","20","newroad","Female",R.drawable.female,R.drawable.delete));
        StudentList.add(new Student("Naraya Pradhan","20","newroad","Male",R.drawable.male,R.drawable.delete));
        StudentList.add(new Student("fjhjfhf","20","newroad","Other",R.drawable.noimage,R.drawable.delete));
  StydentAdapter studentAdapter= new StydentAdapter(this,StudentList );
  recyclerView.setAdapter(studentAdapter);
  recyclerView.setLayoutManager(new LinearLayoutManager(this));
    }
}
