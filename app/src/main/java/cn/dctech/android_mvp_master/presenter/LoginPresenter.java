package cn.dctech.android_mvp_master.presenter;

import android.content.Context;
import android.util.Log;
import android.widget.Toast;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;

import java.io.IOException;

import cn.dctech.android_mvp_master.bean.Login;
import cn.dctech.android_mvp_master.http.RetrofitHttp;
import cn.dctech.android_mvp_master.model.LoginModel;
import cn.dctech.android_mvp_master.model.LoginModelImpl;
import cn.dctech.android_mvp_master.view.LoginView;
import cn.dctech.android_mvp_master.view.MainView;
import okhttp3.Interceptor;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.ResponseBody;
import retrofit2.Response;

/**
 * Created by Guo
 * CreatedDate 2019/2/26.
 * Email 18311371235@163.com
 * Remarks
 */
public class LoginPresenter {
    private Context context;
    private MainView mLoginView;
    private LoginModel mLoginModel;
    public LoginPresenter(MainView mLoginView,Context context){
        this.context=context;
        this.mLoginView=mLoginView;
        mLoginModel=new LoginModelImpl();
    }

    public void reqLogin(String userName,String userPwd){
        mLoginView.showDialog();
        OkHttpClient.Builder builder = new OkHttpClient.Builder();
        //这部分没用，只是查看log数据
        builder.addInterceptor(new Interceptor() {
            @Override
            public okhttp3.Response intercept(Chain chain) throws IOException {
                Request request = chain.request();
                okhttp3.Response proceed = chain.proceed(request);
                Log.d("zzz 登录网址", "request网址-----》" + request.url().toString());
                Log.d("zzz 登录request", "request====" + request.body().toString());
                Log.d("zzz 登录proceed", "proceed====" + proceed.headers().toString());
                return proceed;
            }
        });
        Login login = new Login();
        login.setUserPhone(userName);
        Log.d("执行登录手机号转换json", JSON.toJSONString(login));
        RequestBody body = RequestBody.create(MediaType.parse("application/json; charset=utf-8"), JSON.toJSONString(login));
        RetrofitHttp.getRetrofit(builder.build()).appLogin(body).enqueue(new retrofit2.Callback<ResponseBody>() {
            @Override
            public void onResponse(Response<ResponseBody> response) {
                try {
                    if (response.isSuccess()) {
                        String resultData = response.body().string().toString();
                        Log.d("执行，登录返回", resultData);
                        JSONObject object = JSON.parseObject(resultData);
                        if (!object.getBoolean("success")) {
                            mLoginModel.resultLoginMapData(false,resultData);
                            updLogin(false);
                            return;
                        }
                        mLoginModel.resultLoginMapData(true,resultData);
                        updLogin(true);
                        mLoginView.dissDialog();
                    } else {
                        mLoginView.dissDialog();
                        Toast.makeText(context, "服务器出了点问题", Toast.LENGTH_SHORT).show();
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                    mLoginView.dissDialog();
                }
            }

            @Override
            public void onFailure(Throwable t) {
                mLoginView.dissDialog();
                Toast.makeText(context, "网络不给力", Toast.LENGTH_SHORT).show();
            }
        });
    }
    private void updLogin(boolean isTrue){
        if (mLoginView!=null){
            mLoginView.updLogin(isTrue,mLoginModel.getShowLogin());
        }
    }
}
