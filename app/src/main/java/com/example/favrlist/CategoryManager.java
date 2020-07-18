package com.example.favrlist;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.Preference;

import androidx.preference.PreferenceManager;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Map;

public class CategoryManager {
    public Context mContext;

    public CategoryManager(Context mContext) {
        this.mContext = mContext;
    }

    public void saveCategory(Categories category){
        SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(mContext);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        HashSet itemSet = new HashSet(Arrays.asList(category.getItem()));
        editor.putStringSet(category.getName(),itemSet);
        editor.apply();

    }

    public ArrayList<Categories> retrieveCategory(){
        SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(mContext);
        Map<String,?> data = sharedPreferences.getAll();
        ArrayList<Categories> category = new ArrayList<>();
        for(Map.Entry<String,?> entry : data.entrySet()){
            Categories c = new Categories(entry.getKey(),new ArrayList<String>((HashSet) entry.getValue()));
            category.add(c);
        }
        return category;

    }
    public void removeCategory(){
        SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(mContext);
        SharedPreferences.Editor edit = sharedPreferences.edit();
        edit.clear();
        edit.apply();

    }


}
