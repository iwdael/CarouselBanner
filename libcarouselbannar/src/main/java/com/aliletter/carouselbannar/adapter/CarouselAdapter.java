package com.aliletter.carouselbannar.adapter;

import android.view.ViewGroup;
import android.widget.ImageView;

import com.aliletter.carouselbannar.base.BaseBannerAdapter;
import com.aliletter.carouselbannar.interfaces.CarouselImageFactory;
import com.aliletter.carouselbannar.interfaces.OnCarouselBannarListener;
import com.aliletter.carouselbannar.viewholder.CarouselViewHolder;

import java.util.List;

/**
 * Author：alilettter
 * Github: http://github.com/aliletter
 * Email: 4884280@qq.com
 */
public class CarouselAdapter extends BaseBannerAdapter<CarouselViewHolder> {

    public CarouselAdapter(List<String> urlList, CarouselImageFactory factory, OnCarouselBannarListener onBannerItemClickListener) {
        super(urlList, factory, onBannerItemClickListener);
    }

    @Override
    public CarouselViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new CarouselViewHolder(new ImageView(parent.getContext()));
    }
}
