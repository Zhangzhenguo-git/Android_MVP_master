package cn.dctech.android_mvp_master.http;


import okhttp3.RequestBody;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Headers;
import retrofit2.http.POST;

/**
 * Created by Administrator on 2017/3/31 0022.
 */
public interface HttpInterface {
    /**
     * 登录
     */
    @Headers({"Content-Type: application/json", "Accept: application/json"})
    @POST("/xpgt-api/app/session/appLogin")
    Call<ResponseBody> appLogin(@Body RequestBody userPhone);

    /**
     * 创建订单
     */
    @Headers({"Content-Type: application/json", "Accept: application/json"})
    @POST("/xpgt-api/app/order/placeOrder")
    Call<ResponseBody> placeOrder(@Body RequestBody userPhone);

    /**
     * 取消订单
     */
    @Headers({"Content-Type: application/json", "Accept: application/json"})
    @POST("/xpgt-api/app/order/cancelOrder")
    Call<ResponseBody> cancelOrder(@Body RequestBody cancelOrder);


}