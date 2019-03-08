package com.adtec.daily.util;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Test;

import java.io.FileWriter;
import java.net.URL;
import java.security.Key;
import java.util.Map;
import java.util.ResourceBundle;

/**
 * RSA加密生成私钥和公钥
 * Created by zhangqi on 18-5-3.
 *
 */
public class RSACoderTes {

    static Logger logger = LogManager.getLogger(LogManager.ROOT_LOGGER_NAME);


    private String publicKey;
    private String privateKey;
    private String publicKeyPath;
    private String privateKeyPath;

    @Test
    public void generateKeyPair() throws Exception {
        URL resPath = this.getClass().getClassLoader().getResource("");
        logger.info("resPath:" + resPath);
        publicKeyPath= resPath + ResourceBundle.getBundle("config").getString("publicKeyPath");
        logger.info("publicKeyPath:" + publicKeyPath);
        privateKeyPath=resPath + ResourceBundle.getBundle("config").getString("privateKeyPath");
        logger.info("privateKeyPath:" + privateKeyPath);
        Map<String, Key> keyMap = RSACoder.initKey();
        publicKey = RSACoder.getPublicKey(keyMap);
        privateKey = RSACoder.getPrivateKey(keyMap);
        System.err.println("私钥： \n\r" + publicKey);
        System.err.println("私钥： \n\r" + privateKey);
        // 保存公钥
        FileWriter b1 = new FileWriter(publicKeyPath);
        b1.write(publicKey);
        b1.close();
        // 保存私钥
        FileWriter b2 = new FileWriter(privateKeyPath);
        b2.write(privateKey);
        b2.close();
    }

}
