package com.example.android.thenewsapp;

import android.content.Context;
import android.support.v4.content.AsyncTaskLoader;

import java.util.List;

public class NewsLoader extends AsyncTaskLoader<List<News>> {

    public static String s ;

    public NewsLoader(Context context, String url) {
        super(context);
        this.s = url;
    }

    @Override
    protected void onStartLoading() {
        forceLoad();
    }

    @Override
    public List<News> loadInBackground() {
        if (s == null) {
            return null;
        }

        List<News> newsList = QueryUtils.fetchNewsData(s);
        return newsList;
    }
}
