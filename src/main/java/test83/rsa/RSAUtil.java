package test83.rsa;

import com.google.common.collect.ImmutableMap;
import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;

import javax.crypto.Cipher;
import java.io.ByteArrayOutputStream;
import java.security.*;
import java.security.interfaces.RSAPrivateKey;
import java.security.interfaces.RSAPublicKey;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;
import java.util.Map;

/**
 * 被加密后的内容都会变成乱码，适合加密文本内容？？？？，不适于url参数加密？？？
 * 加密 VS 签名？？？
 */

public class RSAUtil {
    public static final String KEY_ALGORITHM = "RSA";
    private static final String PUBLIC_KEY = "RSAPublicKey";
    private static final String PRIVATE_KEY = "RSAPrivateKey";
    public static final String SIGNATURE_ALGORITHM = "MD5withRSA";
    /**
     * RSA最大加密明文大小
     */
    private static final int MAX_ENCRYPT_BLOCK = 117;

    /**
     * RSA最大解密密文大小
     */
    private static final int MAX_DECRYPT_BLOCK = 128;

    public static Map<String, Object> initKey() throws Exception {
        KeyPairGenerator keyPairGen = KeyPairGenerator.getInstance(KEY_ALGORITHM);
        keyPairGen.initialize(1024);
        KeyPair keyPair = keyPairGen.generateKeyPair();
        RSAPublicKey publicKey = (RSAPublicKey) keyPair.getPublic();
        RSAPrivateKey privateKey = (RSAPrivateKey) keyPair.getPrivate();
        return ImmutableMap.of(PUBLIC_KEY, publicKey, PRIVATE_KEY, privateKey);
    }

    //获得公钥字符串
    public static String getPublicKeyStr(Map<String, Object> keyMap) throws Exception {
        //获得map中的公钥对象 转为key对象
        Key key = (Key) keyMap.get(PUBLIC_KEY);
        //编码返回字符串
        return encryptBASE64(key.getEncoded());
    }


    //获得私钥字符串
    public static String getPrivateKeyStr(Map<String, Object> keyMap) throws Exception {
        //获得map中的私钥对象 转为key对象
        Key key = (Key) keyMap.get(PRIVATE_KEY);
        //编码返回字符串
        return encryptBASE64(key.getEncoded());
    }

    //获取公钥
    public static PublicKey getPublicKey(String key) throws Exception {
        byte[] keyBytes;
        keyBytes = (new BASE64Decoder()).decodeBuffer(key);
        X509EncodedKeySpec keySpec = new X509EncodedKeySpec(keyBytes);
        KeyFactory keyFactory = KeyFactory.getInstance(KEY_ALGORITHM);
        PublicKey publicKey = keyFactory.generatePublic(keySpec);
        return publicKey;
    }

    //获取私钥
    public static PrivateKey getPrivateKey(String key) throws Exception {
        byte[] keyBytes;
        keyBytes = (new BASE64Decoder()).decodeBuffer(key);
        PKCS8EncodedKeySpec keySpec = new PKCS8EncodedKeySpec(keyBytes);
        KeyFactory keyFactory = KeyFactory.getInstance(KEY_ALGORITHM);
        PrivateKey privateKey = keyFactory.generatePrivate(keySpec);
        return privateKey;
    }

    //解码返回byte
    public static byte[] decryptBASE64(String key) throws Exception {
        return (new BASE64Decoder()).decodeBuffer(key);
    }


    //编码返回字符串
    public static String encryptBASE64(byte[] key) throws Exception {
        return (new BASE64Encoder()).encodeBuffer(key);
    }

    //***************************签名和验证*******************************
    public static byte[] sign(byte[] data, String privateKeyStr) throws Exception {
        PrivateKey priK = getPrivateKey(privateKeyStr);
        Signature sig = Signature.getInstance(SIGNATURE_ALGORITHM);
        sig.initSign(priK);
        sig.update(data);
        return sig.sign();
    }

    public static boolean verify(byte[] data, byte[] sign, String publicKeyStr) throws Exception {
        PublicKey pubK = getPublicKey(publicKeyStr);
        Signature sig = Signature.getInstance(SIGNATURE_ALGORITHM);
        sig.initVerify(pubK);
        sig.update(data);
        return sig.verify(sign);
    }

    //************************加密解密**************************
    public static byte[] encrypt(byte[] plainText, String publicKeyStr) throws Exception {
        PublicKey publicKey = getPublicKey(publicKeyStr);
        Cipher cipher = Cipher.getInstance(KEY_ALGORITHM);
        cipher.init(Cipher.ENCRYPT_MODE, publicKey);
        int inputLen = plainText.length;
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        int offSet = 0;
        int i = 0;
        byte[] cache;
        while (inputLen - offSet > 0) {
            if (inputLen - offSet > MAX_ENCRYPT_BLOCK) {
                cache = cipher.doFinal(plainText, offSet, MAX_ENCRYPT_BLOCK);
            } else {
                cache = cipher.doFinal(plainText, offSet, inputLen - offSet);
            }
            out.write(cache, 0, cache.length);
            i++;
            offSet = i * MAX_ENCRYPT_BLOCK;
        }
        byte[] encryptText = out.toByteArray();
        out.close();
        return encryptText;
    }

