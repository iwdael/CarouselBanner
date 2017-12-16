package com.aliletter.carouselbanner.adapter;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.aliletter.carouselbanner.R;
import com.aliletter.carouselbanner.base.BaseBannerAdapter;
import com.aliletter.carouselbanner.interfaces.CarouselImageFactory;
import com.aliletter.carouselbanner.interfaces.OnCarouselBannerListener;
import com.aliletter.carouselbanner.viewholder.CoolCarouselViewHolder;

import java.util.List;

/**
 * Author：alilettter
 * Github: http://github.com/aliletter
 * Email: 4884280@qq.com
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
