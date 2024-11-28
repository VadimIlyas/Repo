package com.client.unibell.controller;

import com.client.unibell.model.Type;
import lombok.Data;
import org.antlr.v4.runtime.misc.NotNull;

@Data
public class SaveContactRequest {
    @NotNull
    private Long clientId;
    @NotNull
    private Type contactType;
    @NotNull
    private String contactValue;
}
