package com.taufiqrahman.ratingreviews;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.util.Pair;

import com.taufiqrahman.reviewratings.BarLabels;
import com.taufiqrahman.reviewratings.RatingReviews;

import java.util.Random;

public class GradientActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gradient);


        RatingReviews ratingReviews = (RatingReviews) findViewById(R.id.rating_reviews);

        Pair colors[] = new Pair[]{
            new Pair<>(Color.parseColor("#0e9d58"), Color.parseColor("#1e88e5")),
            new Pair<>(Color.parseColor("#bfd047"), Color.parseColor("#5c6bc0")),
            new Pair<>(Color.parseColor("#ffc105"), Color.parseColor("#d81b60")),
            new Pair<>(Color.parseColor("#ef7e14"), Color.parseColor("#8bc34a")),
            new Pair<>(Color.parseColor("#d36259"), Color.parseColor("#ea80fc"))
        };

        int minValue = 30;

        int raters[] = new int[]{
                minValue + new Random().nextInt(100 - minValue + 1),
                minValue + new Random().nextInt(100 - minValue + 1),
                minValue + new Random().nextInt(100 - minValue + 1),
                minValue + new Random().nextInt(100 - minValue + 1),
                minValue + new Random().nextInt(100 - minValue + 1)
        };

        ratingReviews.createRatingBars(100, BarLabels.STYPE1, colors, raters);
    }
}
