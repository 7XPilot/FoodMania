package com.example.foodmania.ui.social1;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.example.foodmania.databinding.FragmentSlideshowBinding;
import com.example.foodmania.ui.slideshow.SlideshowViewModel;

public class Soucial1 extends Fragment {

    private FragmentSlideshowBinding binding;
    private String mFacebookUrl = "https://www.facebook.com/ostendpizza/";
    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        SlideshowViewModel slideshowViewModel =
                new ViewModelProvider(this).get(SlideshowViewModel.class);

        binding = FragmentSlideshowBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        Intent intent1 = new Intent(Intent.ACTION_VIEW);
        intent1.setData(Uri.parse(getFacebookPageURL(getContext())));
        getContext().startActivity(intent1);

        return root;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }

        public String getFacebookPageURL(Context context) {
        PackageManager packageManager = context.getPackageManager();
        try {
            int versionCode = packageManager.getPackageInfo("com.facebook.katana", 0).versionCode;
            if (versionCode >= 3002850) { //new Facebook
                return "fb://facewebmodal/f?href=" + mFacebookUrl;
            } else { //old Facebook
                return "fb://page/";
            }
        } catch (PackageManager.NameNotFoundException e) {
            return mFacebookUrl; //if none use url
        }
    }
}