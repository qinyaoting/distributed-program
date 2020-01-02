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


    private static String pubKeyEncoded="MIGfMA0GCSqGSIb3DQEBAQUAA4GNADCBiQKBgQCDA/QhX4cDr8tOE0KN/SYRoytX0kmVsxdogM6ZNtRcHTIiTn3y/P2YoN83HA669AHhb2ZAe7e2eWxKf2MdxT9Adw+JvDyM9iSQFd8m5WlUydfYQP+sCq6wP/uWT5zP/kfHrOnH9D6707tSAosxVTK1gnNK7OE29k7JCWsC7TZCLQIDAQAB";
    private static String prikeyEncoded="MIICdgIBADANBgkqhkiG9w0BAQEFAASCAmAwggJcAgEAAoGBAIMD9CFfhwOvy04TQo39JhGjK1fSSZWzF2iAzpk21FwdMiJOffL8/Zig3zccDrr0AeFvZkB7t7Z5bEp/Yx3FP0B3D4m8PIz2JJAV3yblaVTJ19hA/6wKrrA/+5ZPnM/+R8es6cf0PrvTu1ICizFVMrWCc0rs4Tb2TskJawLtNkItAgMBAAECgYAIr6Vq5QN1ih0ngv1hnov8lV3VR7rbMvF1WzzXSZxQsxrUzXFqP72sddX2uGR9npnVUWZtFga7EVfNpJ50pdQooGaF2FwI6Lw0BtiuT7ocnHJYCpuF79YdyEB8QUdHoQh+E2LW389ugmO4NEcbkh4KTtr+2heW3S6a1TwRR3F5HQJBANZNNF0yoKp+CcUE6oyPeb18kPwVimR+2fFhNIF2NjxI+D8yYg2rvb5u1wdKv/rSsO/iNhp4eb+OMB3HV0jiC6sCQQCcghka0YW7eIYEsDe6N893pkCsV4K5r4kaNXvrhP5BBBtDehuRAb112jPtF8xPQy6HS6JHklaIYq5CIyOv81GHAkB7XwzzTm8iV9cF/nONIhgi1zCcf0Yh3slXZe+VTFmi0RthPn8mgaWFmUffYdAt9Nd58k/VY2ArwA7BRf5g7glrAkEAhA3dotxAy3KhGdmZ27z1h842aXQZMBWlSADyw0FeynrtihzAn7RpKMRo5dcbo5Fa8/tkPKGD8+XXhKRjmzVhhwJAeD4JAJRYts6Jok3a46OwOIS1VrXMoeRZmeVYgQ9ev9q61/5YRSpqvUl6k3vcjZm6OUf7zGbAvcbjTn6sGFHxbg==";

    private static final String RSA_ALGORITHM = "RSA";

    public static void  main(String[] args){
        try {
            //测试用公钥加密
            TreeMap<String,Object> params = new TreeMap<String,Object>();//TreeMap 自带排序
            params.put("sourceUserId",2);//会员id
            params.put("targetUserId",9999);//充值余额
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

