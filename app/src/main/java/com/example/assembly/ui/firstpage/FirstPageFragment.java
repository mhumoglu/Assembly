package com.example.assembly.ui.firstpage;

import androidx.lifecycle.ViewModelProviders;
import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.assembly.R;

public class FirstPageFragment extends Fragment {

    public static FirstPageFragment newInstance() {
        return new FirstPageFragment();
    }

    private FirstPageViewModel firstPageViewModel;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
            @Nullable Bundle savedInstanceState) {
        firstPageViewModel= ViewModelProviders.of(this).get(FirstPageViewModel.class);
        View root = inflater.inflate(R.layout.fragment_firstpage, container, false);
        return root;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        firstPageViewModel = ViewModelProviders.of(this).get(FirstPageViewModel.class);
        // TODO: Use the ViewModel
    }

}
