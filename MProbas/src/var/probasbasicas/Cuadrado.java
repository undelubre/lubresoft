package var.probasbasicas;

public class Cuadrado {
	
	Integer lado;
	final private Integer numLados = 4;

	public Cuadrado(Cuadrado c){
		lado = c.lado;
	}
	
	
	public Cuadrado(Integer lado) {
		super();
		this.lado = lado;
	}

	public Integer getLado() {
		return lado;
	}

	public void setLado(Integer lado) {
		this.lado = lado;
	}

	public Integer getNumLados() {
		return numLados;
	}

	//non compila
//	public void setNumLados(Integer numLados){
//		this.numLados = numLados;
//	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "lado= "+lado+", numLados= "+numLados ;
	}
	
	

}
