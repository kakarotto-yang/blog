package com.kakarotto.common.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

// 一个用户每一个接口默认的令牌数量是10，默认每秒生成一个令牌
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface RateLimit {
    double permitsPerSecond() default 1;
    long capacity() default 10;
    boolean recordIp() default true;
}
