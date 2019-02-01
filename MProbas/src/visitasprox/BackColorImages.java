package visitasprox;

import java.io.File;
import java.net.URL;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Listener;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;

public class BackColorImages {
	
	private Shell shell;

	private Composite backCompositeImagen1;
	private Composite backCompositeImagen2;
	
	private Text texto1;
	private Text texto2;
	
	private Composite vacio;
	
	
	
	private Button button;
	
	private Composite mainComp; 
	
	public BackColorImages(Shell shell) {
		super();
		this.shell = shell;
	}

	public void crearElementos(Composite parent){
		
		GridLayout mainLayout = new GridLayout(3, true);
		
		mainComp = CustomFormFactory.creaComposite(parent, SWT.BORDER, mainLayout, null);
		mainComp.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, false));
		
		
		GridLayout backLayout = new GridLayout(1, false);
		backLayout.marginHeight = 10;
		backLayout.marginWidth = 20;
		backCompositeImagen1 = new Composite(mainComp, SWT.BORDER);
		
		
		
		backCompositeImagen1.setBackground(shell.getDisplay().getSystemColor(SWT.COLOR_WHITE));
		backCompositeImagen1.setLayout(backLayout);

		
		Image nube = loadImage("resources/imax/nube.jpeg");
		Label labelImage = new Label(backCompositeImagen1, SWT.BORDER); 
		labelImage.setLayoutData(new GridData(SWT.CENTER, SWT.CENTER, true, true));
		labelImage.setImage(nube);
		
		Label bottonLabel = new Label(backCompositeImagen1, SWT.NONE);
		bottonLabel.setText("Etiqueta1");
		
		texto1 = new Text(mainComp, SWT.BORDER);
		vacio = CustomFormFactory.insertaElementoVacio(mainComp);
		vacio.setLayoutData(new GridData());
		CustomFormFactory.expandirHorizontal(texto1, 1);

		GridLayout backLayout2 = new GridLayout(1, false);
		backLayout2.marginHeight = 10;
		backLayout2.marginWidth = 20;
		backCompositeImagen2 = new Composite(mainComp, SWT.BORDER);
		
		
		
		backCompositeImagen2.setBackground(shell.getDisplay().getSystemColor(SWT.COLOR_WHITE));
		backCompositeImagen2.setLayout(backLayout2);
		
		
		Image nube2 = loadImage("resources/imax/nube.jpeg");
		Label labelImage2 = new Label(backCompositeImagen2, SWT.BORDER); 
		labelImage2.setLayoutData(new GridData(SWT.CENTER, SWT.CENTER, true, true));
		labelImage2.setImage(nube2);
		
		Label bottonLabel2 = new Label(backCompositeImagen2, SWT.NONE);
		bottonLabel2.setText("Etiqueta2");
		
		texto2 = new Text(mainComp, SWT.BORDER);
		CustomFormFactory.expandirHorizontal(texto2, 2);
		
		button = new Button(mainComp, SWT.NONE);
		button.setText("Ocultar");
		
		button.addListener(SWT.Selection, new Listener() {

			boolean mostrar = false;
			
			@Override
			public void handleEvent(Event event) {
				
				if(mostrar){
					
					CustomFormFactory.ocultar(backCompositeImagen1);
					CustomFormFactory.ocultar(texto1);
					CustomFormFactory.ocultar(vacio);
					CustomFormFactory.mostrar(backCompositeImagen2);
					CustomFormFactory.mostrar(texto2);
					
					button.setText("Ocultar");
					mostrar = false;
					
				}else{

					CustomFormFactory.mostrar(backCompositeImagen1);
					CustomFormFactory.mostrar(texto1);
					CustomFormFactory.mostrar(vacio);
					CustomFormFactory.ocultar(backCompositeImagen2);
					CustomFormFactory.ocultar(texto2);
					
					button.setText("Mostrar");
					mostrar = true;
				}
				
				mainComp.layout();
				shell.layout();
			}
		});
		
	}
	
	private Image loadImage(String filePath){
		 File file = new File(filePath);
		 String absolutePath = file.getAbsolutePath();
		 System.out.println(absolutePath);

		 return new Image(shell.getDisplay(), absolutePath);
	}
	
	
	
	 public static void main(String[] args) {
		 URL location = BackColorImages.class.getProtectionDomain().getCodeSource().getLocation();
		 System.out.println(location.getFile());
		 
		 File file = new File("resources/imax/nube.jpeg");
		 String absolutePath = file.getAbsolutePath();
		 System.out.println(absolutePath);
		 
		 
		 
		 
		 
		 
		 
		 
		    Display display = new Display();
		    Shell shell = new Shell(display);
		 	    
		    GridLayout mainLayout = new GridLayout();
		    shell.setLayout(mainLayout);
		    
		    BackColorImages c = new BackColorImages(shell);
		    c.crearElementos(shell);


//		    shell.setSize(700, 200);
		    shell.open();
		    
		    
		    shell.layout();
		    while (!shell.isDisposed()) {
		      if (!display.readAndDispatch()) 
		        display.sleep();
		    }
		    display.dispose();
		  }

}
