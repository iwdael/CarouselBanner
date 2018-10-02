package com.hacknife.carouselbanner.base;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.LayerDrawable;
import android.os.Handler;
import android.os.Message;
import android.support.annotation.ColorRes;
import android.support.annotation.NonNull;
import android.support.v4.content.ContextCompat;
import android.support.v4.view.GravityCompat;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.PagerSnapHelper;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.Gravity;
import android.view.MotionEvent;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;

import com.hacknife.carouselbanner.R;
import com.hacknife.carouselbanner.interfaces.CarouselImageFactory;
import com.hacknife.carouselbanner.interfaces.OnCarouselBannerListener;

import java.util.ArrayList;
import java.util.List;

/**
 * author  : Hacknife
 * e-mail  : 4884280@qq.com
 * github  : http://github.com/hacknife
 * project : CarouselBanner
 */
public abstract class CarouselBannerBase<L extends RecyclerView.LayoutManager, A extends BaseBannerAdapter> extends FrameLayout {

    protected int autoPlayDuration;//刷新间隔时间

    protected boolean showIndicator;//是否显示指示器
    protected RecyclerView indicatorContainer;
    protected Drawable mSelectedDrawable;
    protected Drawable mUnselectedDrawable;
    protected IndicatorAdapter indicatorAdapter;
    protected float speedPerPixelMillisecond;
    protected int indicatorMargin;//指示器间距

    protected RecyclerView mRecyclerView;
    protected A adapter;
    protected L mLayoutManager;

    protected int WHAT_AUTO_PLAY = 1000;

    protected boolean hasInit;
    protected int bannerSize = 1;
    protected int currentIndex;
    protected boolean isPlaying;

    protected boolean isAutoPlaying;
    protected List<String> tempUrlList = new ArrayList<>();

    protected OnCarouselBannerListener onBannerItemClickListener;


    protected Handler mHandler = new Handler(new Handler.Callback() {
        @Override
        public boolean handleMessage(Message msg) {
            if (msg.what == WHAT_AUTO_PLAY) {
                mRecyclerView.smoothScrollToPosition(++currentIndex);
                refreshIndicator();
                mHandler.sendEmptyMessageDelayed(WHAT_AUTO_PLAY, autoPlayDuration);

            }
            return false;
        }
    });

    public CarouselBannerBase(Context context) {
        this(context, null);
    }

    public CarouselBannerBase(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public CarouselBannerBase(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initView(context, attrs);
    }

    protected void initView(Context context, AttributeSet attrs) {
        TypedArray a = context.obtainStyledAttributes(attrs, R.styleable.CarouselBannerBase);
        showIndicator = a.getBoolean(R.styleable.CarouselBannerBase_showIndicator, true);
        autoPlayDuration = a.getInt(R.styleable.CarouselBannerBase_interval, 4000);
        isAutoPlaying = a.getBoolean(R.styleable.CarouselBannerBase_autoPlaying, true);
        mSelectedDrawable = a.getDrawable(R.styleable.CarouselBannerBase_indicatorSelectedSrc);
        mUnselectedDrawable = a.getDrawable(R.styleable.CarouselBannerBase_indicatorUnselectedSrc);
        speedPerPixelMillisecond = a.getFloat(R.styleable.CarouselBannerBase_speedPerPixelMillisecond, 0.8f);
        if (mSelectedDrawable == null) {
            //绘制默认选中状态图形
            GradientDrawable selectedGradientDrawable = new GradientDrawable();
            selectedGradientDrawable.setShape(GradientDrawable.OVAL);
            selectedGradientDrawable.setColor(getColor(R.color.selectIndicationColor));
            selectedGradientDrawable.setSize(dp2px(5), dp2px(5));
            selectedGradientDrawable.setCornerRadius(dp2px(5) / 2);
            mSelectedDrawable = new LayerDrawable(new Drawable[]{selectedGradientDrawable});
        }
        if (mUnselectedDrawable == null) {
            //绘制默认未选中状态图形
            GradientDrawable unSelectedGradientDrawable = new GradientDrawable();
            unSelectedGradientDrawable.setShape(GradientDrawable.OVAL);
            unSelectedGradientDrawable.setColor(getColor(R.color.unSelectIndicationColor));
            unSelectedGradientDrawable.setSize(dp2px(5), dp2px(5));
            unSelectedGradientDrawable.setCornerRadius(dp2px(5) / 2);
            mUnselectedDrawable = new LayerDrawable(new Drawable[]{unSelectedGradientDrawable});
        }
        indicatorMargin = a.getDimensionPixelSize(R.styleable.CarouselBannerBase_indicatorSpace, dp2px(4));
        int marginLeft = a.getDimensionPixelSize(R.styleable.CarouselBannerBase_indicatorMarginLeft, dp2px(16));
        int marginRight = a.getDimensionPixelSize(R.styleable.CarouselBannerBase_indicatorMarginRight, dp2px(0));
        int marginBottom = a.getDimensionPixelSize(R.styleable.CarouselBannerBase_indicatorMarginBottom, dp2px(11));
        int g = a.getInt(R.styleable.CarouselBannerBase_indicatorGravity, 0);
        int gravity;
        if (g == 0) {
            gravity = GravityCompat.START;
        } else if (g == 2) {
            gravity = GravityCompat.END;
        } else {
            gravity = Gravity.CENTER;
        }
        int o = a.getInt(R.styleable.CarouselBannerBase_orientation, 0);
        int orientation = 0;
        if (o == 0) {
            orientation = LinearLayoutManager.HORIZONTAL;
        } else if (o == 1) {
            orientation = LinearLayoutManager.VERTICAL;
        }
        a.recycle();
        //recyclerView部分
        mRecyclerView = new RecyclerView(context);
        new PagerSnapHelper().attachToRecyclerView(mRecyclerView);
        mLayoutManager = getLayoutManager(context, orientation);
        mRecyclerView.setLayoutManager(mLayoutManager);
        mRecyclerView.addOnScrollListener(new RecyclerView.OnScrollListener() {

            @Override
            public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
                onBannerScrolled(recyclerView, dx, dy);
            }

            @Override
            public void onScrollStateChanged(RecyclerView recyclerView, int newState) {
                onBannerScrollStateChanged(recyclerView, newState);
            }
        });
        LayoutParams vpLayoutParams = new LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT,
                ViewGroup.LayoutParams.MATCH_PARENT);
        addView(mRecyclerView, vpLayoutParams);
        //指示器部分
        indicatorContainer = new RecyclerView(context);

