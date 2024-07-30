package com.java.metaclassroom.common.exception;

import com.java.metaclassroom.common.ApiResult;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ApiExceptionAdvice {
    @ExceptionHandler({ApiException.class})
    public ResponseEntity<ApiResult> exceptionHandler(HttpServletRequest request,
                                                      final ApiException e) {

        ApiExceptionEntity apiExceptionEntity = new ApiExceptionEntity(e);

        return ResponseEntity.status(e.getError().getStatus())
                .body(new ApiResult("error", "api", apiExceptionEntity));
    }

    @ExceptionHandler({RuntimeException.class})
    public ResponseEntity<ApiResult> exceptionHandler(HttpServletRequest request,
                                                      final RuntimeException e) {

        ApiExceptionEntity apiExceptionEntity = new ApiExceptionEntity(e);

        e.printStackTrace();

        return ResponseEntity
                .status(ExceptionData.RUNTIME_EXCEPTION.getStatus())
                .body(new ApiResult("error", "runtime", apiExceptionEntity));
    }

    @ExceptionHandler({Exception.class})
    public ResponseEntity<ApiResult> exceptionHandler(HttpServletRequest request, Exception e) {

        ApiExceptionEntity apiExceptionEntity = new ApiExceptionEntity(e);

        return ResponseEntity
                .status(ExceptionData.INTERNAL_SERVER_EXCEPTION.getStatus())
                .body(new ApiResult("error", "", apiExceptionEntity));
    }
}
