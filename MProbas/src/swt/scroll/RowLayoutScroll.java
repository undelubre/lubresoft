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
	    final Display display = new Display();
	    this.image1 = display.getSystemImage(SWT.ICON_WORKING);
	    this.image2 = display.getSystemImage(SWT.ICON_QUESTION);
	    this.image3 = display.getSystemImage(SWT.ICON_ERROR);

	    final Shell shell = new Shell(display);
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

	public void init(final Display display, final Shell shell){

	    final ScrolledComposite scrollComposite = new ScrolledComposite(shell,
		        SWT.V_SCROLL | SWT.BORDER);

		    final Composite parent = new Composite(scrollComposite, SWT.NONE);
		    for (int i = 0; i <= 50; i++) {
		      final Label label = new Label(parent, SWT.NONE);
		      if ((i % 3) == 0) {
                label.setImage(this.image1);
            }
		      if ((i % 3) == 1) {
                label.setImage(this.image2);
            }
		      if ((i % 3) == 2) {
                label.setImage(this.image3);
            }
		    }
		    final RowLayout layout = new RowLayout(SWT.HORIZONTAL);
		    layout.wrap = true;
		    parent.setLayout(layout);

		    scrollComposite.setContent(parent);
		    scrollComposite.setExpandVertical(true);
		    scrollComposite.setExpandHorizontal(true);


		    scrollComposite.addControlListener(new ControlAdapter() {
		      @Override
            public void controlResized(final ControlEvent e) {
		        final Rectangle r = scrollComposite.getClientArea();
		        scrollComposite.setMinSize(parent.computeSize(r.width,
		            SWT.DEFAULT));
		      }
		    });
		    final Button b = new Button(shell, SWT.NONE);
		    b.addListener(SWT.Selection, new Listener() {

            // @Override
				public void handleEvent(final Event event) {
					// TODO Auto-generated method stub
				      final Label label = new Label(parent, SWT.NONE);
				  	    final Image image1 = event.display.getSystemImage(SWT.ICON_WORKING);
				        label.setImage(image1);

				        final Rectangle r = scrollComposite.getClientArea();
				        scrollComposite.setMinSize(parent.computeSize(r.width,
				        		SWT.DEFAULT));
				        parent.layout();
				        parent.redraw();
				        scrollComposite.layout();
				        scrollComposite.redraw();
				}
			});


	}


	  public static void main(final String[] args) {

new RowLayoutScroll();
	  }
	}