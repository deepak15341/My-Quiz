package com.deepak15341.myquiz.View;



import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.deepak15341.myquiz.R;

public class RandomViewHolder extends RecyclerView.ViewHolder {
    private TextView textViewQuestion;
    private ImageButton trueImageButton, falseImageButton;
    public RandomViewHolder(@NonNull View itemView) {
        super(itemView);
        textViewQuestion = itemView.findViewById(R.id.textViewQuestion);
        trueImageButton = itemView.findViewById(R.id.trueImageButton);
        falseImageButton = itemView.findViewById(R.id.falseImageButton);

    }


    public TextView getTextViewQuestion() {
        return textViewQuestion;
    }



    public ImageButton getTrueImageButton() {
        return trueImageButton;
    }



    public ImageButton getFalseImageButton() {
        return falseImageButton;
    }


}
