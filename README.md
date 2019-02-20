<p align="center"><img width=12.5% src=""></p>

# RatingReviews
___

![](https://img.shields.io/badge/build-passing-brightgreen.svg) ![](https://img.shields.io/badge/API-16%2B-red.svg) ![](https://img.shields.io/badge/release-v1.0.0-blue.svg) ![](https://img.shields.io/badge/tag-v1.0.0-blue.svg) ![](http://img.shields.io/badge/license-Apache_2.0-red.svg) ![](https://img.shields.io/badge/contributions-welcomed-orange.svg)

RatingReviews (*Rating and Reviews*) is a widget or layout that adds Rating and Reviews bar to your app similar to the ones seen on Google playstore and Apple App store. It gives you a beautiful visual summary of the number of raters and ratings they gave on a specific item. And of course it is highly customizable to fit your app theme! ✨✂📐🛠 


### Screenshots

| [![](https://github.com/Inconnu08/android-ratingreviews/blob/master/screenshots/0.png)](https://github.com/Inconnu08/android-ratingreviews/blob/master/screenshots/0.png)  | [![](https://github.com/Inconnu08/android-ratingreviews/blob/master/screenshots/1.png)](https://github.com/Inconnu08/android-ratingreviews/blob/master/screenshots/1.png) | [![](https://github.com/Inconnu08/android-ratingreviews/blob/master/screenshots/2.png)](https://github.com/Inconnu08/android-ratingreviews/blob/master/screenshots/2.png) |
[![](https://github.com/Inconnu08/android-ratingreviews/blob/master/screenshots/3.png)](https://github.com/Inconnu08/android-ratingreviews/blob/master/screenshots/3.png) |
|:---:|:---:|:---:|:---:|
| playstore (*style1*) | appstore (*style2*) | customized (*style2*) | customized (*style2*) |


You can also:
  - Take an existing style (*style1 and style2*) and customise it to get your desired style.




### Installation
In your root build.gradle at the end of repositories:
```
	allprojects {
		repositories {
			...
			maven { url 'https://jitpack.io' }
		}
	}
```
In your app build.gradle:
```
implementation 'com.github.Inconnu08:android-ratingreviews:1.0.0'
```

### Usage

Using RatingReviews is very simple and straight forward. Here is an example:
>java

```
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
```
>xml

```
    <com.taufiqrahman.reviewratings.RatingReviews
        xmlns:bar="http://schemas.android.com/apk/res-auto"
        android:id="@+id/rating_reviews"
        android:layout_width="0dp"
        android:layout_height="wrap_content"
        android:layout_marginStart="42dp"
        android:layout_marginTop="8dp"
        android:layout_marginBottom="8dp"
        app:layout_constraintBottom_toBottomOf="parent"
        app:layout_constraintEnd_toEndOf="parent"
        app:layout_constraintStart_toEndOf="@+id/textView"
        app:layout_constraintTop_toTopOf="parent"
        app:layout_constraintVertical_bias="0.499"
        bar:animation="true"
        bar:max_value="100"
        bar:show_label="true"
        bar:spaces="0dp"
        bar:text_color="#333333"
        bar:text_size="10sp"
        bar:width="15dp" />
```

### Specification

Table below shows the parameters and attributes for furthur customization to suit your needs:

| Attribute | Description | Options (examples) |
| ------ | ------ | ------ |
| animation | of the bars from left to right  | true, false |
| show_label | of the bars for example: 1, 2, 3, 4, 5  | STYPE1,  STYPE2, STYPE3, STYPE4|
| max_value | max value for the ratings  | 100 etc |
| text_color | color of the texts for example the labels  | color int |
| text_size | text size of labels  | 10sp, 12sp etc |
| width | bar width  | 8dp, 15dp etc |
| spaces | space between bars  | 1sp, 2dp etc |


### Contribution

Want to contribute? Fantastic!

If you want to contribute to the project and make it better whether it's a bug fix, feature, improvement, suggestion, documentation or any sort of help, your help is very welcomed!

### Todos

 - Rounded bars
 - Optimization

### Motivation

There was no visual 5 star rating system right off the bat when I needed for a project.
Special thanks to the chart libraries where I took inspiration from.

### License
```
   Copyright (C) 2019 Taufiq Rahman
   Copyright (C) 2018 Android Open Source Project

   Licensed under the Apache License, Version 2.0 (the "License");
   you may not use this file except in compliance with the License.
   You may obtain a copy of the License at

       http://www.apache.org/licenses/LICENSE-2.0

   Unless required by applicable law or agreed to in writing, software
   distributed under the License is distributed on an "AS IS" BASIS,
   WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
   See the License for the specific language governing permissions and
   limitations under the License.
```


<div align="center">
  <sub>Built with ❤︎ by
  <a href="https://twitter.com/taufiqr45780657">Taufiq Rahman</a> and
  <a href="/contributors">
    contributors
  </a>
</div>

[//]: # (These are reference links used in the body of this note and get stripped out when the markdown processor does its job. There is no need to format nicely because it shouldn't be seen. Thanks SO - http://stackoverflow.com/questions/4823468/store-comments-in-markdown-syntax)

