package com.chunyang.stu;

import org.junit.jupiter.api.Test;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.spec.SecretKeySpec;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;

public class DESEncryptionDemo {


    @Test
    void DESTest() throws NoSuchPaddingException, NoSuchAlgorithmException, InvalidKeyException, IllegalBlockSizeException, BadPaddingException {

        // 原文
        String input = "华为";
        // des加密必须是8位
        String key = "12345678";
        // 算法
        String algorithm = "DES";
        String transformation = "DES";
        // Cipher：密码，获取加密对象
        // transformation:参数表示使用什么类型加密
        Cipher cipher = Cipher.getInstance(transformation);

        // 指定秘钥规则
        // 第一个参数表示：密钥，key的字节数组
        // 第二个参数表示：算法
        SecretKeySpec sks = new SecretKeySpec(key.getBytes(), algorithm);

        // 对加密进行初始化
        // 第一个参数：表示模式，有加密模式和解密模式
        // 第二个参数：表示秘钥规则
        cipher.init(Cipher.ENCRYPT_MODE,sks);

        // 进行加密
        byte[] bytes = cipher.doFinal(input.getBytes());
        // 打印字节，因为ascii码有负数，解析不出来，所以乱码
        for (byte b : bytes) {
            System.out.println(b);
        }


        // 打印密文
        //对数据进行base64编码处理
        String encode = Base64.getEncoder().encodeToString(bytes);

        System.out.println(new String(encode));
    }

    @Test
    void DESTest1() throws Exception {

        String input ="华为";
        // DES加密算法，key的大小必须是8个字节
        String key = "12345678";

        String transformation = "DES"; // 9PQXVUIhaaQ=
        // 指定获取密钥的算法
        String algorithm = "DES";
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
        // 获取加密对象
        Cipher cipher = Cipher.getInstance(transformation);
        // 创建加密规则
        // 第一个参数key的字节
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

//        System.out.println(encode);
        return encode;
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
        cipher.init(Cipher.DECRYPT_MODE, sks);
        // 3. 解密，上面使用的base64编码，下面直接用密文
        byte[] bytes = cipher.doFinal(Base64.getDecoder().decode(input));

//        System.out.println("解密" + new String(decode, "UTF-8"));
        //  因为是明文，所以直接返回
        return new String(bytes);
    }


}



