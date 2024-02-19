package com.chunyang.stu.util;

import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;
import java.security.SecureRandom;
import java.util.Base64;

    public class AESUtils {

        private static final String AES_ALGORITHM = "AES";
        private static final String DEFAULT_CIPHER_ALGORITHM = "AES/ECB/PKCS5Padding"; // 默认的加密算法

        /**
         * 生成AES密钥
         *
         * @return AES密钥
         * @throws Exception
         */
        public static SecretKey generateKey() throws Exception {
            KeyGenerator keyGenerator = KeyGenerator.getInstance(AES_ALGORITHM);
            SecureRandom secureRandom = SecureRandom.getInstance("SHA1PRNG");
            secureRandom.setSeed("AESKey".getBytes());
            keyGenerator.init(128, secureRandom); // 128位密钥
            return keyGenerator.generateKey();
        }

        /**
         * 加密字符串
         *
         * @param content 待加密内容
         * @param key     密钥
         * @return 加密后的字符串
         * @throws Exception
         */
        public static String encrypt(String content, SecretKey key) throws Exception {
            Cipher cipher = Cipher.getInstance(DEFAULT_CIPHER_ALGORITHM);
            cipher.init(Cipher.ENCRYPT_MODE, key);
            byte[] encryptedBytes = cipher.doFinal(content.getBytes());
            return Base64.getEncoder().encodeToString(encryptedBytes);
        }

        /**
         * 解密字符串
         *
         * @param content 待解密内容
         * @param key     密钥
         * @return 解密后的字符串
         * @throws Exception
         */
        public static String decrypt(String content, SecretKey key) throws Exception {
            Cipher cipher = Cipher.getInstance(DEFAULT_CIPHER_ALGORITHM);
            cipher.init(Cipher.DECRYPT_MODE, key);
            byte[] decryptedBytes = cipher.doFinal(Base64.getDecoder().decode(content));
            return new String(decryptedBytes);
        }

        public static void main(String[] args) throws Exception {
            // 生成密钥
            SecretKey key = generateKey();

            // 加密测试
            String originalText = "Hello, AES!";
            String encryptedText = encrypt(originalText, key);
            System.out.println("加密后: " + encryptedText);

            // 解密测试
            String decryptedText = decrypt(encryptedText, key);
            System.out.println("解密后: " + decryptedText);
        }
    }
