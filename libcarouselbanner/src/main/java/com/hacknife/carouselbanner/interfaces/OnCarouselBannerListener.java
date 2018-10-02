package com.hacknife.carouselbanner.interfaces;

/**
 * author  : Hacknife
 * e-mail  : 4884280@qq.com
 * github  : http://github.com/hacknife
 * project : CarouselBanner
 */

public interface OnCarouselBannerListener {

    void onItemClick(int position, String url);
    void onItemChange(int position);

}
