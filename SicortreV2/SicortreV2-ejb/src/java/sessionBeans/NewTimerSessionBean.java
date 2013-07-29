/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sessionBeans;

import java.util.Date;
import javax.ejb.Schedule;
import javax.ejb.Stateless;

/**
 *
 * @author Marco
 */
@Stateless
public class NewTimerSessionBean implements NewTimerSessionBeanLocal {

   // @Schedule(minute = "*", second = "*/5", dayOfMonth = "*", month = "*", year = "*", hour = "9-23", dayOfWeek = "Mon-Fri")
    @Override
    public void myTimer() {
        System.out.println("Timer event: " + new Date());
    }
    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
}
