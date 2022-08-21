package com.example.project_;

import android.os.Bundle;
import android.view.View;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.viewbinding.ViewBinding;

public  abstract  class baseAct <T extends ViewBinding> extends AppCompatActivity implements View.OnClickListener {
        protected T binding ;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = initBindingView();
        setContentView(binding.getRoot());
        initView();
    }
    protected abstract void initView();

    protected abstract T initBindingView();


    @Override
    public void onClick(View view) {

    }
}
