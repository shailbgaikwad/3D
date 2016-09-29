package util;

import android.app.Application;
import android.text.TextUtils;
import android.util.DisplayMetrics;


import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.toolbox.ImageLoader;
import com.android.volley.toolbox.Volley;

import volleyImages.LruBitmapCache;

public class AppController extends Application {
 
    public static final String TAG = AppController.class.getSimpleName();
    private RequestQueue mRequestQueue;
    private static AppController mInstance;
 public static int DrawerWidth=460;
    public static int Height=235;
    private ImageLoader mImageLoader;
    LruBitmapCache mLruBitmapCache;
    public static int width,height;
    @Override
    public void onCreate() {
        super.onCreate();
        mInstance = this;
        try {
            DisplayMetrics metrics = getApplicationContext().getResources().getDisplayMetrics();
             width = metrics.widthPixels;
            height=metrics.heightPixels;
           Height=height;
            DrawerWidth = width - 80;
        }catch (Exception e){
            DrawerWidth=460;
            e.printStackTrace();
        }
    }

    public static synchronized AppController getInstance() {
        return mInstance;
    }
 
    public RequestQueue getRequestQueue() {
        if (mRequestQueue == null) {
            mRequestQueue = Volley.newRequestQueue(getApplicationContext());
        }
 
        return mRequestQueue;
    }

//    public ImageLoader getImageLoader() {
//        getRequestQueue();
//        if (mImageLoader == null) {
//            getLruBitmapCache();
//            mImageLoader = new ImageLoader(this.mRequestQueue, mLruBitmapCache);
//        }
//
//        return this.mImageLoader;
//    }

    public LruBitmapCache getLruBitmapCache() {
        if (mLruBitmapCache == null)
            mLruBitmapCache = new LruBitmapCache();
        return this.mLruBitmapCache;
    }



    public <T> void addToRequestQueue(Request<T> req, String tag) {
        req.setTag(TextUtils.isEmpty(tag) ? TAG : tag);
        getRequestQueue().add(req);
    }
 
    public <T> void addToRequestQueue(Request<T> req) {
        req.setTag(TAG);
        getRequestQueue().add(req);
    }
 
    public void cancelPendingRequests(Object tag) {
        if (mRequestQueue != null) {
            mRequestQueue.cancelAll(tag);
        }
    }
}