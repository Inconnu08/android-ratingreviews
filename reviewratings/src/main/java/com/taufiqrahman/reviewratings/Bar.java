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

/**
 * Bar represent the single unit bar of the star rating system.
 */

public class Bar {
    private String starLabel;
    private int raters;
    private int color;
    private int startColor;
    private int endColor;

    public Bar() {
    }

    Bar(int raters, int color) {
        this.raters = raters;
        this.color = color;
    }

    Bar(int raters, int color, String starLabel) {
        this.raters = raters;
        this.color = color;
        this.starLabel = starLabel;
    }

    public int getRaters() {
        return raters;
    }

    public void setRaters(int raters) {
        this.raters = raters;
    }

    public int getColor() {
        return color;
    }

    public void setColor(int color) {
        this.color = color;
    }

    public String getStarLabel() {
        return starLabel;
    }

    public void setStarLabel(String starLabel) {
        this.starLabel = starLabel;
    }

    public int getEndColor() {
        return endColor;
    }

    public void setEndColor(int endColor) {
        this.endColor = endColor;
    }

    public boolean isGradientBar() {
        return endColor != 0;
    }

    public int getStartColor() {
        return startColor;
    }

    public void setStartColor(int startColor) {
        this.startColor = startColor;
    }
}
