import java.util.Iterator;

import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableColumn;
import org.eclipse.swt.widgets.TableItem;

import com.diana.dao.CiudadDAO;
import com.diana.model.Ciudad;
import com.diana.model.Sede;


public class Crear {
	Crear(Shell parent) {
	    Shell child = new Shell(parent);
	    child.setSize(500, 500);
	    child.open();
	  }
}
