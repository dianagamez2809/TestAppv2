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
import com.diana.dao.SedeDAO;
import com.diana.dao.TipoDAO;
import com.diana.model.Ciudad;
import com.diana.model.Sede;
import com.diana.model.Tipo;


public class Crear {
	public Crear(Shell parent) {
		SedeDAO sededao = new SedeDAO();
		CiudadDAO ciudaddao = new CiudadDAO();
		TipoDAO tipodao = new TipoDAO();
	    Shell child = new Shell(parent);
	    child.setSize(500, 300);
	    child.setText("Crear nueva Sede");
	    GridLayout gridLayoutChild = new GridLayout();
	    gridLayoutChild.numColumns = 1;
	    child.setLayout(gridLayoutChild);
	    RowLayout rowLayout1 = new RowLayout();
	    child.setLayout(rowLayout1);
	    
	    // Button to save record
	    Button buttonsave = new Button(child, SWT.PUSH);
	    buttonsave.setText("Guardar");
	    buttonsave.setLayoutData(new RowData(240, 40));
	    // Function to save new record
	    buttonsave.addListener(SWT.Selection, new Listener() {
	        @Override
	        public void handleEvent(Event event) {
			    Sede sede = new Sede();
		        sede.setAno(2017);
		        
		        Tipo tipo = tipodao.getTipo(1);
		        Ciudad ciudad = ciudaddao.getCiudad(2);
		        sede.setTipo(tipo);
		        sede.setCiudad(ciudad);
		        sededao.createSede(sede);
	        }
	    });
	    
	    // Button to close screen
		Button buttoncancel = new Button(child, SWT.PUSH);
		buttoncancel.setText("Cancel");
		buttoncancel.setLayoutData(new RowData(240, 40));
		// Function to close screen
	    buttoncancel.addListener(SWT.Selection, new Listener() {
	        @Override
	        public void handleEvent(Event event) {
                child.dispose();
            }
	    });
	    
	    child.open();
	    
	}
}
