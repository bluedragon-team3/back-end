package com.example.cau.bluedragon.exception;

import com.example.cau.bluedragon.apiPayloadd.code.BaseErrorCode;
import com.example.cau.bluedragon.apiPayloadd.code.ErrorReasonDto;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class GeneralException extends RuntimeException {

    private BaseErrorCode code;

    public ErrorReasonDto getErrorReason() {
        return this.code.getReason();
    }

    public ErrorReasonDto getErrorReasonHttpStatus() {
        return this.code.getReasonHttpStatus();
    }
}
