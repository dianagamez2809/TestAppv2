import java.util.Iterator;

import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableColumn;
import org.eclipse.swt.widgets.TableItem;

import com.diana.dao.CiudadDAO;
import com.diana.model.Ciudad;
import com.diana.model.Sede;

public class CiudadPantalla {
	public CiudadPantalla(Composite shell){
		CiudadDAO ciudaddao = new CiudadDAO();
		Table table = new Table(shell,  SWT.Resize | SWT.V_SCROLL
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
	}
}
