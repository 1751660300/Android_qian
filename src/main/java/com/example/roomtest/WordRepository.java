package com.example.roomtest;

import android.content.Context;
import android.os.AsyncTask;

import androidx.lifecycle.LiveData;

import java.util.List;

public class WordRepository {
    public  WordDao wordDao;

    public LiveData<List<Word>> getListLiveData() {
        return listLiveData;
    }

    private LiveData<List<Word>> listLiveData;

    WordRepository(Context context){
        wordDao =WordDatabase.getINSTENCE(context.getApplicationContext()).getWordDao();
        listLiveData = wordDao.selectWord();
    }

    public void InsertWords(Word... words)
    {
        new AsyctaskInsert(wordDao).execute(words);
    }
}

class AsyctaskInsert extends AsyncTask<Word,Word,Word>{
    private WordDao wordDao;
    AsyctaskInsert(WordDao wordDao){
        this.wordDao = wordDao;
    }

    @Override
    protected Word doInBackground(Word... words) {
        wordDao.insertWord(words);
        return null;
    }

}
