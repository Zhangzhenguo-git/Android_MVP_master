package cn.dctech.android_mvp_master.http;


import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.GsonConverterFactory;
import retrofit2.Retrofit;
import retrofit2.RxJavaCallAdapterFactory;

/**
 * Created by Administrator on 2017/3/31 0022.
 * 单例模式
 */

public class RetrofitHttp {
//    private static String baseUrl = "http://192.168.31.122";
    private static String baseUrl = "http://47.93.78.144:8083";
//    private static String baseUrl = "http://192.168.31.106:8083";
    private static HttpInterface singleton;

    public static HttpInterface getRetrofit(OkHttpClient client){
        synchronized (RetrofitHttp.class) {
            singleton = createRetrofit(client).create(HttpInterface.class);
        }
        return singleton;
    }


    private static Retrofit createRetrofit(OkHttpClient client) {
        HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
        interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(baseUrl)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .client(client)
                .build();
        return retrofit;
    }

}
