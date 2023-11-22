package com.backend.service.user.account;

import java.util.Map;

public interface LoginService {
    //一般返回一个JSON

    Map<String,String> getToken(String username, String password);


}
