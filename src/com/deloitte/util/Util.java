package com.deloitte.util;

public class Util {

    public Util(){
        throw new UnsupportedOperationException("This class is just an Utility does not support instance");
    }

    public static String encrypt(String value){
        if(value == null)
            return value;
        if(value.length()<=0)
            return value;
        System.out.println("Encrypting ".concat(value));
        CacheUtil cacheUtil = CacheUtil.GetInstance();

        String cached = cacheUtil.getPrevEncryptedData(value);
        if(cached != null){
            return cached;
        }
        String result = encryptionAlgorithm(value);

        cacheUtil.pushEncrypt(value, result);
        return result;
    }

    public static String decrypt(String value){
        if(value == null)
            return value;
        if(value.length()<=0)
            return value;
        System.out.println("Decrypting ".concat(value));
        CacheUtil cacheUtil = CacheUtil.GetInstance();

        String cached = cacheUtil.getPreviousDecryptedData(value);
        if(cached != null){
            return cached;
        }
        String result = decryptionAlgorithm(value);

        cacheUtil.pushEncrypt(result, value);
        return result;
    }

    private static String encryptionAlgorithm(String value) {
        String part1 = prepareValue(value).substring(0, prepareValue(value).length()/2);
        String part2 = prepareValue(value).substring(prepareValue(value).length()/2);
        return part2.concat(part1);
    }

    private static String decryptionAlgorithm(String value){
        return encryptionAlgorithm(value).replace("#","");
    }

    private static String prepareValue(String value){
        int valLength = value.length();
        if(valLength % 2 == 0)
            return value;
        else{
            return value.concat("#");
        }
    }


}
