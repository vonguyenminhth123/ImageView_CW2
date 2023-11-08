package com.example.imageview;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {
    private int currentImage = 0;
    int[] images = {R.drawable.mark, R.drawable.renjun, R.drawable.jeno,
            R.drawable.haechan, R.drawable.jaemin, R.drawable.chenle, R.drawable.jisung};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ImageView image = (ImageView) findViewById(R.id.imageView);
        Button next = (Button) findViewById(R.id.buttonNext);
        Button back = (Button) findViewById(R.id.buttonBack);

        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                currentImage++;
                currentImage = currentImage % images.length;

                image.setImageResource(images[currentImage]);
            }
        });
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(currentImage > 0){
                    currentImage--;
                    currentImage = currentImage % images.length;
                } else {
                    currentImage = 6 - currentImage;
                    currentImage = currentImage % images.length;
                }

                image.setImageResource(images[currentImage]);
            }
        });
    }
}