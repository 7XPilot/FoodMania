package com.example.foodmania.ui.home;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.example.foodmania.FoodEnter;
import com.example.foodmania.FoodEnter2;
import com.example.foodmania.FoodEnter3;
import com.example.foodmania.FoodEnter4;
import com.example.foodmania.R;
import com.example.foodmania.databinding.FragmentHomeBinding;

public class HomeFragment extends Fragment {



    private FragmentHomeBinding binding;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        HomeViewModel homeViewModel =
                new ViewModelProvider(this).get(HomeViewModel.class);

        binding = FragmentHomeBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        LinearLayout food1 = binding.food1;
        food1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent();
                intent.setClass(getContext(), FoodEnter.class);
                startActivity(intent);
            }
        });

        LinearLayout food2 = binding.food2;
        food2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent();
                intent.setClass(getContext(), FoodEnter2.class);
                startActivity(intent);
            }
        });

        LinearLayout food3 = binding.food3;
        food3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent();
                intent.setClass(getContext(), FoodEnter3.class);
                startActivity(intent);
            }
        });

        LinearLayout food4 = binding.food4;
        food4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent();
                intent.setClass(getContext(), FoodEnter4.class);
                startActivity(intent);
            }
        });





//        final TextView textView = binding.textHome;
//        homeViewModel.getText().observe(getViewLifecycleOwner(), textView::setText);
        return root;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;


    }
}