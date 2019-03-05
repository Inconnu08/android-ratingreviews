/*
  Copyright 2018 The Android Open Source Project

  Licensed under the Apache License, Version 2.0 (the "License");
  you may not use this file except in compliance with the License.
  You may obtain a copy of the License at

       http://www.apache.org/licenses/LICENSE-2.0

  Unless required by applicable law or agreed to in writing, software
  distributed under the License is distributed on an "AS IS" BASIS,
  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
  See the License for the specific language governing permissions and
  limitations under the License.

  Created by Taufiq Rahman on 07/02/19.
 */

package com.taufiqrahman.reviewratings;

import android.animation.LayoutTransition;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.GradientDrawable;
import android.os.Build;
import android.util.AttributeSet;
import android.util.Pair;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import static com.taufiqrahman.reviewratings.Utils.getRoundedBarDrawable;
import static com.taufiqrahman.reviewratings.Utils.getRoundedBarGradientDrawable;

public class RatingReviews extends FrameLayout {
    private Context mCtx;

    private int mBarSpaces;
    private int mBarTextColor;
    private int mBarDimension;
    private int mBarTextSize;
    private int mBarColor;
    private int mBarMaxValue;
    private int mStyle;
    private int mNumOfBars;
    private boolean isRoundCorner;

    private boolean isBarAdded = false;
    private boolean isShowLabel = true;
    private boolean isShowRaters = true;
    private boolean isShowAnimation = true;

    private LinearLayout mLinearParentLayout;

    private OnBarClickListener onBarClickListener;

    private List<Bar> mBars = new ArrayList<>();

    /**
     * constructor
     */
    public RatingReviews(Context mCtx) {
        super(mCtx);
        initLayout();
    }

    /**
     * constructor
     */
    public RatingReviews(Context mCtx, AttributeSet attrs) {
        super(mCtx, attrs);
        this.mCtx = mCtx;

        TypedArray a = mCtx.obtainStyledAttributes(attrs, R.styleable.RatingReviews, 0, 0);

        mStyle = a.getInt(R.styleable.RatingReviews_style, 1);
        mBarDimension = a.getDimensionPixelSize(R.styleable.RatingReviews_width,
                (int) Utils.convertDpToPixel(20, mCtx));
        mBarColor = a.getColor(R.styleable.RatingReviews_color, Utils.DEFAULT_BAR_COLOR);
        mBarTextSize = (int) Utils.convertPixelsToDp(
                a.getDimensionPixelSize(R.styleable.RatingReviews_text_size,
                        (int) Utils.convertDpToPixel(15, mCtx)), mCtx);
        mBarTextColor = a.getColor(R.styleable.RatingReviews_text_color, Utils.DEFAULT_BAR_TEXT_COLOR);
        mBarMaxValue = a.getInt(R.styleable.RatingReviews_max_value, 0);
        mBarSpaces = a.getDimensionPixelSize(R.styleable.RatingReviews_spaces,
                (int) Utils.convertDpToPixel(Utils.DEFAULT_BAR_SPACE, mCtx));
        isRoundCorner = a.getBoolean(R.styleable.RatingReviews_rounded, false);

        isShowLabel = a.getBoolean(R.styleable.RatingReviews_show_label, true);
        isShowRaters = a.getBoolean(R.styleable.RatingReviews_show_raters, true);
        isShowAnimation = a.getBoolean(R.styleable.RatingReviews_animation, true);

        this.mNumOfBars = 5;

        a.recycle();
        initLayout();
    }

