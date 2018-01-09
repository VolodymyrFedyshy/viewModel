package com.ls.livedata.viewm;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.ViewModel;
import android.os.CountDownTimer;

/**
 * Created on 05/01/2018.
 */

public class ProgressViewModel extends ViewModel {

    private MutableLiveData data;

    LiveData getProgress() {
        if (data == null) {
            data = new MutableLiveData<>();
            countDownTimer.start();
        }
        return data;
    }

    private CountDownTimer countDownTimer =
            new CountDownTimer(10000, 100) {
                public void onTick(long millisUntilFinished) {
                    data.setValue(Math.abs((int) millisUntilFinished / 100 - 100));
                }

                @Override
                public void onFinish() {
                    data.setValue(0);
                }
            };
}
