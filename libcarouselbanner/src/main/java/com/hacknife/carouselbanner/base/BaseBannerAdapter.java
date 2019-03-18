package com.hacknife.carouselbanner.base;

import android.support.v7.widget.RecyclerView;

import com.hacknife.carouselbanner.interfaces.CarouselImageFactory;
import com.hacknife.carouselbanner.interfaces.OnCarouselItemClickListener;

import java.util.List;
/**
 * author  : Hacknife
 * e-mail  : 4884280@qq.com
 * github  : http://github.com/hacknife
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
