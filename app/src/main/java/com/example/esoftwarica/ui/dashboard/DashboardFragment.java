package com.example.esoftwarica.ui.dashboard;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import com.example.esoftwarica.BottmNavigationActivity;
import com.example.esoftwarica.R;
import com.example.esoftwarica.Student;

public class DashboardFragment extends Fragment implements RadioGroup.OnCheckedChangeListener, View.OnClickListener {

    private DashboardViewModel mViewModel;

    private EditText etName,etAddress,etAge;
    private RadioGroup rdogroup;
    private Button btnsave;
    private RadioButton rdmale,rdfemale,rdother;



    private DashboardViewModel dashboardViewModel;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        dashboardViewModel =
                ViewModelProviders.of(this).get(DashboardViewModel.class);
        View root = inflater.inflate(R.layout.fragment_dashboard, container, false);

        rdogroup=root.findViewById(R.id.gender);
        etName=root.findViewById(R.id.tvname);
        etAge=root.findViewById(R.id.tvage);
        etAddress=root.findViewById(R.id.tvaddress);
        btnsave=root.findViewById(R.id.btnsave);
        rdogroup.setOnCheckedChangeListener( this);
        btnsave.setOnClickListener(this);

        final TextView textView = root.findViewById(R.id.text_dashboard);
        dashboardViewModel.getText().observe(this, new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {
            }
        });
        return root;
    }

    String fullname,address,age,gender;


    @Override
    public void onClick(View v) {
        if(v.getId()==R.id.btnsave){
            Toast.makeText(getActivity(),"save",Toast.LENGTH_SHORT).show();
            fullname=etName.getText().toString();
            age=etAge.getText().toString();
            address=etAddress.getText().toString();

            if(validate()){
                BottmNavigationActivity.student.add(new Student(fullname,address,gender, Integer.parseInt(age)));
                Toast.makeText(getContext(),"Student added",Toast.LENGTH_SHORT).show();
            }
        }
    }


    private  boolean validate(){
        if(TextUtils.isEmpty(etName.getText())){
            etName.setError("please enter full name");
            etName.requestFocus();
            return false;
        }
        else if(TextUtils.isEmpty(etAddress.getText())){
            etAddress.setError("please enter address");
            etAddress.requestFocus();
            return false;
        }
        else if(TextUtils.isEmpty(etAge.getText())){
            etAge.setError("please enter age");
            etAge.requestFocus();
            return false;
        }

        else if(TextUtils.isEmpty(gender)){
            Toast.makeText(getContext(),"please select gender",Toast.LENGTH_SHORT).show();
            return  false;
        }
        return true;
    }
    @Override
    public void onCheckedChanged(RadioGroup group, int checkedId) {


        if(checkedId==R.id.rdMale){
            gender="male";
        }
        if(checkedId==R.id.rdfemale){
            gender="female";
        }
        if(checkedId==R.id.rdobtnther){
            gender="other";
        }



    }
}