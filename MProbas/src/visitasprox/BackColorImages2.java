package visitasprox;

import java.io.File;
import java.net.URL;

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

/**
 * 
 * Ao ocultar e excluir un Composite,  non exclue os compoñentes que conten
 * 
 * 
 * @author unoh
 *
 */
public class BackColorImages2 {
	
	private Shell shell;

	private Composite c1;
	private Composite c2;

	private GridData gd1;
	private GridData gd2;
	
	private Button button;
	
	private Composite mainComp; 
	
	public BackColorImages2(Shell shell) {
		super();
		this.shell = shell;
	}

	public void crearElementos(Composite parent){
		
		GridLayout mainLayout = new GridLayout(1, true);
		
		mainComp = CustomFormFactory.creaComposite(parent, SWT.BORDER, mainLayout, null);
		mainComp.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, false));
		
		gd1 = new GridData(SWT.FILL, SWT.CENTER, true, false);
		gd2 = new GridData(SWT.FILL, SWT.CENTER, true, false);
		
		c1 = CustomFormFactory.creaComposite(mainComp, SWT.BORDER, new GridLayout(3, false), gd1);
		c2 = CustomFormFactory.creaComposite(mainComp, SWT.BORDER, new GridLayout(3, false), gd2);
		
		
		GridLayout backLayout = new GridLayout(1, false);
		backLayout.marginHeight = 10;
		backLayout.marginWidth = 20;
		Composite backComposite = new Composite(c1, SWT.BORDER);
		
		
		
		backComposite.setBackground(shell.getDisplay().getSystemColor(SWT.COLOR_WHITE));
		backComposite.setLayout(backLayout);

		
		Image nube = loadImage("resources/imax/nube.jpeg");
		Label labelImage = new Label(backComposite, SWT.BORDER); 
		labelImage.setLayoutData(new GridData(SWT.CENTER, SWT.CENTER, true, true));
		labelImage.setImage(nube);
		
		Label bottonLabel = new Label(backComposite, SWT.NONE);
		bottonLabel.setText("Etiqueta1");
		
		Text texto = new Text(c1, SWT.BORDER);
		CustomFormFactory.expandirHorizontal(texto, 2);

		GridLayout backLayout2 = new GridLayout(1, false);
		backLayout2.marginHeight = 10;
		backLayout2.marginWidth = 20;
		Composite backComposite2 = new Composite(c2, SWT.BORDER);
		
		
		
		backComposite2.setBackground(shell.getDisplay().getSystemColor(SWT.COLOR_WHITE));
		backComposite2.setLayout(backLayout2);
		
		
		Image nube2 = loadImage("resources/imax/nube.jpeg");
		Label labelImage2 = new Label(backComposite2, SWT.BORDER); 
		labelImage2.setLayoutData(new GridData(SWT.CENTER, SWT.CENTER, true, true));
		labelImage2.setImage(nube2);
		
		Label bottonLabel2 = new Label(backComposite2, SWT.NONE);
		bottonLabel2.setText("Etiqueta2");
		
		Text texto2 = new Text(c2, SWT.BORDER);
		CustomFormFactory.expandirHorizontal(texto2, 2);
		
		button = new Button(mainComp, SWT.NONE);
		button.setText("Ocultar");
		
		button.addListener(SWT.Selection, new Listener() {

			boolean mostrar = false;
			
			@Override
			public void handleEvent(Event event) {
				
				if(mostrar){
					
					gd1.exclude = false;
					c1.setVisible(true);
					gd2.exclude = true;
					c2.setVisible(false);
					
//					CustomFormFactory.ocultar(c1);
//					CustomFormFactory.mostrar(c2);
					
					button.setText("Ocultar");
					mostrar = false;
					
				}else{
					
					gd1.exclude = true;
					c1.setVisible(false);
					gd2.exclude = false;
					c2.setVisible(true);

//					CustomFormFactory.ocultar(c2);
//					CustomFormFactory.mostrar(c1);
					
					button.setText("Mostrar");
					mostrar = true;
				}
				
				mainComp.layout();
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
		 URL location = BackColorImages2.class.getProtectionDomain().getCodeSource().getLocation();
		 System.out.println(location.getFile());
		 
		 File file = new File("resources/imax/nube.jpeg");
		 String absolutePath = file.getAbsolutePath();
		 System.out.println(absolutePath);
		 
		 
		 
		 
		 
		 
		 
		 
		    Display display = new Display();
		    Shell shell = new Shell(display);
		 	    
		    GridLayout mainLayout = new GridLayout();
		    shell.setLayout(mainLayout);
		    
		    BackColorImages2 c = new BackColorImages2(shell);
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
