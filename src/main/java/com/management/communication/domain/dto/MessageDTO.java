package com.management.communication.domain.dto;

import lombok.*;

import java.io.Serializable;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class MessageDTO implements Serializable {

    private String email;
    private String name;
    private String orderID;
    private String status;

}
