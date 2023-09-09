package com.example.dictionary;

import com.example.dictionary.Modules.APIResponse;

public interface onFeatchDataListner {
    void OnFeatchData(APIResponse apiResponse, String message);
    void ONError (String massage);
}
