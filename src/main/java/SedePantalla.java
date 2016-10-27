import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableColumn;
import org.eclipse.swt.widgets.TableItem;

import com.diana.dao.SedeDAO;
import com.diana.model.Sede;

public class SedePantalla {
	public SedePantalla (Composite shell){
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
		    item.setText(0, sede.getAno().toString());
		    item.setText(1, sede.getCiudad().getNombreCiudad());
		    item.setText(2, sede.getTipo().getDescripcion()); 
		}
		
		for (int loopIndex = 0; loopIndex < titlessedes.length; loopIndex++) {
			tablesedes.getColumn(loopIndex).pack();
	    }

		tablesedes.setBounds(25, 25, 350, 150);
	}
}
