package com.aliletter.carouselbanner.adapter;

import android.view.ViewGroup;
import android.widget.ImageView;

import com.aliletter.carouselbanner.base.BaseBannerAdapter;
import com.aliletter.carouselbanner.interfaces.CarouselImageFactory;
import com.aliletter.carouselbanner.interfaces.OnCarouselBannerListener;
import com.aliletter.carouselbanner.viewholder.CarouselViewHolder;

import java.util.List;

/**
 * Author：alilettter
 * Github: http://github.com/aliletter
 * Email: 4884280@qq.com
 */
public class CarouselAdapter extends BaseBannerAdapter<CarouselViewHolder> {

    public CarouselAdapter(List<String> urlList, CarouselImageFactory factory, OnCarouselBannerListener onBannerItemClickListener) {
        super(urlList, factory, onBannerItemClickListener);
    }

    @Override
    public CarouselViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new CarouselViewHolder(new ImageView(parent.getContext()));
    }
}
