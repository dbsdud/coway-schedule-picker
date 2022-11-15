package io.dbsdud.schedulepicker.proxy;

import io.dbsdud.schedulepicker.proxy.request.NotificationRequest;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import javax.validation.Valid;

@FeignClient(name = "notificationProxy", url = "http://localhost:8889/notification")
public interface NotificationProxy {

    @PostMapping(value = "/sendMail")
    String sendMail(@RequestBody @Valid NotificationRequest req);
}
