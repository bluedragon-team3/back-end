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
  USER_NOT_FOUND(HttpStatus.NOT_FOUND, 4001, "해당 ID를 가진 회원이 존재하지 않습니다."),
  EMAIL_NOT_VAILD(HttpStatus.BAD_REQUEST, 4002, "중앙대학교 이메일이 아닙니다."),
  USER_NOT_OWNER(HttpStatus.BAD_REQUEST, 4003, "소모임장이 아닙니다."),

  // Group Error
  GROUP_NOT_FOUND(HttpStatus.NOT_FOUND, 5001, "해당 소모임이 없습니다."),
  GROUP_ALREADY_ENDED(HttpStatus.BAD_REQUEST, 5002, "이미 종료된 소모임입니다."),


  // GroupUser Error
  GROUP_USER_ALREADY_PRESENT(HttpStatus.BAD_REQUEST, 6001, "이미 종료된 소모임입니다."),
  GROUP_USER_FULL(HttpStatus.BAD_REQUEST, 6002, "인원이 다 찼습니다.")

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
