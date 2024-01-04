package com.example.myappfour;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class UserAdapter extends RecyclerView.Adapter<UserAdapter.MyViewHolder> {

    private Context mContext;
    private ArrayList<StudentsClass> names_list;
    private LayoutInflater inflater;

    public UserAdapter(Context mContext, ArrayList<StudentsClass> names_list) {
        this.mContext = mContext;
        this.names_list = names_list;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        inflater = LayoutInflater.from(mContext);
        View view = inflater.inflate(R.layout.item_student_marks, parent, false);

        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        holder.tv_name.setText(names_list.get(position).name);
        holder.tv_marks.setText(names_list.get(position).marks);
    }

    @Override
    public int getItemCount() {
        return names_list.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {

        TextView tv_name;
        TextView tv_marks;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            tv_name = itemView.findViewById(R.id.tv_name);
            tv_marks = itemView.findViewById(R.id.tv_marks);
        }
    }
}
