package com.taufiqrahman.ratingreviews;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.util.Pair;

import com.taufiqrahman.reviewratings.BarLabels;
import com.taufiqrahman.reviewratings.RatingReviews;

import java.util.Random;

public class RoundedGradientActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rounded_gradient);

        RatingReviews ratingReviews = (RatingReviews) findViewById(R.id.rating_reviews);

        Pair colors[] = new Pair[]{
                new Pair<>(Color.parseColor("#0c96c7"), Color.parseColor("#00fe77")),
                new Pair<>(Color.parseColor("#7b0ab4"), Color.parseColor("#ff069c")),
                new Pair<>(Color.parseColor("#fe6522"), Color.parseColor("#fdd116")),
                new Pair<>(Color.parseColor("#104bff"), Color.parseColor("#67cef6")),
                new Pair<>(Color.parseColor("#ff5d9b"), Color.parseColor("#ffaa69"))
        };

        int minValue = 30;

        int raters[] = new int[]{
                minValue + new Random().nextInt(100 - minValue + 1),
                minValue + new Random().nextInt(100 - minValue + 1),
                minValue + new Random().nextInt(100 - minValue + 1),
                minValue + new Random().nextInt(100 - minValue + 1),
                minValue + new Random().nextInt(100 - minValue + 1)
        };


        ratingReviews.createRatingBars(100, BarLabels.STYPE3, colors, raters);
    }
}
