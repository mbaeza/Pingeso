/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sessionBeans;

import javax.ejb.Local;

/**
 *
 * @author Marco
 */
@Local
public interface NewTimerSessionBeanLocal {
    
    public void myTimer();
}
