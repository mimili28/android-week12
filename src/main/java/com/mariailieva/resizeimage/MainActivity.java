package com.mariailieva.resizeimage;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.provider.MediaStore;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import com.mariailieva.resizeimage.controller.ImageController;

import java.io.ByteArrayOutputStream;
import java.io.EOFException;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.text.SimpleDateFormat;
import java.util.Date;

public class MainActivity extends AppCompatActivity {

    public ImageView imageView;
    private ImageController imageController;
    private String currentPhotoPath;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        imageView = findViewById(R.id.imageView);
        imageController = new ImageController(this);
    }


    public void cameraBtnPressed(View view) {
        Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        startActivityForResult(intent, 1);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent intent) {
        super.onActivityResult(requestCode, resultCode, intent);
        if (resultCode != -1) return;
        imageController.handleImageReturn(requestCode, intent);

    }

    public void saveImageToPhotoRoll(View view) {
        imageView.setDrawingCacheEnabled(true);
        Bitmap b = imageView.getDrawingCache();
        MediaStore.Images.Media.insertImage(getContentResolver(), b,"newImage", "resizedImg");
        Toast.makeText(this,"Image saved!",Toast.LENGTH_SHORT).show();
    }
}
