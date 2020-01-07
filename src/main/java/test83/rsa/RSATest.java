package test83.rsa;

import org.joda.time.DateTime;

import javax.crypto.Cipher;
import java.security.KeyFactory;
import java.security.interfaces.RSAPrivateKey;
import java.security.interfaces.RSAPublicKey;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;
import java.util.Base64;
import java.util.Map;
import java.util.TreeMap;

public class RSATest {


    private static String pubKeyEncoded="MIGfMA0GCSqGSIb3DQEBAQUAA4GNADCBiQKBgQCRv3SyxOLh7KynCayoVJTnCBtkqPq/gvBYTxgoX8LdaO0knkOvoDhVlRjERAjRF9VW/OQ97Dy1tbiaSsJoiE25QWoysMQlT4W7Ao1K/mEh4caFZOVAc20BbeqPwlpFkG6xJ4sUh+UtzsIXLXPg5x1rjBPK/O6VzCfwnBYHntCrsQIDAQAB";
    private static String prikeyEncoded="MIICdQIBADANBgkqhkiG9w0BAQEFAASCAl8wggJbAgEAAoGBAJG/dLLE4uHsrKcJrKhUlOcIG2So+r+C8FhPGChfwt1o7SSeQ6+gOFWVGMRECNEX1Vb85D3sPLW1uJpKwmiITblBajKwxCVPhbsCjUr+YSHhxoVk5UBzbQFt6o/CWkWQbrEnixSH5S3Owhctc+DnHWuME8r87pXMJ/CcFgee0KuxAgMBAAECgYB6Nlp6lNHStAzKPDiFJfd+CrQ9odwwvnEe+6O8JyBVXGiNrg//so/KY61S1eG2ww9nU8NnkTIPBIP5DPsbgD/67sL+LFdrxCwO/N47F6tFe/UDatUqpOgz51jUa51WxPQdZhyN9dp/+VBUIBsgjXwCA7TmpM2rcNZcN9iejwwYaQJBAO3FHndu+Lobw4tHOi6O8q0wZuQKnZCN7qkiUqwr7BIhoQg/hFVWNl9ToMzp3H6s2cAc2Yn3TCLfHFWOS5b4SQ8CQQCc7Cc0nslOCcFP1saTSZy12LW3kcMVw/xAeqFMBkHa5byypFMrhaaE3kSC2O2bUQ2GugJVKOiHyCrdm+AuhD8/AkBXlY3kdsc+Xu3IB0PCVLvF2hd8lwB1eCLawJ7tdvxtrV+RFzya5rf+o2KPOPIU430OjFIBxUuRaNgaF+F2Sh03AkAjLIP1NYpl5aXhIYFNTnjEAhlpVlDmNhH62gIBqn1kdY6AdHj4DnMu4St2MO3BnL9tbZBMSmkk1mdVWTU8+AO9AkBsoqhO6YHyudRynfW6M/yLpQa5th6JhQ4RkEH8ESJ7AJM7znBxcxgPSxpr0HvlPlgEeHJ5ZpwKVXpDZvLYcNaO";

    private static final String RSA_ALGORITHM = "RSA";

    public static void  main(String[] args){
        try {
            //测试用公钥加密
            TreeMap<String,Object> params = new TreeMap<String,Object>();//TreeMap 自带排序
            params.put("appId","sc-payment");//会员id
            params.put("nonce","bpFsYeBUrgKIyUga");//会员id
            params.put("sourceUserId",2);//会员id
            //params.put("targetUserId",9999);//充值余额
            params.put("amount", 233);//充值余额
            params.put("timestamp", DateTime.now().getMillis());//充值余额
            String signStr = sign(params);//生成签名
            System.out.println(String.format("生成的签名：%s",signStr));
            //测试用私钥解密
            String decryptStr = decrypt(signStr);
            System.out.println(String.format("解密后：%s",decryptStr));
        } catch (Exception e) {
            e.printStackTrace();
        }

        // 1.公钥必定要暴露在前端js中
        // 2.确保链接一次有效，每次给前端返回公钥？，每次来的都是

    }

    private static String sign(TreeMap<String,Object> params) throws Exception {
        // TreeMap<String,Object> 按字典排序  组成 {参数1}=参数值1&{参数2}=参数值2 的字符串 再对该字符串进行加密
        if(params.containsKey("sign"))
            params.remove("sign");
        StringBuilder sb = new StringBuilder();
        for(Map.Entry<String, Object> entry:params.entrySet()){
            if(entry.getValue()!=null){
                sb.append(entry.getKey()).append("=").append(entry.getValue()).append("&");
            }
        }
        if(sb.length()>0){
            sb.deleteCharAt(sb.length()-1);
        }
        return RSAStr(sb.toString());
    }

    /**
     * 公钥加密
     * @param str
     * @return
     * @throws Exception
     */
    private static String RSAStr(String str) throws Exception{
        Cipher cipher = Cipher.getInstance(RSA_ALGORITHM);
        KeyFactory keyFactory = KeyFactory.getInstance(RSA_ALGORITHM);
        X509EncodedKeySpec x509KeySpec = new X509EncodedKeySpec(Base64.getDecoder().decode(pubKeyEncoded));
        RSAPublicKey pubkey = (RSAPublicKey) keyFactory.generatePublic(x509KeySpec);
        cipher.init(Cipher.ENCRYPT_MODE, pubkey);
        byte[] b1 = cipher.doFinal(str.getBytes("UTF-8"));
        return new String( Base64.getEncoder().encode(b1));
    }

    /**
     * 私钥解密
     * @param test
     * @return
     * @throws Exception
     */
    private static String decrypt(String test) throws Exception{
        Cipher cipher = Cipher.getInstance(RSA_ALGORITHM);
        KeyFactory keyFactory = KeyFactory.getInstance(RSA_ALGORITHM);
        PKCS8EncodedKeySpec spec = new PKCS8EncodedKeySpec(Base64.getDecoder().decode(prikeyEncoded));
        RSAPrivateKey priKey = (RSAPrivateKey) keyFactory.generatePrivate(spec);
        cipher.init(Cipher.DECRYPT_MODE, priKey);
        byte[] b2 = Base64.getDecoder().decode(test);
        byte[] b = cipher.doFinal(b2);
        return new String (b);
    }
}

