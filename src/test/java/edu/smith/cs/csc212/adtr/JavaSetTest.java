package edu.smith.cs.csc212.adtr;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

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
	
//	@Test
//	public void testToList() {
//		SetADT<Integer> intList = new JavaSet<>();
//		assertEquals(intList.toList().getClass(), ListADT.class);
//	}
}
