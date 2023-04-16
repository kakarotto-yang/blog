package com.kakarotto.service;

import com.kakarotto.common.result.Result;
import com.kakarotto.pojo.User;

public interface LoginServcie {
     Result login(User user);

    Result logout();
}
