package New_Package;

import java.util.Arrays;

public class Array_Sort {
	
	public static void main(String args[]) {
		
		int[] array1 = {25,11,23,99,5,6,1};
		int temp=0;
		
		for(int i=0;i<array1.length;i++) {
			for(int j=1;j<array1.length;j++) {
				if(array1[j]<array1[j-1]) {
					temp=array1[j-1];
					array1[j-1]=array1[j];
					array1[j]=temp;
				}
			}
		}
		System.out.println(Arrays.toString(array1));
		
	}

}
