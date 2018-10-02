package com.hacknife.carouselbanner;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.AttributeSet;
import com.hacknife.carouselbanner.adapter.CoolCarouselAdapter;
import com.hacknife.carouselbanner.base.CarouselBannerBase;
import com.hacknife.carouselbanner.interfaces.CarouselImageFactory;
import com.hacknife.carouselbanner.interfaces.OnCarouselBannerListener;
import com.hacknife.carouselbanner.layoutmanager.CoolBannerLayoutManager;

import java.util.List;

/**
 * author  : Hacknife
 * e-mail  : 4884280@qq.com
 * github  : http://github.com/hacknife
 * project : CarouselBanner
 */
public class CoolCarouselBanner extends CarouselBannerBase<CoolBannerLayoutManager, CoolCarouselAdapter> {


    public CoolCarouselBanner(Context context) {
        this(context, null);
    }

    public CoolCarouselBanner(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public CoolCarouselBanner(Context context, AttributeSet attrs, int defStyleAttr) {
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
    protected CoolBannerLayoutManager getLayoutManager(Context context, int orientation) {
        return new CoolBannerLayoutManager(orientation, dp2px(10),speedPerPixelMillisecond);
    }

    @Override
    protected CoolCarouselAdapter getAdapter(List<String> list, CarouselImageFactory factory, OnCarouselBannerListener onBannerItemClickListener) {
        return new CoolCarouselAdapter(list, factory, onBannerItemClickListener);
    }


}