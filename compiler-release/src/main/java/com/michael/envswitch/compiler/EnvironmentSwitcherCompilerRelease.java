package com.michael.envswitch.compiler;


import com.squareup.javapoet.FieldSpec;
import com.michael.envswitch.annotation.Env;
import com.michael.envswitch.bean.EnvironmentBean;

import javax.lang.model.element.Modifier;


public class EnvironmentSwitcherCompilerRelease extends EnvironmentSwitcherCompilerDebug {

    @Override
    protected FieldSpec generateEnvironmentField(Env environmentAnnotation,
                                                 FieldSpec.Builder defaultXXEnvironmentFiledBuilder,
                                                 String moduleUpperCaseName,
                                                 String environmentName,
                                                 String environmentUpperCaseName,
                                                 String url,
                                                 String alias) {
        if (environmentAnnotation.isRelease()) {
            return super.generateEnvironmentField(environmentAnnotation, defaultXXEnvironmentFiledBuilder, moduleUpperCaseName, environmentName, environmentUpperCaseName, url, alias);
        }

        return FieldSpec.builder(EnvironmentBean.class,
                String.format("%s_%s%s", moduleUpperCaseName, environmentUpperCaseName, VAR_DEFAULT_ENVIRONMENT_SUFFIX),
                Modifier.PUBLIC, Modifier.STATIC, Modifier.FINAL)
                .initializer(String.format("new %s(\"%s\", \"%s\", \"%s\", %s%s)",
                        EnvironmentBean.class.getSimpleName(), environmentName, "", alias, VAR_MODULE_PREFIX, moduleUpperCaseName))
                .build();
    }
}