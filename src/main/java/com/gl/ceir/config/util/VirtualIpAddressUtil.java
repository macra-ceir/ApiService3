/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.gl.ceir.config.util;

import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.net.UnknownHostException;
import java.util.Enumeration;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Service;

@Service
public class VirtualIpAddressUtil {

    private final Logger log = LogManager.getLogger(VirtualIpAddressUtil.class);

    public String getVirtualIp() {
        String vip = null;
        try {
            Enumeration<NetworkInterface> networkInterfaces = NetworkInterface.getNetworkInterfaces();
            while (networkInterfaces.hasMoreElements()) {
                NetworkInterface networkInterface = networkInterfaces.nextElement();
                Enumeration<InetAddress> inetAddresses = networkInterface.getInetAddresses();

                while (inetAddresses.hasMoreElements()) {
                    InetAddress inetAddress = inetAddresses.nextElement();

                    if (!inetAddress.isLoopbackAddress() && !inetAddress.isLinkLocalAddress() && !inetAddress.isSiteLocalAddress()) {
                        log.info("Virtual IP Address: " + inetAddress.getHostAddress());
                        vip = inetAddress.getHostAddress();
                    }
                }
            }
            return vip;
        } catch (Exception e) {
            log.error("" + e);
            e.printStackTrace();
        }
        return vip;
    }

    public void getFullList() {
        try {
            InetAddress localhost = InetAddress.getLocalHost();
            log.info(" IP Addr: " + localhost.getHostAddress());
            // Just in case this host has multiple IP addresses....
            InetAddress[] allMyIps = InetAddress.getAllByName(localhost.getCanonicalHostName());
            if (allMyIps != null && allMyIps.length > 1) {
                log.info(" Full list of IP addresses:");
                for (int i = 0; i < allMyIps.length; i++) {
                    log.info(" List 1    " + allMyIps[i]);
                }
            }
        } catch (UnknownHostException e) {
            log.info(" (error retrieving server host name) " + e);
        }

        try {
            log.info("Full list of Network Interfaces:");
            for (Enumeration<NetworkInterface> en = NetworkInterface.getNetworkInterfaces();
                    en.hasMoreElements();) {
                NetworkInterface intf = en.nextElement();
                log.info("    " + intf.getName() + " " + intf.getDisplayName());
                for (Enumeration<InetAddress> enumIpAddr = intf.getInetAddresses();
                        enumIpAddr.hasMoreElements();) {
                    log.info("   List 2     " + enumIpAddr.nextElement().toString());
                }
            }
        } catch (SocketException e) {
            log.info(" (error retrieving network interface list)" + e);
        }

    }

}
