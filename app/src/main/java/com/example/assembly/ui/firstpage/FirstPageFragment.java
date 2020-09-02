package com.example.assembly.ui.firstpage;

import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

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

        final TextView textView = root.findViewById(R.id.text_firstpage);
        firstPageViewModel.getText().observe(getViewLifecycleOwner(), new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {
                textView.setText(s);
            }
        });
        return root;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        firstPageViewModel = ViewModelProviders.of(this).get(FirstPageViewModel.class);
        // TODO: Use the ViewModel
    }


}
