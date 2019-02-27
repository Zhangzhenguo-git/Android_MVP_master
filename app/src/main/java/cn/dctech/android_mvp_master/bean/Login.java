package cn.dctech.android_mvp_master.bean;

/**
 * Created by Guo
 * CreatedDate 2019/1/17.
 * Email 18311371235@163.com
 * Remarks
 */
public class Login {
    private String userPhone;

    public Login() {
    }

    public Login(String userPhone) {
        this.userPhone = userPhone;
    }

    public String getUserPhone() {
        return userPhone;
    }

    public void setUserPhone(String userPhone) {
        this.userPhone = userPhone;
    }
}
