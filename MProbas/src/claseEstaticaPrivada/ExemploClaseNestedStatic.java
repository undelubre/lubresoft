package claseEstaticaPrivada;



/**
 * https://docs.oracle.com/javase/tutorial/java/javaOO/nested.html
 * https://www.caveofprogramming.com/java/java-static-class-tutorial.html
 * 
 * */
public class ExemploClaseNestedStatic {
	
	private static Integer VARIABLESTATICA = 123;
	
	private Integer enteiro;
	private String string;
	
	
	public ExemploClaseNestedStatic() {
		System.out.println("Constructor ExemploClaseEstaticaPrivada() ...");
	}

	
	public void metodoProba(){
		System.out.println();
		System.out.println("InnerClass.metodoProba  ...VARIABLESTATICA= "+VARIABLESTATICA);
		//Erro de compilacion
//		System.out.println("InnerClass.metodoProba  ...innerEnteiro= "+NestedClassEstatica.nestedEnteiro);
		System.out.println("InnerClass.metodoProba  ...enteiro= "+enteiro);
		System.out.println();
	}
	
	public static void metodoProba2(){
		System.out.println();
		System.out.println("InnerClass.metodoProba  ...VARIABLESTATICA= "+VARIABLESTATICA);
		//Erro de compilacion
//		System.out.println("InnerClass.metodoProba  ...innerEnteiro= "+NestedClassEstatica.nestedEnteiro);
		//Erro de compilacion
//		System.out.println("InnerClass.metodoProba  ...enteiro= "+enteiro);
		System.out.println();
	}
	
	

	public Integer getEnteiro() {
		return enteiro;
	}
	public void setEnteiro(Integer enteiro) {
		this.enteiro = enteiro;
	}
	public String getString() {
		return string;
	}
	public void setString(String string) {
		this.string = string;
	}













/* ************************************************************************** */

	
	/**
	 * Nota miña: non lle vexo moito sentido que dentro dunha clase interna statica haxa campos, ou metodos non estaticos.
	 * 
	 * */

	public static class NestedClassEstatica{
		private Integer nestedEnteiro;
		private String nestedString;
		
		
		
		/*Dende a clase estatica tense acceso as variables staticas da clase principal (outer)*/
		public NestedClassEstatica() {
			System.out.println("Constructor InnerClassEstatica() ...VARIABLESTATICA= "+VARIABLESTATICA);
//			enteiro = 0;//Esto non compila (Cannot make a static reference to the non-static field enteiro)
		}
		public NestedClassEstatica(Integer nestedEnteiro, String nestedString) {
			super();
			this.nestedEnteiro = nestedEnteiro;
			this.nestedString = nestedString;
		}

		public void metodoProba(){
			System.out.println("NestedClassEstatica.metodoProba ...VARIABLESTATICA= "+VARIABLESTATICA);
//			enteiro = 0;//Esto non compila (Cannot make a static reference to the non-static field enteiro)
		}
		
		
		
		public Integer getNestedEnteiro() {
			return nestedEnteiro;
		}
		public void setNestedEnteiro(Integer nestedEnteiro) {
			this.nestedEnteiro = nestedEnteiro;
		}
		public String getNestedString() {
			return nestedString;
		}
		public void setNestedString(String nestedString) {
			this.nestedString = nestedString;
		}


		@Override
		public String toString() {
			return "NestedClassEstatica [nestedEnteiro=" + nestedEnteiro
					+ ", nestedString=" + nestedString + "]";
		}
	}




	public class InnerClass{
		private Integer innerEnteiro;
		private String innerString;
		
		public InnerClass() {
			System.out.println("Cosntructor InnerClass()  ...VARIABLESTATICA= "+VARIABLESTATICA);
		}
		
		public void metodoProba(){
			System.out.println();
			System.out.println("InnerClass.metodoProba  ...VARIABLESTATICA= "+VARIABLESTATICA);
			System.out.println("InnerClass.metodoProba  ...innerEnteiro= "+innerEnteiro);
			System.out.println("InnerClass.metodoProba  ...enteiro= "+enteiro);
			System.out.println();
		}
		
		
		public Integer getInnerEnteiro() {
			return innerEnteiro;
		}
		public void setInnerEnteiro(Integer innerEnteiro) {
			this.innerEnteiro = innerEnteiro;
		}
		public String getInnerString() {
			return innerString;
		}
		public void setInnerString(String innerString) {
			this.innerString = innerString;
		}




		@Override
		public String toString() {
			return "InnerClass [innerEnteiro=" + innerEnteiro
					+ ", innerString=" + innerString + "]";
		}
		
	}

}
