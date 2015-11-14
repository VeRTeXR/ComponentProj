/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package helperclasses;

import java.util.ArrayList;
import javax.servlet.ServletContext;

/**
 *
 * @author sarun
 */
public class UpdatingRecord {
    public static boolean isUpdating(ServletContext sc, int id) {
        ArrayList<Integer> idUsed = (ArrayList<Integer>) sc.getAttribute("idUsed");
        if (idUsed == null) {
            idUsed = new ArrayList<Integer>();
            idUsed.add(id);
            sc.setAttribute("idUsed", idUsed);
        }
        else {
            if (idUsed.indexOf(id) == -1) {
                idUsed.add(id);
            }
            else {
                return true;
            }
        }
        return false;
    }
    public static void removeUpdated(ServletContext sc, Integer id) {
         ArrayList<Integer> idUsed = (ArrayList<Integer>) sc.getAttribute("idUsed");
         if (idUsed == null) return;
         idUsed.remove(id);
        
    }
}
