package com.taufiqrahman.ratingreviews;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.taufiqrahman.reviewratings.Bar;
import com.taufiqrahman.reviewratings.BarLabels;
import com.taufiqrahman.reviewratings.RatingReviews;

import java.util.Random;

public class Example2Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_example2);

        RatingReviews ratingReviews = (RatingReviews) findViewById(R.id.rating_reviews2);

        int raters[] = new int[]{
                new Random().nextInt(100),
                new Random().nextInt(100),
                new Random().nextInt(100),
                new Random().nextInt(100),
                new Random().nextInt(100)
        };

        int color = Color.parseColor("#333333");

        ratingReviews.createRatingBars(100, BarLabels.STYPE2, color, raters);

        ratingReviews.setOnBarClickListener(new RatingReviews.OnBarClickListener() {
            @Override
            public void onBarClick(Bar bar) {
                Toast.makeText(Example2Activity.this, bar.getStarLabel(), Toast.LENGTH_SHORT).show();
            }
        });
    }

    public void callExample3Activity(View view) {
        Intent intent = new Intent(this, Example2Activity.class);
        startActivity(intent);
    }
}
