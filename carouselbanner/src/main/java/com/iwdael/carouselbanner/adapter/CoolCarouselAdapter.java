package com.iwdael.carouselbanner.adapter;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.iwdael.carouselbanner.R;
import com.iwdael.carouselbanner.base.BaseBannerAdapter;
import com.iwdael.carouselbanner.interfaces.OnCarouselItemClickListener;
import com.iwdael.carouselbanner.viewholder.CoolCarouselViewHolder;

import java.util.List;

/**
 * author  : Iwdael
 * e-mail  : iwdael@outlook.com
 * github  : http://github.com/iwdael
 * project : CarouselBanner
 */
public class CoolCarouselAdapter extends BaseBannerAdapter<CoolCarouselViewHolder> {

    public CoolCarouselAdapter(List<String> urlList, OnCarouselItemClickListener onBannerItemClickListener) {
        super(urlList, onBannerItemClickListener);
    }

    @Override
    public CoolCarouselViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new CoolCarouselViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.item_image, parent, false));
    }
}
