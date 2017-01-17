package com.bwie.library.imageloader.glideutils;

import android.content.Context;

import com.bumptech.glide.Glide;
import com.bumptech.glide.GlideBuilder;
import com.bumptech.glide.load.DecodeFormat;
import com.bumptech.glide.load.engine.bitmap_recycle.LruBitmapPool;
import com.bumptech.glide.load.engine.cache.DiskLruCacheFactory;
import com.bumptech.glide.load.engine.cache.LruResourceCache;
import com.bumptech.glide.load.engine.cache.MemorySizeCalculator;
import com.bumptech.glide.module.GlideModule;

/**
 * 1.类的用途
 * 2.@author:weihuanhuan
 * 3.@ 2016/12/28.
 */

public class MyGlideModel implements GlideModule {
    @Override
    public void applyOptions(Context context, GlideBuilder builder) {
        //设置图片格式
        builder.setDecodeFormat(DecodeFormat.PREFER_ARGB_8888);
        //设置缓存池大小
        MemorySizeCalculator calculator = new MemorySizeCalculator(context);
        int defaultMemoryCacheSize = calculator.getMemoryCacheSize();
        int defaultBitmapPoolSize = calculator.getBitmapPoolSize();

        int customMemoryCacheSize = (int) (1.2 * defaultMemoryCacheSize);
        int customBitmapPoolSize = (int) (1.2 * defaultBitmapPoolSize);

        builder.setMemoryCache( new LruResourceCache( customMemoryCacheSize ));
        builder.setBitmapPool( new LruBitmapPool( customBitmapPoolSize ));
        String cachePath=context.getExternalCacheDir().getPath();
        int cacheSize=50*1024;
        builder.setDiskCache(new DiskLruCacheFactory(cachePath,"image",cacheSize));
    }

    @Override
    public void registerComponents(Context context, Glide glide) {

    }
}
