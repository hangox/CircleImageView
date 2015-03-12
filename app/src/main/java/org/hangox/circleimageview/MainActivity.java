package org.hangox.circleimageview;

import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;

import com.nostra13.universalimageloader.core.DisplayImageOptions;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.assist.FailReason;
import com.nostra13.universalimageloader.core.listener.SimpleImageLoadingListener;

import java.util.ArrayList;
import java.util.List;

import auggie.library.displayers.CircleBitmapDisplayer;
import auggie.library.displayers.ScaleRoundedBitmapDisplayer;
import butterknife.ButterKnife;
import butterknife.InjectView;


public class MainActivity extends ActionBarActivity {
    @InjectView(R.id.imageList)
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
                .showImageOnLoading(new ColorDrawable(Color.BLUE))
                .cacheInMemory(true)
                .cacheOnDisk(true)
                .build();
        imageOptionsList.add(new DisplayImageOptions.Builder().cloneFrom(options).displayer(new
                CircleBitmapDisplayer()).build());
        imageOptionsList.add(new DisplayImageOptions.Builder().cloneFrom(options).displayer(new
                ScaleRoundedBitmapDisplayer(8)).build());
        gViewImage.setAdapter(new ItemAdapter());

    }


    public class ItemAdapter extends BaseAdapter{
        public static final String IMAGE_URL = "http://c.hiphotos.baidu.com/image/pic/item/7acb0a46f21fbe09f9d1479869600c338644adab.jpg";
        @Override
        public int getCount() {
            return imageOptionsList.size();
        }

        @Override
        public Object getItem(int position) {
            return null;
        }

        @Override
        public long getItemId(int position) {
            return 0;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            if(convertView == null) {
                convertView= View.inflate(MainActivity.this,R.layout.adapter_image_show,null);
                convertView.setTag(new ViewHolder(convertView));
            }
            ViewHolder viewHolder = (ViewHolder) convertView.getTag();
            DisplayImageOptions options = imageOptionsList.get(position);
            ImageLoader.getInstance().displayImage(IMAGE_URL,viewHolder.iViewShow,options,new SimpleImageLoadingListener(){
                @Override
                public void onLoadingComplete(String imageUri, View view, Bitmap loadedImage) {
                    super.onLoadingComplete(imageUri, view, loadedImage);
                    Log.i("imageloader","completed");
                }

                @Override
                public void onLoadingFailed(String imageUri, View view, FailReason failReason) {
                    Log.i("imageloader", "fail");
                }
            });
            return convertView;
        }

        public class ViewHolder {
            public ImageView iViewShow;
            public ViewHolder(View parent){
                iViewShow  = (ImageView) parent.findViewById(R.id.imageView);
            }
        }
    }






}
