package com.blackchopper.carouselbanner.base;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;

import com.blackchopper.carouselbanner.interfaces.CarouselImageFactory;
import com.blackchopper.carouselbanner.interfaces.OnCarouselBannerListener;

/**
 * author  : Black Chopper
 * e-mail  : 4884280@qq.com
 * github  : http://github.com/BlackChopper
 * project : CarouselBanner
 */

public class BaseViewHolder extends RecyclerView.ViewHolder {
    protected ImageView imageView;

    public BaseViewHolder(View itemView) {
        super(itemView);
    }

    public void bindData(final String url, final int position, CarouselImageFactory factory, final OnCarouselBannerListener onClickListener) {
        factory.onLoadFactory(url, imageView);
        if (onClickListener!=null){
            imageView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    onClickListener.onItemClick(position,url);
                }
            });
        }
    }

}