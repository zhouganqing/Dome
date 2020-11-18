package cn.zhougq;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.mail.MailMessage;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.test.context.junit4.SpringRunner;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.io.File;
import java.util.Properties;

@RunWith(SpringRunner.class)
@SpringBootTest
class EmailTests {

    @Autowired
    private JavaMailSenderImpl mailSender;

    //简单邮件发送
    @Test
    void sendEmail() {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setSubject("通知==我是标题");
        message.setText("我是内容");
        message.setTo("zhouganqing@163.com");
        message.setFrom("84374122@qq.com");

        /*Properties properties = new Properties();
        properties.setProperty("mail.smtp.auth", "true");//开启认证
        properties.setProperty("mail.debug", "true");//启用调试
        properties.setProperty("mail.smtp.timeout", "1000");//设置链接超时
        properties.setProperty("mail.smtp.port", "465");//设置端口
        properties.setProperty("mail.smtp.socketFactory.port", "465");//设置ssl端口
        properties.setProperty("mail.smtp.socketFactory.fallback", "false");
        properties.setProperty("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
        mailSender.setJavaMailProperties(properties);*/

        mailSender.send(message);
    }

    @Test
    void sendTextEmail() throws MessagingException {
        //复杂邮件发送
        MimeMessage mimeMessage = mailSender.createMimeMessage();
        //multipart :是否上传附件
        MimeMessageHelper messageHelper = new MimeMessageHelper(mimeMessage,true);
        messageHelper.setSubject("通知==我是标题");
        messageHelper.setText("<b>我是内容</b>");
        messageHelper.setTo("zhouganqing@163.com");
        messageHelper.setFrom("84374122@qq.com");

        //上传附件
        messageHelper.addAttachment("1.jpg",new File("D:\\1.jpg"));
        messageHelper.addAttachment("2.jpg",new File("D:\\2.jpg"));

        mailSender.send(mimeMessage);
    }

}
