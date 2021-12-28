package com.iwdael.carouselbanner.viewholder;

import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.recyclerview.widget.RecyclerView;

import com.iwdael.carouselbanner.base.BaseViewHolder;

/**
 * author  : Iwdael
 * e-mail  : iwdael@outlook.com
 * github  : http://github.com/iwdael
 * project : CarouselBanner
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
