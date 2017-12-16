package com.aliletter.carouselbanner.base;

import android.support.v7.widget.RecyclerView;

import com.aliletter.carouselbanner.interfaces.CarouselImageFactory;
import com.aliletter.carouselbanner.interfaces.OnCarouselBannerListener;

import java.util.List;
/**
 * Author：alilettter
 * Github: http://github.com/aliletter
 * Email: 4884280@qq.com
 */
public abstract class BaseBannerAdapter<VH extends BaseViewHolder> extends RecyclerView.Adapter<VH> {
    protected List<String> urlList;
    protected OnCarouselBannerListener onClickListener;
    protected CarouselImageFactory factory;

    public BaseBannerAdapter(List<String> urlList, CarouselImageFactory factory, OnCarouselBannerListener onBannerItemClickListener) {
        this.urlList = urlList;
        this.onClickListener = onBannerItemClickListener;
        this.factory = factory;
    }

    @Override
    public void onBindViewHolder(VH holder, int position) {
        holder.bindData(urlList.get(position % urlList.size()),  position % urlList.size(), factory, onClickListener);
    }

    @Override
    public int getItemCount() {
        return urlList.size() < 2 ? 1 : Integer.MAX_VALUE;
    }

}
