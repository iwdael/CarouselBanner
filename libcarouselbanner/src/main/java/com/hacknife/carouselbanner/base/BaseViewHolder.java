package com.hacknife.carouselbanner.base;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;

import com.hacknife.carouselbanner.interfaces.CarouselImageFactory;
import com.hacknife.carouselbanner.interfaces.OnCarouselBannerListener;

/**
 * author  : Hacknife
 * e-mail  : 4884280@qq.com
 * github  : http://github.com/hacknife
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
