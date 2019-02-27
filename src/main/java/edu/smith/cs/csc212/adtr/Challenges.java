package edu.smith.cs.csc212.adtr;

import static org.junit.Assert.assertEquals;


import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.junit.Test;

import edu.smith.cs.csc212.adtr.real.JavaList;
import edu.smith.cs.csc212.adtr.real.JavaMap;
import edu.smith.cs.csc212.adtr.real.JavaSet;

public class Challenges {

	// The union of two sets is the set of elements that either contains.
	public static SetADT<Integer> union(SetADT<Integer> left, SetADT<Integer> right) {
		SetADT<Integer> output = new JavaSet<>(); 
		for (int i=0; i < left.size(); i++) {
			output.insert(left.toList().getIndex(i));
		}
		for (int i=0; i< right.size(); i++) {
			output.insert(right.toList().getIndex(i));
		}
		
		return output;
	}
	
	@Test 
	public void testUnion() {
		SetADT<Integer> set1 = new JavaSet<>();
		set1.insert(1);
		set1.insert(2);
		set1.insert(3); 
		SetADT<Integer> set2 = new JavaSet<>();
		set2.insert(3); 
		set2.insert(4);
		set2.insert(5);
		Set<Integer> finalSet = new HashSet<Integer>();
		finalSet.add(1);
		finalSet.add(2);
		finalSet.add(3);
		finalSet.add(4);
		finalSet.add(5);
		for (int i=0; i<finalSet.size(); i++) {
			assertEquals(union(set1, set2).toJava(), finalSet);
		}
		
		
	}
	
	// The intersection of two sets is the set of elements that both contain.
	public static SetADT<Integer> intersection(SetADT<Integer> left, SetADT<Integer> right) {
		SetADT<Integer> output = new JavaSet<>();
		ListADT<Integer> leftList = left.toList();
		for (int i = 0; i<leftList.size(); i++) {
			if (right.contains(leftList.getIndex(i))) {
				output.insert(leftList.getIndex(i));
			} else {}
		}
		ListADT<Integer> rightList = right.toList();
		for (int i=0; i<rightList.size(); i++) {
			if (left.contains(rightList.getIndex(i))) {
				output.insert(rightList.getIndex(i));
			} else {}
		}
		return output;
	}
	
	@Test
	public void testSetIntersection() {
		SetADT<Integer> set1 = new JavaSet<>();
		set1.insert(1);
		set1.insert(2);
		set1.insert(3); 
		SetADT<Integer> set2 = new JavaSet<>();
		set2.insert(3); 
		set2.insert(4);
		set2.insert(5);
		SetADT<Integer> finalSet = new JavaSet<>();
		finalSet.insert(3);
		for (int i=0; i<finalSet.size(); i++) {
			assertEquals(intersection(set1, set2).toJava(), finalSet.toJava());
		}
	}
	
	// Count the words in the input list and put them in the map.
	public static MapADT<String, Integer> wordCount(ListADT<String> words) {
		MapADT<String, Integer> output = new JavaMap<>();
		List<String> wordsJavaList = words.toJava();
		for (int i = 0; i < wordsJavaList.size(); i++) {
			String aWord = wordsJavaList.get(i);
			int count = 1;
			wordsJavaList.add(i, null);
			for (int j= 0; j < wordsJavaList.size(); j++) {
				if(wordsJavaList.get(j) == aWord && !(output.getKeys().toJava().contains(aWord))) {
					count += 1;
				} else {}
			}
			output.put(aWord, (Integer) count);
		}
		return output;
	}
	
	
	@Test
	public void testWordCount() {
		ListADT<String> randomWords = new JavaList<>();
		randomWords.addFront("try");
		randomWords.addFront("I");
		randomWords.addBack("try");
		randomWords.addBack("my");
		randomWords.addBack("best");
		randomWords.addBack("best");
		MapADT<String, Integer> gotMap = wordCount(randomWords);
		MapADT<String, Integer> expectedMap = new JavaMap <>();
		expectedMap.put("I", 1);
		expectedMap.put("try", 2);
		expectedMap.put("my", 1);
		expectedMap.put("best", 2);
		assertEquals(gotMap.toJava(), expectedMap.toJava());
	}
	
	
	
}
