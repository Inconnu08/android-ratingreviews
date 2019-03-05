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

import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.util.DisplayMetrics;
import android.util.Pair;


class Utils {
    static int DEFAULT_BAR_COLOR = Color.parseColor("#333333");
    static int DEFAULT_BAR_TEXT_COLOR = Color.parseColor("#333333");
    static int DEFAULT_BAR_SPACE = 5;

    /**
     * convertDpToPixel converts device specific density independent pixels to pixels.
     *
     * @param dp      A value in dp unit.
     * @param context Context to get resources and device specific display metrics.
     * @return A float value that represents px.
     */
    static float convertDpToPixel(float dp, Context context) {
        return dp * ((float) context.getResources().getDisplayMetrics().densityDpi / DisplayMetrics.DENSITY_DEFAULT);
    }

    /**
     * convertPixelsToDp converts device specific pixels to density independent pixels.
     *
     * @param px      A value in px (pixels) unit.
     * @param context Context to get resources and device specific display metrics
     * @return A float value that represents dp equivalent to px value
     */
    static float convertPixelsToDp(float px, Context context) {
        return px / ((float) context.getResources().getDisplayMetrics().densityDpi / DisplayMetrics.DENSITY_DEFAULT);
    }

    /**
     * @param bgColor Background color of bar.
     * @param radius  Corner Radius of bar.
     * @return Rounded Corner Drawable.
     */
    static Drawable getRoundedBarDrawable(int bgColor, int radius) {
        GradientDrawable drawable = new GradientDrawable();
        drawable.setShape(GradientDrawable.RECTANGLE);
        drawable.setCornerRadii(new float[]{
                radius, radius, radius, radius, radius, radius, radius, radius
        });
        drawable.setColor(bgColor);
        return drawable;
    }


    /**
     * @param startColor The start color for the Background gradient.
     * @param endColor The end color for the Background gradient.
     * @param radius  Corner Radius of bar.
     * @return Rounded Corner Drawable.
     */
    static GradientDrawable getRoundedBarGradientDrawable(int startColor, int endColor, int radius) {

        GradientDrawable gradientDrawable = new GradientDrawable(
                GradientDrawable.Orientation.LEFT_RIGHT,
                new int[] {startColor, endColor});
        gradientDrawable.setShape(GradientDrawable.RECTANGLE);
        gradientDrawable.setCornerRadii(new float[]{
                radius, radius, radius, radius, radius, radius, radius, radius
        });
        return gradientDrawable;
    }
}
