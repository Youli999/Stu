package com.chunyang.stu.util;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.JwtBuilder;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import java.util.Date;

public class JwtUtils {

    private static final String SECRET_KEY = "chunyang"; // 密钥，应该在生产环境中使用更安全的密钥管理方式

    /**
     * 创建JWT令牌
     *
     * @param subject    主体，通常是用户名
     * @param issuer     签发者
     * @param expiration  过期时间，单位为秒
     * @return JWT令牌
     */
    public static String createToken(String subject, String issuer, long expiration) {
        JwtBuilder jwt = Jwts.builder()
                .setSubject(subject) // 设置主体
                .setIssuer(issuer) // 设置签发者
                .setIssuedAt(new Date()) // 设置签发时间
                .setExpiration(new Date(System.currentTimeMillis() + expiration * 1000)) // 设置过期时间
                .signWith(SignatureAlgorithm.HS256, SECRET_KEY); // 使用HS256算法和密钥签名

        // 添加自定义声明
        jwt.claim("name", "Rose")
                .claim("admin", true);

        return jwt.compact();
    }

    /**
     * 解析JWT令牌
     *
     * @param token JWT令牌
     * @return Claims对象，包含令牌中的信息
     */
    public static Claims parseToken(String token) {
        return Jwts.parser().setSigningKey(SECRET_KEY).parseClaimsJws(token).getBody();
    }

    public static void main(String[] args) {
        // 创建令牌
        String token = createToken("tom", "Jack", 60); // 设置过期时间为1分钟
        System.out.println("Token: " + token);

        // 解析令牌
        Claims claims = parseToken("e4MzM0NTI1LCJuYW1lIjoiUm9zZSIsImFkbWluIjp0cnVlfQ.66QXCf9OrurqLN81mnu4MpAZVtZ7iUZXo6hxbuLxSTQ");
        System.out.println("Subject: " + claims.getSubject());
        System.out.println("Issuer: " + claims.getIssuer());
        System.out.println("Expiration: " + claims.getExpiration());
        System.out.println("Name: " + claims.get("name"));
        System.out.println("Admin: " + claims.get("admin"));
    }

}
