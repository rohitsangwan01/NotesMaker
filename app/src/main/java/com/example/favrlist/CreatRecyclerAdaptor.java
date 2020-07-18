package com.example.favrlist;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.zip.Inflater;

public class CreatRecyclerAdaptor extends RecyclerView.Adapter<RecyclerViewHolder> {

   // String[] hobbies = {"Games","Movies","Shooting","Singing","Coding","Reading","Fighting"};
    ArrayList<Categories> categories;

    public CreatRecyclerAdaptor(ArrayList<Categories> categories) {
        this.categories = categories;
    }

    @NonNull
    @Override
    public RecyclerViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.view_holder,parent,false);
        RecyclerViewHolder NewView = new RecyclerViewHolder(view);
        return NewView;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerViewHolder holder, int position) {
        holder.getFirstText().setText(Integer.toString(position +1));
        holder.getSecondText().setText(categories.get(position).getName());
//        holder.btn.setText("My Hobby Is "+categories.get(position).getName());

    }

    @Override
    public int getItemCount() {
        return categories.size();
    }
    public  void addAdapter(Categories categoriy){
        categories.add(categoriy);
        notifyItemInserted(categories.size()-1);
    }

    public void removeItems(){
        categories.remove(0);
    }
}
