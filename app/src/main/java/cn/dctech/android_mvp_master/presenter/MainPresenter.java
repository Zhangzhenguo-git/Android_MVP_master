package cn.dctech.android_mvp_master.presenter;

import cn.dctech.android_mvp_master.model.MainModel;
import cn.dctech.android_mvp_master.model.MainModelImpl;
import cn.dctech.android_mvp_master.view.MainView;

/**
 * Created by Guo
 * CreatedDate 2018/3/6.
 * Email 18311371235@163.com
 * Remarks
 */

public class MainPresenter{
    MainModel mModel;
    MainView mView;

    /**
     * 有参构造方法
     * @param mView
     */
    public MainPresenter(MainView mView){
        this.mView=mView;
        mModel=new MainModelImpl();
    }
    /**
     * 用来给VIew请求数据的方法
     */
    public void requestWetherInfo(){
        getNetworkinfo();
    }


    /**
     * 判断并显示弹框
     */
    public void showWaitingDialog(){
        if (mView!=null){
            mView.showDialog();
        }
    }
    /**
     * 判断并关闭弹框
     */
    public void dismissWaitingDialog(){
        if (mView!=null){
            mView.dissDialog();
        }
    }
    /**
     * 显示天气数据
     */
    public void updateWetherInfo(String info){
        if (mView!=null){
            mView.updWeather(info);
        }
    }
    public void saveInfo(String info){
        mModel.setInfo(info);
    }

    public String localInfo(){
        return mModel.getInfo();
    }

    public void getNetworkinfo(){
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    //打开等待网络弹框
                    showWaitingDialog();
                    //设置加载延迟
                    Thread.sleep(6000);

                    String info="今天晴转多云，温度21c";
                    //保存到Model层
                    saveInfo(info);
                    //从Model层获取数据，为了演示效果，实际开发中根据情况需要
                    String localinfo=localInfo();
                    //通知View层改变视图
                    updateWetherInfo(localinfo);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }finally {
                    dismissWaitingDialog();
                }
            }
        }).start();
    }
}
