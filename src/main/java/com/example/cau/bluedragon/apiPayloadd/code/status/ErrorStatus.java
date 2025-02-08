package com.example.cau.bluedragon.apiPayloadd.code.status;

import com.example.cau.bluedragon.apiPayloadd.code.BaseErrorCode;
import com.example.cau.bluedragon.apiPayloadd.code.ErrorReasonDto;
import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
@AllArgsConstructor
public enum ErrorStatus implements BaseErrorCode {
  // Common Error
  _INTERNAL_SERVER_ERROR(HttpStatus.INTERNAL_SERVER_ERROR, 500, "서버 에러, 관리자에게 문의 바랍니다."),
  _BAD_REQUEST(HttpStatus.BAD_REQUEST,400,"잘못된 요청입니다."),
  _UNAUTHORIZED(HttpStatus.UNAUTHORIZED,401,"인증이 필요합니다."),
  _FORBIDDEN(HttpStatus.FORBIDDEN, 403, "금지된 요청입니다."),

  // User Error
  USER_NOT_FOUND(HttpStatus.BAD_REQUEST, 4001, "사용자가 없습니다."),
  EMAIL_NOT_VAILD(HttpStatus.BAD_REQUEST, 4001, "중앙대학교 이메일이 아닙니다.")

  ;
  private final HttpStatus httpStatus;
  private final Integer code;
  private final String message;

  @Override
  public ErrorReasonDto getReason() {
    return ErrorReasonDto.builder()
        .code(code)
        .message(message)
        .build();
  }

  @Override
  public ErrorReasonDto getReasonHttpStatus() {
    return ErrorReasonDto.builder()
        .message(message)
        .code(code)
        .httpStatus(httpStatus)
        .build();
  }
}
