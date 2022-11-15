package io.dbsdud.schedulepicker.proxy.request;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class MailRequest {

    private String date;
    private String time;
    private String mail;

}
