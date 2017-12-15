package com.aliletter.carouselbannar.adapter;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.aliletter.carouselbannar.R;
import com.aliletter.carouselbannar.base.BaseBannerAdapter;
import com.aliletter.carouselbannar.interfaces.CarouselImageFactory;
import com.aliletter.carouselbannar.interfaces.OnCarouselBannarListener;
import com.aliletter.carouselbannar.viewholder.CoolCarouselViewHolder;

import java.util.List;

/**
 * Author：alilettter
 * Github: http://github.com/aliletter
 * Email: 4884280@qq.com
 */
public class CoolCarouselAdapter extends BaseBannerAdapter<CoolCarouselViewHolder> {

    public CoolCarouselAdapter(List<String> urlList, CarouselImageFactory factory, OnCarouselBannarListener onBannerItemClickListener) {
        super(urlList, factory, onBannerItemClickListener);
    }

    @Override
    public CoolCarouselViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new CoolCarouselViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.item_image, parent, false));
    }
}
