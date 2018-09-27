package HelloWorld.com.qa.quickstart;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

/**
 * Unit test for simple App.
 */
public class AppTest 
    extends TestCase
{
    tax tester = new tax();
    
    
    
    public void test() {
    	assertEquals(0.20, tester.getTax(35000));
    	assertEquals(7000d, tester.calcTax(tester.getTax(35000), 35000));
    }
}
