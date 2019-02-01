package swt.components;

import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Listener;
import org.eclipse.swt.widgets.Shell;

public class ComboExample2 {
  Display display;

  Shell shell;

  ComboExample2() {
    display = new Display();
    shell = new Shell(display);
    shell.setSize(500, 500);
    
    shell.setText("A Combo Example");
    shell.setLayout(new GridLayout());
    
    Composite composite = new Composite(shell, SWT.BORDER);
    GridLayout gl = new GridLayout(1, true);
    gl.marginHeight = 10;
    gl.marginWidth = 10;
    composite.setLayout(gl);
    composite.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true));
    
    final Combo c1 = new Combo(composite, SWT.READ_ONLY | SWT.DROP_DOWN);
    c1.setBounds(50, 20, 150, 65);
    
    
    final Combo c2 = new Combo(composite, SWT.READ_ONLY);
    c2.setBounds(50, 20, 150, 65);
    c2.setEnabled(false);
    String items[] = { "Item One", "Item Two", "Item Three", "Item Four",
        "Item Five" };
    c1.setItems(items);
    
    c1.addSelectionListener(new SelectionAdapter() {
      public void widgetSelected(SelectionEvent e) {
    	  System.out.println("Evento Selection");
        if (c1.getText().equals("Item One")) {
          String newItems[] = { "Item One A", "Item One B",
              "Item One C" };
          c2.setItems(newItems);
          c2.setEnabled(true);
        } else if (c1.getText().equals("Item Two")) {
          String newItems[] = { "Item Two A", "Item Two B",
              "Item Two C" };
          c2.setItems(newItems);
          c2.setEnabled(true);
        } else {
          c2.add("Not Applicable");
          c2.setText("Not Applicable");
        }

      }
    });
    
    
    c1.addListener(SWT.CLOSE, new Listener() {
		
		@Override
		public void handleEvent(Event event) {
			System.out.println("Evento close");
		}
	});
    
    c1.addListener(SWT.OPEN, new Listener() {
    	
    	@Override
    	public void handleEvent(Event event) {
    		System.out.println("Evento open");
    	}
    });
    
    c1.addListener(SWT.Verify, new Listener() {
    	
    	@Override
    	public void handleEvent(Event event) {
    		System.out.println("Evento verify");
    	}
    });
    
    c1.addListener(SWT.OrientationChange, new Listener() {
    	
    	@Override
    	public void handleEvent(Event event) {
    		System.out.println("Evento OrientationChange");
    	}
    });

    c1.addListener(SWT.Modify, new Listener() {
    	
    	@Override
    	public void handleEvent(Event event) {
    		System.out.println("Evento Modify");
    	}
    });
    
    c1.addListener(SWT.MouseDown, new Listener() {
    	
    	@Override
    	public void handleEvent(Event event) {
    		System.out.println("Evento click");
    	}
    });
    
    
    c1.addListener(SWT.DROP_DOWN, new Listener() {
    	
    	@Override
    	public void handleEvent(Event event) {
    		System.out.println("Evento DROP_DOWN");
    	}
    });
    
    
    
    shell.open();
    while (!shell.isDisposed()) {
      if (!display.readAndDispatch())
        display.sleep();
    }
    display.dispose();
  }

  public static void main(String[] argv) {
    new ComboExample2();
  }
}