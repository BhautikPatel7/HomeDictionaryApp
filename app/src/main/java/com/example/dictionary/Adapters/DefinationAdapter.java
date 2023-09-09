package com.example.dictionary.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.dictionary.Modules.Definations;
import com.example.dictionary.R;
import com.example.dictionary.ViewHolder.DefinationViewHolder;

import java.util.List;

public class DefinationAdapter extends RecyclerView.Adapter<DefinationViewHolder> {
    private Context context;
    private List<Definations> definationsList;

    public DefinationAdapter(Context context, List<Definations> definationsList) {
        this.context = context;
        this.definationsList = definationsList;
    }

    @NonNull
    @Override
    public DefinationViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new DefinationViewHolder(LayoutInflater.from(context).inflate(R.layout.defination_list_iteam,parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull DefinationViewHolder holder, int position) {
        holder.textview_defination.setText("defination:" + definationsList.get(position).getDefinition());
        holder.textview_defination_example.setText("Example:" + definationsList.get(position).getExample() );
        StringBuilder synonyms = new StringBuilder();
        StringBuilder antonyms = new StringBuilder();

        synonyms.append(definationsList.get(position).getSynonyms());
        antonyms.append(definationsList.get(position).getAntonyms());

        holder.textview_synnonms.setText(synonyms);
        holder.textview_antononyms.setText(antonyms);

        holder.textview_synnonms.setSelected(true);
        holder.textview_antononyms.setSelected(true);


    }

    @Override
    public int getItemCount() {
        return definationsList.size();
    }
}

