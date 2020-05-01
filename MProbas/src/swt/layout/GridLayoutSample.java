package swt.layout;

/******************************************************************************
 * Copyright (c) 1998, 2004 Jackwind Li Guojie
 * All right reserved.
 *
 * Created on Jan 29, 2004 10:12:41 AM by JACK
 * $Id$
 *
 * visit: http://www.asprise.com/swt
 *****************************************************************************/



import org.eclipse.swt.SWT;
import org.eclipse.swt.events.MouseEvent;
import org.eclipse.swt.events.MouseListener;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.List;
import org.eclipse.swt.widgets.Shell;

public class GridLayoutSample {
  Display display = new Display();
  Shell shell = new Shell(this.display);

  GridData gridData3;


  public GridLayoutSample() {

    final GridLayout gridLayout = new GridLayout();
    gridLayout.numColumns = 2;
    gridLayout.makeColumnsEqualWidth = true;

    final GridData data = new GridData();
    data.horizontalAlignment = SWT.FILL;

    this.shell.setLayout(gridLayout);

    final Button button1 = new Button(this.shell, SWT.PUSH);
    button1.setText("button1");
    button1.setLayoutData(new GridData(GridData.VERTICAL_ALIGN_BEGINNING));


    final List list = new List(this.shell, SWT.BORDER);
    list.add("item 1");
    list.add("item 2");
    list.add("item 3");
    list.setLayoutData(new GridData(GridData.VERTICAL_ALIGN_CENTER));

    final Button button2 = new Button(this.shell, SWT.PUSH);
    button2.setText("button #2");
    final GridData gridData = new GridData(GridData.VERTICAL_ALIGN_END);
    gridData.horizontalIndent = 5;
    button2.setLayoutData(gridData);

    final Button button3 = new Button(this.shell, SWT.PUSH);
    button3.setText("3");

    this.gridData3 = new GridData(GridData.FILL, GridData.CENTER, true, true);


    button3.setLayoutData(this.gridData3);


    button1.addMouseListener(new MouseListener() {

            // @Override
		public void mouseUp(final MouseEvent e) {
			// TODO Auto-generated method stub

		}

            // @Override
		public void mouseDown(final MouseEvent e) {
			// TODO Auto-generated method stub

//			gridData3.exclude = false;
			button3.setVisible(true);
		}

            // @Override
		public void mouseDoubleClick(final MouseEvent e) {
			// TODO Auto-generated method stub

		}
	});
    button2.addMouseListener(new MouseListener() {

            // @Override
		public void mouseUp(final MouseEvent e) {
			// TODO Auto-generated method stub

		}

            // @Override
		public void mouseDown(final MouseEvent e) {
			// TODO Auto-generated method stub
//			gridData3.exclude = true;
			button3.setVisible(false);
		}

            // @Override
		public void mouseDoubleClick(final MouseEvent e) {
			// TODO Auto-generated method stub

		}
	});




    this.shell.pack();
    this.shell.open();
    //textUser.forceFocus();

    // Set up the event loop.
    while (!this.shell.isDisposed()) {
      if (!this.display.readAndDispatch()) {
        // If no more entries in event queue
        this.display.sleep();
      }
    }

    this.display.dispose();
  }

  private void init() {

  }

  public static void main(final String[] args) {
    new GridLayoutSample();
  }
}