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

import com.diana.dao.SedeDAO;
import com.diana.model.Sede;

public class SedePantalla {
	public SedePantalla (Composite shell, Shell parent){
		int i = 0;
		SedeDAO sededao = new SedeDAO();
		Table tablesedes = new Table(shell,  SWT.Resize | SWT.V_SCROLL
	            | SWT.H_SCROLL);
	    tablesedes.setHeaderVisible(true);
        String[] titlessedes = { "AÑO", "CIUDAD", "TIPO", "VER", "EDITAR", "BORRAR"};

        for (int loopIndex = 0; loopIndex < titlessedes.length; loopIndex++) {
          TableColumn column = new TableColumn(tablesedes, SWT.NULL);
          column.setText(titlessedes[loopIndex]);
        }
		
        
        
		for (Sede sede : sededao.getSedes()) {
		    TableItem item = new TableItem(tablesedes, SWT.NULL);
		    TableEditor editor = new TableEditor(tablesedes);
		    item.setText(0, sede.getAno().toString());
		    item.setText(1, sede.getCiudad().getNombreCiudad());
		    item.setText(2, sede.getTipo().getDescripcion());
		}
		
		for (int loopIndex = 0; loopIndex < titlessedes.length; loopIndex++) {
			tablesedes.getColumn(loopIndex).pack();
	    }

		tablesedes.setBounds(25, 25, 350, 150);
		
		
		RowLayout rowLayout2 = new RowLayout();
	    shell.setLayout(rowLayout2);
		Button buttonver = new Button(shell, SWT.PUSH);
		buttonver.setText("Ver");
		
		buttonver.addListener(SWT.Selection, new Listener() {
	        public void handleEvent(Event event) {
	        	new Ver(parent, 1992, 3);
	        }
		});
	}
}
