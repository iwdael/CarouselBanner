package com.aliletter.carouselbannar.base;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;

import com.aliletter.carouselbannar.interfaces.CarouselImageFactory;
import com.aliletter.carouselbannar.interfaces.OnCarouselBannarListener;

/**
 * Author：alilettter
 * Github: http://github.com/aliletter
 * Email: 4884280@qq.com
 * data: 2017/12/15
 */

public class BaseViewHolder extends RecyclerView.ViewHolder {
    protected ImageView imageView;

    public BaseViewHolder(View itemView) {
        super(itemView);
    }

    public void bindData(final String url, final int position, CarouselImageFactory factory, final OnCarouselBannarListener onClickListener) {
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
