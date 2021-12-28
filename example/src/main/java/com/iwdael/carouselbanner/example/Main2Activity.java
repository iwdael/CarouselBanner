package com.iwdael.carouselbanner.example;

import android.os.Bundle;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.iwdael.carouselbanner.CarouselBanner;
import com.iwdael.carouselbanner.interfaces.OnCarouselItemChangeListener;
import com.iwdael.carouselbanner.interfaces.OnCarouselItemClickListener;

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
        list.add("http://g.hiphotos.baidu.com/image/pic/item/b17eca8065380cd78775def0ab44ad3459828147.jpg");
        list.add("http://f.hiphotos.baidu.com/image/pic/item/a08b87d6277f9e2faa2048151530e924b899f392.jpg");
        list.add("http://b.hiphotos.baidu.com/image/pic/item/03087bf40ad162d923621d011bdfa9ec8a13cd1b.jpg");
        list.add("http://e.hiphotos.baidu.com/image/pic/item/b7fd5266d0160924d76acf06de0735fae6cd345b.jpg");
        list.add("http://a.hiphotos.baidu.com/image/pic/item/c83d70cf3bc79f3d785ce62db0a1cd11728b2969.jpg");
        list.add("http://f.hiphotos.baidu.com/image/pic/item/fcfaaf51f3deb48fd146bfc3fa1f3a292df578fb.jpg");

        banner.setOnCarouselItemClickListener(new OnCarouselItemClickListener() {
            @Override
            public void onItemClick(int position, String url) {
                Toast.makeText(Main2Activity.this, url, Toast.LENGTH_LONG).show();
            }
        });
        banner.setOnCarouselItemChangeListener(new OnCarouselItemChangeListener() {
            @Override
            public void onItemChange(int position) {
//                Toast.makeText(Main2Activity.this, String.valueOf(position), Toast.LENGTH_LONG).show();
            }
        });
        banner.initBanner(list);
        banner2.initBanner(list);
    }

}
