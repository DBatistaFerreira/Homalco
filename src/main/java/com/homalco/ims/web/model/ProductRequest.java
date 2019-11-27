package com.homalco.ims.web.model;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;

@Getter
@Setter
public class ProductRequest {
        @NotBlank
        private String id;
}
