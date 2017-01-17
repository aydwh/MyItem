package com.bwie.library.imageloader;

import com.bwie.library.imageloader.glideutils.GlideImagerLoader;

import static com.bwie.library.imageloader.ImageLoaderManager.Type.GLIDE;


/**
 * 1.类的用途
 * 2.@author:weihuanhuan
 * 3.@ 2016/12/28.
 */

public class ImageLoaderManager {
    private static ImageLoaderManager mManager;
    public static final int GLIDER=1;
    private ImageLoaderManager(){}
    public static ImageLoaderManager getInstance(){
        if(mManager==null)
            mManager=new ImageLoaderManager();
        return mManager;

    }
    public ImageLoader getImageLoader(){
        return getImageLoader(null);
    }

    public ImageLoader getImageLoader(Type type){
        if(GLIDE==type){
            return GlideImagerLoader.getInstance();
        }
        return  GlideImagerLoader.getInstance();
    }
    enum Type{
        GLIDE;
    }
}
