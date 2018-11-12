package com.gree.auth.utils;


import microsoft.exchange.webservices.data.core.ExchangeService;
import microsoft.exchange.webservices.data.core.enumeration.misc.ExchangeVersion;
import microsoft.exchange.webservices.data.core.exception.service.local.ServiceLocalException;
import microsoft.exchange.webservices.data.core.service.item.EmailMessage;
import microsoft.exchange.webservices.data.credential.ExchangeCredentials;
import microsoft.exchange.webservices.data.credential.WebCredentials;
import microsoft.exchange.webservices.data.property.complex.MessageBody;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.net.URI;
import java.net.URISyntaxException;

/**
 * Created by 260152(AWU) on 2018/11/12 11:45.
 */
public class MailUtils {
    private static Logger logger = LoggerFactory.getLogger(MailUtils.class);

    public static void sendOutlook(String subject, String body, String[] to, String[] fileNames) {
        ExchangeService service = new ExchangeService(ExchangeVersion.Exchange2010_SP2);
        try {
            String mailname = "";
            String mailpwd = "";
            String mailserver = "";
            ExchangeCredentials credentials = new WebCredentials(mailname, mailpwd);
            service.setCredentials(credentials);
            service.setUrl(new URI(mailserver));
            EmailMessage msg = new EmailMessage(service);
            msg.setSubject(subject);
            msg.setBody(MessageBody.getMessageBodyFromText(body));
            if (fileNames != null) {
                for (String fileName : fileNames) {
                    msg.getAttachments().addFileAttachment(fileName);
                }
            }
            if (to != null) {
                for (String s : to) {
                    msg.getToRecipients().add(s);
                }
            }
            msg.send();
        } catch (URISyntaxException e) {
            logger.error("邮件服务器地址错误");
            logger.error(e.toString());
            e.printStackTrace();
        } catch (ServiceLocalException e) {
            logger.error("邮件对象生成错误");
            logger.error(e.toString());
            e.printStackTrace();
        } catch (Exception e) {
            logger.error("发送邮件错误");
            logger.error(e.toString());
            e.printStackTrace();
        }
    }
}
