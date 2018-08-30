package test.com.deloitte.util.test;

import com.deloitte.util.CacheUtil;
import org.junit.Assert;
import org.junit.Test;

public class CacheUtilTest {

    @Test
    public void cacheSingleton(){
        CacheUtil cacheUtil = CacheUtil.GetInstance();
        CacheUtil cacheUtil1 = CacheUtil.GetInstance();

        Assert.assertEquals(cacheUtil,cacheUtil1);
    }

    @Test
    public void pushEncryptTest(){
        CacheUtil cacheUtil = CacheUtil.GetInstance();

        boolean saved = cacheUtil.pushEncrypt("Hello","World");
        Assert.assertEquals(true,saved);

        boolean saved2 = cacheUtil.pushEncrypt("Hello","World");
        Assert.assertEquals(false,saved2);
    }

    @Test
    public void getPrevEncryptedDataTest(){
        CacheUtil cacheUtil = CacheUtil.GetInstance();
        cacheUtil.pushEncrypt("Key","Val");

        String val = cacheUtil.getPrevEncryptedData("Key");
        Assert.assertEquals("Val",val);
    }

    @Test
    public void getPrevEncryptedDataNullTest(){
        CacheUtil cacheUtil = CacheUtil.GetInstance();

        String val = cacheUtil.getPrevEncryptedData("XXXXX");
        Assert.assertEquals(null,val);
    }

    @Test
    public void getPreviousDecryptedDataTest(){
        CacheUtil cacheUtil = CacheUtil.GetInstance();
        String dec = "DECRYPT";
        String enc = "this";
        cacheUtil.pushEncrypt(enc,dec);
        String val = cacheUtil.getPreviousDecryptedData(dec);
        Assert.assertEquals(enc, val);
    }

}
