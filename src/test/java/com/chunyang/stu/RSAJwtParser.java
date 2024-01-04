import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jws;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.junit.Test;

import java.security.*;
import java.util.Base64;

public class RSAJwtParser {
    @Test
    public void CreatToken() throws NoSuchAlgorithmException {
        // 生成RSA密钥对
        KeyPairGenerator keyPairGenerator = KeyPairGenerator.getInstance("RSA");
        keyPairGenerator.initialize(2048);
        KeyPair keyPair = keyPairGenerator.generateKeyPair();
        PublicKey publicKey = keyPair.getPublic();
        PrivateKey privateKey = keyPair.getPrivate();

        System.out.println("公钥: " + Base64.getEncoder().encodeToString(publicKey.getEncoded()));
        System.out.println("私钥: " + Base64.getEncoder().encodeToString(privateKey.getEncoded()));

        // JWT的头部
        String header = "{\"alg\":\"RS256\",\"typ\":\"JWT\"}";

        // JWT的载荷
        String payload = "{\"sub\":\"1234567890\",\"name\":\"John Doe\",\"iat\":" + System.currentTimeMillis() + "}";

        // 使用私钥签名JWT
        String jwt = Jwts.builder()
                .setHeaderParam("header", header) // 添加头部信息
                .setPayload(payload)
                .signWith(SignatureAlgorithm.RS256, privateKey)
                .compact();

        // 输出JWT
        System.out.println("JWT: " + jwt);

        // 使用公钥验证JWT
        Jws<Claims> claimsJws = Jwts.parser().setSigningKey(publicKey).parseClaimsJws(jwt);
        String parsedPayload = claimsJws.getBody().toString();
        System.out.println("JWT 载荷内容：" + parsedPayload);
    }
}
