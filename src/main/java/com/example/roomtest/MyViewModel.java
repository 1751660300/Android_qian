package com.example.roomtest;

import android.app.Application;
import android.content.Context;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import java.util.List;

public class MyViewModel extends ViewModel {
    private WordRepository wordRepository;
    private LiveData<List<Word>> mutableLiveData = wordRepository.getListLiveData();
    public MyViewModel(Application application){
        wordRepository = new WordRepository(application.getApplicationContext());
    }

    public LiveData<List<Word>> getMutableLiveData() {
        return mutableLiveData;
    }
    void insertWords(Word... words) {
        wordRepository.InsertWords(words);
    }

}
