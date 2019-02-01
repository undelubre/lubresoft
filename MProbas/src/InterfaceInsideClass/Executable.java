package InterfaceInsideClass;

import InterfaceInsideClass.ClassWithInterface.Interface1;

public class Executable {

	private Interface1 interfaz;
	
	public static void main(String args[]){
		ClassWithInterface classInter = new ClassWithInterface();
		classInter.metodo0();
		
		
		Interface1 interfaceImpl = new Interface1Impl();
		interfaceImpl.metodo1("main()");
		
		/*Erro compilacion:
		 * No enclosing instance of type ClassWithInterface is accessible. Must qualify 
		 * the allocation with an enclosing instance of type ClassWithInterface 
		 * (e.g. x.new A() where x is an instance of ClassWithInterface).
		 * */
//		Interface1 interfaceImlPriv = new ClassWithInterface.Interface1ImplPriv();
	}
}
