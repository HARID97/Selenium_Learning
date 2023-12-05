package New_Package;

import org.testng.annotations.Test;

public class Child_Class2 extends Parent_Class{
	
	@Test
	public void print_result() {
		method1();
		//calling parameterized constructor of another class(not parent)
		Not_ParentClass ps = new Not_ParentClass(5);
		System.out.println(ps.increment());
		System.out.println(ps.decrement());
		
		//calling the method of Parent_Class3 by using object of Not_ParentClass
		System.out.println(ps.multiplyByThree());
	}
	

}
