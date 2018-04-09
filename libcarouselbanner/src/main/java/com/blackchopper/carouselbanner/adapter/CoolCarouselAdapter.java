package com.blackchopper.carouselbanner.adapter;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.blackchopper.carouselbanner.R;
import com.blackchopper.carouselbanner.base.BaseBannerAdapter;
import com.blackchopper.carouselbanner.interfaces.CarouselImageFactory;
import com.blackchopper.carouselbanner.interfaces.OnCarouselBannerListener;
import com.blackchopper.carouselbanner.viewholder.CoolCarouselViewHolder;

import java.util.List;

/**
 * author  : Black Chopper
 * e-mail  : 4884280@qq.com
 * github  : http://github.com/BlackChopper
 * project : CarouselBanner
 */
public class CoolCarouselAdapter extends BaseBannerAdapter<CoolCarouselViewHolder> {

    public CoolCarouselAdapter(List<String> urlList, CarouselImageFactory factory, OnCarouselBannerListener onBannerItemClickListener) {
        super(urlList, factory, onBannerItemClickListener);
    }

    @Override
    public CoolCarouselViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new CoolCarouselViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.item_image, parent, false));
    }
}
