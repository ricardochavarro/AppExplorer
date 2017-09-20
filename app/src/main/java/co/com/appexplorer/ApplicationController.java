package co.com.appexplorer;

import android.app.Application;
import android.text.TextUtils;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.toolbox.ImageLoader;
import com.android.volley.toolbox.Volley;

import java.util.List;
import java.util.Map;

import co.com.appexplorer.util.dto.Category;
import co.com.appexplorer.util.dto.Entry;
import co.com.appexplorer.util.dto.Top;
import co.com.appexplorer.util.volley_code.LruBitmapCache;

/**
 * Created by ricardo.chavarro on 19/09/2017.
 */

public class ApplicationController extends Application {
    public static final String TAG = ApplicationController.class
            .getSimpleName();

    private RequestQueue mRequestQueue;
    private ImageLoader mImageLoader;

    private static Top top;

    private static Category categoriaExplora;

    private static Map<String, List<Entry>> categoriasAplicaciones;

    public static Map<String, List<Entry>> getCategoriasAplicaciones() {
        return categoriasAplicaciones;
    }

    public static void setCategoriasAplicaciones(Map<String, List<Entry>> categoriasAplicaciones) {
        ApplicationController.categoriasAplicaciones = categoriasAplicaciones;
    }

    public static Category getCategoriaExplora() {
        return categoriaExplora;
    }

    public static void setCategoriaExplora(Category categoriaExplora) {
        ApplicationController.categoriaExplora = categoriaExplora;
    }

    public static Top getFeed() {
        return ApplicationController.top;
    }

    public static void setFeed(Top top) {
        ApplicationController.top = top;
    }

    private static ApplicationController mInstance;

    @Override
    public void onCreate() {
        super.onCreate();
        mInstance = this;
    }

    public static synchronized ApplicationController getInstance() {
        return mInstance;
    }

    public RequestQueue getRequestQueue() {
        if (mRequestQueue == null) {
            mRequestQueue = Volley.newRequestQueue(getApplicationContext());
        }

        return mRequestQueue;
    }

    public ImageLoader getImageLoader() {
        getRequestQueue();
        if (mImageLoader == null) {
            mImageLoader = new ImageLoader(this.mRequestQueue,
                    new LruBitmapCache());
        }
        return this.mImageLoader;
    }

    public <T> void addToRequestQueue(Request<T> req, String tag) {
        // set the default tag if tag is empty
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
