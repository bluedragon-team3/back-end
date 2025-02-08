package com.example.cau.bluedragon.exception.handler;


import com.example.cau.bluedragon.apiPayloadd.code.BaseErrorCode;
import com.example.cau.bluedragon.exception.GeneralException;

public class GeneralExceptionHandler extends GeneralException {

    public GeneralExceptionHandler(BaseErrorCode code) {
        super(code);
    }
}
