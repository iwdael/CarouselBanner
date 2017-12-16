# CarouselBanner [![](https://jitpack.io/v/aliletter/carouselbanner.svg)](https://jitpack.io/#aliletter/carouselbanner)
CarouselBanner is a control that displays pictures or ads. It is simple to use and does not rely on other third party frameworks, and allows user to implement the process of loading the picture is implemented  by the interface.[中文文档](https://github.com/aliletter/CarouselBanner/blob/master/README_CHINESE.md)
## Instruction
CarouselBanner can set the direction of image scroll, such as horizontal and vertical, and also can set the speed of rolling, the time of rolling, and the location of indicator. CarouselBanner is a common carousel controls, if you need to use a zoom effect control, please use the CoolCarouselBanner.
### Code Sample
The user needs to implement the process of loading the picture.
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
    <!--<com.aliletter.carouselbanner.CarouselBanner-->
    <com.aliletter.carouselbanner.CoolCarouselBanner
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
## How to
To get a Git project into your build:
### Step 1. Add the JitPack repository to your build file
Add it in your root build.gradle at the end of repositories.   [click here for details](https://github.com/aliletter/CarouselBanner/blob/master/root_build.gradle.png)
```Java
	allprojects {
		repositories {
			...
			maven { url 'https://jitpack.io' }
		}
	}
```
### Step 2. Add the dependency
Add it in your application module build.gradle at the end of dependencies where you want to use.   [click here for details](https://github.com/aliletter/CarouselBanner/blob/master/application_build.gradle.png)
```Java
	dependencies {
                ...
	        compile 'com.github.aliletter:carouselbanner:v1.0.0'
	}
```
CarouselBanner
<br>
![Image Text](https://github.com/aliletter/CarouselBanner/blob/master/CarouselBanner.gif)
<br><br>
CoolCarouselBanner
<br>
![Image Text](https://github.com/aliletter/CarouselBanner/blob/master/CoolCarouselBanner.gif)
<br>
## Thank you for your browsing
If you have any questions, please join the QQ group. I will do my best to answer it for you. Welcome to star and fork this repository, alse follow me.
<br>
![Image Text](https://github.com/aliletter/CarouselBanner/blob/master/qq_group.png)
