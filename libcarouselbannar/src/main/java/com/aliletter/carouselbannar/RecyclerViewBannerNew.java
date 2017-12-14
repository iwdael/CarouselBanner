package com.aliletter.carouselbannar;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.AttributeSet;

import com.aliletter.carouselbannar.adapter.MzBannerAdapter;
import com.aliletter.carouselbannar.base.CarouselBannerBase;
import com.aliletter.carouselbannar.layoutmanager.BannerLayoutManager;

import java.util.List;

public class RecyclerViewBannerNew extends CarouselBannerBase<BannerLayoutManager, MzBannerAdapter> {


    public RecyclerViewBannerNew(Context context) {
        this(context, null);
    }

    public RecyclerViewBannerNew(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public RecyclerViewBannerNew(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onBannerScrolled(RecyclerView recyclerView, int dx, int dy) {

    }

    @Override
    protected void onBannerScrollStateChanged(RecyclerView recyclerView, int newState) {
        int first = mLayoutManager.getCurrentPosition();
        if (currentIndex != first) {
            currentIndex = first;
            refreshIndicator();
        }
    }

    @Override
    protected BannerLayoutManager getLayoutManager(Context context, int orientation) {
        return new BannerLayoutManager(orientation, dp2px(10));
    }

    @Override
    protected MzBannerAdapter getAdapter(Context context, List<String> list,OnBannerItemClickListener onBannerItemClickListener) {
        return new MzBannerAdapter(context, list,onBannerItemClickListener);
    }


}