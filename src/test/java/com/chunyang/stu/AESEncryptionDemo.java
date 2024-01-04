package com.chunyang.stu;


import org.junit.jupiter.api.Test;

import javax.crypto.*;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import java.nio.charset.StandardCharsets;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;

public class AESEncryptionDemo {


    @Test
    void DESTest1() throws Exception {

        String input ="111111";
        // DES加密算法，key的大小必须是8个字节
        String key = "12345678";

        String transformation = "DES/ECB/PKCS5Padding";    //填充
       // String transformation = "DES/CBC/NoPadding"; // 9PQXVUIhaaQ=       指定参数8位

        // 指定获取密钥的算法
        String algorithm = "DES";
        String encryptDES = encryptDES(input, key, transformation, algorithm);
        System.out.println("加密:" + encryptDES);
        String s = decryptDES(encryptDES, key, transformation, algorithm);
        System.out.println("解密:" + s);
    }

    @Test
    void AESTest1() throws Exception {

        String input ="华为";
        // DES加密算法，key的大小必须是8个字节
        String key = "1234567812345678";

        String transformation = "AES/ECB/PKCS5Padding "; //填充位数
        //String transformation = " AES/CBC/NoPadding "; //指定位数

        // 指定获取密钥的算法
        String algorithm = "AES";
        String encryptDES = encryptDES(input, key, transformation, algorithm);
        System.out.println("加密:" + encryptDES);
        String s = decryptDES(encryptDES, key, transformation, algorithm);
        System.out.println("解密:" + s);
    }


    /**
     * 使用DES加密数据
     *
     * @param input          : 原文
     * @param key            : 密钥(DES,密钥的长度必须是8个字节)
     * @param transformation : 获取Cipher对象的算法
     * @param algorithm      : 获取密钥的算法
     * @return : 密文
     * @throws Exception
     */
    private static String encryptDES(String input, String key, String transformation, String algorithm) throws Exception {
        //获取加密对象
        Cipher cipher = Cipher.getInstance(transformation);
        // 创建加密规则
        // 第一个参数key的字节d
        // 第二个参数表示加密算法
        SecretKeySpec sks = new SecretKeySpec(key.getBytes(), algorithm);
        // ENCRYPT_MODE：加密模式
        // DECRYPT_MODE: 解密模式

        // 初始化加密模式和算法
        cipher.init(Cipher.ENCRYPT_MODE,sks);
        // 加密
        byte[] bytes = cipher.doFinal(input.getBytes());

        // 输出加密后的数据
        String encode = new String(Base64.getEncoder().encode(bytes), "UTF-8");

        return  encode;

    }

    /**
     * 使用DES解密
     *
     * @param input          : 密文
     * @param key            : 密钥
     * @param transformation : 获取Cipher对象的算法
     * @param algorithm      : 获取密钥的算法
     * @throws Exception
     * @return: 原文
     */
    private static String decryptDES(String input, String key, String transformation, String algorithm) throws Exception {
        // 1,获取Cipher对象
        Cipher cipher = Cipher.getInstance(transformation);
        // 指定密钥规则
        SecretKeySpec sks = new SecretKeySpec(key.getBytes(), algorithm);



        // 初始化加密模式和算法  Cipher.ENCRYPT_MODE   Cipher.DECRYPT_MODE
        cipher.init(Cipher.DECRYPT_MODE,sks);


        // 初始向量，参数表示跟谁进行异或，初始向量的长度必须是8位       //CEC 需要使用向量
        //  IvParameterSpec iv = new IvParameterSpec(key.getBytes());
        // cipher.init(Cipher.ENCRYPT_MODE,sks,iv);

        // 3. 解密，上面使用的base64编码，下面直接用密文
        byte[] bytes = cipher.doFinal(Base64.getDecoder().decode(input));

        //  因为是明文，所以直接返回
        return new String(bytes);

    }


}
