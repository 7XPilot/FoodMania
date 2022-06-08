package com.example.foodmania;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class FoodAdapter extends RecyclerView.Adapter<FoodAdapter.ViewHolder>{

    private List<Food> mBookList;
    static class ViewHolder extends RecyclerView.ViewHolder{
        ImageView foodImage;
        TextView foodName;
        TextView price;
        ImageButton admin;
        public ViewHolder(View view){
            super(view);
            foodImage=view.findViewById(R.id.a1);
            foodName=view.findViewById(R.id.a2);
            price=view.findViewById(R.id.a3);

        }
    }

    public FoodAdapter(List<Food> bookList){
        mBookList=bookList;
    }
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.food_item,parent,false);
        RecyclerView.ViewHolder holder=new ViewHolder(view);
        return (ViewHolder) holder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        Food book=mBookList.get(position);
        holder.foodImage.setImageResource(book.getImageId());
        holder.foodName.setText(book.getName());
        holder.price.setText(book.getPrice1());
    }

    @Override
    public int getItemCount() {
        return mBookList.size();
    }
}