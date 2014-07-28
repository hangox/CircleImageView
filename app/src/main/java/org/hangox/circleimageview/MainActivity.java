package org.hangox.circleimageview;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.widget.ImageView;

import com.nostra13.universalimageloader.core.DisplayImageOptions;
import com.nostra13.universalimageloader.core.ImageLoader;

import auggie.library.displayers.CircleBitmapDisplayer;


public class MainActivity extends ActionBarActivity {
    ImageView iViewCircleImageDisplayer;
    String imageUrl = "http://d.hiphotos.baidu" +
            ".com/image/pic/item/9358d109b3de9c8242a7de176e81800a18d84363.jpg";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        iViewCircleImageDisplayer = (ImageView) findViewById(R.id.circle_image_displayer);
        ImageLoader.getInstance().displayImage(imageUrl,iViewCircleImageDisplayer,options);
//        BitmapDrawable bitmapDrawable = (BitmapDrawable) getResources().getDrawable(R.drawable.test_personal);
//        iViewCircleImageDisplayer.setImageDrawable(new CircleDrawable(bitmapDrawable.getBitmap()));
    }



    DisplayImageOptions options = new DisplayImageOptions.Builder()
            .cacheInMemory(true)
            .cacheOnDisk(true)
            .displayer(new CircleBitmapDisplayer())
            .build();


}
