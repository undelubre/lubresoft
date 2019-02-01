package swt.scroll;

/*
 * Create a ScrolledComposite with wrapping content.
 *
 * For a list of all SWT example snippets see
 * http://dev.eclipse.org/viewcvs/index.cgi/%7Echeckout%7E/platform-swt-home/dev.html#snippets
 */
import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.ScrolledComposite;
import org.eclipse.swt.events.ControlAdapter;
import org.eclipse.swt.events.ControlEvent;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.graphics.Rectangle;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.layout.RowLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Listener;
import org.eclipse.swt.widgets.Shell;

public class RowLayoutScroll {

    Image image1;
    Image image2;
    Image image3;

	
	
	public RowLayoutScroll(){
	    Display display = new Display();
	    image1 = display.getSystemImage(SWT.ICON_WORKING);
	    image2 = display.getSystemImage(SWT.ICON_QUESTION);
	    image3 = display.getSystemImage(SWT.ICON_ERROR);

	    Shell shell = new Shell(display);
	    shell.setLayout(new FillLayout());

	    init(display, shell);

	    
	    shell.open();
	    while (!shell.isDisposed()) {
	      if (!display.readAndDispatch()) {
	        display.sleep();
	      }
	    }
	    display.dispose();
	    
	}
	
	public void init(Display display, Shell shell){
		
	    final ScrolledComposite scrollComposite = new ScrolledComposite(shell,
		        SWT.V_SCROLL | SWT.BORDER);

		    final Composite parent = new Composite(scrollComposite, SWT.NONE);
		    for (int i = 0; i <= 50; i++) {
		      Label label = new Label(parent, SWT.NONE);
		      if (i % 3 == 0)
		        label.setImage(image1);
		      if (i % 3 == 1)
		        label.setImage(image2);
		      if (i % 3 == 2)
		        label.setImage(image3);
		    }
		    RowLayout layout = new RowLayout(SWT.HORIZONTAL);
		    layout.wrap = true;
		    parent.setLayout(layout);

		    scrollComposite.setContent(parent);
		    scrollComposite.setExpandVertical(true);
		    scrollComposite.setExpandHorizontal(true);
		    
		    
		    scrollComposite.addControlListener(new ControlAdapter() {
		      public void controlResized(ControlEvent e) {
		        Rectangle r = scrollComposite.getClientArea();
		        scrollComposite.setMinSize(parent.computeSize(r.width,
		            SWT.DEFAULT));
		      }
		    });
		    Button b = new Button(shell, SWT.NONE);
		    b.addListener(SWT.Selection, new Listener() {
				
				@Override
				public void handleEvent(Event event) {
					// TODO Auto-generated method stub
				      Label label = new Label(parent, SWT.NONE);
				  	    Image image1 = event.display.getSystemImage(SWT.ICON_WORKING);
				        label.setImage(image1);

				        Rectangle r = scrollComposite.getClientArea();
				        scrollComposite.setMinSize(parent.computeSize(r.width,
				        		SWT.DEFAULT));
				        parent.layout();
				        parent.redraw();
				        scrollComposite.layout();
				        scrollComposite.redraw();
				}
			});
		
		
	}
	

	  public static void main(String[] args) {
	    
new RowLayoutScroll();
	  }
	}