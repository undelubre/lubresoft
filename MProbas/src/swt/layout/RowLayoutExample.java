package swt.layout;

import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.RowLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;

public class RowLayoutExample {
    public static void main(String[] args) {
        Display display = new Display();
        Shell shell = new Shell(display, SWT.BORDER | SWT.RESIZE);
        // Create the layout.
        RowLayout layout = new RowLayout();
        // Optionally set layout fields.
        layout.wrap = true;
        // Set the layout into the composite.
        shell.setLayout(layout);
        // Create the children of the composite.
        new Button(shell, SWT.PUSH).setText("B1");
        new Button(shell, SWT.PUSH).setText("Wide Button 2");
        new Button(shell, SWT.PUSH).setText("Button 3");
        shell.pack();
        shell.open();
        
        while (!shell.isDisposed()) {
            if (!display.readAndDispatch()) display.sleep();
        }
    }
}