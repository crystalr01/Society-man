package com.rameshwar.societyman;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;

public class NoticeAdapter extends RecyclerView.Adapter<NoticeAdapter.NoticeViewAdapter> {

    private Context context;
    private ArrayList<NoticeData> list;

    public NoticeAdapter(Context context, ArrayList<NoticeData> list) {
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public NoticeViewAdapter onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.custom_image_text_activity, parent, false);
        return new NoticeViewAdapter(view);
    }

    @Override
    public void onBindViewHolder(@NonNull NoticeViewAdapter holder, int position) {

        final NoticeData currentItem = list.get(position);

        holder.userName.setText(currentItem.getUserName1());
        holder.houseNo.setText(currentItem.getHouseNo());
        holder.familyMem.setText(currentItem.getFamily());
        holder.work.setText(currentItem.getWork());
        holder.goTime.setText(currentItem.getGoTime());
        holder.returnTime.setText(currentItem.getReturnTime());
        holder.vehicals.setText(currentItem.getVehicals());
        holder.date.setText(currentItem.getDate());
        holder.time.setText(currentItem.getTime());

        try {
            if (currentItem.getImage() != null)
                Glide.with(context).load(currentItem.getImage()).into(holder.newsImage);
        } catch (Exception e) {
            e.printStackTrace();
        }
        holder.itemView.setOnClickListener(new View.OnClickListener() {

        @Override
        public void onClick(View v) {



            Intent intent = new Intent(context,UserInfo.class);
            intent.putExtra("newsImage",currentItem.getImage());
            intent.putExtra("userName",currentItem.getUserName1());
            intent.putExtra("houseNo",currentItem.getHouseNo());
            intent.putExtra("familyMem",currentItem.getFamily());
            intent.putExtra("work",currentItem.getWork());
            intent.putExtra("goTime",currentItem.getGoTime());
            intent.putExtra("returnTime",currentItem.getReturnTime());
            intent.putExtra("vehicals",currentItem.getVehicals());
            intent.putExtra("date",currentItem.getDate());
            intent.putExtra("time",currentItem.getTime());
            intent.putExtra("image",currentItem.getImage());
            context.startActivity(intent);


        }
    });

    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class NoticeViewAdapter extends RecyclerView.ViewHolder {

        private TextView userName,date,time,houseNo,familyMem,goTime,returnTime,work,vehicals;
        private ImageView newsImage;

        public NoticeViewAdapter(@NonNull View itemView) {
            super(itemView);

            userName = itemView.findViewById(R.id.userName);
            newsImage = itemView.findViewById(R.id.custom_image_news1);
            date = itemView.findViewById(R.id.custom_date);
            time = itemView.findViewById(R.id.custom_time);
            houseNo = itemView.findViewById(R.id.houseNo);
            familyMem = itemView.findViewById(R.id.familyNo);
            goTime = itemView.findViewById(R.id.goTime);
            returnTime = itemView.findViewById(R.id.returnTime);
            work = itemView.findViewById(R.id.work);
            vehicals = itemView.findViewById(R.id.vehicals);
        }
    }
}
