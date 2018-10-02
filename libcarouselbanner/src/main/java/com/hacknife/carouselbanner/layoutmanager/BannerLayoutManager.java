package com.hacknife.carouselbanner.layoutmanager;

import android.content.Context;
import android.graphics.PointF;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.LinearSmoothScroller;
import android.support.v7.widget.RecyclerView;
import android.util.AttributeSet;
import android.util.DisplayMetrics;

/**
 * author  : Hacknife
 * e-mail  : 4884280@qq.com
 * github  : http://github.com/hacknife
 * project : CarouselBanner
 */

public class BannerLayoutManager extends LinearLayoutManager {

    private   float speedPerPixelMillisecond;

    public BannerLayoutManager(Context context) {
        super(context);
    }

    public BannerLayoutManager(Context context, int orientation, boolean reverseLayout) {
        super(context, orientation, reverseLayout);
    }
    public BannerLayoutManager(Context context, int orientation, boolean reverseLayout , float speedPerPixelMillisecond) {
        super(context, orientation, reverseLayout);
        this.speedPerPixelMillisecond=speedPerPixelMillisecond;
    }

    public BannerLayoutManager(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
    }

    @Override
    public void smoothScrollToPosition(RecyclerView recyclerView, RecyclerView.State state, int position) {
        CenterSmoothScroller centerSmoothScroller =
                new CenterSmoothScroller(recyclerView.getContext());
        centerSmoothScroller.setTargetPosition(position);
        startSmoothScroll(centerSmoothScroller);
    }


    private class CenterSmoothScroller extends LinearSmoothScroller {

        CenterSmoothScroller(Context context) {
            super(context);
        }

        @Nullable
        @Override
        public PointF computeScrollVectorForPosition(int targetPosition) {
            return BannerLayoutManager.this.computeScrollVectorForPosition(targetPosition);
        }

        @Override
        public int calculateDtToFit(int viewStart, int viewEnd, int boxStart, int boxEnd, int snapPreference) {
            return (boxStart + (boxEnd - boxStart) / 2) - (viewStart + (viewEnd - viewStart) / 2);
        }

        protected float calculateSpeedPerPixel(DisplayMetrics displayMetrics) {
            return speedPerPixelMillisecond;
        }

        @Override
        protected int getVerticalSnapPreference() {
            return SNAP_TO_START;
        }
    }
}
