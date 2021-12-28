package com.iwdael.carouselbanner.example;

import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.iwdael.carouselbanner.interfaces.CarouselImageFactory;

public class ImageFactory implements CarouselImageFactory {
    @Override
    public void onLoadFactory(String url, ImageView view) {
        Glide.with(view).load(url).into(view);
    }
}
