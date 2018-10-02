package com.hacknife.carouselbanner.adapter;

import android.view.ViewGroup;
import android.widget.ImageView;

import com.hacknife.carouselbanner.base.BaseBannerAdapter;
import com.hacknife.carouselbanner.interfaces.CarouselImageFactory;
import com.hacknife.carouselbanner.interfaces.OnCarouselBannerListener;
import com.hacknife.carouselbanner.viewholder.CarouselViewHolder;

import java.util.List;

/**
 * author  : Hacknife
 * e-mail  : 4884280@qq.com
 * github  : http://github.com/hacknife
 * project : CarouselBanner
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
