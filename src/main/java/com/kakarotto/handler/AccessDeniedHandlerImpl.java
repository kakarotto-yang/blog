package com.kakarotto.handler;

import com.alibaba.fastjson.JSON;
import com.kakarotto.common.result.Result;
import com.kakarotto.common.result.ResultCodeEnum;
import com.kakarotto.common.util.WebUtils;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.web.access.AccessDeniedHandler;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Component
public class AccessDeniedHandlerImpl implements AccessDeniedHandler {
    @Override
    public void handle(HttpServletRequest request, HttpServletResponse response, AccessDeniedException accessDeniedException) throws IOException, ServletException {
        Result result = Result.build(null,ResultCodeEnum.FORBIDDEN);
        String json = JSON.toJSONString(result);
        WebUtils.renderString(response,json);

    }
}


