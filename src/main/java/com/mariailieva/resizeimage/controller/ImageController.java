package com.mariailieva.resizeimage.controller;

import android.content.Intent;
import android.graphics.Bitmap;

import androidx.annotation.Nullable;

import com.mariailieva.resizeimage.MainActivity;


public class ImageController {

    private MainActivity mainActivity;

    public ImageController(MainActivity mainActivity) {
        this.mainActivity = mainActivity;
    }

    public void handleImageReturn(int requestCode, @Nullable Intent intent) {
        if(requestCode == 1){
            Bitmap bitmap = (Bitmap) intent.getExtras().get("data");
            Bitmap resized = Bitmap.createScaledBitmap(bitmap,90 ,90 , true);
            mainActivity.imageView.setImageBitmap(resized);
        }
    }




}
