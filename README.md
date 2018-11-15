# CarouselBanner
[![](https://img.shields.io/badge/platform-android-orange.svg)](https://github.com/hacknife) [![](https://img.shields.io/badge/language-java-yellow.svg)](https://github.com/hacknife) [![](https://img.shields.io/badge/jcenter-1.0.7-brightgreen.svg)](https://jcenter.bintray.com/com/hacknife/carouselbanner) [![](https://img.shields.io/badge/build-passing-brightgreen.svg)](https://github.com/hacknife) [![](https://img.shields.io/badge/license-apache--2.0-green.svg)](https://github.com/hacknife) [![](https://img.shields.io/badge/api-19+-green.svg)](https://github.com/hacknife)<br/><br/>
CarouselBanner 是一款展示图片或者广告的控件。它使用简单，不依赖其他第三方框架，而且把图片加载的过程通过接口的方式让使用者自行实现。
<br>
![Image Text](https://github.com/hacknife/CarouselBanner/blob/master/CarouselBanner.gif)
<br><br>
![Image Text](https://github.com/hacknife/CarouselBanner/blob/master/CoolCarouselBanner.gif)
<br>

## 使用说明hacknife
CarouselBanner可以设置滚动的方向，例如水平和垂直，也可以设置滚动的速度，滚动间隔时间，以及指示器的位置。CarouselBanner是普通的轮播控件，如果你想使用带有放缩效果的轮播控件，请使用CoolCarouselBanner。

### 代码示例
使用者需要实现图片加载的过程。
```Java
        CoolCarouselBanner banner;//with zoom effect
        //CarouselBanner
    ...
        banner = findViewById(R.id.banner);
    ...
        List<String> list = new ArrayList<>();
        OnHttp.initDefault(getApplicationContext());
        list.add("http://g.hiphotos.baidu.com/image/pic/item/b17eca8065380cd78775def0ab44ad3459828147.jpg");
        list.add("http://f.hiphotos.baidu.com/image/pic/item/a08b87d6277f9e2faa2048151530e924b899f392.jpg");
        list.add("http://b.hiphotos.baidu.com/image/pic/item/03087bf40ad162d923621d011bdfa9ec8a13cd1b.jpg");
        list.add("http://e.hiphotos.baidu.com/image/pic/item/b7fd5266d0160924d76acf06de0735fae6cd345b.jpg");
        list.add("http://a.hiphotos.baidu.com/image/pic/item/c83d70cf3bc79f3d785ce62db0a1cd11728b2969.jpg");
        list.add("http://f.hiphotos.baidu.com/image/pic/item/fcfaaf51f3deb48fd146bfc3fa1f3a292df578fb.jpg");
        banner.initBanner(list, new CarouselImageFactory() {
            @Override
            public void onLoadFactory(String url, ImageView view) {
                OnHttp.imageLoader().url(url).view(view).defaultId(R.mipmap.ic_launcher).build();
            }
        }, new OnCarouselBannerListener() {
            @Override
            public void onItemClick(int position, String url) {
                Toast.makeText(MainActivity.this, "clicked:" + position, Toast.LENGTH_SHORT).show();
            }
        });

```
```Java
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
## 快速引入项目
合并以下代码到需要使用的Module的dependencies中。
```Java
	dependencies {
                ...
	        compile 'com.hacknife:carouselbanner:1.0.7'
	}
```

## 感谢浏览
如果你有任何疑问，请加入QQ群，我将竭诚为你解答。欢迎Star和Fork本仓库，当然也欢迎你关注我。
<br>
![Image Text](https://github.com/hacknife/CarouselBanner/blob/master/qq_group.png)
