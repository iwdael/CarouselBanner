package com.hacknife.carouselbanner;

import com.hacknife.carouselbanner.interfaces.CarouselImageFactory;

public class Banner {
    public static volatile Banner sBanner;
    private CarouselImageFactory factory;

    private Banner() {
    }

    public static void init(CarouselImageFactory factory) {
        if (sBanner == null) {
            synchronized (Banner.class) {
                if (sBanner == null)
                    sBanner = new Banner();
            }
        }
        sBanner.factory = factory;
    }

    public static CarouselImageFactory factory() {
        if (sBanner == null) {
            synchronized (Banner.class) {
                if (sBanner == null)
                    sBanner = new Banner();
            }
        }
        if (sBanner.factory == null)
            throw new RuntimeException("CarouselBanner must be initialized by \"Banner.init\" method !!!");
        return sBanner.factory;
    }
}
