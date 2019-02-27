package cn.dctech.android_mvp_master.model;

import java.util.Random;

/**
 * Created by Guo
 * CreatedDate 2019/2/22.
 * Email 18311371235@163.com
 * Remarks
 */
public class MainModelImpl implements MainModel {

    @Override
    public String getInfo() {
        Random r = new Random();
        int seed = r.nextInt(3);

        if(seed % 2 == 0){
            return "21度，晴转多云";
        }else{
            return "22度，晴";
        }
    }

    @Override
    public void setInfo(String info) {

    }


}
