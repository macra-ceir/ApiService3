///*
// * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
// * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
// */
//package com.gl.ceir.config.util;
//
//import java.lang.reflect.Field;
//import java.util.LinkedHashMap;
//import org.json.JSONObject;
//
//
///**
// *
// * @author maverick
// */
//public class Tester {
//
//    public static void maisdsn(String[] args) {
//
//        JSONObject item = new JSONObject();
//
//        try {
//            Field map = item.getClass().getDeclaredField("map");
//            map.setAccessible(true);//because the field is private final...
//            map.set(item, new LinkedHashMap<>());
//            map.setAccessible(false);//return flag
//
//        } catch (Exception e) {
//            System.out.println("error1--->" + e.getLocalizedMessage());
//            System.out.println("error2--->" + e.getMessage());
//        }
//
//        item.put("one", "11");
//        item.put("two", "222");
//        item.put("three", "3");
//        item.put("four", "4");
//        item.put("five", "555");
//        item.put("six", "666");
//
//        System.out.println("--->" + item.toString());
//
//    }
//
//}