    /**
     * initLayout creates the base linear layout for the rating mBars.
     */
    private void initLayout() {
        mLinearParentLayout = new LinearLayout(mCtx);
        mLinearParentLayout.setOrientation(LinearLayout.VERTICAL);
        mLinearParentLayout.setLayoutParams(
                new LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT));
        mLinearParentLayout.setGravity(Gravity.START); // Gravity.LEFT | Gravity.START
        if (isShowAnimation) {
            mLinearParentLayout.setLayoutTransition(new LayoutTransition());
        }
        this.addView(mLinearParentLayout);
    }

    /**
     * @param mBarMaxValue sets the max value for the Bar and should ONLY be called initially as it
     *                     also clears all the mBars and data.
     */
    public void setMaxBarValue(int mBarMaxValue) {
        this.mBarMaxValue = mBarMaxValue + 20; // 20+ scales much nicer but maybe should change soon.
        clearAll();
    }

    /**
     * createRatingBars creates the ratingreviews with values given by user.
     *
     * @param maxBarValue max value for the Bars.
     * @param labels      format and styling of the label texts.
     * @param colorsArr   expects an array of the color-int (parseColor).
     * @param raters      expects an array of the raters for each stars given.
     */
    public void createRatingBars(int maxBarValue, String labels[], int colorsArr[], int raters[]) {

        setMaxBarValue(maxBarValue);

        for (int i = 0; i < mNumOfBars; i++) {
            Bar bar = new Bar();
            bar.setRaters(raters[i]);
            bar.setColor(colorsArr[i]);
            bar.setStarLabel(labels[i]);
            addBar(bar);
        }
    }

    /**
     * createRatingBars creates the ratingreviews with values given by user.
     *
     * @param maxBarValue max value for the Bars.
     * @param labels      format and styling of the label texts.
     * @param colors      expects an array of Pairs composed of the start and end color for the gradient.
     * @param raters      expects an array of the raters for each stars given.
     */
    public void createRatingBars(int maxBarValue, String labels[], Pair colors[], int raters[]) {

        setMaxBarValue(maxBarValue);

        for (int i = 0; i < mNumOfBars; i++) {
            Bar bar = new Bar();
            bar.setRaters(raters[i]);
            bar.setStartColor((int) colors[i].first);
            bar.setEndColor((int) colors[i].second);
            bar.setStarLabel(labels[i]);
            addBar(bar);
        }
    }


    /**
     * createRatingBars creates the ratingreviews with values given by user.
     *
     * @param maxBarValue max value for the Bars.
     * @param labels      format and styling of the label texts.
     * @param color       expects a color-int (parseColor) that is applied to every rating bar.
     * @param raters      expects an array of the raters for each stars given.
     */
    public void createRatingBars(int maxBarValue, String labels[], int color, int raters[]) {

        setMaxBarValue(maxBarValue);

        for (int i = 0; i < mNumOfBars; i++) {
            Bar bar = new Bar();
            bar.setRaters(raters[i]);
            bar.setColor(color);
            bar.setStarLabel(labels[i]);
            addBar(bar);
        }
    }

    /**
     * createBar inflates the given bar to the bar layout specified and calls draw() to render it.
     *
     * @param dimension of the bar.
     * @param bar       object itself.
     */
    private void createBar(int dimension, final Bar bar) {
        if (dimension == 0 || mBarMaxValue == 0) {
            return;
        }

        int styleLayout;

        switch (mStyle) {
            case 1:
                styleLayout = R.layout.bar;
                break;
            case 2:
                styleLayout = R.layout.bar_two;
                break;
            default:
                styleLayout = R.layout.bar;
                break;
        }

        View view = LayoutInflater.from(mCtx).inflate(styleLayout, mLinearParentLayout, false);
        draw(dimension, null, bar, view);
    }

    /**
     * draw renders the bar with all the parameters specified.
     *
     * @param dimension  of bar.
     * @param initialBar initial bar.
     * @param bar        itself.
     * @param view       view.
     */
    private void draw(int dimension, Bar initialBar, final Bar bar, final View view) {
        final int bgColor = bar.getColor() != 0 ? bar.getColor() : mBarColor;

        view.post(new Runnable() {
            @Override
            public void run() {
                int radius = view.getHeight() / 2; //getting height inside post method to ensure view has drawn

                if (bar.isGradientBar()) {
                    if (bar.getStartColor() == 0 || bar.getEndColor() == 0) {
                        throw new RuntimeException("Gradient colors were not provided.");
                    }
                    if (isRoundCorner) {
                        view.findViewById(R.id.linear_bar).setBackground(getRoundedBarGradientDrawable(bar.getStartColor(), bar.getEndColor(), radius));
                    } else {
                        GradientDrawable gradientDrawable = new GradientDrawable(
                                GradientDrawable.Orientation.LEFT_RIGHT,
                                new int[]{bar.getStartColor(), bar.getEndColor()}
                        );
                        view.findViewById(R.id.linear_bar).setBackground(gradientDrawable);
                    }
                } else {
                    if (isRoundCorner) {
                        view.findViewById(R.id.linear_bar).setBackground(getRoundedBarDrawable(bgColor, radius));
                    } else {
                        view.findViewById(R.id.linear_bar).setBackgroundColor(bgColor);
                    }
                }
            }
        });


        int dimensionBar = dimension * bar.getRaters() / mBarMaxValue;

        MarginLayoutParams layoutParamsBar = (MarginLayoutParams) view.getLayoutParams();

        if (isShowLabel) {
            TextView textView = view.findViewById(R.id.text_view_bar_label);

            if (bar.getStarLabel() != null) {
                textView.setText(String.format(Locale.getDefault(), "%s", bar.getStarLabel()));
            }

            textView.setTextSize(mBarTextSize);
            textView.setTextColor(mBarTextColor);
        } else {
            view.findViewById(R.id.text_view_bar_label).setVisibility(GONE);
        }

        if (isShowRaters) {
            TextView raters = view.findViewById(R.id.text_view_raters);

            if (bar.getStarLabel() != null) {
                raters.setText(String.format(Locale.getDefault(), "%s", bar.getRaters()));
            }
        }

        final LinearLayout linearLayoutBar = view.findViewById(R.id.linear_bar);
        ValueAnimator anim = ValueAnimator.ofInt(
                initialBar == null ? 0 : dimension * initialBar.getRaters() / mBarMaxValue, dimensionBar);

        anim.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                ViewGroup.LayoutParams layoutParams = linearLayoutBar.getLayoutParams();
                layoutParams.width = (Integer) valueAnimator.getAnimatedValue();
                linearLayoutBar.setLayoutParams(layoutParams);
            }
        });

        if (isShowAnimation) {
            anim.setDuration(500);
        } else {
            anim.setDuration(0);
        }
        anim.start();

        view.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                if (onBarClickListener != null) {
                    onBarClickListener.onBarClick(bar);
                }
            }
        });

        view.setTag(bar);

        view.getLayoutParams().height = mBarDimension;

        if (initialBar == null) {
            if (isBarAdded) {
                layoutParamsBar.topMargin = mBarSpaces;
            }
            mLinearParentLayout.addView(view);
        }

        isBarAdded = true;
    }

    /**
     * getDimension gets dimension of the view.
     *
     * @param view     for which dimension is wanted.
     * @param listener callback listener.
     */
    @SuppressWarnings("deprecation")
    private void getDimension(final View view,
                              final DimensionReceivedCallback listener) {
        view.getViewTreeObserver()
                .addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() {
                    @Override
                    public void onGlobalLayout() {
                        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN) {
                            view.getViewTreeObserver().removeOnGlobalLayoutListener(this);
                        } else {
                            view.getViewTreeObserver().removeGlobalOnLayoutListener(this);
                        }
                        listener.onDimensionReceived(view.getWidth());
                    }
                });
    }

    /**
     * @param onBarClickListener listener for bar.
     */
    public void setOnBarClickListener(OnBarClickListener onBarClickListener) {
        this.onBarClickListener = onBarClickListener;
    }

    /**
     * @param bar single rating bar that needs to be added to the layout.
     */
    public void addBar(final Bar bar) {
        addBar(mBars.size(), bar);
    }

    /**
     * addBar adds the given bar to mBars list, gets parent dimension and calls createBar.
     *
     * @param position for the bar.
     * @param bar      object.
     */
    public void addBar(final int position, final Bar bar) {
        if (position > mNumOfBars) {
            return;
        }

        mBars.add(bar);

        if (bar != null) {
            if (mLinearParentLayout.getHeight() == 0) {
                getDimension(mLinearParentLayout, new DimensionReceivedCallback() {
                    @Override
                    public void onDimensionReceived(int dimension) {
                        createBar(dimension, bar);
                    }
                });
            } else {
                createBar(mLinearParentLayout.getWidth(), bar);
            }
        }
    }

    /**
     * clearAll clears all the bars and everything from the linear base layout.
     */
    public void clearAll() {
        mBars.clear();
        mLinearParentLayout.removeAllViews();
    }

    private interface DimensionReceivedCallback {
        void onDimensionReceived(int dimension);
    }

    public interface OnBarClickListener {
        void onBarClick(Bar bar);
    }
}
