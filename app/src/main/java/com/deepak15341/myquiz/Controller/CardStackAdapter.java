package com.deepak15341.myquiz.Controller;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.deepak15341.myquiz.R;
import com.deepak15341.myquiz.View.RandomViewHolder;

import java.util.List;

public class CardStackAdapter extends RecyclerView.Adapter<RandomViewHolder> {
    private Context mContext;
    private List<String> mRandomList;
    private LayoutInflater mLayoutInflater;
    public  CardStackAdapter(Context context,List<String> randomList){
        mContext = context;
        mRandomList = randomList;
        mLayoutInflater = LayoutInflater.from(context);
    }

    @NonNull
    @Override
    public RandomViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View  view= mLayoutInflater.inflate(R.layout.random_view,parent,false);
        return new RandomViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RandomViewHolder holder, int position) {

        holder.getTextViewQuestion().setText(mRandomList.get(position));
        holder.getTrueImageButton().setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(mContext, "True is tapped", Toast.LENGTH_SHORT).show();
            }
        });
        holder.getFalseImageButton().setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(mContext, "False is tapped", Toast.LENGTH_SHORT).show();
            }
        });

    }

    @Override
    public int getItemCount() {
        return mRandomList.size();
    }
}