    public static byte[] decrypt(byte[] encryptText, String privateKeyStr) throws Exception {
        PrivateKey privateKey = getPrivateKey(privateKeyStr);
        Cipher cipher = Cipher.getInstance(KEY_ALGORITHM);
        cipher.init(Cipher.DECRYPT_MODE, privateKey);
        int inputLen = encryptText.length;
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        int offSet = 0;
        byte[] cache;
        int i = 0;
        // 对数据分段解密
        while (inputLen - offSet > 0) {
            if (inputLen - offSet > MAX_DECRYPT_BLOCK) {
                cache = cipher.doFinal(encryptText, offSet, MAX_DECRYPT_BLOCK);
            } else {
                cache = cipher.doFinal(encryptText, offSet, inputLen - offSet);
            }
            out.write(cache, 0, cache.length);
            i++;
            offSet = i * MAX_DECRYPT_BLOCK;
        }
        byte[] plainText = out.toByteArray();
        out.close();
        return plainText;
    }

    /*public static void main(String[] args) throws Exception {
        String publicKey = "MIGfMA0GCSqGSIb3DQEBAQUAA4GNADCBiQKBgQChfPuQl2KdBK15MYtl/fg8dPn+P+jHoyV/Om07\n" +
                "klaQ9XNCBU4/A4cVbQkzI4XsdmkuNc3eQ629G6b30n5l9zEfoyEYu1zjvS0Nk1HjHmtIQdqeni1L\n" +
                "uODsmo3yqjX7yOo4YI8ZCrSJgbJ0SJcYgVdKMB1dHKP5sRwfOIYBTMx1RQIDAQAB";
        String privateKey = "MIICdgIBADANBgkqhkiG9w0BAQEFAASCAmAwggJcAgEAAoGBAKF8+5CXYp0ErXkxi2X9+Dx0+f4/\n" +
                "6MejJX86bTuSVpD1c0IFTj8DhxVtCTMjhex2aS41zd5Drb0bpvfSfmX3MR+jIRi7XOO9LQ2TUeMe\n" +
                "a0hB2p6eLUu44OyajfKqNfvI6jhgjxkKtImBsnRIlxiBV0owHV0co/mxHB84hgFMzHVFAgMBAAEC\n" +
                "gYAzpaVPORtw3G4etJnApNkffMn3ZrksICF971HAG61T7yxNkSTVQmuRjq3CjTnnxncdMFgHHd4S\n" +
                "/SUJXWjPc59h2xs8s3+64OFQ7IhVyiVzNNfo4sJtnsLAPi8BM5Bkg5HlFYsRgC93yQ6Ngrd1MAza\n" +
                "kkr8qfXH7O0UViSz+dlUAQJBAO+OoNqePiV9/8nX93CHU/2VnTKiGSlwuGHM27AyG6pTkpRjxPET\n" +
                "EjyuwUccDVbBgxGIoHgvmrVPd8LMTm83LakCQQCskpF+S/SI4N0nXDA9xxB6EdVSAD/VlujHOXnT\n" +
                "44hT3ByFnu5YJzsr7F0zcotFIyHOAAj9u0kQQeQAKusqBnQ9AkBUJCm1f/1eF9p/H98mZDIJEMLt\n" +
                "JOhnmNL6bwT+5yq2cbI7cqua7VLrg4oZmu3IeiG6R93tOPNDGc1721z1TVE5AkAXfE7uqDmcUzXl\n" +
                "wGcUUT4NztWANmZ5k/MUAd9xlbqc5wy+ppV7S8OCw8UfVkxb2V8lYN3YYh+cZcs4tp6QdpZlAkEA\n" +
                "179eaQyWVVE3/i1bjUNtv7XOlEB40y22HV2dvI9pI6Q972qNk7faINdQgCVmE8OWPWEj4H0pyx9C\n" +
                "sGqsVphxgQ==";
        String url = "amount=233&sourceUserId=2&timestamp=1577954264122";

        byte[]cipherText = encrypt(url.getBytes(), publicKey);
        System.out.println("url:");
        String sign = new String(cipherText);
        System.out.println("sign---" + sign);

        byte[] plainText = decrypt(sign.getBytes(), privateKey);
        System.out.println("decrypt===" + new String(plainText));
    }*/


    public static void main(String[] args) {
        Map<String, Object> keyMap;
        byte[] cipherText;
        String input = "Hello World!";
        try {
            keyMap = initKey();
            String publicKey = getPublicKeyStr(keyMap);
            System.out.println("公钥------------------");
            System.out.println(publicKey);
            String privateKey = getPrivateKeyStr(keyMap);
            System.out.println("私钥------------------");
            System.out.println(privateKey);

            System.out.println("测试可行性-------------------");
            System.out.println("明文=======" + input);

            cipherText = encrypt(input.getBytes(), publicKey);
            //加密后的东西
            System.out.println("密文=======" + new String(cipherText));
            //开始解密
            byte[] plainText = decrypt(cipherText, privateKey);
            System.out.println("解密后明文===== " + new String(plainText));
            System.out.println("验证签名-----------");


            String str = "被签名的内容";
            //String str = "amount=233&sourceUserId=2&targetUserId=9999&timestamp=1578018358404";
            System.out.println("\n原文:" + str);
            byte[] signature = sign(str.getBytes(), privateKey);
            boolean status = verify(str.getBytes(), signature, publicKey);
            System.out.println("验证情况：" + status);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }



    public static String[] getKeyPari() throws Exception {
        Map<String, Object> map = initKey();
        String publicKey = getPublicKeyStr(map);
        String privateKey = getPrivateKeyStr(map);
        return new String[]{publicKey, privateKey};
    }


}