package test82.string;

import org.apache.commons.lang3.RandomStringUtils;

public class MainClass {

    public static void main(String[] args) {

        // 生成16位的随机字符串

        String nonce = RandomStringUtils.randomAlphabetic(16);
        System.out.println("nonce:" + nonce);

        String nonce2 =  RandomStringUtils.randomAlphanumeric(12);
        System.out.println("nonce2:" + nonce2);

    }
}
