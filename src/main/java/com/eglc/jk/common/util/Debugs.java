package com.eglc.jk.common.util;

public class Debugs {
    public static final Boolean debugs = true;

    public static void  fly(Runnable runnable){
        if (runnable == null || !debugs){
            return;
        }
        runnable.run();

    }





}
