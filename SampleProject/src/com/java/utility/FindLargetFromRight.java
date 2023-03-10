package com.java.utility;

import java.util.LinkedList;
import java.util.List;

public class FindLargetFromRight {

	public static void main(String[] args) {
		
		List<Integer> list = new LinkedList<Integer>();
		
		list.add(18);
		list.add(12);
		list.add(9);
		list.add(4);
		list.add(3);
		list.add(11);
		list.add(1);
		
		printLargestFromRight(list, list.size());
		
	}
	
	static void printLargestFromRight(List<Integer> list, int listSize) {
	    int count =0;
	    int a = 0;
	    int temp = 1;
	    List<Integer> newList = new LinkedList<Integer>();
	    for(int i = 0; i<listSize; i++){
	       for(int j = temp; j<listSize; j++){
	           if(list.get(i)>list.get(j)){
	              count ++;
	           }
	       }
	       a = a + 1;
	       if(count == (listSize - a)){
	          newList.add(list.get(i));
	       }
	       temp = temp + 1;
	       count = 0;
	    }
	    System.out.println(newList.toString());
	}
}
