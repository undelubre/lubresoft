package visitasprox;

import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.CLabel;
import org.eclipse.swt.custom.ScrolledComposite;
import org.eclipse.swt.custom.StyledText;
import org.eclipse.swt.events.DisposeEvent;
import org.eclipse.swt.events.DisposeListener;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Listener;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;

public class Comentarios {

	
	private static final int NUM_COLS = 8;

	private static final int ALTO_COMENTARIO = 100;
	
	private Composite comentariosScrollContent;
	private ScrolledComposite comentariosScroll;

	private int contComentarios = 0;
	
	private Color blanco;


	Comentarios(Shell shell){
		
		blanco = shell.getDisplay().getSystemColor(SWT.COLOR_WHITE);
		
		shell.setBackground(blanco);
		
		
		
		
		
		
		shell.addDisposeListener(new DisposeListener() {
			
			@Override
			public void widgetDisposed(DisposeEvent e) {
				// TODO Auto-generated method stub
				System.out.println(" O_O ---> Dispose() -------------------- ");
				
				
			}
		});
	}



	private void crearComentarios(Composite parent){


	        final GridLayout gl = new GridLayout(NUM_COLS, true);

	        final Composite infoComposite = CustomFormFactory.creaCompositeSinEspacios(parent,
	                SWT.NONE, gl, null);
	        infoComposite.setBackground(blanco);

	        CustomFormFactory.expandirHorizontal(infoComposite, 8);


	        final Composite comentariosComposite = CustomFormFactory.creaCompositeSinEspacios(
	                infoComposite, SWT.NONE, new GridLayout(NUM_COLS - 1, true), null);
	        comentariosComposite.setBackground(blanco);

	        CustomFormFactory.expandirHorizontal(comentariosComposite, 8);

	        Label label = new Label(comentariosComposite, SWT.NONE);
	        label.setText("Comentarios:");
	        label.setLayoutData(new GridData(SWT.CENTER, SWT.TOP, false, false));

	        CustomFormFactory.alinear(label, SWT.CENTER, SWT.TOP);

	        comentariosScroll = new ScrolledComposite(comentariosComposite, 
	        		SWT.V_SCROLL | SWT.NONE);
	        comentariosScroll.setBackground(blanco);

	        this.comentariosScrollContent = CustomFormFactory.creaComposite(comentariosScroll, SWT.NONE, new GridLayout(), null);
	        comentariosScrollContent.setBackground(blanco);

	        final GridData layy = new GridData(SWT.FILL, SWT.CENTER, true, false);
	        layy.heightHint = calcularMaxTamScroll(this.contComentarios);
	        comentariosScroll.setLayoutData(layy);


	        comentariosScroll.setExpandVertical(true);
	        comentariosScroll.setExpandHorizontal(true);
	        comentariosScroll.setContent(this.comentariosScrollContent);
	        comentariosScroll.setMinSize(this.comentariosScrollContent.computeSize(SWT.DEFAULT, SWT.DEFAULT));

	        CustomFormFactory.expandirHorizontal(comentariosScroll, 5);
	        CustomFormFactory.insertaElementoVacio(comentariosComposite);

	        insertarComentario(this.comentariosScrollContent, "asldfuy saudf kshadfkljhsa lkdjfhskaldfh lksjdhf klsajhdfkljsahdflkjsahdfkljashdfkljh k k slkdf lksahdfkljh kj hklhs dfkljh salf wiquhef sndlkjvh aslidufhwekljfh s,adjh fuwefk");
	        insertarComentario(this.comentariosScrollContent, null);
	        insertarComentario(this.comentariosScrollContent, null);
	        
	        
	        Combo combo = new Combo(parent, SWT.NONE);
	        combo.setBackground(blanco);
	        
	        RuedaRatonListener list = new RuedaRatonListener();
	        
	        addListenerTo(comentariosScroll, list);
	        addListenerTo(comentariosScrollContent, list);
	        
	}
	
	private void addListenerTo(Composite parent, Listener listener){
		
		for(Control control : parent.getChildren()){
			System.out.println(""+control.toString());
			control.addListener(SWT.MouseWheel, listener);
		}
	}



		private int calcularMaxTamScroll(final int numComentarios) {
		
		    final int tam = ALTO_COMENTARIO + 20;
		
		    if (numComentarios > 1) {
		        return (ALTO_COMENTARIO * 2) + 30;
		    }
		    return tam;
		    // return (componenteBase.computeSize(SWT.DEFAULT, SWT.DEFAULT).y * 2) + 10;
		}

	

	    private Text insertarComentario(final Composite parent, final String texto) {
	        // TODO crear metodo para crear comentario (Text)
	    	Text comentario = null;
	    	
	    	int ancho = this.comentariosScroll.getClientArea().x;

	        if ((texto != null) && !texto.isEmpty()) {
	            comentario = new Text(parent, SWT.MULTI | SWT.READ_ONLY | SWT.WRAP);

	            comentario.setText(texto);

	            final GridData gridData = new GridData();
	            gridData.horizontalAlignment = SWT.FILL;
	            gridData.grabExcessHorizontalSpace = true;

	            // XXX se da un tamaño o las lineas que ocupe el texo????
	            gridData.heightHint = ALTO_COMENTARIO;
	            gridData.widthHint = ancho;

	            comentario.setEditable(false);
	            comentario.setLayoutData(gridData);

	        } else {

	            comentario = new Text(parent, SWT.MULTI | SWT.BORDER | SWT.WRAP);

	            final GridData gridData = new GridData();
	            gridData.horizontalAlignment = SWT.FILL;
	            gridData.grabExcessHorizontalSpace = true;
	            gridData.heightHint = ALTO_COMENTARIO;
	            gridData.widthHint = ancho;

	            comentario.setLayoutData(gridData);
	        }
	        
//	        comentario.addListener(SWT.MouseWheel, new RuedaRatonListener());
	        
	        GridData data = (GridData)comentariosScroll.getLayoutData();
	        data.heightHint = calcularMaxTamScroll(this.contComentarios);
	        
	        comentariosScroll.setMinSize(this.comentariosScrollContent.computeSize(SWT.DEFAULT, SWT.DEFAULT));

	        this.contComentarios++;

	        parent.layout();
	        return comentario;
	    }
	
	
	
	
	
	
	 public static void main(String[] args) {
		    Display display = new Display();
		    Shell shell = new Shell(display);
		 	    
		    GridLayout mainLayout = new GridLayout();
		    shell.setLayout(mainLayout);
		    
		    Comentarios c = new Comentarios(shell);
		    c.crearComentarios(shell);


//		    shell.setSize(700, 200);
		    shell.open();
		    
		    
		    shell.layout();
		    while (!shell.isDisposed()) {
		      if (!display.readAndDispatch()) 
		        display.sleep();
		    }
		    display.dispose();
		  }
	 
	 
	 
	 class RuedaRatonListener implements Listener{
		 
		 public void handleEvent(Event event){
         	System.out.println(" ---------------- ----- -- -");
        	
            int wheelCount = event.count;
            wheelCount = (int) Math.ceil(wheelCount / 3.0f);
            while (wheelCount < 0) {
            	comentariosScroll.getVerticalBar().setIncrement(4);
                wheelCount++;
            }

            while (wheelCount > 0) {
            	comentariosScroll.getVerticalBar().setIncrement(-4);
                wheelCount--;
            }
			 
		 }
	 }

}
