package swt.dialog;


import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Dialog;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;

public class MainClass {


  public static void main(String[] a) {
    Display d = new Display();
    Shell s = new Shell(d);
    s.setSize(500,500);
    s.open();
    DialogExample cs = new DialogExample(s);
    cs.open();

  }
}
class DialogExample extends Dialog {    
  DialogExample(Shell parent)
  {
      super(parent);        
  }
  public String open()
  {
      Shell parent = getParent(); 
//      Shell dialog = new Shell(parent, SWT.DIALOG_TRIM | SWT.APPLICATION_MODAL); 
      
      Shell dialog = new Shell(parent, SWT.SHELL_TRIM | SWT.APPLICATION_MODAL); 
      dialog.setSize(100,100);
      dialog.setText("A Dialog"); 
      dialog.open(); 
      Display display = parent.getDisplay(); 
      while (!dialog.isDisposed()) 
      { if (!display.readAndDispatch()) display.sleep(); 
      } 
      return "After Dialog";
  }
}