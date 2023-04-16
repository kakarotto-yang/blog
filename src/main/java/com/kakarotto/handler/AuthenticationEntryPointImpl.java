package com.kakarotto.handler;

import com.alibaba.fastjson.JSON;
import com.kakarotto.common.result.Result;
import com.kakarotto.common.result.ResultCodeEnum;
import com.kakarotto.common.util.WebUtils;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @Author 三更  B站： https://space.bilibili.com/663528522
 */
@Component
public class AuthenticationEntryPointImpl implements AuthenticationEntryPoint {
    @Override
    public void commence(HttpServletRequest request, HttpServletResponse response, AuthenticationException authException) throws IOException, ServletException {
        Result result = Result.build(null,ResultCodeEnum.UNAUTHORIZED);
        String json = JSON.toJSONString(result);
        WebUtils.renderString(response,json);
    }
}


