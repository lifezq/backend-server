package com.dpi.server.handler;

import com.alibaba.fastjson2.JSON;
import com.dpi.server.dto.ResponseDto;
import com.dpi.server.enums.CommonEnum;
import com.dpi.server.enums.ErrorCodeEnum;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @Package com.dpi.server.handler
 * @ClassName CustomAuthenticationFailureHandler
 * @Description TODO
 * @Author Ryan
 * @Date 2022/12/23
 */
public class CustomAuthenticationFailureHandler implements AuthenticationFailureHandler {
    @Override
    public void onAuthenticationFailure(HttpServletRequest request,
                                        HttpServletResponse response,
                                        AuthenticationException exception) throws IOException, ServletException {

        response.setStatus(HttpStatus.FORBIDDEN.value());

        ResponseDto responseDto = ResponseDto.builder()
                .code(HttpStatus.FORBIDDEN.value())
                .message(HttpStatus.FORBIDDEN.toString())
                .userMessage(ErrorCodeEnum.ERROR_CODE_FORBIDDEN.getDesc()).build();
        response.setHeader(CommonEnum.MEDIA_TYPE_APPLICATION_JSON.getName(),
                CommonEnum.MEDIA_TYPE_APPLICATION_JSON.getValue());
        response.getWriter().write(JSON.toJSONString(responseDto));
    }
}
