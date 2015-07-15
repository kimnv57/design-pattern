/**
 * Copyright © 2015 Ntq-Solution.
 * 
 */
package queue;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

/**
 * class main.java
 * 
 * @version 1 9:40:27 AM
 * @author kimnv57
 *
 */
public class main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
//		People kim=new People("kim",21);
//		People thao=new People("thao",22);
//		System.out.println(kim.equals(thao));
//		long start=System.currentTimeMillis();
//		MyHashMap<Integer,String> hashmap = new MyHashMap<Integer, String>();
//		for(int i=0;i<10000;i++) {
//			hashmap.put(i, "kim");
//		}
//		
//		long total=System.currentTimeMillis()-start;
//		System.out.println("1: "+total);
//		start=System.currentTimeMillis();
//		hashmap.put(2, "gaheo1");
//		hashmap.put(3, "gaheo2");
//		hashmap.put(64, "gaheo3");
//		hashmap.put(65, "gaheo4");
//		System.out.println(hashmap.size());
//		
//		HashMap<Integer,String> hashmap2 = new HashMap<Integer, String>();
//		for(int i=0;i<10000;i++) {
//			hashmap2.put(i, "kim");
//		}
//		
//		total=System.currentTimeMillis()-start;
//		System.out.println("2: "+total);
		
//		hashmap2.entrySet();
//		hashmap2.put(kim, "kim");
//		hashmap2.put(thao, "gaheo");
//		for (Entry<People, String> e : hashmap2.entrySet()) {
//			System.out.println(e.getValue());
//        }
//		System.out.println(hashmap.get(kim));
//		System.out.println(hashmap.get(thao));
//		System.out.println(hashmap2.get(kim));
//		System.out.println(hashmap2.get(thao));
		HashMapTest t =new HashMapTest();
		int i=222323211;
		i=i*1000000;
		System.out.println(i);
		System.out.println(t.hashString("kimkakaksppp"));
		
		HashMap<String,String> hash= new HashMap<String, String>();
		hash.put("user", "Kim");
		hash.put("password", "gaheo1994");
		System.out.println(hash.get("user")+" "+ (1 << 4)+ " "+(1 << 30));
		System.out.println(hash.get("password"));
//		MyQueue<Integer> ints =new MyQueue<Integer>();
//		ints.add(2);
//		ints.add(3);
//		ints.add(4);
//		ints.add(5);
//		ints.add(6);
//		for(int v:ints)
//			System.out.println(v);
//		ArrayList<Integer> cc=new ArrayList<Integer>();
//		cc.add(2);
//		cc.add(5);
//		ints.retainAll(cc);
//		for(int v:ints)
//			System.out.println(v);
//		
//		List<? extends Integer> intList = new ArrayList<>();
//		List<? extends Number>  numList = new ArrayList<>();
//		intList = (List<? extends Integer>) numList; 
//		
//		(List<? extends Number>)intList;
//		
//		// TODO Auto-generated method stub
//		PriorityQueue<String> a = new PriorityQueue<String>();
////		a.removeAll(c)
//		a.iterator()
//		LinkedList<String> c = new LinkedList<String>();
//		c.add("a");
//		Arrays.c
//		c.add("b");
//		c.add("c");
//		System.out.println(c.getLast());
//		c.removeLast();
		  List<Object> objects = new ArrayList<Object>();
	      objects.add(new Object());
	      List<String> strings =  (List) objects;
	      System.out.println(strings);
	      for(Object e : strings) {
	    	  System.out.println(e);
	      }
	      
	      
	      Object[] a=new Object[0];
	      a=strings.toArray(a);
	      for(Object b: a) 
	    	  System.out.println(b);
		
	}
}
