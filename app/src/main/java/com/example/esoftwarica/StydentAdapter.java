package com.example.esoftwarica;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class StydentAdapter extends RecyclerView.Adapter<StydentAdapter.StudentViewHolder>{
    Context mContext;
    List<Student> StutentList;
    public StydentAdapter( Context mContext,List<Student>StudentList){
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
    public void onBindViewHolder(@NonNull StudentViewHolder holder, final int position) {
    final Student student=StutentList.get(position);
    holder.imgperson.setImageResource(student.getImgProfileId());
    holder.tvname.setText(student.getName());
    holder.tvage.setText(Integer.toString(student.getAge()));
    holder.tvaddress.setText(student.getAddress());
    holder.tvgender.setText(student.getGender());
    holder.imgdelete.setImageDrawable(mContext.getResources().getDrawable(R.drawable.delete));
        String gender=student.getGender();
        if (gender=="male") {

            holder.imgperson.setImageResource(R.drawable.male);
        }
        else if(gender=="female"){
            holder.imgperson.setImageResource(R.drawable.female);
        }
        else {
            holder.imgperson.setImageDrawable(mContext.getResources().getDrawable(R.drawable.female));
        }

        holder.imgperson.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(mContext,"hi"+student.getName(),Toast.LENGTH_SHORT).show();
            }
        });

        holder.imgperson.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Student cont=StutentList.get(position);
                StutentList.remove(position);
                notifyItemRemoved(position);
                Toast.makeText(mContext,"Removed:"+cont.getName(),Toast.LENGTH_SHORT).show();
            }
        });




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
