// Code was based on http://www.thetechnologyupdates.com/tutorial-to-swipe-images-in-android-application/, but altered

package com.example.android.greenbird;
import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

public class ImageAdapter extends PagerAdapter {

    Context context;

    ImageAdapter(Context context){
        this.context=context;
    }

    private int[] imageSlider = new int[] {
            R.drawable.imgslider1,
            R.drawable.imgslider2,
            R.drawable.imgslider3,
    };

    @Override
    public int getCount() {
        return imageSlider.length;
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view == (object);
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        ImageView imageView = new ImageView(context);
        imageView.setImageResource(imageSlider[position]);
        (container).addView(imageView, 0);
        imageView.setScaleType(ImageView.ScaleType.FIT_XY);
        return imageView;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        (container).removeView((ImageView) object);
    }

}
