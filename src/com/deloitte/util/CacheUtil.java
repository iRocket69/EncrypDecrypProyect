package com.deloitte.util;

import com.sun.org.apache.xpath.internal.SourceTree;

import javax.sound.midi.Soundbank;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;

public class CacheUtil {
    private HashMap<String,String> encryptedCacheData = new HashMap<>();
    private static final CacheUtil cache = new CacheUtil();
    private CacheUtil(){}

    public static CacheUtil GetInstance(){
        return cache;
    }

    public boolean pushEncrypt(String key, String val){
        if(getPrevEncryptedData(key) == null){
            cache.encryptedCacheData.put(key, val);
            System.out.println("Adding to cache");
            return true;
        }else
            return false;
    }

    public String getPrevEncryptedData(String key){
        if(encryptedCacheData.containsKey(key)) {
            System.out.println(key.concat(" found in cache."));
            return encryptedCacheData.get(key);
        }else
            return null;
    }

   public String getPreviousDecryptedData(String val){
        if(encryptedCacheData.containsValue(val)){
            System.out.println(val.concat(" found in cache."));
            return  encryptedCacheData.entrySet()
                    .stream()
                    .filter(entry -> Objects.equals(entry.getValue(), val)).findFirst()
                    .map(Map.Entry::getKey).get();
        }
        else return null;
    }



}
