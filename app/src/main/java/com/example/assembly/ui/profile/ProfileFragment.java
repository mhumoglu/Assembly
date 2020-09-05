package com.example.assembly.ui.profile;

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

public class ProfileFragment extends Fragment {

    private ProfileViewModel notificationsViewModel;
    private FirstPageViewModel firstPageViewModel;
    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        firstPageViewModel.ct.cancel();
        notificationsViewModel =
                ViewModelProviders.of(this).get(ProfileViewModel.class);
        View root = inflater.inflate(R.layout.fragment_profile, container, false);
        return root;
    }
}
