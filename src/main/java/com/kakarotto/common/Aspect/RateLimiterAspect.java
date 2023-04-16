package com.kakarotto.common.Aspect;

import com.kakarotto.common.annotation.RateLimit;
import com.kakarotto.common.exception.CFException;
import com.kakarotto.common.result.ResultCodeEnum;
import com.kakarotto.common.util.TokenBucketUtil;
import com.kakarotto.pojo.LoginUser;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;

@Component
@Aspect
public class RateLimiterAspect {

    @Autowired
    private TokenBucketUtil tokenBucketUtil;

    // 限流规则：
    // 如果用户未登录，则使用接口名字和ip作为key限流
    // 如果用户已经登录，则使用用户id和接口名字和IP限流
    @Around("@annotation(rateLimit)")
    public Object rateLimit(ProceedingJoinPoint joinPoint, RateLimit rateLimit) throws Throwable {
        String key;
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (authentication != null && authentication.isAuthenticated()) {
            LoginUser loginUser = (LoginUser) authentication.getPrincipal();
            key =loginUser.getUser().getId().toString()+joinPoint.getSignature().toString();
        }

        else {
            // 如果没有没有登录，则使用方法名作为key
            key = joinPoint.getSignature().toString();
        }
        // 如果设置了记录IP，则加上IP地址作为key的一部分
        if (rateLimit.recordIp()) {
            String ip = getIpAddress();
            key = ip + ":" + key;
        }
        if (tokenBucketUtil.getToken(key,rateLimit.capacity(),rateLimit.permitsPerSecond())) {
            return joinPoint.proceed();
        } else {
            // 抛出请求频繁错误
            throw new CFException(ResultCodeEnum.FREQUENT_REQUESTS);
        }
    }

    /**
     * 获取请求来源的IP地址
     */
    private String getIpAddress() {
        HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
        String ip = request.getHeader("X-Real-IP");
        if (StringUtils.isEmpty(ip) || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("X-Forwarded-For");
        }
        if (StringUtils.isEmpty(ip) || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("Proxy-Client-IP");
        }
        if (StringUtils.isEmpty(ip) || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("WL-Proxy-Client-IP");
        }
        if (StringUtils.isEmpty(ip) || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("HTTP_CLIENT_IP");
        }
        if (StringUtils.isEmpty(ip) || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("HTTP_X_FORWARDED_FOR");
        }
        if (StringUtils.isEmpty(ip) || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getRemoteAddr();
        }
        return ip;
    }
}
