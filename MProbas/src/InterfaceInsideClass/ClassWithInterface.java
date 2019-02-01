package InterfaceInsideClass;

public class ClassWithInterface {

	
	private Interface1 interfazPriv;
	
	public interface Interface1{
		//Static final by default
		Integer int0 = 0;
		
		public void metodo1(String orixenDeExecucion);
	}
	
	
	public ClassWithInterface() {
		interfazPriv = new Interface1ImplPriv();
	}
	
	public void metodo0(){
		System.out.println("Executando metodo0");
		
		interfazPriv.metodo1("ClassWithInterface.metodo0()");
	}
	
	
	
	
	
	
	
	public class Interface1ImplPriv implements Interface1{

		@Override
		public void metodo1(String orixenDeExecucion) {
			System.out.println(orixenDeExecucion+" ---> Interface1ImplPriv.metodo1() - implementacion interface ClassWithInterface en clase privada");
		}
	}
}
