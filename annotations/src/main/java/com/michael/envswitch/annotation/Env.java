package com.michael.envswitch.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;


@Target(ElementType.FIELD)
@Retention(RetentionPolicy.CLASS)
public @interface Env {

    String value();


    boolean isRelease() default false;


    String alias() default "";


    boolean isDebug() default false;
}
