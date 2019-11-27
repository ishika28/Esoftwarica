package com.example.esoftwarica;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class StydentAdapter extends RecyclerView.Adapter<StydentAdapter.StudentViewHolder>{
    Context mContext;
    List<Student> StutentList;
    public StydentAdapter(Context mContext,List<Student>StudentList){
        this.mContext=mContext;
        this.StutentList= StudentList;
    }

    @NonNull
    @Override
    public StudentViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
       View view = LayoutInflater.from(parent.getContext())
               .inflate(R.layout.layout_student,parent,false);
       return new StudentViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull StudentViewHolder holder, int position) {
    Student student=StutentList.get(position);
    holder.imgperson.setImageResource(student.getImgperson());
    holder.tvname.setText(student.getName());
    holder.tvage.setText(student.getAge());
    holder.tvaddress.setText(student.getAddress());
    holder.tvgender.setText(student.getGender());
    holder.imgdelete.setImageResource(student.getImgdelete());


        }

    @Override
    public int getItemCount() {
        return StutentList.size();
    }

    public class StudentViewHolder extends RecyclerView.ViewHolder{

        ImageView imgperson, imgdelete;
        TextView tvname, tvage, tvaddress, tvgender;

        public StudentViewHolder(View item){
            super(item);
            imgperson=item.findViewById(R.id.imgperson);
            imgdelete=item.findViewById(R.id.imgdelete);
            tvname=item.findViewById(R.id.tvname);
            tvage=item.findViewById(R.id.tvage);
            tvaddress=item.findViewById(R.id.tvaddress);
            tvgender=item.findViewById(R.id.tvgender);

        }
    }
}
