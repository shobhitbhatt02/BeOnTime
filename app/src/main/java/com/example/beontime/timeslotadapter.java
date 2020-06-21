package com.example.beontime;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.firebase.ui.database.FirebaseRecyclerOptions;

public class timeslotadapter extends FirebaseRecyclerAdapter<timeslot,timeslotadapter.timeslotViewHolder>{
    public timeslotadapter(@NonNull FirebaseRecyclerOptions<timeslot> options) {
        super(options);
    }

    @Override
    protected void onBindViewHolder(@NonNull timeslotViewHolder holder, int position, @NonNull timeslot ts) {
        holder.begintime.setText(ts.getBegintime());
        holder.date.setText(ts.getDate());
        holder.endtime.setText(ts.getEndtime());
    }

    @NonNull
    @Override
    public timeslotViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.times, parent, false);

        return new timeslotViewHolder(view);
    }

    public class timeslotViewHolder extends RecyclerView.ViewHolder{
        TextView date,begintime,endtime;


        public timeslotViewHolder(@NonNull View itemView) {
            super(itemView);
            begintime=itemView.findViewById(R.id.begintime1);

            date=itemView.findViewById(R.id.date1);
            endtime=itemView.findViewById(R.id.endtime1);
        }
    }
}
