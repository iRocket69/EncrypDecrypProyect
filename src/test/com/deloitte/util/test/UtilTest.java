package test.com.deloitte.util.test;

import com.deloitte.util.Util;
import org.junit.Assert;
import org.junit.Test;

public class UtilTest {
    @Test
    public void encryptAndDecryptTest() {
        System.out.println(Util.encrypt("MyNameIsJulio"));
        System.out.println();
        System.out.println(Util.encrypt("MyNameIsJulio"));
        System.out.println();
        System.out.println(Util.decrypt("sJulio#MyNameI"));
        System.out.println();
        System.out.println(Util.decrypt("ertRob"));
        System.out.println();
        System.out.println(Util.encrypt("Robert"));
        System.out.println();
    }

    @Test
    public void UtilTestNotInstance(){
        String expected = "This class is just an Utility does not support instance";
        String actual = null;
        try{
            Util util = new Util();
        }catch (Exception ex){
            actual = ex.getMessage();
        }
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void encryptTest(){
        String actual = Util.encrypt("Dude");
        String expected = "deDu";
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void encryptHastagTest(){
        String actual = Util.encrypt("Allan");
        String expected = "an#All";
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void decryptTest(){
        String actual = Util.decrypt("elaAng");
        String expected = "Angela";
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void decryptHashtagTest(){
        String actual = Util.decrypt("el#Ang");
        String expected = "Angel";
        Assert.assertEquals(expected, actual);
    }
}
