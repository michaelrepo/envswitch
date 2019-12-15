package com.michael.envswitch.listener;

import com.michael.envswitch.bean.ModuleBean;

import java.util.List;

public interface OnTypeChangeListener {

    void onTypeChanged(List<ModuleBean> moduleBeans);
}
