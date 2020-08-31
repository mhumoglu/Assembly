package com.example.assembly.ui.firstpage;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class FirstPageViewModel extends ViewModel {
    // TODO: Implement the ViewModel
    private MutableLiveData<String> mText;

    public FirstPageViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("This is firstpage");
    }

    public LiveData<String> getText() {
        return mText;
    }
}
