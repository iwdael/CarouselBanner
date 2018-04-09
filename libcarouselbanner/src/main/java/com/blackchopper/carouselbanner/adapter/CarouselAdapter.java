package com.blackchopper.carouselbanner.adapter;

import android.view.ViewGroup;
import android.widget.ImageView;

import com.blackchopper.carouselbanner.base.BaseBannerAdapter;
import com.blackchopper.carouselbanner.interfaces.CarouselImageFactory;
import com.blackchopper.carouselbanner.interfaces.OnCarouselBannerListener;
import com.blackchopper.carouselbanner.viewholder.CarouselViewHolder;

import java.util.List;

/**
 * author  : Black Chopper
 * e-mail  : 4884280@qq.com
 * github  : http://github.com/BlackChopper
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
