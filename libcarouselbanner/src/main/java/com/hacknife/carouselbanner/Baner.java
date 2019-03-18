package com.hacknife.carouselbanner;

import com.hacknife.carouselbanner.interfaces.CarouselImageFactory;

public class Baner {
    public static volatile Baner sBanner;
    private CarouselImageFactory factory;

    private Baner() {
    }

    public static void init(CarouselImageFactory factory) {
        if (sBanner == null) {
            synchronized (Baner.class) {
                if (sBanner == null)
                    sBanner = new Baner();
            }
        }
        sBanner.factory = factory;
    }

    public static CarouselImageFactory factory() {
        if (sBanner == null) {
            synchronized (Baner.class) {
                if (sBanner == null)
                    sBanner = new Baner();
            }
        }
        if (sBanner.factory == null)
            throw new RuntimeException("CarouselBanner must be initialized by \"Banner.init\" method !!!");
        return sBanner.factory;
    }
}
