package com.example.dictionary;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SearchView;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import com.example.dictionary.Adapters.MeaningAdapter;
import com.example.dictionary.Adapters.PhoneticsAdapter;
import com.example.dictionary.Modules.APIResponse;

public class MainActivity extends AppCompatActivity {
 SearchView search_view;
 TextView textview_word;
 RecyclerView recycle_phonetics,recycle_meaning;
 PhoneticsAdapter phoneticsAdapter;
 MeaningAdapter meaningAdapter;
 ProgressDialog progressDialog;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        search_view = findViewById(R.id.search_view);
        textview_word = findViewById(R.id.textview_word);
        recycle_phonetics = findViewById(R.id.recycle_phonetics);
        recycle_meaning = findViewById(R.id.recycle_meaning);
        progressDialog = new ProgressDialog(this);

        progressDialog.setTitle("Loadinh... " );
        progressDialog.show();
        RequestManager manager = new RequestManager(MainActivity.this);
        manager.getWordMeaning(listener,"hello");

        search_view.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                progressDialog.setTitle("Featching result of " + query);
                progressDialog.show();
                RequestManager manager = new RequestManager(MainActivity.this);
                manager.getWordMeaning(listener,query);
                return true;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                return false;
            }
        });


    }
    private final onFeatchDataListner listener = new onFeatchDataListner() {
        @Override
        public void OnFeatchData(APIResponse apiResponse, String message) {
            progressDialog.dismiss();
            if (apiResponse == null){
                Toast.makeText(MainActivity.this,"No Data Found",Toast.LENGTH_LONG).show();
                return;
            }
            showData(apiResponse);

        }

        @Override
        public void ONError(String massage) {
            progressDialog.dismiss();
            Toast.makeText(MainActivity.this,massage,Toast.LENGTH_LONG).show();
        }
    };

    private void showData(APIResponse apiResponse) {
        textview_word.setText("Word:" + apiResponse.getWord());
        recycle_phonetics.setHasFixedSize(true);
        recycle_phonetics.setLayoutManager(new GridLayoutManager(this,1));
        phoneticsAdapter = new PhoneticsAdapter(this,apiResponse.getPhonetics());
        recycle_phonetics.setAdapter(phoneticsAdapter);
        recycle_meaning.setHasFixedSize(true);
        recycle_meaning.setLayoutManager(new GridLayoutManager(this,1));
        meaningAdapter = new MeaningAdapter(this,apiResponse.getMeanings());
        recycle_meaning.setAdapter(meaningAdapter);

    }
}