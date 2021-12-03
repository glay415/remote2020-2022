package com.example.errortest.entity;

import com.example.errortest.apiTest.ApplePayload;
import com.example.errortest.entity.precedence.Phone;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity
@DiscriminatorValue(value = "APPLE")
public class Apple extends Phone {

    private String mac;

    private String logo;

    public Apple(ApplePayload applePayload) {
        this.mac = applePayload.getMac();
        this.logo = applePayload.getLogo();
        super.setProfile(applePayload.getProfile());
    }
}
