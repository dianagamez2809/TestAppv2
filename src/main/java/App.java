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
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableColumn;
import org.eclipse.swt.widgets.TableItem;

public class App {

    public static void main(String[] args) {
        CiudadDAO ciudaddao = new CiudadDAO();
        Display display = new Display ();
		Shell shell = new Shell(display);
		shell.setText("Resultados");
		shell.setBounds(50, 50, 500, 500);
	    final Text text = new Text(shell, SWT.BORDER);
	    
	    Table table = new Table(shell,  SWT.BORDER | SWT.V_SCROLL
	            | SWT.H_SCROLL);
        table.setHeaderVisible(true);
        String[] titles = { "ID_PAIS", "PAIS", "ID_CIUDAD", "CIUDAD", "VALOR", "NUMERO_SEDE", "DESCRIPCION" };

        for (int loopIndex = 0; loopIndex < titles.length; loopIndex++) {
          TableColumn column = new TableColumn(table, SWT.NULL);
          column.setText(titles[loopIndex]);
        }
		
		//Text helloWorldTest = new Text(shell, SWT.NONE);
		//for (Ciudad ciudad : ciudaddao.listCiudades()) {
			//helloWorldTest.setText(iter.toString());
			//System.out.println("ID_PAIS " + ciudad.getPais().getId());
			//System.out.println("NOMBRE_PAIS " + ciudad.getPais().getNombrePais());
			//System.out.println("ID_CIUDAD " + ciudad.getId());
			//System.out.println("NOMBRE_CIUDAD " + ciudad.getNombreCiudad());
			//if(ciudad.getValorCiudad() == null){
				//System.out.println("VALOR P " + ciudad.getPais().getValorPais());
			//}
			//else{
				//System.out.println("VALOR " + ciudad.getValorCiudad());
			//}
			//System.out.println("NUMERO_SEDE " + ciudad.getSedes().size());
			//for (Iterator iterator = 
                    //ciudad.getSedes().iterator(); iterator.hasNext();){
				//Sede sede = (Sede) iterator.next();
				//System.out.println("DESCRIPCION " + sede.getTipo().getDescripcion());
			//}
        //}
		
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
		
		//helloWorldTest.pack();
		for (int loopIndex = 0; loopIndex < titles.length; loopIndex++) {
	      table.getColumn(loopIndex).pack();
	    }

	    table.setBounds(25, 25, 500, 500);
		
		shell.pack();
		shell.open ();
		while (!shell.isDisposed ()) {
			if (!display.readAndDispatch ()) display.sleep ();
		}
		display.dispose ();

        
    }

}
