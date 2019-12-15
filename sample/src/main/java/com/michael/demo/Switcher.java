package com.michael.demo;

import android.content.Context;
import android.text.TextUtils;

import com.michael.envswitch.EnvSwitch;
import com.michael.envswitch.bean.EnvironmentBean;
import com.michael.envswitch.bean.ModuleBean;
import com.michael.envswitch.listener.OnTypeChangeListener;

import java.util.ArrayList;
import java.util.List;

public class Switcher {

    private List<ModuleBean> moduleBeanList = new ArrayList<>();

    private void init() {
        ModuleBean moduleBean = new ModuleBean("app", "test");

        EnvironmentBean environmentBean = new EnvironmentBean("test", "test", "测试", moduleBean);

        ArrayList<EnvironmentBean> environmentBeans = new ArrayList<>();

        environmentBeans.add(environmentBean);

        moduleBean.setEnvironments(environmentBeans);

    }

    private OnTypeChangeListener listener;

    private void setType(Context context, String type) {
        for (ModuleBean bean : moduleBeanList) {
            for (EnvironmentBean environment : bean.getEnvironments()) {
                if (TextUtils.equals(type, environment.getName())) {
                    if (bean.getName().equals("app")) {
                        EnvSwitch.setAppEnvironment(context, environment);
                    }
                    break;
                }
            }
        }
        listener.onTypeChanged(moduleBeanList);
    }
}