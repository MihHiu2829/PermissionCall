package com.example.project_;

import android.content.Intent;

import com.example.project_.databinding.M002DetailActBinding;

public class M002_detail_act extends baseAct<M002DetailActBinding> {
    @Override
    protected void initView() {
        Intent intent = getIntent() ;
        String name = intent.getStringExtra(M001_mainAct.NAME_ANIMAL);
        int drawableID = intent.getIntExtra(M001_mainAct.IMAGE_ANIMAL,-1);

        binding.ivImageAnimal.setImageResource(drawableID);
        binding.tvNameAnimal.setText(name);
    }

    @Override
    protected M002DetailActBinding initBindingView() {
        return M002DetailActBinding.inflate(getLayoutInflater());
    }
}
