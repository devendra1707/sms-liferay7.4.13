package com.armantec.lms.common.util.services.service.impl;


import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.Socket;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLEncoder;
import java.security.SecureRandom;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLEngine;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509ExtendedTrustManager;

public class SMSUtil {
  public static String send(String mobileNo, String message) {
    TrustManager[] trustAllCerts = { new X509ExtendedTrustManager() {
          public X509Certificate[] getAcceptedIssuers() {
            return null;
          }
          
          public void checkClientTrusted(X509Certificate[] certs, String authType) {}
          
          public void checkServerTrusted(X509Certificate[] certs, String authType) {}
          
          public void checkClientTrusted(X509Certificate[] arg0, String arg1, Socket arg2) throws CertificateException {}
          
          public void checkClientTrusted(X509Certificate[] arg0, String arg1, SSLEngine arg2) throws CertificateException {}
          
          public void checkServerTrusted(X509Certificate[] arg0, String arg1, Socket arg2) throws CertificateException {}
          
          public void checkServerTrusted(X509Certificate[] arg0, String arg1, SSLEngine arg2) throws CertificateException {}
        } };
    try {
      SSLContext sc = SSLContext.getInstance("SSL");
      sc.init(null, trustAllCerts, new SecureRandom());
      HttpsURLConnection.setDefaultSSLSocketFactory(sc.getSocketFactory());
    } catch (Exception exception) {}
    try {
      String baseURL = "https://smsgw.sms.gov.in/failsafe/HttpLink?username=niipspi.otp&pin=O1@tY6$pQ0&";
      String replyTo = "SPIDII";
      String recipient = mobileNo;
      String messageBody = message;
      messageBody = URLEncoder.encode(messageBody, "UTF-8");
      StringBuffer URI = new StringBuffer();
      URI.append(baseURL);
      URI.append("signature=" + replyTo);
      URI.append("&mnumber=" + recipient);
      URI.append("&message=" + messageBody);
      URI.append("&dlt_entity_id=1101576000000029323");
      URI.append("&dlt_template_id=1107160273684262555");
      
      String result = "";
      URL url = new URL(URI.toString());
      URLConnection conn = url.openConnection();
      BufferedReader rd = new BufferedReader(new InputStreamReader(conn.getInputStream()));
      StringBuffer sb = new StringBuffer();
      String line;
      while ((line = rd.readLine()) != null)
        sb.append(line); 
      rd.close();
      result = sb.toString();
      System.out.println("Result:" + result);
      return result;
    } catch (Exception e) {
      e.printStackTrace();
      return "Failed";
    } 
  }
}