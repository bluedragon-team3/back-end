package com.example.cau.bluedragon.exception;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Builder
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class ConstraintExceptionDto<T> {
    private Integer code;
    private String message;
    private String timestamp;
    private T data;
}
