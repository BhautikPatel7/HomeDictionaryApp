package com.example.dictionary;

import android.content.Context;
import android.widget.Toast;

import com.example.dictionary.Modules.APIResponse;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.GET;
import retrofit2.http.Path;

public class RequestManager {
    Context context;
    Retrofit retrofit =  new Retrofit.Builder()
            .baseUrl("https://api.dictionaryapi.dev/api/v2/")
            .addConverterFactory(GsonConverterFactory.create())
            .build();

    public RequestManager(Context context) {
        this.context = context;
    }
    public void getWordMeaning(onFeatchDataListner listner, String word){
        CallDictionary callDictionary = retrofit.create(CallDictionary.class);
        Call<List<APIResponse>> call = callDictionary.callMeanings(word);

        try {
            call.enqueue(new Callback<List<APIResponse>>() {
                @Override
                public void onResponse(Call<List<APIResponse>> call, Response<List<APIResponse>> response) {
                    if (!response.isSuccessful()){
                        Toast.makeText(context,"Error",Toast.LENGTH_LONG).show();
                        return;
                    }
                    listner.OnFeatchData(response.body().get(0),response.message());
                }

                @Override
                public void onFailure(Call<List<APIResponse>> call, Throwable t) {
                    listner.ONError("Request Fail");
                }
            });
        } catch (Exception e){
            e.printStackTrace();
            Toast.makeText(context,"An eroor occured",Toast.LENGTH_LONG).show();
        }
    }

     public interface CallDictionary {
        @GET("entries/en/{word}")
         Call<List<APIResponse>> callMeanings(
            @Path("word") String word
        );
    };
}
