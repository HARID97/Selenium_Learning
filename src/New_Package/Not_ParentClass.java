package New_Package;

public class Not_ParentClass extends Parent_Class3{
	
	int num;
	
	public Not_ParentClass(int num) {
		super(num);  //invoking the constructor of parent class in child class method
		this.num=num;
		
	}
	
	public int increment() {
		num=num+1;
		return num;
	}
	
	public int decrement() {
		num=num-1;
		return num;
	}

}
