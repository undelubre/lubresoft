package visitasprox;

import org.eclipse.jface.action.Action;
import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.CLabel;
import org.eclipse.swt.events.ModifyEvent;
import org.eclipse.swt.events.ModifyListener;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Layout;


@SuppressWarnings("rawtypes")
public final class CustomFormFactory/* extends BaseCustomFormToolkit */{

    private static final GridData EMPTY_GRID_DATA = new GridData(GridData.FILL, GridData.FILL, true, false);


    // FIXME pasar a toolkit
    public static Button creaRadioButton(final Composite parent, final String text,
            final SelectionAdapter listener) {

        final Button b = new Button(parent, SWT.RADIO);
        b.setText(text);
        b.addSelectionListener(listener);

        return b;
    }



    // FIXME pasar a toolkit
    public static void expandirHorizontal2(final Control control, final int numCeldas) {

        final GridData gd = new GridData(SWT.FILL, SWT.CENTER, true, false);
        gd.horizontalSpan = numCeldas;

        control.setLayoutData(gd);
    }

    // FIXME pasar a toolkit
    public static void expandirHorizontal(final Control control, final int numCeldas) {

        GridData gd = ((GridData) control.getLayoutData());

        if (gd != null) {
            gd.grabExcessHorizontalSpace = true;
            gd.horizontalAlignment = SWT.FILL;
        } else {
            gd = new GridData(SWT.FILL, SWT.CENTER, true, false);
        }
        gd.horizontalSpan = numCeldas;

        control.setLayoutData(gd);
    }

    public static void alinear(final Control control, final int horizontal, final int vertical) {

        GridData gd = ((GridData) control.getLayoutData());

        if (gd == null) {
            gd = new GridData();
        }

        if (horizontal != 0) {
            gd.grabExcessHorizontalSpace = true;
            gd.horizontalAlignment = horizontal;
        }

        if (vertical != 0) {
            gd.grabExcessVerticalSpace = true;
            gd.verticalAlignment = vertical;
        }

        control.setLayoutData(gd);
    }

    // FIXME pasar a toolkit
    public static Composite insertaElementoVacio(final Composite parent) {
        return new Composite(parent, SWT.BORDER);
    }

    // FIXME pasar a toolkit
    public static void insertaElementosVacios(final Composite parent, final int num) {
        for (int i = 0; i < num; i++) {
            insertaElementoVacio(parent);
        }
    }

    // FIXME pasar a toolkit
    public static Composite creaComposite(final Composite parent, final int style,
            final Layout layout, final GridData data) {

        final Composite c = new Composite(parent, style);

        if (layout != null) {
            c.setLayout(layout);
        }

        if (data != null) {
            c.setLayoutData(data);
        }

        return c;
    }

    public static Composite creaCompositeSinEspacios(final Composite parent, final int style,
            final GridLayout layout, final GridData data) {

        final GridData gd = data;
        GridLayout gl = layout;

        if (gl == null) {
            gl = new GridLayout();
        }

        gl.horizontalSpacing = 0;
        gl.verticalSpacing = 0;
        gl.marginBottom = 0;
        gl.marginHeight = 0;
        gl.marginLeft = 0;
        gl.marginRight = 0;
        gl.marginTop = 0;
        gl.marginWidth = 0;

        return creaComposite(parent, style, gl, gd);
    }

    public static void eliminarEspacios(final Composite parent) {

        GridLayout gl = (GridLayout) (parent.getLayout());

        if (gl == null) {
            gl = new GridLayout();
        } else {
            gl = new GridLayout();
        }

        gl.verticalSpacing = 0;
        gl.marginBottom = 0;
        gl.marginHeight = 0;
        gl.marginLeft = 0;
        gl.marginRight = 0;
        gl.marginTop = 0;
        gl.marginWidth = 0;

    }

    public static Combo creaCombo(final Composite parent, final int style, final Layout layout,
            final GridData data) {
        final Combo c = new Combo(parent, style);

        if (layout != null) {
            c.setLayout(layout);
        }
        if (data != null) {
            c.setLayoutData(data);
        }

        return c;
    }

    public static void ocultar(Control control){
    	GridData gd = (GridData)control.getLayoutData();
    	gd.exclude = true;
    	
    	
    	control.setLayoutData(gd);
    	control.setVisible(false);
    }

    public static void mostrar(Control control){
    	GridData gd = (GridData)control.getLayoutData();
    	gd.exclude = false;
    	
    	control.setLayoutData(gd);
    	control.setVisible(true);
    }
    
}


