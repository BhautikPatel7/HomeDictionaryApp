package com.example.dictionary.ViewHolder;

import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.dictionary.R;

public class DefinationViewHolder extends RecyclerView.ViewHolder {
    public  TextView textview_defination,textview_defination_example,textview_synnonms,textview_antononyms;
    public DefinationViewHolder(@NonNull View itemView) {
        super(itemView);
        textview_defination = itemView.findViewById(R.id.textview_defination);
        textview_defination_example = itemView.findViewById(R.id.textview_defination_example);
        textview_synnonms = itemView.findViewById(R.id.textview_synnonms);
        textview_antononyms = itemView.findViewById(R.id.textview_antononyms);
    }
}
