package com.example.admin.mynewproject;

import android.annotation.SuppressLint;
import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.AppCompatTextView;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.Adapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class AdapterClass extends Adapter <AdapterClass.MyViewHolder> {
    private List<Schedule> scheduleList;

    AdapterClass(Context context, List<Schedule> scheduleList) {
        this.scheduleList = scheduleList;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.list_item_user, parent, false);

        return new MyViewHolder(itemView);
    }

    @SuppressLint("SetTextI18n")
    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        Schedule schedule = scheduleList.get(position);
        holder.schedulename.setText("Name : " + schedule.getSchedule());
        holder.room_name.setText("RoomName :" + schedule.getRoomName());
        holder.applience_name.setText("ApplienceName :" + schedule.getApplienceName());
        holder.timestam.setText(formatDate(schedule.getTimestamp()));

    }

    private String formatDate(String dateStr) {

        try {
            @SuppressLint("SimpleDateFormat") SimpleDateFormat fmt = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            Date date = fmt.parse(dateStr);
            @SuppressLint("SimpleDateFormat") SimpleDateFormat fmtOut = new SimpleDateFormat("MMM d");
            return fmtOut.format(date);
        } catch (ParseException e) {

        }

        return "";
    }

    @Override
    public int getItemCount() {
        return scheduleList.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        public AppCompatTextView schedulename;
        public AppCompatTextView room_name;
        public AppCompatTextView applience_name;
        public AppCompatTextView timestam;


        private MyViewHolder(@NonNull View itemView) {
            super(itemView);
            schedulename = itemView.findViewById(R.id.schedulename);
            room_name =itemView.findViewById(R.id.room_name);
            applience_name = itemView.findViewById(R.id.applience_name);
            timestam =itemView.findViewById(R.id.timestam);
        }
    }
}
