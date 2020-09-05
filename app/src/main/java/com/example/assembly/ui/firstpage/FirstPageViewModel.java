package com.example.assembly.ui.firstpage;

import android.os.CountDownTimer;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.assembly.ResponseTask;

import java.util.concurrent.ExecutionException;

public class FirstPageViewModel extends ViewModel {
    // TODO: Implement the ViewModel
    private MutableLiveData<String> mText;
    public static CountDownTimer ct;
    public FirstPageViewModel() throws ExecutionException, InterruptedException {
        mText = new MutableLiveData<>();
        ct=new CountDownTimer(Long.MAX_VALUE, 10000) {
            @Override
            //OnTick metodu geri sayım süresince yapılacak değişiklikler
            public void onTick(long millisUntilFinished) {
                String x = null;
                try {
                    x = new ResponseTask().execute("http://209.250.237.51:3000/getStory").get();
                } catch (ExecutionException e) {
                    e.printStackTrace();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                mText.setValue(x);

            }

            @Override
            //süre bittiğinde yapılacaklar
            public void onFinish() {


            }
        }.start();

    }

    public LiveData<String> getText() {
        return mText;
    }
}
