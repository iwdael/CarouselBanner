package com.aliletter.democarouselbannar;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;
import android.widget.Toast;

import com.aliletter.carouselbannar.CarouselBanner;
import com.aliletter.carouselbannar.interfaces.CarouselImageFactory;
import com.aliletter.carouselbannar.interfaces.OnCarouselBannarListener;
import com.aliletter.onhttp.OnHttp;

import java.util.ArrayList;
import java.util.List;

public class Main2Activity extends AppCompatActivity {
    CarouselBanner banner, banner2;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        banner = findViewById(R.id.banner);
        banner2 = findViewById(R.id.banner2);
        List<String> list = new ArrayList<>();
        list.add("http://oo6pz0u05.bkt.clouddn.com/17-12-13/69427561.jpg");
        list.add("http://oo6pz0u05.bkt.clouddn.com/17-12-13/23738150.jpg");
        list.add("http://oo6pz0u05.bkt.clouddn.com/17-12-13/30127126.jpg");
        list.add("http://oo6pz0u05.bkt.clouddn.com/17-12-13/36125492.jpg");
        banner.initBanner(list, new CarouselImageFactory() {
            @Override
            public void onLoadFactory(String url, ImageView view) {
                OnHttp.imageLoader().url(url).view(view).build();
            }
        }, new OnCarouselBannarListener() {
            @Override
            public void onItemClick(int position, String url) {
                Toast.makeText(Main2Activity.this, "clicked:" + position, Toast.LENGTH_SHORT).show();
            }
        });
        banner2.initBanner(list, new CarouselImageFactory() {
            @Override
            public void onLoadFactory(String url, ImageView view) {
                OnHttp.imageLoader().url(url).view(view).build();
            }
        });
    }

}
