package org.hangox.circleimageview;

import android.app.Application;

import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.ImageLoaderConfiguration;

/**
 * Created With Android Studio
 * User @47
 * Date 2014-07-27
 * Time 20:36
 */
public class MyApplication extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        initImageLoader();
    }

    private void initImageLoader(){
        ImageLoaderConfiguration config = new ImageLoaderConfiguration.Builder(getApplicationContext())
                .denyCacheImageMultipleSizesInMemory()
                .diskCacheExtraOptions(1024,1024,null)
                .memoryCacheSize(2 * 1024 * 1024)
                .discCacheSize(50 * 1024 * 1024)
                .discCacheFileCount(100)
                .build();
        ImageLoader.getInstance().init(config);
    }
}
