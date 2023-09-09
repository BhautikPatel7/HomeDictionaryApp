package com.example.dictionary.ViewHolder;

import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.dictionary.R;

public class MeaningViewHolder extends RecyclerView.ViewHolder {
  public   TextView textview_spartofspeach;
     public  RecyclerView recycle_defination;
    public MeaningViewHolder(@NonNull View itemView) {
        super(itemView);
        textview_spartofspeach = itemView.findViewById(R.id.textview_spartofspeach);
        recycle_defination = itemView.findViewById(R.id.recycle_defination);
    }
}
