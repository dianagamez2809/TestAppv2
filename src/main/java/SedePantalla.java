import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.TableEditor;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.layout.RowData;
import org.eclipse.swt.layout.RowLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Listener;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableColumn;
import org.eclipse.swt.widgets.TableItem;
import org.eclipse.swt.widgets.Text;

import com.diana.dao.SedeDAO;
import com.diana.model.Sede;

public class SedePantalla {
	public SedePantalla (Shell parent){
		Shell child = new Shell(parent);
	    child.setSize(500, 350);
	    child.setText("Crear nueva Sede");
	    child.setLayout(new GridLayout(2, false));
		int i = 0;
		SedeDAO sededao = new SedeDAO();
		Table tablesedes = new Table(child,  SWT.Resize | SWT.V_SCROLL
	            | SWT.H_SCROLL);
	    tablesedes.setHeaderVisible(true);
        String[] titlessedes = { "AÑO   ", "CIUDAD       ", "TIPO        ",  "EDITAR   ", "BORRAR  "};

        for (int loopIndex = 0; loopIndex < titlessedes.length; loopIndex++) {
          TableColumn column = new TableColumn(tablesedes, SWT.NULL);
          column.setText(titlessedes[loopIndex]);
        }
		
        for (Sede sede : sededao.getSedes()) {
            new TableItem(tablesedes, SWT.NONE);
        }
        
        TableItem[] items = tablesedes.getItems();
        for (Sede sede : sededao.getSedes()) {
        	TableEditor editor = new TableEditor(tablesedes);
        	Text ano = new Text(tablesedes, SWT.NONE);
        	ano.setText(sede.getId().toString());
            editor.grabHorizontal = true;
            editor.setEditor(ano, items[i], 0);
            // Ciudad
            editor = new TableEditor(tablesedes);
            Text ciudad = new Text(tablesedes, SWT.NONE);
            ciudad.setText(sede.getCiudad().getNombreCiudad());
            editor.grabHorizontal = true;
            editor.setEditor(ciudad, items[i], 1);
            // Tipo
            editor = new TableEditor(tablesedes);
            Text tipo = new Text(tablesedes, SWT.NONE);
            tipo.setText(sede.getTipo().getDescripcion());
            editor.grabHorizontal = true;
            editor.setEditor(tipo, items[i], 2);
            //editor.minimumWidth = 100;
            
            
		    // Edit
            editor = new TableEditor(tablesedes);
			Button buttonver = new Button(tablesedes, SWT.PUSH);
			buttonver.setText("Editar");
			buttonver.pack();
			editor.minimumWidth = buttonver.getSize().x;
			editor.horizontalAlignment = SWT.LEFT;
			editor.setEditor(buttonver, items[i], 3);
			
			buttonver.addListener(SWT.Selection, new Listener() {
		        public void handleEvent(Event event) {
		        	new Editar(parent, sede.getId(), sede.getTipo().getId());
		        }
			});
			
			// Delete
			editor = new TableEditor(tablesedes);
			Button buttonborrar = new Button(tablesedes, SWT.PUSH);
			buttonborrar.setText("Borrar");
			buttonborrar.pack();
			editor.minimumWidth = buttonborrar.getSize().x;
			editor.horizontalAlignment = SWT.LEFT;
			editor.setEditor(buttonborrar, items[i], 4);
			
			buttonborrar.addListener(SWT.Selection, new Listener() {
		        public void handleEvent(Event event) {
		        	sededao.deleteSede(sede.getId(), sede.getCiudad().getId());
		        	//layout.topControl = shell;
		        	child.dispose();
		        }
			});
			
			i++;
		}
		
		for (int loopIndex = 0; loopIndex < titlessedes.length; loopIndex++) {
			tablesedes.getColumn(loopIndex).pack();
	    }

		tablesedes.setBounds(25, 25, 500, 300);
		
		Button buttoncrear = new Button(child, SWT.PUSH);
		buttoncrear.setText("Crear Sede");
		//buttoncrear.setLayoutData(new RowData(200, 40));
		
		buttoncrear.addListener(SWT.Selection, new Listener(){
	    	public void handleEvent(Event event) {
	    		new Crear(parent);
	    		child.dispose();
	    	}
	    });
		child.open();
	}
}
