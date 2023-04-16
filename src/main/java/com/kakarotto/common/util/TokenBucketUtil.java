package com.kakarotto.common.util;

import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.BoundValueOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;

@Component
public class TokenBucketUtil {
    @Autowired
    private RedisUtil redisUtil;

    /**
     * 令牌桶算法实现，用于限制请求速率
     * @param key 令牌的键
     * @param capacity 令牌的容量
     * @param rate 令牌的速率，单位：每秒生成几个令牌
     * @return true表示可以获得令牌，false表示没有令牌可用
     */
    public boolean getToken(String key,long capcity, double rate) {
        // 当前毫秒
        long millisTime = System.currentTimeMillis();
        Bucke bucke = redisUtil.getCacheObject(key);
        if (bucke == null){
            bucke = new Bucke();
            bucke.setTokens(capcity);
            bucke.setLastTime(millisTime);
            redisUtil.setCacheObject(key,bucke);
        }
        // 两次请求的间隔，单位是毫秒
        long time = (millisTime - bucke.lastTime);
        // 当前桶中的令牌数
        long oo = (long) (bucke.tokens + time * rate/1000);
        long o = (long) (time/1000 * rate);
        bucke.tokens = (long) Math.min(capcity, bucke.tokens + time * rate/1000);
        bucke.lastTime = millisTime;

        if (bucke.tokens == 0) {
            // 没有令牌拿
            return false;
        }
        // 拿走一块令牌
        --bucke.tokens;
        redisUtil.setCacheObject(key,bucke);
        return true;
    }

}
@Data
class Bucke{
    long tokens; // 当前桶中令牌数量
    // 记录上次统计时间的毫秒
    long lastTime = System.currentTimeMillis();
}