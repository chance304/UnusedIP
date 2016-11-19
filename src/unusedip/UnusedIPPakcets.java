/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package unusedip;
import java.util.Arrays;

/**
 *Finding out the unusedIPPackets 
 * @author Shobhit Tripathi
 */
public class UnusedIPPakcets {

    static String[] connectedIP = {"192.168.43.5", "192.168.43.30", "192.168.43.62", "192.168.43.208", "192.168.43.186"};
    //These are the packets found
    
    public static void main(String[] args) {
        for(String unused:unusedIP())//unusedIP returns a String Array
            System.out.println(unused);
    }

    public static String[] unusedIP() {
        String[] unused = new String[usedIP().length+1];
        int[] a = usedIP();
        Arrays.sort(a);
        int i = 2, j = 0;
        String classC = "192.168.43.0/24";
        String ipBits = classC.substring(0, classC.length() - 4);
        for (int x : a) {
            String unusedIP = ipBits + i + " to " + ipBits + (x - 1);
            unused[j++] = unusedIP;
            i = x + 1;
        }
        unused[j] = ipBits + i + " to " + ipBits + "255";
        return unused;
    }

    static int[] usedIP() {
        int count = 0;
        int[] a = new int[connectedIP.length];

        for (String connectedIP1 : connectedIP) {
            int i = 0;
            int len = connectedIP1.length();
            char temp = connectedIP1.charAt(--len);
            while (temp != 46) {
                i++;
                temp = connectedIP1.charAt(--len);
            }
            a[count++] = Integer.parseInt(connectedIP1.substring(len + 1, connectedIP1.length()));
        }
        return a;
    }

}
