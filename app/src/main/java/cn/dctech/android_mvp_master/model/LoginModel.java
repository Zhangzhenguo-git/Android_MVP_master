package cn.dctech.android_mvp_master.model;

/**
 * Created by Guo
 * CreatedDate 2019/2/26.
 * Email 18311371235@163.com
 * Remarks
 */
public interface LoginModel {
    /**
     * 请求接口时传入数据
     */
    String getShowLogin();

    /**
     * 请求完接口返回数据
     * @param infoData
     * @return
     */
    void resultLoginMapData(boolean isTrue,String infoData);
}
