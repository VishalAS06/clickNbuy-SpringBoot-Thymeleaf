
package com.example.clickNbuy.util;
import com.twilio.rest.verify.v2.service.Verification;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;

import com.twilio.Twilio;
import com.twilio.rest.api.v2010.account.Message;
import com.twilio.type.PhoneNumber;

import jakarta.mail.internet.MimeMessage;

@Service
public class OtpSender {

    @Autowired
    JavaMailSender mailSender;

    @Autowired
    TemplateEngine templateEngine;

    public void sendOtpThruEmail(String email, int otp, String name) {
        try {
            MimeMessage message = mailSender.createMimeMessage();
            MimeMessageHelper helper =
                    new MimeMessageHelper(message, true, "UTF-8");

            helper.setFrom("noreply@clicknbuy.com", "Clicknbuy");
            helper.setTo(email);
            helper.setSubject("OTP for Creating Account with ClickNBuy");

            Context context = new Context();
            context.setVariable("name", name);
            context.setVariable("otp", otp);

            String emailMessage = templateEngine.process(
                    "email-template.html", context);

            helper.setText(emailMessage, true);
            mailSender.send(message);

        } catch (Exception e) {
            throw new IllegalStateException(
                    "Failed to send OTP email", e);
        }
    }

    public void sendOtpThruMobile(Long mobile, int otp, String name) {

        String accountSid = System.getenv("TWILIO_ACCOUNT_SID");
        String authToken = System.getenv("TWILIO_AUTH_TOKEN");
        String serviceSid = System.getenv("TWILIO_VERIFY_SERVICE_SID");

        if (accountSid == null || authToken == null || serviceSid == null) {
            throw new IllegalStateException(
                    "Twilio environment variables are missing");
        }

        Twilio.init(accountSid, authToken);

        String phoneNumber = "+91" + mobile;

        try {
            Verification.creator(serviceSid, phoneNumber, "sms").create();
        } catch (com.twilio.exception.ApiException e) {
            System.err.println("Twilio error code: " + e.getCode());
            System.err.println("Twilio error message: " + e.getMessage());
            throw e;
        }
    }
}
