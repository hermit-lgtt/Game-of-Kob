package com.example.backend.consumer.utils;

import com.example.backend.utils.JwtUtil;
import io.jsonwebtoken.Claims;

public class JwtAuthentication {
<<<<<<< HEAD

    public static Integer getUserId(String token){
        Integer userId = -1;
        try{
            Claims claims = JwtUtil.parseJWT(token);
            userId = Integer.parseInt(claims.getSubject());
        }catch (Exception e){
=======
    public  static Integer getUserId(String token){
        int userId = -1;
        try {
            Claims claims = JwtUtil.parseJWT(token);
            userId = Integer.parseInt(claims.getSubject());
        } catch (Exception e) {
>>>>>>> 260afeb8ca2386dcc2576e9bfc82614b0417f529
            throw new RuntimeException(e);
        }
        return userId;
    }
}
