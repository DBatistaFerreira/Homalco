package com.homalco.ims.web.model;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;

@Getter
@Setter
public class AccountRequest{

    @NotBlank
    private String username;

    @NotBlank
    private String password;
}
