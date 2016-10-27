/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author diana
 */
import com.diana.dao.SedeDAO;
import com.diana.dao.CiudadDAO;
import com.diana.model.Ciudad;
import com.diana.model.Sede;
import com.diana.model.Tipo;


import java.sql.SQLException;
import java.util.Iterator;
import java.util.List;
import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.StackLayout;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.layout.RowData;
import org.eclipse.swt.layout.RowLayout;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableColumn;
import org.eclipse.swt.widgets.TableItem;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Listener;
import org.eclipse.swt.widgets.Event;

public class App {

	static int pageNum = 0;
    public static void main(String[] args) {
        
        Display display = new Display ();
		Shell shell = new Shell(display);
		shell.setText("Resultados");
		shell.setSize(550, 600);
	    
		
		// Draw layout
	    GridLayout gridLayout = new GridLayout();
	    gridLayout.numColumns = 1;
	    shell.setLayout(gridLayout);
	    
	    
	    //Button to change contents
	    RowLayout rowLayout = new RowLayout();
	    shell.setLayout(rowLayout);
	    rowLayout.type = SWT.VERTICAL;
		Button buttonciudades = new Button(shell, SWT.PUSH);
		buttonciudades.setText("Sedes");
		buttonciudades.setLayoutData(new RowData(550, 40));
	    
	    
	    
	    
	    // Results of query, first screen
	    final Composite contentPanel = new Composite(shell, SWT.BORDER);
	    contentPanel.setBounds(100, 10, 190, 90);
	    final StackLayout layout = new StackLayout();
	    contentPanel.setLayout(layout);

	    
	    final Composite page0 = new Composite(contentPanel, SWT.NONE);
	    page0.setLayout(new RowLayout());
	    new CiudadPantalla(page0);
	    
	    
	    
	    // List of sedes
	    final Composite page1 = new Composite(contentPanel, SWT.NONE);
	    RowLayout rowLayout1 = new RowLayout();
	    page1.setLayout(rowLayout1);
	    rowLayout1.type = SWT.VERTICAL;
		Button buttoncrear = new Button(page1, SWT.PUSH);
		buttoncrear.setText("Crear");
		buttoncrear.setLayoutData(new RowData(250, 40));
		new SedePantalla(page1);
		
	    
	    
		// Initialise layout
		layout.topControl = page0;
	    
	    buttonciudades.addListener(SWT.Selection, new Listener() {
	        public void handleEvent(Event event) {
	          pageNum = ++pageNum % 2;
	          if(pageNum == 0) {
	        	  layout.topControl = page0;
	        	  buttonciudades.setText("Lista de Sedes");
	          }
	          else{
	        	  layout.topControl = page1;
	        	  buttonciudades.setText("Lista de Ciudades");
	          }
	          contentPanel.layout();
	        }
	    });
	    
	    buttoncrear.addListener(SWT.Selection, new Listener(){
	    	public void handleEvent(Event event) {
	    		new Crear(shell);
	    	}
	    });
	    
	    
	    
		
		shell.pack();
		shell.open ();
		while (!shell.isDisposed ()) {
			if (!display.readAndDispatch ()) display.sleep ();
		}
		display.dispose ();

        
    }

}
