package com.example.project_;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.view.View;
import android.view.animation.AnimationUtils;
import android.widget.Toast;

import com.example.project_.databinding.M001MainActBinding;

public class M001_mainAct extends baseAct <M001MainActBinding> {

    public static final String NAME_ANIMAL = "NAME_ANIMAL";
    public static final String IMAGE_ANIMAL = "IMAGE_ANIMAL";
    private int drawableID;
    private String name ;

    @Override
    protected void initView() {
                binding.ivBird.setOnClickListener(v -> doAnimal(v,R.drawable.icon_bird,R.string.contentBird));
                binding.ivDog.setOnClickListener(v -> doAnimal(v,R.drawable.icon_dog,R.string.contentDog));
                binding.ivPenguin.setOnClickListener(v -> doAnimal(v,R.drawable.icon_penguin,R.string.contentPenguin));
                binding.ivChecken.setOnClickListener(v -> doAnimal(v,R.drawable.icon_checken,R.string.contentChecken));
                binding.btDetail.setOnClickListener(v -> gotodetail());
                binding.ivCall.setOnClickListener(v -> makeCalPhone("900"));
                binding.ivDialpad   .setOnClickListener(v -> showDialPad("900"));
    }

    private void showDialPad(String phone) {
        Intent intent = new Intent() ;
        intent.setAction(Intent.ACTION_DIAL) ;
        intent.setData(Uri.parse("Tel:" + phone)) ;

        startActivity(intent);
    }

    private void makeCalPhone(String phone) {
        if(checkSelfPermission(Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED)
        {
            requestPermissions(new String[]{
                    Manifest.permission.CALL_PHONE
            },101);
            return ;
        }
        Intent intent = new Intent() ;
        intent.setAction(Intent.ACTION_CALL) ;
        intent.setData(Uri.parse(phone)) ;

        startActivity(intent);
    }

    public void onRequestPermissionsResult(int requestCode, String[] permissions, int[] grantResult) {


        super.onRequestPermissionsResult(requestCode, permissions, grantResult);
        if(requestCode == 101 && grantResult[0] == PackageManager.PERMISSION_GRANTED)
        {
            makeCalPhone("900");
        }else
            Toast.makeText(this, "please allow call phone permission to do this!", Toast.LENGTH_SHORT).show();
    }

    private void gotodetail() {
        Intent intent = new Intent();
        intent.putExtra(NAME_ANIMAL,name);
        intent.putExtra(IMAGE_ANIMAL,drawableID);
        startActivity(intent);
    }

    private void doAnimal(View v, int drawableID, int content) {
        v.startAnimation(AnimationUtils.loadAnimation(this, androidx.appcompat.R.anim.abc_fade_in)) ;
        binding.btDetail.setEnabled(true);
        binding.tvContent.setText(content);
        this.drawableID = drawableID  ;
        name = v.getContentDescription().toString() ;
    }

    @Override
    protected M001MainActBinding initBindingView() {
        return M001MainActBinding.inflate(getLayoutInflater());
    }
}
