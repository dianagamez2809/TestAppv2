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

public class App {

    public static void main(String[] args) {
        CiudadDAO ciudaddao = new CiudadDAO();

        
        for (Ciudad iter : ciudaddao.getAllCiudades()) {
            System.out.println(iter);
        }

        
    }

}
