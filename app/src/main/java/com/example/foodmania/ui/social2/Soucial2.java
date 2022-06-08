package com.example.foodmania.ui.social2;
import android.content.Intent;
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
public class Soucial2 extends Fragment {

    private FragmentSlideshowBinding binding;
    private String mFacebookUrl = "https://www.facebook.com/";
    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        SlideshowViewModel slideshowViewModel =
                new ViewModelProvider(this).get(SlideshowViewModel.class);
        binding = FragmentSlideshowBinding.inflate(inflater, container, false);
        View root = binding.getRoot();
        Uri uri1 = Uri.parse("http://instagram.com/_u/");
        Intent intent1 = new Intent(Intent.ACTION_VIEW, uri1);
        intent1.setPackage("com.instagram.android");
        try {
            getContext().startActivity(intent1);
        } catch (Exception e) {
            getContext().startActivity(new Intent(Intent.ACTION_VIEW,
                    Uri.parse("http://instagram.com/")));
        }

        return root;
    }

    @Override
    public void onDestroyView () {
        super.onDestroyView();
        binding = null;
    }
}