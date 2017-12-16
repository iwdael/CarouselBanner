package com.aliletter.carouselbanner.viewholder;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.aliletter.carouselbanner.base.BaseViewHolder;

/**
 * Author：alilettter
 * Github: http://github.com/aliletter
 * Email: 4884280@qq.com
 * data: 2017/12/15
 */

public class CarouselViewHolder extends BaseViewHolder {

    public CarouselViewHolder(View itemView) {
        super(itemView);
        imageView = (ImageView) itemView;
        RecyclerView.LayoutParams params = new RecyclerView.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT);
        imageView.setLayoutParams(params);
        imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
    }
}
