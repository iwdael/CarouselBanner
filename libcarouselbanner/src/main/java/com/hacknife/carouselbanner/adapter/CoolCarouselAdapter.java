package com.hacknife.carouselbanner.adapter;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.hacknife.carouselbanner.R;
import com.hacknife.carouselbanner.base.BaseBannerAdapter;
import com.hacknife.carouselbanner.interfaces.CarouselImageFactory;
import com.hacknife.carouselbanner.interfaces.OnCarouselBannerListener;
import com.hacknife.carouselbanner.viewholder.CoolCarouselViewHolder;

import java.util.List;

/**
 * author  : Hacknife
 * e-mail  : 4884280@qq.com
 * github  : http://github.com/hacknife
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
