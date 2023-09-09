package com.example.dictionary.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.dictionary.Modules.Meanings;
import com.example.dictionary.R;
import com.example.dictionary.ViewHolder.MeaningViewHolder;

import java.util.List;

public class MeaningAdapter extends RecyclerView.Adapter<MeaningViewHolder> {
    private Context context;
    private List<Meanings> meaningsList;

    public MeaningAdapter(Context context, List<Meanings> meaningsList) {
        this.context = context;
        this.meaningsList = meaningsList;
    }

    @NonNull
    @Override
    public MeaningViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new MeaningViewHolder(LayoutInflater.from(context).inflate(R.layout.meanings_list_iteams,parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull MeaningViewHolder holder, int position) {
        holder.textview_spartofspeach.setText("Part of Speech:" + meaningsList.get(position).getDefinitions());
        holder.recycle_defination.setHasFixedSize(true);
        holder.recycle_defination.setLayoutManager(new GridLayoutManager(context,1));
        DefinationAdapter definationAdapter = new DefinationAdapter(context,meaningsList.get(position).getDefinitions());
        holder.recycle_defination.setAdapter(definationAdapter);
    }

    @Override
    public int getItemCount() {
        return meaningsList.size();
    }
}
