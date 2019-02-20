<p align="center"><img width=12.5% src=""></p>

# RatingReviews
___

![](https://img.shields.io/badge/build-passing-brightgreen.svg) ![](https://img.shields.io/badge/API-16%2B-red.svg) ![](https://img.shields.io/badge/release-v0.3.2-blue.svg) ![](https://img.shields.io/github/tag/pandao/editor.md.svg) [![Apache license](http://img.shields.io/badge/license-Apache_2.0-red.svg)](http://opensource.org/licenses/apache)  ![Contributions welcome](https://img.shields.io/badge/contributions-welcomed-orange.svg)

RatingReviews (*Rating and Reviews*) is a widget or layout that adds Rating and Reviews bar to your app similar to the ones seen on Google playstore and Apple App store. It gives you a beautiful visual summary of the number of raters and ratings they gave on a specific item. And of course it is highly customizable to fit your app theme! ✨✂📐🛠 


### Screenshots

| [![VideoBlocks](https://d1ow200m9i3wyh.cloudfront.net/img/assets/videoblocks/images/logo.png)](http://videoblocks.com)  | [![AudioBlocks](https://dtyn3c8zjrx01.cloudfront.net/img/assets/audioblocks/images/logo.png)](http://audioblocks.com) | [![GraphicStock](http://www.graphicstock.com/images/logo.jpg)](http://graphicstock.com) |
[![AudioBlocks](https://dtyn3c8zjrx01.cloudfront.net/img/assets/audioblocks/images/logo.png)](http://audioblocks.com) |
|:---:|:---:|:---:|:---:|
| playstore (*style1*) | appstore (*style2*) | customized | customized |


You can also:
  - Take an existing style (*style1 and style2*) and customise it to get your desired style.


> The overriding design goal for Markdown's


### Installation

```
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
        bar:text_color="#808080"
        bar:text_size="10sp"
        bar:width="15dp" />
```

### Specification

Table below shows the parameters and attributes for furthur customization to suit your needs:

| Attribute | README | Description | Example |
| ------ | ------ | ------ | ------ |
| Dropbox | [plugins/dropbox/README.md][PlDb] |
| Github | [plugins/github/README.md][PlGh] |
| Google Drive | [plugins/googledrive/README.md][PlGd] |
| OneDrive | [plugins/onedrive/README.md][PlOd] |
| Medium | [plugins/medium/README.md][PlMe] |
| Google Analytics | [plugins/googleanalytics/README.md][PlGa] |


### Contribution

Want to contribute? Fantastic!

RatingReviews uses Gulp + Webpack for fast developing.
Make a change in your file and instantanously see your updates!

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


   [dill]: <https://github.com/joemccann/dillinger>
   [git-repo-url]: <https://github.com/joemccann/dillinger.git>
   [john gruber]: <http://daringfireball.net>
   [df1]: <http://daringfireball.net/projects/markdown/>
   [markdown-it]: <https://github.com/markdown-it/markdown-it>
   [Ace Editor]: <http://ace.ajax.org>
   [node.js]: <http://nodejs.org>
   [Twitter Bootstrap]: <http://twitter.github.com/bootstrap/>
   [jQuery]: <http://jquery.com>
   [@tjholowaychuk]: <http://twitter.com/tjholowaychuk>
   [express]: <http://expressjs.com>
   [AngularJS]: <http://angularjs.org>
   [Gulp]: <http://gulpjs.com>

   [PlDb]: <https://github.com/joemccann/dillinger/tree/master/plugins/dropbox/README.md>
   [PlGh]: <https://github.com/joemccann/dillinger/tree/master/plugins/github/README.md>
   [PlGd]: <https://github.com/joemccann/dillinger/tree/master/plugins/googledrive/README.md>
   [PlOd]: <https://github.com/joemccann/dillinger/tree/master/plugins/onedrive/README.md>
   [PlMe]: <https://github.com/joemccann/dillinger/tree/master/plugins/medium/README.md>
   [PlGa]: <https://github.com/RahulHP/dillinger/blob/master/plugins/googleanalytics/README.md>
