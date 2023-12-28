package listener;

import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
@Listeners(listener.CustomListener.class)
public class ListenerTest {

    @Test
public void test_1(){
        System.out.println("Test 1");
        Assert.assertEquals("A","A");
            }
    @Test
   public void test_2(){
        System.out.println("Test 2");
        Assert.assertEquals("A","B");
    }
    @Test
   public void test_3(){
        System.out.println("Test 3");
        throw new SkipException("Skip test");
    }
}
