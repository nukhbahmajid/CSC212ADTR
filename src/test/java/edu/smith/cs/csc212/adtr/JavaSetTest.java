package edu.smith.cs.csc212.adtr;

import static org.junit.Assert.assertEquals;

import org.junit.Assert;
import org.junit.Test;

import edu.smith.cs.csc212.adtr.real.JavaList;
import edu.smith.cs.csc212.adtr.real.JavaSet;

public class JavaSetTest {
	
	@Test
	public void testEmpty() {
		SetADT<String> empty = new JavaSet<>();
		assertEquals(empty.size(), 0);
	}
	
	@Test
	public void testInsert() {
		SetADT<Integer> intList = new JavaSet<>();
		intList.insert(2);
		intList.insert(5);
		intList.insert(46);
		assertEquals(intList.size(), 3);
	}
	
	@Test
	public void testInsertRepeated() {
		SetADT<Integer> intList = new JavaSet<>();
		intList.insert(4);
		intList.insert(4);
		intList.insert(4);
		assertEquals(intList.size(), 1);
		
	}
	
	@Test
	public void testContains() {
		SetADT<Integer> intList = new JavaSet<>();
		intList.insert(45);
		intList.insert(134);
		intList.insert(223);
		assertEquals(intList.contains(45), true);
	}
	
	@Test
	public void testSize() {
		SetADT<Integer> intList = new JavaSet<>();
		intList.insert(34); 
		intList.insert(34);
		intList.insert(67);
		assertEquals(intList.size(), 2);
	}
	
	@Test
	public void testRemove() {
		SetADT<Integer> intList = new JavaSet<>();
		intList.insert(45);
		intList.insert(10);
		intList.insert(45);
		intList.remove(10);
		assertEquals(intList.size(), 1);
	}
	
	@Test
	public void testToJava() {
		SetADT<Integer> intSet = new JavaSet<>();
		intSet.insert(1);
		intSet.insert(2);
		intSet.insert(3); 
		intSet.insert(4); 
		Assert.assertTrue(intSet.contains(2) && intSet.toJava().contains(2));
		
	}
	@Test
	public void testToList() {
		SetADT<Integer> intSet = new JavaSet<>();
		intSet.insert(1);
		intSet.insert(2);
		intSet.insert(3); 
		intSet.insert(4); 
		ListADT<Integer> listJava = new JavaList<>();
		listJava.toJava().addAll(intSet.toJava());
		for (int i = 0; i < listJava.size(); i++) {
			assertEquals(intSet.toList().getIndex(i), listJava.getIndex(i));
		}
	}
	
	
}
