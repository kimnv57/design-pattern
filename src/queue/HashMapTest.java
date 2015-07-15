/**
 * Copyright © 2015 Ntq-Solution.
 * 
 */
package queue;

/**
 * class HashMapTest.java
 * @version 1 10:10:39 AM
 * @author kimnv57
 *
 */
public class HashMapTest {
	public int hashString(String s) {
		int value=0;
		for(int i=0;i<s.length();i++)
			value=37*value+s.charAt(i);
		return value;
	}

}
