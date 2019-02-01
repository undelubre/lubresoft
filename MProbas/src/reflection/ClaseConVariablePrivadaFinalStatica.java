package reflection;

public class ClaseConVariablePrivadaFinalStatica {
	private final static Integer STATIC_PRIVATE = 219;
	
	private Integer i =0;
	
	
	public ClaseConVariablePrivadaFinalStatica(Integer i) {
		this.i = i;
	}


	@Override
	public String toString() {
		return "ClaseConVariablePrivadaFinalStatica [i=" + i + "][STATIC_PRIVATE= "+STATIC_PRIVATE+"]";
	}

}
