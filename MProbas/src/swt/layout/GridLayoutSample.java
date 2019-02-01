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
  Shell shell = new Shell(display);

  GridData gridData3;
  
  
  public GridLayoutSample() {
    
    GridLayout gridLayout = new GridLayout();
    gridLayout.numColumns = 2;
    gridLayout.makeColumnsEqualWidth = true;
    
    GridData data = new GridData();
    data.horizontalAlignment = SWT.FILL;
    
    shell.setLayout(gridLayout);

    Button button1 = new Button(shell, SWT.PUSH);
    button1.setText("button1");
    button1.setLayoutData(new GridData(GridData.VERTICAL_ALIGN_BEGINNING));
    
    
    List list = new List(shell, SWT.BORDER);
    list.add("item 1");
    list.add("item 2");
    list.add("item 3");
    list.setLayoutData(new GridData(GridData.VERTICAL_ALIGN_CENTER));
    
    Button button2 = new Button(shell, SWT.PUSH);
    button2.setText("button #2");  
    GridData gridData = new GridData(GridData.VERTICAL_ALIGN_END);
    gridData.horizontalIndent = 5;
    button2.setLayoutData(gridData);
    
    final Button button3 = new Button(shell, SWT.PUSH);
    button3.setText("3");
    
    gridData3 = new GridData(GridData.FILL, GridData.CENTER, true, true);
    
    
    button3.setLayoutData(gridData3);

    
    button1.addMouseListener(new MouseListener() {
		
		@Override
		public void mouseUp(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}
		
		@Override
		public void mouseDown(MouseEvent e) {
			// TODO Auto-generated method stub
			
//			gridData3.exclude = false;
			button3.setVisible(true);
		}
		
		@Override
		public void mouseDoubleClick(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}
	});
    button2.addMouseListener(new MouseListener() {
		
		@Override
		public void mouseUp(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}
		
		@Override
		public void mouseDown(MouseEvent e) {
			// TODO Auto-generated method stub
//			gridData3.exclude = true;
			button3.setVisible(false);
		}
		
		@Override
		public void mouseDoubleClick(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}
	});

    
    
    
    shell.pack();
    shell.open();
    //textUser.forceFocus();

    // Set up the event loop.
    while (!shell.isDisposed()) {
      if (!display.readAndDispatch()) {
        // If no more entries in event queue
        display.sleep();
      }
    }

    display.dispose();
  }

  private void init() {

  }

  public static void main(String[] args) {
    new GridLayoutSample();
  }
}