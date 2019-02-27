package cn.dctech.android_mvp_master.view;

/**
 * Created by Guo
 * CreatedDate 2019/2/22.
 * Email 18311371235@163.com
 * Remarks
 * 继承View
 */
public interface MainView {
    /**
     * 更新UI天气信息
     * @param info
     */
    void updWeather(String info);
    //请求网络时打开弹框
    void dissDialog();
    //请求网络时关闭弹框
    void showDialog();

    void updLogin(boolean isTrue,String info);
}
