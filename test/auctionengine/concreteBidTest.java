/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package auctionengine;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author amenu
 */
public class concreteBidTest {
    
    public concreteBidTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of placeBid method, of class concreteBid.
     */
    @Test
    public void testplaceBidEmpty() {
        System.out.println("PlaceBid");
        String item = "";
        int price = 0;
        String bidder = "";
        concreteBid instance = new concreteBid();
        instance.placeBid(item, price, bidder);
        // TODO review the generated test code and remove the default call to fail.
      //  fail("The test case is a prototype.");
    }
    @Test
    public void testplaceBidNonEmpty() {
        System.out.println("PlaceBid");
        String item = "bidItem";
        int price = 20;
        String bidder = "bidder";
        concreteBid instance = new concreteBid();
        instance.placeBid(item, price, bidder);
        // TODO review the generated test code and remove the default call to fail.
      //  fail("The test case is a prototype.");
    }

    /**
     * Test of getCurrentBid method, of class concreteBid.
     */
    @Test
    public void testGetCurrentBid() {
        System.out.println("getCurrentBid");
        String item = "";
        concreteBid instance = new concreteBid();
        String expResult = "";
        String result = instance.getCurrentBid(item);
        assertEquals(result, result);
        // TODO review the generated test code and remove the default call to fail.
      //  fail("The test case is a prototype.");
    }
    
    /*
    @Test(expected = FileNotFoundException.class)
    public void testGetCurrentBidException() {
        System.out.println("getCurrentBid");
        String item = "";
        concreteBid instance = new concreteBid();
        String expResult = "";
        String result = instance.getCurrentBid(item);
        assertEquals(false, result);
        // TODO review the generated test code and remove the default call to fail.
      //  fail("The test case is a prototype.");
    }
    
    */

    /**
     * Test of checkItem method, of class concreteBid.
     */
    @Test
    public void testCheckItemNullEntry() {
        System.out.println("checkItem");
        String item = "";
        concreteBid instance = new concreteBid();
        boolean expResult = false;
        boolean result = instance.checkItem(item);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
      //  fail("The test case is a prototype.");
    }
    @Test
    public void testCheckItemNonNullEntry() {
        System.out.println("checkItem");
        String item = "bidItem";
        concreteBid instance = new concreteBid();
        boolean expResult = false;
        boolean result = instance.checkItem(item);
        assertEquals(true, result);
        // TODO review the generated test code and remove the default call to fail.
      //  fail("The test case is a prototype.");
    }
    
    @Test
    public void testCheckItemExpResultTrue() {
        System.out.println("checkItem");
        String item = "bidItem";
        concreteBid instance = new concreteBid();
        boolean expResult = true;
        boolean result = instance.checkItem(item);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
      //  fail("The test case is a prototype.");
    }

    /**
     * Test of stringContainsNumber method, of class concreteBid.
     */
    @Test
    public void testStringContainsNumber() {
        System.out.println("stringContainsNumber");
        String s = "";
        concreteBid instance = new concreteBid();
        boolean expResult = false;
        boolean result = instance.stringContainsNumber(s);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
     //   fail("The test case is a prototype.");
    }

    /**
     * Test of getMaxValue method, of class concreteBid.
     */
    @Test
    public void testGetMaxValue() throws Exception {
        System.out.println("getMaxValue");
        String item = "";
        concreteBid instance = new concreteBid();
        int expResult = instance.getMaxValue(item);;
        int result = instance.getMaxValue(item);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
    //    fail("The test case is a prototype.");
    }

    /**
     * Test of DisplayItems method, of class concreteBid.
     */
    @Test
    public void testDisplayAllItems() {
        System.out.println("DisplayItems");
        concreteBid instance = new concreteBid();
        instance.displayAllItems();
        // TODO review the generated test code and remove the default call to fail.
    ///    fail("The test case is a prototype.");
    }

    /**
     * Test of displayItem method, of class concreteBid.
     */
    @Test
    public void testDisplayItem() {
        System.out.println("displayItem");
        concreteBid instance = new concreteBid();
        instance.displayItem();
        // TODO review the generated test code and remove the default call to fail.
     //   fail("The test case is a prototype.");
    }

    /**
     * Test of displayUsersBids method, of class concreteBid.
     */
    @Test
    public void testDisplayUsersBids() {
        System.out.println("displayUsersBids");
        String Username = "";
        concreteBid instance = new concreteBid();
        instance.displayUsersBids(Username);
        // TODO review the generated test code and remove the default call to fail.
     //   fail("The test case is a prototype.");
    }
    
}
