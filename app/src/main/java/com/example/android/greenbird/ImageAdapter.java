// Code was based on http://www.thetechnologyupdates.com/tutorial-to-swipe-images-in-android-application/, but altered by Carina Cunha
// updated code and added arrows to swipe through views

package com.example.android.greenbird;
import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v4.view.PagerAdapter;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

class ImageAdapter extends PagerAdapter {

    private final Context context;

    ImageAdapter(Context context){
        this.context=context;
    }

    private final int[] imageSlider = new int[]{
            R.drawable.imgslider1,
            R.drawable.imgslider2,
            R.drawable.imgslider3,
    };

    @Override
    public int getCount() {
        return imageSlider.length;
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
        return view == (object);
    }

    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {
        ImageView imageView = new ImageView(context);
        imageView.setImageResource(imageSlider[position]);
        (container).addView(imageView, 0);
        imageView.setScaleType(ImageView.ScaleType.FIT_XY);
        return imageView;
    }

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
        (container).removeView((ImageView) object);
    }


}
