package InterfaceInsideClass;

import InterfaceInsideClass.ClassWithInterface.Interface1;

public class Interface1Impl implements Interface1{

	@Override
	public void metodo1(String orixenDeExecucion) {
		System.out.println(orixenDeExecucion+" ---> Interface1Impl.metodo1() - implementacion interface ClassWithInterface");
	}

}
