package com.chunyang.stu;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.JwtBuilder;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.junit.Test;

import java.util.Base64;
import java.util.Date;

public class JwtParser {
    /**
     * 创建令牌
     */
    @Test
    public void CreatToken() {
        // 创建令牌
        JwtBuilder jwt = Jwts.builder()
                .signWith(SignatureAlgorithm.HS256,"chunyang") // JWT头部,加密算法为HS256,盐是 sunmone (自定义)
                // 载荷部分 标准
                .setId("123456") // jti: jwt的唯一身份标识，主要用来作为一次性token,从而回避重放攻击
                .setSubject("tom") // sub: jwt所面向的用户
                .setIssuer("Jack") // iss: jwt签发者d
                .setIssuedAt(new Date()) // iat: jwt的签发时间
                .setExpiration(new Date(System.currentTimeMillis() + (1000 * 60)))// exp: jwt的过期时间 一分钟
                // 载荷部分 自定义
                .claim("name","Rose")
                .claim("admin",true);
        // 使用 compact 方法生成 Token
        String token = jwt.compact();
        // Base64编码
        String encodedString = Base64.getEncoder().encodeToString(token.getBytes());

        // 输出 token
        System.out.println("Base64加密前："+token);
        System.out.println("Base64加密后："+encodedString);
    }
    /**
     * 解析令牌
     */
    @Test
    public void AnalysisToken(){
        // 复制上面创建的令牌 如果token超过有效期,那么解析会报错
        String token = "eyJhbGciOiJIUzI1NiJ9.eyJqdGkiOiI4ODg4ODgiLCJzdWIiOiJjaHVueWFuZyIsImlzcyI6ImNoaW5hIiwiaWF0IjoxNzA0MjczNTY5LCJleHAiOjE3MDQyNzM4NjksIm5hbWUiOiJSb3NlIiwiYWRtaW4iOnRydWV9.ZN2wjn9SmiOgc-LPuFvabsTdqxRYHIdWLadIpDt7zmk";
        // setSigningKey("sunmone") 把盐告知jwt , parseClaimsJws(token) 再把生成的token告知 就可以解密了
        Claims claims = Jwts.parser().setSigningKey("chunyang").parseClaimsJws(token).getBody();
        // 输出解析后的token
        System.out.println("jti :" + claims.getId()); // 唯一身份标识
        System.out.println("sub :" + claims.getSubject()); // 用户名高
        System.out.println("iss :" + claims.getIssuer()); // 签发者
        System.out.println("iat :" + claims.getIssuedAt().toLocaleString()); // 签发时间
        System.out.println("exp :" + claims.getExpiration().toLocaleString()); // 过期时间
        // 输出自定义部分载荷
        System.out.println("name :" + claims.get("name"));
        System.out.println("admin :" + claims.get("admin"));

    }


    @Test
    public void CurrentTimestampExample(){

        // 创建一个新的Date对象，表示当前日期和时间
        Date now = new Date();

        long currentTimestamp  = now.getTime();

        String ScurrentTimestamp = String.valueOf(currentTimestamp);

        // 计算5分钟后的时间戳
        long fiveMinutesLaterTimestamp = currentTimestamp  + 5 * 60 * 1000;

        String SfiveMinutesLaterTimestamp = String.valueOf(fiveMinutesLaterTimestamp);

        // 输出当前时间的时间戳
        System.out.println("Current Timestamp: " + ScurrentTimestamp.substring(0,10));

        // 输出5分钟后的时间戳
        System.out.println("Timestamp 5 minutes later: " + SfiveMinutesLaterTimestamp.substring(0,10));
    }

}
