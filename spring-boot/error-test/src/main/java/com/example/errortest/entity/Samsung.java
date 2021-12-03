package com.example.errortest.entity;

import com.example.errortest.entity.precedence.Phone;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity
@DiscriminatorValue(value = "SAMSUNG")
public class Samsung extends Phone {

    private String size;

    private String camera;
}