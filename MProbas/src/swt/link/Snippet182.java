package swt.link;


/*
 * Link example snippet: create a link widget
 * 
 * For a list of all SWT example snippets see
 * http://dev.eclipse.org/viewcvs/index.cgi/%7Echeckout%7E/platform-swt-home/dev.html#snippets
 */
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Link;
import org.eclipse.swt.widgets.Listener;
import org.eclipse.swt.widgets.Shell;

public class Snippet182 {

  public static void main(String[] args) {
	  Snippet182 s = new Snippet182();
	  
    Display display = new Display();
    Shell shell = new Shell(display);
    Link link = new Link(shell, SWT.BORDER);
    link.setText("This a <a>very</a> simple <A>link</A> widget.");
    link.setSize(140, 40);
    
    link.addListener(SWT.Selection, s.new AListener());
    shell.pack();
    shell.open();
    while (!shell.isDisposed()) {
      if (!display.readAndDispatch()) 
        display.sleep();
    }
    display.dispose();
  }
  
  
  public class AListener implements Listener{
	  
	  public void handleEvent(Event e){
		  
		  System.out.println("click en el texto ["+e.text+"]");
		  
		  
	  }
  }
  
}