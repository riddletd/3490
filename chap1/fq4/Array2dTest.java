/**
 * Array2dTest.java
 * 
 * JUnit test file for Array2d class (subclassed from PartialArray2d)
 * 
 * @author Dr. Fenwick
 * @version January 2017
 *
 * COPYRIGHT (C) 2017 Jay Fenwick. All Rights Reserved.
 */

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import org.junit.Test;
import org.junit.Before;


/**
 * JUnit test class for Array2d class.
 *
 * @author Dr. Fenwick
 * @version January 2017
 */
public class Array2dTest {
    int[][] javaDefault;
    int[] javaDefault1dRmo, javaDefault1dCmo;
    Array2d myRMO, myCMO;

    /**
     * Initializes test data.
     *
     * Currently tests on this 2D array:
     * new int[][] { { 11, 12, 13},
     *               { 21, 22, 23},
     *               { 31, 32, 33},
     *               { 41, 42, 43} };
     *
     * Note that this setUp method runs before each test.
     */
    @Before
    public void setUp() {
	javaDefault = new int[][] { { 11, 12, 13},
			            { 21, 22, 23},
			            { 31, 32, 33},
			            { 41, 42, 43} };
	javaDefault1dRmo = new int[] { 11, 12, 13, 21, 22, 23, 31, 32, 33, 41, 42, 43 };
	javaDefault1dCmo = new int[] { 11, 21, 31, 41, 12, 22, 32, 42, 13, 23, 33, 43 };

	myRMO = new Array2d(4, 3);
	myRMO.setElement(0,0,11); myRMO.setElement(0,1,12); myRMO.setElement(0,2,13);
	myRMO.setElement(1,0,21); myRMO.setElement(1,1,22); myRMO.setElement(1,2,23);
	myRMO.setElement(2,0,31); myRMO.setElement(2,1,32); myRMO.setElement(2,2,33);
	myRMO.setElement(3,0,41); myRMO.setElement(3,1,42); myRMO.setElement(3,2,43);

	myCMO = new Array2d(4, 3, Array2d.COLUMN_MAJOR_ORDER);
	myCMO.setElement(0,0,11); myCMO.setElement(0,1,12); myCMO.setElement(0,2,13);
	myCMO.setElement(1,0,21); myCMO.setElement(1,1,22); myCMO.setElement(1,2,23);
	myCMO.setElement(2,0,31); myCMO.setElement(2,1,32); myCMO.setElement(2,2,33);
	myCMO.setElement(3,0,41); myCMO.setElement(3,1,42); myCMO.setElement(3,2,43);
    }

    /**
     * Tests all the accessor methods.
     */
    @Test
    public void checkAccessors() {
	assertEquals(4, myRMO.getRows());
	assertEquals(3, myRMO.getCols());
	assertEquals(12, myRMO.length());
	assertEquals(Array2d.ROW_MAJOR_ORDER, myRMO.getOrder());
	assertEquals(Array2d.COLUMN_MAJOR_ORDER, myCMO.getOrder());
    }

    /**
     * Tests the get/set Element methods.
     */
    @Test
    public void checkBasicOperations() {
	myRMO.setElement(1,1,55);
	assertEquals(55, myRMO.getElement(1,1));
	myRMO.setElement(3,2,57);
	assertEquals(57, myRMO.getElement(3,2));
    }


    /**
     * Ensures column-major-order of internal data array.
     */
    @Test
    public void checkColumnMajorOrder() {
	boolean testPassed = true;
	String expected = "Raw data: ";
	expected += java.util.Arrays.toString(javaDefault1dCmo);
	expected += "\nColumn-major-order: ";
	expected += java.util.Arrays.deepToString(javaDefault);

	String myCmoString = myCMO.toString();

	if (! expected.equals(myCmoString)) {
	    testPassed = false;
	    System.out.println();
	    System.out.println("checkColumnMajorOrder FAILED");
	    System.out.println("Expected output:");
	    System.out.println(expected);
	    System.out.println("Your output:");
	    System.out.println(myCmoString);
	    System.out.println();
	}
	assertTrue(testPassed);
    }

    /**
     * Ensures row-major-order of internal data array.
     */
    @Test
    public void checkRowMajorOrder() {
	boolean testPassed = true;
	String expected = "Raw data: ";
	expected += java.util.Arrays.toString(javaDefault1dRmo);
	expected += "\nRow-major-order: ";
	expected += java.util.Arrays.deepToString(javaDefault);

	String myRmoString = myRMO.toString();

	if (! expected.equals(myRmoString)) {
	    testPassed = false;
	    System.out.println();
	    System.out.println("checkRowMajorOrder FAILED");
	    System.out.println("Expected output:");
	    System.out.println(expected);
	    System.out.println("Your output:");
	    System.out.println(myRmoString);
	    System.out.println();
	}
	assertTrue(testPassed);
    }
}
