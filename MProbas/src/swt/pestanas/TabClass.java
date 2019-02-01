package swt.pestanas;

import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Rectangle;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Listener;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.TabFolder;
import org.eclipse.swt.widgets.TabItem;
import org.eclipse.swt.widgets.Text;

public class TabClass {
  public static void main(String[] args) {
    Display display = new Display();
    final Shell shell = new Shell(display);
    shell.setText("Tab Folder Example");
    shell.setSize(450, 250);

    final TabFolder tabFolder = new TabFolder(shell, SWT.BORDER);

    for (int loopIndex = 0; loopIndex < 10; loopIndex++) {
      TabItem tabItem = new TabItem(tabFolder, SWT.NULL);
      tabItem.setText("Tab " + loopIndex);

      Text text = new Text(tabFolder, SWT.BORDER);
      text.setText("This is page " + loopIndex);
      tabItem.setControl(text);
    }
//    tabFolder.setSize(400, 200);
    
    
    shell.addListener (SWT.Resize,  new Listener () {
        public void handleEvent (Event e) {
          
          tabFolder.setSize(shell.getSize());
        }
      });
    

    shell.open();
    while (!shell.isDisposed()) {
      if (!display.readAndDispatch())
        display.sleep();
    }
    display.dispose();
  }
}