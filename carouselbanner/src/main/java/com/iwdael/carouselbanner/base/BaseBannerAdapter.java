package com.iwdael.carouselbanner.base;


import androidx.recyclerview.widget.RecyclerView;

import com.iwdael.carouselbanner.interfaces.OnCarouselItemClickListener;

import java.util.List;

/**
 * author  : Iwdael
 * e-mail  : iwdael@outlook.com
 * github  : http://github.com/iwdael
 * project : CarouselBanner
 */
public abstract class BaseBannerAdapter<VH extends BaseViewHolder> extends RecyclerView.Adapter<VH> {
    protected List<String> urlList;
    protected OnCarouselItemClickListener onClickListener;

    public BaseBannerAdapter(List<String> urlList,  OnCarouselItemClickListener onBannerItemClickListener) {
        this.urlList = urlList;
        this.onClickListener = onBannerItemClickListener;
     }

    @Override
    public void onBindViewHolder(VH holder, int position) {
        holder.bindData(urlList.get(position % urlList.size()),  position % urlList.size(),   onClickListener);
    }

    @Override
    public int getItemCount() {
        return urlList.size() < 2 ? 1 : Integer.MAX_VALUE;
    }

}
