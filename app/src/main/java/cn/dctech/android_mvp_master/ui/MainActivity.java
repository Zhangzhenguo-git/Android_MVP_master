package cn.dctech.android_mvp_master.ui;

import android.app.ProgressDialog;
import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.squareup.haha.perflib.Main;

import butterknife.BindView;
import butterknife.ButterKnife;
import cn.dctech.android_mvp_master.R;
import cn.dctech.android_mvp_master.model.MainModelImpl;
import cn.dctech.android_mvp_master.presenter.LoginPresenter;
import cn.dctech.android_mvp_master.presenter.MainPresenter;
import cn.dctech.android_mvp_master.view.MainView;

public class MainActivity extends AppCompatActivity implements MainView {


    @BindView(R.id.et_UserName)
    EditText etUserName;
    @BindView(R.id.et_UserPwd)
    EditText etUserPwd;
    @BindView(R.id.bt_Login)
    Button btLogin;

    private ProgressDialog mDialog;

    private MainModelImpl mianModel;
    private MainPresenter mianPresenter;
    private LoginPresenter loginPresenter;
    private int [] arr=new int[]{2,4,3,5,6,7,8,9,10,1,0};
    private Context context;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        context=MainActivity.this;
        initView();
        setClick();

    }

    private void initView(){
        mianPresenter=new MainPresenter(MainActivity.this);
        mianPresenter.getNetworkinfo();
        loginPresenter=new LoginPresenter(MainActivity.this,context);
    }
    private void setClick(){
        btLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                loginPresenter.reqLogin("18311371235","");
            }
        });
    }

    @Override
    public void updWeather(final String info) {
        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                etUserName.setText(info);
            }
        });
    }

    @Override
    public void showDialog() {
        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                if (mDialog!=null && mDialog.isShowing()){
                    mDialog.dismiss();
                }
                mDialog=ProgressDialog.show(MainActivity.this,"","正在获取中...");
            }
        });
    }

    @Override
    public void updLogin(boolean isTrue,String info) {
        if (isTrue){
            Toast.makeText(this, "登录成功"+info, Toast.LENGTH_SHORT).show();
        }else {
            Toast.makeText(this, "登录失败"+info, Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    public void dissDialog() {
        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                if (mDialog!=null && mDialog.isShowing()){
                    mDialog.dismiss();
                }
            }
        });
    }


    private void sdf(int [] arr){
        for (int i=0;i<arr.length;i++){
            int minPost=i;
            for (int j=i+1;j<arr.length;j++){
                if (arr[j]<arr[minPost]){
                    minPost=j;
                }
            }
            if (arr[i]>arr[minPost]){
                int temp=arr[i];
                arr[i]=arr[minPost];
                arr[minPost]=temp;
            }
        }
    }

    private void dsf(){
        for (int i=0;i<arr.length;i++){
            int temp=arr[i];
            int j;
            for (j=i-1;j>=0 && temp<arr[j];j--){
                arr[j+1]=arr[j];
            }
            arr[j+1]=temp;
        }
    }
}
