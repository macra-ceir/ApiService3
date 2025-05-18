///*
// * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
// * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
// */
//package com.gl.ceir.config.security;
//
///**
// *
// * @author maverick
// */
//import org.springframework.security.web.authentication.preauth.AbstractPreAuthenticatedProcessingFilter;
//
//import javax.servlet.http.HttpServletRequest;
//
//public class HostHeaderValidationFilter extends AbstractPreAuthenticatedProcessingFilter {
//
//    @Override
//    protected Object getPreAuthenticatedPrincipal(HttpServletRequest request) {
//        String host = request.getHeader("Host");
//        System.out.println("Host Name " + host);
//        // Implement your validation logic here, e.g., check if the host is a valid hostname
//        // If it's invalid, you can return null or throw an exception
//        return host;
//    }
//
//    @Override
//    protected Object getPreAuthenticatedCredentials(HttpServletRequest request) {
//        return "N/A";
//    }
//}
