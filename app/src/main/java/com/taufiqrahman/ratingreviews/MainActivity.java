package com.taufiqrahman.ratingreviews;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;

import com.taufiqrahman.reviewratings.BarLabels;
import com.taufiqrahman.reviewratings.RatingReviews;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        RatingReviews ratingReviews = (RatingReviews) findViewById(R.id.rating_reviews);

        int colors[] = new int[]{
                Color.parseColor("#0e9d58"),
                Color.parseColor("#bfd047"),
                Color.parseColor("#ffc105"),
                Color.parseColor("#ef7e14"),
                Color.parseColor("#d36259")};

        int raters[] = new int[]{
                new Random().nextInt(100),
                new Random().nextInt(100),
                new Random().nextInt(100),
                new Random().nextInt(100),
                new Random().nextInt(100)
        };

        ratingReviews.createRatingBars(100, BarLabels.STYPE1, colors, raters);
    }

    public void callExample2Activity(View view) {
        Intent intent = new Intent(this, Example2Activity.class);
        startActivity(intent);
    }

    public void goToRoundBarSample(View view) {
        startActivity(new Intent(this, RoundBarSampleActivity.class));
    }

    public void goToGradientSample(View view) {
        startActivity(new Intent(this, GradientActivity.class));
    }

    public void goToRoundedGradientSample(View view) {
        startActivity(new Intent(this, RoundedGradientActivity.class));
    }
}
