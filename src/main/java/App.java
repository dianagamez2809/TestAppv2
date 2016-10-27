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
        CiudadDAO ciudaddao = new CiudadDAO();
        SedeDAO sededao = new SedeDAO();
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
	    Table table = new Table(page0,  SWT.Resize | SWT.V_SCROLL
	            | SWT.H_SCROLL);
        table.setHeaderVisible(true);
        String[] titlesciudades = { "ID_PAIS", "PAIS", "ID_CIUDAD", "CIUDAD", "VALOR", "NUMERO_SEDE", "DESCRIPCION" };

        for (int loopIndex = 0; loopIndex < titlesciudades.length; loopIndex++) {
          TableColumn column = new TableColumn(table, SWT.NULL);
          column.setText(titlesciudades[loopIndex]);
        }
		
		for (Ciudad ciudad : ciudaddao.listCiudades()) {
		    TableItem item = new TableItem(table, SWT.NULL);
		    item.setText(0, ciudad.getPais().getId().toString());
		    item.setText(1, ciudad.getPais().getNombrePais());
		    item.setText(2, ciudad.getId().toString());
		    item.setText(3, ciudad.getNombreCiudad());
			if(ciudad.getValorCiudad() == null){
				item.setText(4, ciudad.getPais().getValorPais().toString());
			}
			else{
				item.setText(4, ciudad.getValorCiudad().toString());
			}
			System.out.println("NUMERO_SEDE " + ciudad.getSedes().size());
			item.setText(5, Integer.toString(ciudad.getSedes().size()));
			for (Iterator iterator = 
                   ciudad.getSedes().iterator(); iterator.hasNext();){
				Sede sede = (Sede) iterator.next();
				item.setText(6, sede.getTipo().getDescripcion());
			}   
		}
		
		for (int loopIndex = 0; loopIndex < titlesciudades.length; loopIndex++) {
	      table.getColumn(loopIndex).pack();
	    }

	    table.setBounds(25, 25, 500, 260);
	    
	    
	    
	    // List of sedes
	    final Composite page1 = new Composite(contentPanel, SWT.NONE);
	    page1.setLayout(new RowLayout());
	    Table tablesedes = new Table(page1,  SWT.Resize | SWT.V_SCROLL
	            | SWT.H_SCROLL);
	    tablesedes.setHeaderVisible(true);
        String[] titlessedes = { "AÑO", "CIUDAD", "TIPO", "VER", "EDITAR", "BORRAR"};

        for (int loopIndex = 0; loopIndex < titlessedes.length; loopIndex++) {
          TableColumn column = new TableColumn(tablesedes, SWT.NULL);
          column.setText(titlessedes[loopIndex]);
        }
		
		for (Sede sede : sededao.getSedes()) {
		    TableItem item = new TableItem(tablesedes, SWT.NULL);
		    item.setText(0, sede.getAno().toString());
		    item.setText(1, sede.getCiudad().getNombreCiudad());
		    item.setText(2, sede.getTipo().getDescripcion()); 
		}
		
		for (int loopIndex = 0; loopIndex < titlessedes.length; loopIndex++) {
			tablesedes.getColumn(loopIndex).pack();
	    }

		tablesedes.setBounds(25, 25, 350, 150);
	    
	    
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
	    
	    
	    
		
		shell.pack();
		shell.open ();
		while (!shell.isDisposed ()) {
			if (!display.readAndDispatch ()) display.sleep ();
		}
		display.dispose ();

        
    }

}
