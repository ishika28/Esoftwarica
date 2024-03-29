package com.example.esoftwarica.ui.home;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.esoftwarica.BottmNavigationActivity;
import com.example.esoftwarica.R;
import com.example.esoftwarica.Student;
import com.example.esoftwarica.StydentAdapter;

import java.util.ArrayList;
import java.util.List;

public class HomeFragment extends Fragment {

    private HomeViewModel homeViewModel;
    private RecyclerView recyclerView;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        homeViewModel =
                ViewModelProviders.of(this).get(HomeViewModel.class);
        View root = inflater.inflate(R.layout.fragment_home, container, false);
        final TextView textView = root.findViewById(R.id.text_home);
        homeViewModel.getText().observe(this, new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {
                textView.setText(s);
            }
        });
        recyclerView=root.findViewById(R.id.recyclerView);

        List<Student> StudentList = new ArrayList<>();
        if(BottmNavigationActivity.student.isEmpty()){
            BottmNavigationActivity.student.add(new Student("romeo","ktm","male",18));
             StydentAdapter stydentAdapter=new StydentAdapter(getContext(),BottmNavigationActivity.student);
            recyclerView.setAdapter(stydentAdapter);
            recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));


        }
        else {

            StydentAdapter stydentAdapter=new StydentAdapter(getContext(),BottmNavigationActivity.student);
            recyclerView.setAdapter(stydentAdapter);
            recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));


        }
        return root;
    }
}