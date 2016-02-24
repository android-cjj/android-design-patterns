package com.cjj.pattern.builder;

/**
 * Created by cjj on 2016/2/23.
 */
public class DemoTest {

    public static void main(String agrs[]){
        Ninja naruto  = new Ninja.NinjaBuilder().withName("鸣人").withAge(13).withSex(0).withHeight(173).withLevel(1).withLike("吃拉面").build();
        System.out.printf(naruto.toString());

        Ninja zuozu = new Ninja.NinjaBuilder().withName("佐助").withAge(14).withSex(0).withHeight(174).withLevel(1).withLike("装逼").build();
        System.out.printf(zuozu.toString());

        Ninja xiaoying = new Ninja.NinjaBuilder().withName("小樱").withAge(14).withSex(1).withHeight(170).withLevel(1).withLike("花痴").build();
        System.out.printf(xiaoying.toString());
    }
}
