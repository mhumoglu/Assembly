package com.example.assembly.ui.assemblies;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;


import com.example.assembly.R;
import com.example.assembly.ui.firstpage.FirstPageFragment;
import com.example.assembly.ui.firstpage.FirstPageViewModel;

public class AssembliesFragment extends Fragment {

    private AssembliesViewModel dashboardViewModel;
    private FirstPageViewModel firstPageViewModel;
    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        firstPageViewModel.ct.cancel();
        dashboardViewModel =
                ViewModelProviders.of(this).get(AssembliesViewModel.class);
        View root = inflater.inflate(R.layout.fragment_assemblies, container, false);
        final TextView textView = root.findViewById(R.id.text_ass);
        dashboardViewModel.getText().observe(getViewLifecycleOwner(), new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {
                textView.setText(s);
            }
        });
        return root;
    }
}
