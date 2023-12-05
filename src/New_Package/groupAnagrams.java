package New_Package;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

//Given an array of strings strs, group the anagrams together. You can return the answer in any order.
//An Anagram is a word or phrase formed by rearranging the letters of a different word or phrase, typically using all the original letters exactly once.

class groupAnagrams {
    public List<List<String>> groupAnagrams_method(String[] strs) {
        
    	List<List<String>> output_array = new ArrayList<List<String>>();
    	List<List<String>> output_array2 = new ArrayList<List<String>>();
        
        for(int i=0;i<strs.length;i++) {
        	//System.out.println("Element: "+strs[i]);
        	List<String> temp_list = new ArrayList();
        	temp_list.add(strs[i]);
        	String[] temp=strs[i].split("");
        	Arrays.sort(temp);
        	for(int j=i+1;j<strs.length;j++) {
        		String[] temp2=strs[j].split("");
        		Arrays.sort(temp2);
        		if(Arrays.toString(temp).equals(Arrays.toString(temp2))) {
        			temp_list.add(strs[j]);
        		}
        	
        	}
        	Collections.sort(temp_list);
        	output_array.add(temp_list);
        	
        }
        System.out.println("Output Array: "+output_array);
        output_array2.add(output_array.get(0));
        
        for(int i=0;i<output_array.size();i++) {
        	List<String> temp1 = output_array.get(i);
        	System.out.println("temp1: "+temp1);
        	for(int j=i+1;j<output_array.size();j++) {
        		boolean flag=true;
        		List<String> temp2 = output_array.get(j);
        		System.out.println("temp2: "+temp2);
        		for(String str:temp2) {
        			if(temp1.contains(str)==false) {
        				flag=false;
        			}
        		}
        		if(flag==true) {
        			output_array.remove(j);
        		}
        		if(flag==false) {
        			output_array2.add(temp2);
        		}
        	}
        }
        return output_array;
        
    }
    
    public static void main(String args[]) {
    	String[] anagrams = {"eat","tea","tan","ate","nat","bat"};
    	groupAnagrams obj1 = new groupAnagrams();
    	System.out.println("Final Array: "+obj1.groupAnagrams_method(anagrams));
    }
}