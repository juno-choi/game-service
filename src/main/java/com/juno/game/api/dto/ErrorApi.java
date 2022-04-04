package com.juno.game.api.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class ErrorApi {
    private String code;
    private String msg;
}
