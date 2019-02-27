package cn.dctech.android_mvp_master.model;

/**
 * Created by Guo
 * CreatedDate 2019/2/22.
 * Email 18311371235@163.com
 * Remarks
 */
public interface MainModel {

    /**
     * 获取数据
     * @return
     */
    String getInfo();
    /**
     * 传入数据
     * @param info
     */
    void setInfo(String info);
}
