package com.junling.gard;

import android.app.Activity;
import android.os.Bundle;
import android.os.Environment;
import android.util.Log;
import android.view.View;
import android.widget.RelativeLayout;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

import dalvik.system.DexClassLoader;

/**
 * Created by Administrator on 2016/11/15.
 
*	反射的时候方法
*	android 反射sd卡中的jar库
 */

public class mainactivity extends Activity {

    private RelativeLayout bannerContainer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.mian);
        adv();
    }

    private void adv() {
        //这里要把dex.jar进行转换
        //dx --dex --output=dynamic.jar test.jar ,dynamic.jar是对test.jar处理后得到的jar文件.
        //dx在build-tools 下面
        String sdcard = Environment.getExternalStorageDirectory().getAbsolutePath();
        String jarPath = sdcard + "/Jar/dex.jar";
        String tmpPath = getApplicationContext().getDir("Jar", 0).getAbsolutePath();
        DexClassLoader cl = new DexClassLoader(jarPath, tmpPath
                , null, this.getClass().getClassLoader());
        Class<?> libProviderCls = null;
        try {

            Class<?> mBannerView = cl.loadClass("com.junling.vda.ads.banner.BannerView");
            Class<?> mAbstractBannerADListener = cl.loadClass("com.junling.vda.ads.banner.AbstractBannerADListener");
            Class<?> mBannerADListener = cl.loadClass("com.junling.vda.ads.banner.BannerADListener");
            Class<?> mADSize =cl.loadClass("com.junling.vda.ads.banner.ADSize");

//            Class<?> mBannerView = Class.forName("com.junling.jjadv.ads.banner.BannerView");
//            Class<?> mAbstractBannerADListener = Class.forName("com.junling.jjadv.ads.banner.AbstractBannerADListener");
//            Class<?> mBannerADListener =  Class.forName("com.junling.jjadv.ads.banner.BannerADListener");
//            Class<?> mADSize = Class.forName("com.junling.jjadv.ads.banner.ADSize");

//            Field banner = mADSize.getDeclaredField("BANNER");
            //得到成员变量的类类型
//            Class<?> bannerType =banner.getType();
//            for(Method s :mBannerView.getDeclaredMethods())
//            {
//                Log.i("logg","s name=="+s.getName());
//
//            }

            //得到枚举类型
            //得到enum的所有实例
//            Class clazz = mADSize.getDeclaringClass();
            Object[] objs = mADSize.getEnumConstants();
            Object mnumObject=null;
            for (Object obj :objs){
                if (obj.toString().equalsIgnoreCase("BANNER")) {
                    mnumObject =obj;
                    Log.i("logg","mADSize=="+mADSize.getName()+",,,");
                }
            }

//            Log.i("logg","0000");

            Constructor c=mBannerView.getConstructors()[0];//如果就一个构造函数
            Class[] paraTypes=c.getParameterTypes();//构造函数的参数类型

            for(int i=0;i<paraTypes.length;i++)
            {
                Log.i("logg","paraTypes["+i+"]=="+paraTypes[i].getName());

            }
            //参数类型数组
            Class[] mparameterTypes={Activity.class,mADSize,String.class,String.class};
            Constructor mconstructor=mBannerView.getConstructor(mparameterTypes);
            //参数数组

            Log.i("logg","11111");
            Object[] mparameters={mainactivity.this,mnumObject,"1105600648", "7000916319746851"};
            //根据获取的构造函数和参数，创建实例
            Object objmBannerView=mconstructor.newInstance(mparameters);

            Log.i("logg","22222");

            Method  msetRefresh = mBannerView.getMethod("setRefresh",int.class);
            msetRefresh.setAccessible(true);
            msetRefresh.invoke(objmBannerView,30);

            Log.i("logg","333333");

//            Method  msetADListener = mBannerView.getMethod("setADListener",mBannerADListener);
//            msetADListener.setAccessible(true);
//            Log.i("logg","44444");
//            msetADListener.invoke(objmBannerView,null);
//            Log.i("logg","55555");


            bannerContainer = (RelativeLayout) this.findViewById(R.id.appx_banner_container);
            bannerContainer.addView((View)objmBannerView);


            Method  mloadAD = mBannerView.getMethod("loadAD");
            mloadAD.setAccessible(true);
            mloadAD.invoke(objmBannerView);

        } catch (Exception e) {
            e.printStackTrace();
            Log.i("logg","出错==="+e.toString());
        }

    }


}
