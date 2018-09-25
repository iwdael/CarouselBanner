package com.blackchopper.carouselbanner.interfaces;

/**
 * author  : Black Chopper
 * e-mail  : 4884280@qq.com
 * github  : http://github.com/BlackChopper
 * project : CarouselBanner
 */

public interface OnCarouselBannerListener {

    void onItemClick(int position, String url);
    void onItemChange(int position);

}
