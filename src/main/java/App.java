/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author diana
 */
import com.diana.dao.CiudadDAO;
import com.diana.model.Ciudad;
import java.sql.SQLException;
import java.util.List;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;

public class App {

    public static void main(String[] args) {
        CiudadDAO ciudaddao = new CiudadDAO();

        
        //for (List iter : ciudaddao.getAllCiudades()) {
        //    System.out.println(iter);
        //}
        
        ciudaddao.listCiudades();
        
        for (Object iter : ciudaddao.listCiudades()) {
            System.out.println(iter.toString());
        }
        
        Display display = new Display ();
		Shell shell = new Shell(display);
		
		Text helloWorldTest = new Text(shell, SWT.NONE);
		for (Object iter : ciudaddao.listCiudades()) {
			helloWorldTest.setText(iter.toString());
        }
		
		helloWorldTest.pack();
		
		shell.pack();
		shell.open ();
		while (!shell.isDisposed ()) {
			if (!display.readAndDispatch ()) display.sleep ();
		}
		display.dispose ();

        
    }

}
