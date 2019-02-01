package visitasprox;


import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.ScrolledComposite;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.layout.RowLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.FileDialog;
import org.eclipse.swt.widgets.Link;
import org.eclipse.swt.widgets.Listener;
import org.eclipse.swt.widgets.Shell;

public class Anexos {
	
	private Composite anexosContent;

	
	public void crearFilaAnexos(Composite parent, final Shell shell){
		
		

	    GridLayout layout = new GridLayout(2, false);
		GridData anexosData = new  GridData(SWT.FILL, SWT.CENTER, true, false);
	    Composite anexosComposite = CustomFormFactory.creaCompositeSinEspacios(parent, SWT.BORDER, layout, null);
	    anexosComposite.setLayout(layout);
	    anexosComposite.setLayoutData(anexosData);
	    
	    Button button = new Button(anexosComposite, SWT.PUSH);
//		button.setImage(image);
		button.setText("Anexar");
		button.setLayoutData(new GridData(SWT.CENTER, SWT.CENTER, false, false));
		
		
		final ScrolledComposite anexosScroll = new ScrolledComposite(anexosComposite, SWT.BORDER | SWT.V_SCROLL);
		
		GridLayout anexosScrollLayout = new GridLayout();
		GridData anexosScrollData = new  GridData(SWT.FILL, SWT.CENTER, true, true);
		anexosScrollData.heightHint = 100;
		
		anexosScroll.setLayout(anexosScrollLayout);
		anexosScroll.setLayoutData(anexosScrollData);
		
		RowLayout rowLayout = new RowLayout();
		rowLayout.wrap = true;
		GridLayout gridLayout = new GridLayout(4, true);
		
		GridData anexosContentData = new  GridData(SWT.FILL, SWT.CENTER, false, false);
		anexosContent = CustomFormFactory.creaComposite(anexosScroll, SWT.BORDER, rowLayout, anexosContentData);
//		anexosContent = CustomFormFactory.creaComposite(anexosScroll, SWT.BORDER, gridLayout, anexosContentData);
		
		
		
		
		
		anexosScroll.setExpandVertical(true);
		anexosScroll.setExpandHorizontal(true);
		anexosScroll.setContent(anexosContent);
		anexosScroll.setMinSize(anexosContent.computeSize(SWT.DEFAULT, SWT.DEFAULT));
//		anexosContent.setSize(anexosContent.computeSize(SWT.DEFAULT, SWT.DEFAULT));
		
		
		
		
		
		button.addListener(SWT.Selection, new Listener() {
			
			@Override
			public void handleEvent(Event event) {
				
				Link link0 = new Link(anexosContent, SWT.BORDER);
				link0.setText("<a>aaaaaaaaaaaaaa</a>");
//				GridData gd = new GridData();
//				link0.setLayoutData(gd);
				anexosScroll.setMinSize(anexosContent.computeSize(50, SWT.DEFAULT));
//				anexosScroll.setMinSize(anexosContent.computeSize(SWT.DEFAULT, SWT.DEFAULT));
//				anexosContent.setSize(anexosContent.computeSize(SWT.DEFAULT, SWT.DEFAULT));
				anexosContent.layout();
//				anexosScroll.layout();
				

				
//		        FileDialog fd = new FileDialog(shell, SWT.OPEN);
////		        fd.setText("Open");
////		        fd.setFilterPath("C:/");
//		        String[] filterExt = { "*.pdf", "*.jpg", "*.*" };
//		        fd.setFilterExtensions(filterExt);
//
//		        String selected = fd.open();
//		        System.out.println(selected);
			}
		});
	    
	    
		
	}
	
	
	
	 public static void main(String[] args) {
	    Display display = new Display();
	    Shell shell = new Shell(display);
	 	    
	    GridLayout mainLayout = new GridLayout();
	    shell.setLayout(mainLayout);
	    
	    Anexos anexos = new Anexos();


	    shell.setSize(700, 200);
	    shell.open();
	    
	    anexos.crearFilaAnexos(shell, shell);
	    
	    shell.layout();
	    while (!shell.isDisposed()) {
	      if (!display.readAndDispatch()) 
	        display.sleep();
	    }
	    display.dispose();
	  }
	  
	  
	
}