        LinearLayoutManager indicatorLayoutManager = new LinearLayoutManager(context, orientation, false);
        indicatorContainer.setLayoutManager(indicatorLayoutManager);
        indicatorAdapter = new IndicatorAdapter();
        indicatorContainer.setAdapter(indicatorAdapter);
        LayoutParams params = new LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        params.gravity = Gravity.BOTTOM | gravity;
        params.setMargins(marginLeft, 0, marginRight, marginBottom);
        addView(indicatorContainer, params);
        if (!showIndicator) {
            indicatorContainer.setVisibility(GONE);
        }
    }

    protected abstract void onBannerScrolled(RecyclerView recyclerView, int dx, int dy);

    protected abstract void onBannerScrollStateChanged(RecyclerView recyclerView, int newState);

    protected abstract L getLayoutManager(Context context, int orientation);

    protected abstract A getAdapter(List<String> list, CarouselImageFactory factory, OnCarouselBannerListener onBannerItemClickListener);

    /**
 * author  : Hacknife
 * e-mail  : 4884280@qq.com
 * github  : http://github.com/hacknife
 * project : CarouselBanner
 */
    public void setIndicatorInterval(int millisecond) {
        this.autoPlayDuration = millisecond;
    }

    /**
 * author  : Hacknife
 * e-mail  : 4884280@qq.com
 * github  : http://github.com/hacknife
 * project : CarouselBanner
 */
    protected void setPlaying(boolean playing) {
        if (isAutoPlaying && hasInit) {
            if (!isPlaying && playing && adapter != null && adapter.getItemCount() > 2) {
                mHandler.sendEmptyMessageDelayed(WHAT_AUTO_PLAY, autoPlayDuration);
                isPlaying = true;
            } else if (isPlaying && !playing) {
                mHandler.removeMessages(WHAT_AUTO_PLAY);
                isPlaying = false;
            }
        }
    }

    /**
 * author  : Hacknife
 * e-mail  : 4884280@qq.com
 * github  : http://github.com/hacknife
 * project : CarouselBanner
 */
    public void setAutoPlaying(boolean isAutoPlaying) {
        this.isAutoPlaying = isAutoPlaying;
        setPlaying(this.isAutoPlaying);
    }

    public boolean isPlaying() {
        return isPlaying;
    }

    public void setShowIndicator(boolean showIndicator) {
        this.showIndicator = showIndicator;
        indicatorContainer.setVisibility(showIndicator ? VISIBLE : GONE);
    }

    public void setOnBannerItemClickListener(OnCarouselBannerListener onBannerItemClickListener) {
        this.onBannerItemClickListener = onBannerItemClickListener;
    }

    /**
 * author  : Hacknife
 * e-mail  : 4884280@qq.com
 * github  : http://github.com/hacknife
 * project : CarouselBanner
 */
    public void initBanner(@NonNull List<String> newList, CarouselImageFactory factory, OnCarouselBannerListener onBannerItemClickListener) {
        //解决recyclerView嵌套问题
        if (compareListDifferent(newList, tempUrlList)) {
            this.onBannerItemClickListener = (onBannerItemClickListener==null? this.onBannerItemClickListener:onBannerItemClickListener);
            hasInit = false;
            setVisibility(VISIBLE);
            setPlaying(false);
            adapter = getAdapter(newList, factory, this.onBannerItemClickListener);
            mRecyclerView.setAdapter(adapter);
            tempUrlList = newList;
            bannerSize = tempUrlList.size();
            if (bannerSize > 1) {
                indicatorContainer.setVisibility(VISIBLE);
                currentIndex = bannerSize * 10000;
                mRecyclerView.scrollToPosition(currentIndex);
                indicatorAdapter.notifyDataSetChanged();
                setPlaying(true);
            } else {
                indicatorContainer.setVisibility(GONE);
                currentIndex = 0;
            }
            hasInit = true;
        }
        if (!showIndicator) {
            indicatorContainer.setVisibility(GONE);
        }
    }

    /**
 * author  : Hacknife
 * e-mail  : 4884280@qq.com
 * github  : http://github.com/hacknife
 * project : CarouselBanner
 */
    public void initBanner(@NonNull List<String> newList, CarouselImageFactory factory) {
        initBanner(newList, factory, null);
    }

    @Override
    public boolean dispatchTouchEvent(MotionEvent ev) {
        switch (ev.getAction()) {
            case MotionEvent.ACTION_DOWN:
                setPlaying(false);
                break;
            case MotionEvent.ACTION_UP:
            case MotionEvent.ACTION_CANCEL:
                setPlaying(true);
                break;
        }
        //解决recyclerView嵌套问题
        try {
            return super.dispatchTouchEvent(ev);
        } catch (IllegalArgumentException ex) {
            ex.printStackTrace();
        }
        return false;
    }

    //解决recyclerView嵌套问题
    @Override
    public boolean onTouchEvent(MotionEvent ev) {
        try {
            return super.onTouchEvent(ev);
        } catch (IllegalArgumentException ex) {
            ex.printStackTrace();
        }
        return false;
    }

    //解决recyclerView嵌套问题
    @Override
    public boolean onInterceptTouchEvent(MotionEvent ev) {
        try {
            return super.onInterceptTouchEvent(ev);
        } catch (IllegalArgumentException ex) {
            ex.printStackTrace();
        }
        return false;
    }

    @Override
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        setPlaying(true);
    }

    @Override
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        setPlaying(false);
    }

    @Override
    protected void onWindowVisibilityChanged(int visibility) {
        super.onWindowVisibilityChanged(visibility);
        if (visibility == VISIBLE) {
            setPlaying(true);
        } else {
            setPlaying(false);
        }
    }

    /**
 * author  : Hacknife
 * e-mail  : 4884280@qq.com
 * github  : http://github.com/hacknife
 * project : CarouselBanner
 */
    protected class IndicatorAdapter extends RecyclerView.Adapter {

        int currentPosition = 0;

        public void setPosition(int currentPosition) {
            this.currentPosition = currentPosition;
        }

        @Override
        public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

            ImageView bannerPoint = new ImageView(getContext());
            RecyclerView.LayoutParams lp = new RecyclerView.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT,
                    ViewGroup.LayoutParams.WRAP_CONTENT);
            lp.setMargins(indicatorMargin, indicatorMargin, indicatorMargin, indicatorMargin);
            bannerPoint.setLayoutParams(lp);
            return new RecyclerView.ViewHolder(bannerPoint) {
            };
        }

        @Override
        public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
            ImageView bannerPoint = (ImageView) holder.itemView;
            bannerPoint.setImageDrawable(currentPosition == position ? mSelectedDrawable : mUnselectedDrawable);

        }

        @Override
        public int getItemCount() {
            return bannerSize;
        }
    }


    /**
 * author  : Hacknife
 * e-mail  : 4884280@qq.com
 * github  : http://github.com/hacknife
 * project : CarouselBanner
 */
    protected void refreshIndicator() {
        if (showIndicator && bannerSize > 1) {
            indicatorAdapter.setPosition(currentIndex % bannerSize);
            indicatorAdapter.notifyDataSetChanged();
        }
        if (onBannerItemClickListener!=null)
            onBannerItemClickListener.onItemChange(currentIndex % bannerSize);
    }


    protected int dp2px(int dp) {
        return (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, dp, Resources.getSystem().getDisplayMetrics());
    }

    /**
 * author  : Hacknife
 * e-mail  : 4884280@qq.com
 * github  : http://github.com/hacknife
 * project : CarouselBanner
 */
    protected int getColor(@ColorRes int color) {
        return ContextCompat.getColor(getContext(), color);
    }

    protected boolean compareListDifferent(List<String> newTabList, List<String> oldTabList) {
        if (oldTabList == null || oldTabList.isEmpty())
            return true;
        if (newTabList.size() != oldTabList.size())
            return true;
        for (int i = 0; i < newTabList.size(); i++) {
            if (TextUtils.isEmpty(newTabList.get(i)))
                return true;
            if (!newTabList.get(i).equals(oldTabList.get(i))) {
                return true;
            }
        }
        return false;
    }

}
