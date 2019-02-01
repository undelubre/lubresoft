package cloning;

public class Object1 {
	private Integer integer1;
	private int int2;
	
	private Object2 obj2;

	public Object1(){
		
	}
	
	public Object1(Integer int1, int int2, Object2 obj2) {
		super();
		this.integer1 = int1;
		this.int2 = int2;
		this.obj2 = obj2;
	}
	
	
	public Integer getInteger1() {
		return integer1;
	}

	public void setInteger1(Integer int1) {
		this.integer1 = int1;
	}

	public int getInt2() {
		return int2;
	}

	public void setInt2(int int2) {
		this.int2 = int2;
	}

	public Object2 getObj2() {
		return obj2;
	}

	public void setobj2(Object2 obj2) {
		this.obj2 = obj2;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((integer1 == null) ? 0 : integer1.hashCode());
		result = prime * result + int2;
		result = prime * result + ((obj2 == null) ? 0 : obj2.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Object1 other = (Object1) obj;
		if (integer1 == null) {
			if (other.integer1 != null)
				return false;
		} else if (!integer1.equals(other.integer1))
			return false;
		if (int2 != other.int2)
			return false;
		if (obj2 == null) {
			if (other.obj2 != null)
				return false;
		} else if (!obj2.equals(other.obj2))
			return false;
		return true;
	}

	
	
	
	
	
	
	
	
	public Object1 clone(){
		try {
			return (Object1)super.clone();
		} catch (CloneNotSupportedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return null;
	}

	public Object1 clone1(){
		Object1 o1 = new Object1();
	
		o1.setInteger1(this.getInteger1());
		o1.setInt2(this.getInt2());
		o1.setobj2(this.getObj2().clone());
		
		return o1;
	}	

	public Object1 clone2(){
		Object1 o1 = new Object1();
	
		Integer i = new Integer(this.getInteger1());
		
		o1.setInteger1(i);
		o1.setInt2(this.getInt2());
		o1.setobj2(this.getObj2());
		
		return o1;
	}	

	
	
	
	public static void main(String args[]){
		
		Object2 o2 = new Object2("asdf", 999L);
		
		Object1 o1 = new Object1(1, 2, o2);
		
		
		Object1 clone0 = o1.clone();
		System.out.println("Exception porque o metodo super.clone() non funciona....\n");

		
		Object1 clone1 = o1.clone1();
		
		System.out.println("\n");
		System.out.println("Metodo de clonacion: clone1 ....\n");
		
		System.out.println("o1 == clone1: "+(o1 == clone1));
		System.out.println("o1.getInteger1() == clone1.getInteger1(): "+(o1.getInteger1() == clone1.getInteger1())+" ---> Aqui observase que non se clona, se non que o 'integer1' do clon ten simplemente unha referenca ao 'integer1' do obxeto orixinal");
		System.out.println("o1.getInt2() == clone1.getInt2(): "+(o1.getInt2() == clone1.getInt2()));
		System.out.println("o1.getObj2() == clone1.getObj2(): "+(o1.getObj2() == clone1.getObj2()));

		System.out.println("(o1.equals(clone1)): "+(o1.equals(clone1)));
		System.out.println("o1.getInteger1().equals(clone1.getInteger1()): "+(o1.getInteger1().equals(clone1.getInteger1())));
		System.out.println("o1.getObj2().equals(clone1.getObj2()): "+(o1.getObj2().equals(clone1.getObj2())));
			
			
		System.out.println("\n");
//		Object1 clone2 = o1.clone2();
		System.out.println("Comparando clonacion object2");
		
		System.out.println("o1.getObj2().getStr1() == o2.getStr1(): "+(o1.getObj2().getStr1() == o2.getStr1()));
		System.out.println("o1.getObj2().getLong1() == o2.getLong1()): "+(o1.getObj2().getLong1() == o2.getLong1()));
		
		
		
		
		
		
		
		
		System.out.println("\n");
		System.out.println("\n\nMetodo de clonacion: clone2 ....\n");
		
		Object1 clone2 = o1.clone2();
		
		
		System.out.println("o1 == clone2: "+(o1 == clone2));
		System.out.println("o1.getInteger1() == clone2.getInteger1(): "+(o1.getInteger1() == clone2.getInteger1()));
		System.out.println("o1.getInt2() == clone2.getInt2(): "+(o1.getInt2() == clone2.getInt2()));
		System.out.println("o1.getObj2() == clone2.getObj2(): "+(o1.getObj2() == clone2.getObj2()));
		
		System.out.println("(o1.equals(clone2)): "+(o1.equals(clone2)));
		System.out.println("o1.getInteger1().equals(clone2.getInteger1()): "+(o1.getInteger1().equals(clone2.getInteger1())));
		System.out.println("o1.getObj2().equals(clone2.getObj2()): "+(o1.getObj2().equals(clone2.getObj2())));
		
		
		System.out.println("\n");
//		Object1 clone2 = o1.clone2();
		System.out.println("Comparando clonacion object2");
		
		System.out.println("o1.getObj2().getStr1() == o2.getStr1(): "+(o1.getObj2().getStr1() == o2.getStr1())+"  ---->  este chama a atencion, pero os String son inmutables ==> o obxeto orixinal e a clonacion son o mesmo obxeto");
		System.out.println("o1.getObj2().getLong1() == o2.getLong1()): "+(o1.getObj2().getLong1() == o2.getLong1()));
		
		
	}
}
