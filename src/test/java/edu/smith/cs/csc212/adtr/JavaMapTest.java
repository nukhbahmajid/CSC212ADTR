package edu.smith.cs.csc212.adtr;

import static org.junit.Assert.*;

import java.util.Map;
import org.junit.Assert;
import org.junit.Test;

import edu.smith.cs.csc212.adtr.real.JavaMap;

public class JavaMapTest {

	@Test
	public void testEmpty() {
		MapADT<String, Integer> empty = new JavaMap<>();
		assertEquals(empty.size(), 0);
	}
	
	void assertInt(int x, int y) {
		assertEquals(x, y);
	}
	
	@Test 
	public void testPut() {
		MapADT<String, Integer> aMap = new JavaMap<>();
		aMap.put("CSC212", 0);
		aMap.put("CSC250", 1);
		assertEquals(aMap.size(), 2);
		assertInt(aMap.get("CSC212"), 0);
	}
	
	@Test
	public void testGet() {
		MapADT<String, Integer> aMap = new JavaMap<>();
		aMap.put("CSC212", 0);
		aMap.put("CSC250", 1);
		assertSame(aMap.get("CSC212"), 0);
		
	}
	
	@Test
	public void testSize() {
		MapADT<String, Integer> aMap = new JavaMap<>();
		aMap.put("CSC212", 0);
		aMap.put("CSC250", 1);
		aMap.put("CSC212", 2);
		assertEquals(aMap.size(), 2); 
	}
	
	@Test 
	public void testRemove() {
		MapADT<String, Integer> aMap = new JavaMap<>();
		aMap.put("CSC212", 0);
		aMap.put("CSC250", 1);
		aMap.put("SDS192", 2);
		aMap.remove("SDS192");
		assertEquals(aMap.get("SDS192"), null);
	}
	
	@Test
	public void testgetKeys() {
		MapADT<String, Integer> aMap = new JavaMap<>();
		aMap.put("CSC212", 0); 
		aMap.put("CSC250", 1);
		aMap.put("SDS192", 2); 
		ListADT<String> keys = aMap.getKeys();
		Assert.assertTrue(keys.toJava().contains("CSC212"));
		
	}
	
	@Test 
	public void testgetEntries() {
		MapADT<String, Integer> aMap = new JavaMap<>();
		aMap.put("CSC212", 0); 
		aMap.put("CSC250", 1);
		aMap.put("SDS192", 2);
		ListADT<Pair<String, Integer>> entries = aMap.getEntries();
		assertEquals("CSC212",entries.toJava().get(0).getKey());
	}
	
	@Test
	public void testToJava() {
		MapADT<String, Integer> aMap = new JavaMap<>();
		aMap.put("CSC212", 0); 
		aMap.put("CSC250", 1);
		aMap.put("SDS192", 2);
		Map<String, Integer> javaMap = aMap.toJava();
		// wow @ my last two brain cells
		for (int i = 0; i < aMap.size(); i++) {
			assertTrue(javaMap.containsKey(aMap.getEntries().toJava().get(i).getKey()));
		}
	}
}
