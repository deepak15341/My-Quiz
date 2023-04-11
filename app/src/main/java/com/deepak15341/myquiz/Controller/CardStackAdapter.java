package com.deepak15341.myquiz.Controller;


import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class CardStackAdapter extends RecyclerView.ViewHolder {
    private TextView textViewQuestion;
    private ImageButton trueImageButton, falseImageButton;
    public CardStackAdapter(@NonNull View itemView) {
        super(itemView);
    }
}
