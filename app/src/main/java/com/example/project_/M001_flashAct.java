package com.example.project_;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewbinding.ViewBinding;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

import com.example.project_.databinding.M001FlashactBinding;

public class M001_flashAct extends AppCompatActivity {
  protected M001FlashactBinding binding ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = M001FlashactBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        initView();
    }

    private void initView() {
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                gotoMain();
            }
        },500);

    }

    private void gotoMain() {
        Intent intent = new Intent();
        intent.setClass(this, M001_mainAct.class);
        startActivity(intent);
        finish();
    }
}