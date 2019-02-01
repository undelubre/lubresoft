package cloning;

public class Object2 {
	
	private String str1;
	private long long1;
	
	
	public Object2(){}
	
	public Object2(String str1, long long1) {
		super();
		this.str1 = str1;
		this.long1 = long1;
	}


	public String getStr1() {
		return str1;
	}


	public void setStr1(String str1) {
		this.str1 = str1;
	}


	public long getLong1() {
		return long1;
	}


	public void setLong1(long long1) {
		this.long1 = long1;
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (int) (long1 ^ (long1 >>> 32));
		result = prime * result + ((str1 == null) ? 0 : str1.hashCode());
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
		Object2 other = (Object2) obj;
		if (long1 != other.long1)
			return false;
		if (str1 == null) {
			if (other.str1 != null)
				return false;
		} else if (!str1.equals(other.str1))
			return false;
		return true;
	}
	
	public Object2 clone(){
		Object2 o2 = new Object2();
		
		
		//Neste caso estas duas opcions serian validas
//		String s = this.getStr1();
		String s = new String(this.getStr1());
		
		o2.setStr1(s);
		o2.setLong1(this.getLong1());
		
		return o2;
	}	


}
