package cn.dctech.android_mvp_master.view;

/**
 * Created by Guo
 * CreatedDate 2019/2/26.
 * Email 18311371235@163.com
 * Remarks
 */
public interface LoginView {
    /**
     * 更新UI层方法
     * @param isTrue
     */
    void upLogin(boolean isTrue);
    void showDialog();
    void dissDialog();
}
