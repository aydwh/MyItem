package com.bwie.library.imageloader.glideutils;

import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bwie.library.imageloader.ImageLoader;

/**
 * 1.类的用途
 * 2.@author:weihuanhuan
 * 3.@ 2016/12/28.
 */

public class GlideImagerLoader implements ImageLoader {

    public static GlideImagerLoader glideUtils;
    private GlideImagerLoader(){}
    public static GlideImagerLoader getInstance(){
        if(glideUtils==null){
            synchronized (GlideImagerLoader.class){
                if(glideUtils==null){
                    glideUtils = new GlideImagerLoader();
                }
            }
        }
        return glideUtils;
    }

    @Override
    public void display(ImageView imageView, String url) {

        Glide.with(imageView.getContext())
                .load(url)
                .into(imageView);
    }

    /**
     * 这里不得不强调下Glide的一个强大的功能，当你在With后面的传Activity或者Fragment，
     * Glide就可以根据当前Activity或者Fragment的生命周期维护图片的生命周期，
     * 比如但activity销毁的时候，就会自动取消需要加载的图片
     *
     * @param imageView
     * @param url
     * @param loadingImg
     * @param errorImg
     */
    @Override
    public void display(ImageView imageView, String url, int loadingImg, int errorImg) {
        Glide.with(imageView.getContext())
                .load(url)
                .placeholder(loadingImg)
                .error(errorImg)
                .into(imageView);
    }

    @Override
    public void displayCircleImg(ImageView imageView, int resId) {

        Glide.with(imageView.getContext())
                .load(resId)
                .transform(new GlideCircleTransform(imageView.getContext()))
                .into(imageView);
    }

    @Override
    public void displayCircleImg(ImageView imageView, String url) {

        Glide.with(imageView.getContext())
                .load(url)
                .transform(new GlideCircleTransform(imageView.getContext()))
                .into(imageView);
    }

    @Override
    public void displayRoundImg(ImageView imageView, int resId) {
        Glide.with(imageView.getContext())
                .load(resId)
                .transform(new GlideRoundTransform(imageView.getContext()))
                .into(imageView);
    }

    @Override
    public void displayRoundImg(ImageView imageView, String url) {

        Glide.with(imageView.getContext())
                .load(url)
                .transform(new GlideRoundTransform(imageView.getContext()))
                .into(imageView);
    }

    @Override
    public void displayImgQuick(ImageView imageView, String url, float num, DiskCacheStrategy diskCacheStrategy) {
        Glide.with(imageView.getContext())
                .load(url)
                .thumbnail(num)
                .diskCacheStrategy(diskCacheStrategy)
                .into(imageView);
    }
}
