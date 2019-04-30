# CarouselBanner
[![](https://img.shields.io/badge/platform-android-orange.svg)](https://github.com/hacknife) [![](https://img.shields.io/badge/language-java-yellow.svg)](https://github.com/hacknife) [![](https://img.shields.io/badge/JCenter-1.1.2-brightgreen.svg)](https://jcenter.bintray.com/com/hacknife/carouselbanner) [![](https://img.shields.io/badge/build-passing-brightgreen.svg)](https://github.com/hacknife) [![](https://img.shields.io/badge/license-apache--2.0-green.svg)](https://github.com/hacknife) [![](https://img.shields.io/badge/api-19+-green.svg)](https://github.com/hacknife)<br/><br/>
CarouselBanner 是一款展示图片或者广告的控件。它使用简单，不依赖其他第三方框架，而且把图片加载的过程通过接口的方式让使用者自行实现。
<br>
![Image Text](https://github.com/hacknife/CarouselBanner/blob/master/CarouselBanner.gif)
<br><br>
![Image Text](https://github.com/hacknife/CarouselBanner/blob/master/CoolCarouselBanner.gif)
<br>

## 使用说明
CarouselBanner可以设置滚动的方向，例如水平和垂直，也可以设置滚动的速度，滚动间隔时间，以及指示器的位置。CarouselBanner是普通的轮播控件，如果你想使用带有放缩效果的轮播控件，请使用CoolCarouselBanner。

### 代码示例
#### 自定义加载器
```
public class ImageFactory implements CarouselImageFactory {
    @Override
    public void onLoadFactory(String url, ImageView view) {
        Glide.with(view).load(url).into(view);
    }
}
```
#### 初始化
```
Banner.init(new ImageFactory());
```
#### 添加到布局
```
    <!--<com.hacknife.carouselbanner.CarouselBanner-->
    <com.hacknife.carouselbanner.CoolCarouselBanner
        android:id="@+id/banner"
        android:layout_width="match_parent"
        android:layout_height="200dp"
        app:autoPlaying="true"
        app:indicatorGravity="left"
        app:indicatorSelectedSrc="#d6c2c2"
        app:indicatorUnselectedSrc="#df0000"
        app:orientation="horizontal"
        app:speedPerPixelMillisecond="0.8" />
```
#### 绑定数据
```
    banner = findViewById(R.id.banner);
    banner.setOnCarouselItemChangeListener(...);//滚动监听
    banner.setOnCarouselItemClickListener(...);//点击监听
    list.add("http://.............jpg");
    banner.initBanner(list);
```

## 快速引入项目
合并以下代码到需要使用的Module的dependencies中。
```Java
	dependencies {
                ...
	        implementation 'com.hacknife:carouselbanner:1.1.2'
	}
```

## 感谢浏览
如果你有任何疑问，请加入QQ群，我将竭诚为你解答。欢迎Star和Fork本仓库，当然也欢迎你关注我。
<br>
![Image Text](https://github.com/hacknife/CarouselBanner/blob/master/qq_group.png)
