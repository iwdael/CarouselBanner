package com.aliletter.carouselbannar;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.AttributeSet;
import com.aliletter.carouselbannar.adapter.CoolCarouselAdapter;
import com.aliletter.carouselbannar.base.CarouselBannerBase;
import com.aliletter.carouselbannar.interfaces.CarouselImageFactory;
import com.aliletter.carouselbannar.interfaces.OnCarouselBannarListener;
import com.aliletter.carouselbannar.layoutmanager.CoolBannerLayoutManager;
import java.util.List;

/**
 * Author：alilettter
 * Github: http://github.com/aliletter
 * Email: 4884280@qq.com
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
    protected CoolCarouselAdapter getAdapter(List<String> list, CarouselImageFactory factory, OnCarouselBannarListener onBannerItemClickListener) {
        return new CoolCarouselAdapter(list, factory, onBannerItemClickListener);
    }


}