package com.taufiqrahman.reviewratings.utils;

import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;

/**
 * Created by Chan Myae Aung on 2/23/19.
 */
public class ViewUtils {

  /**
   * @param bgColor Background color of bar
   * @param radius Corner Radius of bar
   * @return Rounded Corner Drawable
   */
  public static Drawable getRoundedBarDrawable(int bgColor, int radius) {
    GradientDrawable drawable = new GradientDrawable();
    drawable.setShape(GradientDrawable.RECTANGLE);
    drawable.setCornerRadii(new float[] {
        radius, radius, radius, radius, radius, radius, radius, radius
    });
    drawable.setColor(bgColor);
    return drawable;
  }
}
