package com.michael.envswitch.listener;

import com.michael.envswitch.bean.EnvironmentBean;
import com.michael.envswitch.bean.ModuleBean;

public interface OnEnvironmentChangeListener {


    void onEnvironmentChanged(ModuleBean module, EnvironmentBean oldEnvironment, EnvironmentBean newEnvironment);
}