package com.example.logintoolbox;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.ImageView;
import android.widget.ListView;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

import javax.net.ssl.HttpsURLConnection;

public class ImagePage extends AppCompatActivity {
    ImageView im;
    final Handler mHandler = new Handler();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_image_page);
        im = (ImageView) findViewById(R.id.imageView);
    }

    public  void Image1(View view)
    {


        Thread thread = new Thread(new Runnable() {

            @Override
            public void run() {
                try  {
                    Bitmap temp= getBitmapFromURL("https://picsum.photos/200/300");
                    mHandler.post(new Runnable() {
                        public void run() {
                            im.setImageBitmap(temp);
                        }
                    });

                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });

        thread.start();
    }
    public static Bitmap getBitmapFromURL(String src) {
        try {
            URL url = new URL(src);
            HttpsURLConnection connection = (HttpsURLConnection) url.openConnection();
            connection.setDoInput(true);
            connection.connect();
            InputStream input = connection.getInputStream();
            Bitmap myBitmap = BitmapFactory.decodeStream(input);
            return myBitmap;
        } catch (IOException e)
        {
            e.printStackTrace();
            return null;
        }
    }
}