package swt.scroll;

import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.ScrolledComposite;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;

public class MeuExemplo {

	
	public static void main(String[] args){
	      Display display = new Display ();
	      Shell shell = new Shell (display);
	      shell.setLayout(new FillLayout());

	      ScrolledComposite sc = new ScrolledComposite(shell, SWT.VERTICAL | SWT.BORDER);
	      
	      sc.setExpandHorizontal(true);
	      
	      sc.setLayout(new GridLayout());
	      final Composite c1 = new Composite(sc, SWT.NONE);
	      GridLayout gl = new GridLayout();
	      gl.marginRight = 50;
	      gl.marginLeft = 50;
	      c1.setLayout(gl);
	      
	      Text texto = new Text(c1, SWT.MULTI | SWT.BORDER | SWT.WRAP );
	      GridData gridData = new GridData();
	      gridData.horizontalAlignment = SWT.FILL;
	      gridData.grabExcessHorizontalSpace = true;
	      gridData.heightHint= 100;
	      texto.setLayoutData(gridData);
	      c1.setSize(c1.computeSize(SWT.DEFAULT, SWT.DEFAULT));
		
	      sc.setContent(c1);
		
		
	      shell.open ();
	      while (!shell.isDisposed ()) {
	          if (!display.readAndDispatch ()) display.sleep ();
	      }
	      display.dispose ();
	}
}
