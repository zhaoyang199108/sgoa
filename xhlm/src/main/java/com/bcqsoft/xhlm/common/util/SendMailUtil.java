package com.bcqsoft.xhlm.common.util;

import java.util.Date;
import java.util.Properties;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class SendMailUtil {
	public static final String HOST = "smtp.163.com";
    public static final String PROTOCOL = "smtp";   
    public static final int PORT = 25;
    public static final String FROM = "ly_1209@163.com";//发件人的email
    public static final String PWD = "gllf1209/*-+";//发件人密码
     
    /**
     * 获取Session
     * @return
     */
    private static Session getSession() {
        Properties props = new Properties();
        props.put("mail.smtp.host", HOST);//设置服务器地址
        props.put("mail.store.protocol" , PROTOCOL);//设置协议
        props.put("mail.smtp.port", PORT);//设置端口
        props.put("mail.smtp.auth" , true);
         
        Authenticator authenticator = new Authenticator() {
        	
        
 
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(FROM, PWD);
            }
             
        };
        Session session = Session.getInstance(props , authenticator);
        return session;
    }
     
    public static boolean send(String toEmail , String content) {
        Session session = getSession();
        boolean result = false;
        try {
            // Instantiate a message
            Message msg = new MimeMessage(session);
  
            //Set message attributes
            msg.setFrom(new InternetAddress(FROM));
            InternetAddress[] address = {new InternetAddress(toEmail)};
            msg.setRecipients(Message.RecipientType.TO, address);
            msg.setSubject("协会联盟密码重置邮件");
            msg.setSentDate(new Date());
            msg.setContent(content , "text/html;charset=utf-8");
  
            //Send the message
            Transport transport = session.getTransport("smtp");  
            transport.connect(HOST,PORT,FROM, PWD);  
            transport.sendMessage(msg, msg.getAllRecipients());//发送邮件,其中第二个参数是所有已设好的收件人地址  
            transport.close();
            result = true;
//            Transport.send(msg);
        }
        catch (MessagingException mex) {
            mex.printStackTrace();
            result = false;
        }
        return result;
    }
    
    public static void main(String[] args) {
    	StringBuffer sb=new StringBuffer("点击下面链接激活账号，48小时生效，否则重新注册账号，链接只能使用一次，请尽快激活！<br>");
        sb.append(PropertiesUtil.getWebappServerHost()+"/booking/jh_bookinguser.htm?loginId="); 
        sb.append("");
        sb.append("&email=");
        sb.append("ly1209@vip.qq.com");
        sb.append("&validateCode=");
        sb.append(MD5Util.toMd5("111"));
        sb.append("");
        //发送邮件
        SendMailUtil.send("ly1209@vip.qq.com", sb.toString());
        
//        HtmlEmail semail = new HtmlEmail();
//        semail.setFrom("kcjktj@163.com", "subject");
//        semail.setCharset("utf-8");
//        semail.setHostName("smtp.163.com");
//        semail.setAuthentication("kcjktj","1qaz2wsx");
//        semail.setSubject("ssss");
//        semail.setHtmlMsg(sb.toString());
//        semail.addTo("ly_1209@163.com");
    }
}
