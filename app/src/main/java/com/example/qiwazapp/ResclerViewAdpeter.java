package com.example.qiwazapp;

import android.os.CountDownTimer;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.qiwazapp.moudle.datamoudle;

import java.util.ArrayList;
import java.util.Locale;

public class ResclerViewAdpeter extends RecyclerView.Adapter<ResclerViewAdpeter.moudleViewHolder> {

    ArrayList<datamoudle> datemoudle;
    int sec=12000;// 60 sec = 60000milis
    boolean dayisrunng=true;// if day is still rinig we have 8 days whent it beacom 0 this become false

    Button Btndays1, Btnhours1, Btnmins1, Btnsec1;// this to use our buttons to change
    public ResclerViewAdpeter(ArrayList<datamoudle> datemoudle) {
        this.datemoudle = datemoudle;
    }

    @NonNull
    @Override
    public moudleViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.singlelayout, null, false);
        moudleViewHolder viewHolder = new moudleViewHolder(view);
        return viewHolder;
    }
    //first method to start with sec it take all  buttons to send it all to next metod like NODE WORK
    void setTimerSec(Button btntimeSec,Button btntimeMint,Button btntimeHour,Button Day,long time)
    {
        new CountDownTimer(time, 1000) {// EVERY 1000MILSEC MAKE CHANGE

            public void onTick(long millisUntilFinished) {

                btntimeSec.setText(""+millisUntilFinished/1000 +"\nSEC");
            }

            public void onFinish() {
                if (dayisrunng==true) {
                    setTimerSec(btntimeSec,btntimeMint,btntimeHour, Day,60000);
                    setTimerMins(btntimeMint,btntimeHour,Day, 660000);//11 mints = 660000ms
                }
                else {

                    btntimeSec.setText("Finsh");
                }


            }
        }.start();
    }
   void setTimerMins (Button btntimeMinte,Button btntimeHours,Button btntimeDays,long time)
    {

        new CountDownTimer(time, 60000) {


            public void onTick(long millisUntilFinished) {


                    btntimeMinte.setText("" + ((millisUntilFinished / 1000) / 60) + "\nMints");

            }

            public void onFinish() {
                if (dayisrunng) {
                    //setTimerSec(btntime, 60000);
                    setTimerMins(btntimeMinte,btntimeHours,btntimeDays,3600000);//60min = 3600000 milis
                    setTimerHour(btntimeHours,btntimeDays,18000000);
                }
                else {

                    btntimeMinte.setText("Finsh");
                }

            }
        }.start();
    }
    void setTimerHour(Button btntimeHoure,Button btntimedays,long time){

        new CountDownTimer(time, 3600000) {

            public void onTick(long millisUntilFinished) {

                btntimeHoure.setText(""+(((millisUntilFinished / 1000) / 60)/60) +"\nHours");
            }

            public void onFinish() {
                if (dayisrunng) {
                    //setTimerSec(btntime, 60000);
                    setTimerHour(btntimeHoure,btntimedays,86400000 );//24 h = 86400000 ms
                    setDay(btntimedays,691200000);
                }
                else {
                    btntimeHoure.setText("Finsh");
                }
            }
        }.start();
    }

    void setDay(Button btntime,long time)
    { new CountDownTimer(time, 86400000 ) {

            public void onTick(long millisUntilFinished) {

                btntime.setText(""+((((millisUntilFinished / 1000) / 60)/60)/24) +"\nDays");
            }

            public void onFinish() {
                btntime.setText("finsh");
                dayisrunng=false;

            }
        }.start();
    }
    @Override
    public void onBindViewHolder(@NonNull moudleViewHolder holder, int position) {
        datamoudle date = datemoudle.get(position);
        holder.iv.setImageResource(date.getImg());
        Btnsec1=holder.Btnsec;
        Btnmins1=holder.Btnmins;
        Btnhours1=holder.Btnhours;
        Btndays1=holder.Btnmins;
       setTimerSec(Btnsec1,Btnmins1,Btnhours1,Btndays1,sec); // WE Smoend the method here
    }

    @Override
    public int getItemCount() {
        return datemoudle.size();
    }

    //we are Not gone use this class Outsid  so no point to Created sprit
    // this class is  Holder or Container for our ResyclyerView
    class moudleViewHolder extends RecyclerView.ViewHolder {
        ImageView iv;
        Button Btndays, Btnhours, Btnmins, Btnsec;

        public moudleViewHolder(@NonNull View itemView) {

            super(itemView);
            iv = itemView.findViewById(R.id.imget);
            Btndays = itemView.findViewById(R.id.btndays);
            Btnhours = itemView.findViewById(R.id.btnhours);
            Btnmins = itemView.findViewById(R.id.btnmins);
            Btnsec = itemView.findViewById(R.id.btnsec);


        }
    }



}
