package cn.dctech.android_mvp_master.model;

import android.content.Intent;
import android.util.Log;
import android.widget.Toast;

import java.io.IOException;

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
public class LoginModelImpl implements LoginModel{

    private String info="";
    @Override
    public String getShowLogin() {
        return info;
    }

    @Override
    public void resultLoginMapData(boolean isTrue, String infoData) {
        if (isTrue){
            info=infoData;
        }else {
            info="登录失败";
        }
    }
}
