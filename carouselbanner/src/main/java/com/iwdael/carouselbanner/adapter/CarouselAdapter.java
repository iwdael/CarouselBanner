package com.iwdael.carouselbanner.adapter;

import android.view.ViewGroup;
import android.widget.ImageView;

import com.iwdael.carouselbanner.base.BaseBannerAdapter;
import com.iwdael.carouselbanner.interfaces.OnCarouselItemClickListener;
import com.iwdael.carouselbanner.viewholder.CarouselViewHolder;

import java.util.List;

/**
 * author  : Iwdael
 * e-mail  : iwdael@outlook.com
 * github  : http://github.com/iwdael
 * project : CarouselBanner
 */
public class CarouselAdapter extends BaseBannerAdapter<CarouselViewHolder> {

    public CarouselAdapter(List<String> urlList, OnCarouselItemClickListener onBannerItemClickListener) {
        super(urlList, onBannerItemClickListener);
    }

    @Override
    public CarouselViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new CarouselViewHolder(new ImageView(parent.getContext()));
    }
}
