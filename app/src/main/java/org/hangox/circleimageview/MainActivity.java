package org.hangox.circleimageview;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.widget.GridView;

import com.lidroid.xutils.view.annotation.ViewInject;
import com.nostra13.universalimageloader.core.DisplayImageOptions;

import java.util.ArrayList;
import java.util.List;

import auggie.library.displayers.CircleBitmapDisplayer;
import auggie.library.displayers.ScaleRoundedBitmapDisplayer;
import butterknife.ButterKnife;


public class MainActivity extends ActionBarActivity {
    @ViewInject(R.id.imageList)
    GridView gViewImage;

    List<DisplayImageOptions> imageOptionsList = new ArrayList<>(10);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.inject(this);
        setUpOption();
    }

    private void setUpOption(){
        DisplayImageOptions options = new DisplayImageOptions.Builder()
                .cacheInMemory(true)
                .cacheOnDisk(true)
                .build();
        imageOptionsList.add(new DisplayImageOptions.Builder().cloneFrom(options).displayer(new
                CircleBitmapDisplayer()).build());
        imageOptionsList.add(new DisplayImageOptions.Builder().cloneFrom(options).displayer(new
                ScaleRoundedBitmapDisplayer(8)).build());

    }







}
