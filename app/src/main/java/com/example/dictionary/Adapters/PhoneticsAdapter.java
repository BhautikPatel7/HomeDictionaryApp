package com.example.dictionary.Adapters;

import android.content.Context;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.dictionary.Modules.Phonetics;
import com.example.dictionary.R;
import com.example.dictionary.ViewHolder.PhoneticViewHolder;

import java.io.IOException;
import java.util.List;

public class PhoneticsAdapter extends RecyclerView.Adapter<PhoneticViewHolder> {

    private Context context;
    private List<Phonetics> phoneticsList;

    public PhoneticsAdapter(Context context, List<Phonetics> phoneticsList) {
        this.context = context;
        this.phoneticsList = phoneticsList;
    }

    @NonNull
    @Override
    public PhoneticViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new PhoneticViewHolder(LayoutInflater.from(context).inflate(R.layout.phonetics_list_iteams,parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull PhoneticViewHolder holder, int position) {
    holder.textview_phonetics.setText(phoneticsList.get(position).getText());
    holder.imagebutton_audio.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            MediaPlayer player = new MediaPlayer();
            try {
                player.setAudioStreamType(AudioManager.STREAM_MUSIC);
                player.setDataSource("https:" + phoneticsList.get(position).getAudio());
                player.prepare();
                player.start();
            } catch (Exception e) {
                e.printStackTrace();
                Toast.makeText(context,"couldn't play audio",Toast.LENGTH_LONG).show();
            }
        }
    });
    }

    @Override
    public int getItemCount() {
        return phoneticsList.size();
    }
}
