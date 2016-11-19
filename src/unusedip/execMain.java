/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package unusedip;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *The main thread to get the IP of the system 
 * @author chance
 */
public class execMain {

    public static void main(String[] args) {
        ExecuteThread et = new ExecuteThread();
        et.newThread();
        while (et.t.isAlive()) {
            try {
                Thread.sleep(100);
            } catch (InterruptedException ex) {
                Logger.getLogger(execMain.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
     
        et.setIP();
        System.out.print("The IP FEtched is" + et.getIP());
        ExecuteNmapThread nt = new ExecuteNmapThread(1);
        nt.newThread();
        while (nt.t.isAlive()) {
            try {
                Thread.sleep(100);
            } catch (InterruptedException ex) {
                Logger.getLogger(execMain.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
        for(String ipAddress : nt.connectedHostsIP()){
            System.out.println("Fetched "+ipAddress);
        }
        
        for(String unusedIP : nt.unusedIP()){
            System.out.println(unusedIP);
        }
    }
}

