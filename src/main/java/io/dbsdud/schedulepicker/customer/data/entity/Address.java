package io.dbsdud.schedulepicker.customer.data.entity;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Embeddable;
import javax.validation.constraints.NotEmpty;

@Getter
@Embeddable
@NoArgsConstructor
public class Address {

    @NotEmpty
    private String address1;
    @NotEmpty
    private String address2;

    @Builder
    public Address(String address1, String address2) {
        this.address1 = address1;
        this.address2 = address2;
    }
}
