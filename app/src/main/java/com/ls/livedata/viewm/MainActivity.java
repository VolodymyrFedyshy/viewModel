package com.ls.livedata.viewm;

import android.arch.lifecycle.LifecycleActivity;
import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProviders;
import android.support.annotation.Nullable;
import android.os.Bundle;
import android.widget.ProgressBar;
import android.widget.TextView;

/**
 * Created on 05/01/2018.
 */

public class MainActivity extends LifecycleActivity {
    private ProgressBar progressBar;
    private TextView pr_text_view;

    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        progressBar = (ProgressBar) findViewById(R.id.pr);
        pr_text_view = (TextView) findViewById(R.id.pr_text_view);
        ProgressViewModel viewModel = ViewModelProviders.of(this).get(ProgressViewModel.class);
        viewModel.getProgress().observe(this, new Observer<Integer>() {
            @Override
            public void onChanged(@Nullable Integer p) {
                progressBar.setProgress(p);
                pr_text_view.setText(String.valueOf(p));
            }
        });
    }
}
