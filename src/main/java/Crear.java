import java.util.Iterator;

import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.layout.RowData;
import org.eclipse.swt.layout.RowLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Listener;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableColumn;
import org.eclipse.swt.widgets.TableItem;

import com.diana.dao.CiudadDAO;
import com.diana.model.Ciudad;
import com.diana.model.Sede;


public class Crear {
	public Crear(Shell parent) {
	    Shell child = new Shell(parent);
	    child.setSize(500, 300);
	    child.setText("Crear nueva Sede");
	    GridLayout gridLayoutChild = new GridLayout();
	    gridLayoutChild.numColumns = 1;
	    child.setLayout(gridLayoutChild);
	    RowLayout rowLayout1 = new RowLayout();
	    child.setLayout(rowLayout1);
	    rowLayout1.type = SWT.VERTICAL;
		Button buttoncancel = new Button(child, SWT.PUSH);
		buttoncancel.setText("Cancel");
		buttoncancel.setLayoutData(new RowData(500, 40));
	    buttoncancel.addListener(SWT.Selection, new Listener() {
	        @Override
	        public void handleEvent(Event event) {
                child.dispose();
            }
	    });
	    child.open();
	    
	  }
}
