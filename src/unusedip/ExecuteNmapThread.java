
package unusedip;

import java.util.Arrays;

/**
 *To find out the used and unused IPs
 * @author chance
 */
public class ExecuteNmapThread extends ExecuteThread {

    public ExecuteNmapThread(int choice) {
        super(choice);
    }

    public int connectedHosts() {
        String[] array = result.split("\n");
        String arr[] = array[array.length - 1].split(" ");
        int numberofHosts = Integer.parseInt(arr[5].substring(1, arr[5].length()));
        return numberofHosts;
    }

    public String[] connectedHostsIP() {
        String connected[] = new String[connectedHosts()];
        int count = 0;
        String resultArray[] = result.split("\n");
        StringBuilder ipBuilder;
        int line = resultArray.length - 1;
        while (count != connectedHosts() && line != 0) {
            ipBuilder = new StringBuilder();
            if (resultArray[line].substring(0, 9).equalsIgnoreCase("Nmap Scan")) {
                String resultLine = resultArray[line];
                for (int i = 0; i < resultLine.length(); i++) {
                    if (((int) resultLine.charAt(i) >= 48 && (int) resultLine.charAt(i) <= 57) || (int) resultLine.charAt(i) == 46) {
//                        System.out.println("only getting "+resultLine.charAt(i));
                        ipBuilder.append(resultLine.charAt(i));
                    }
//                    System.out.println("The value of i "+i+"and the character "+resultLine.charAt(i)+" with ascii value "+(int)resultLine.charAt(i));
                }
                connected[count] = ipBuilder.toString();
                count++;
            }
//            System.out.println(line);
            line--;
        }
        return connected;
    }

     public  String[] unusedIP() {
        String[] unused = new String[usedIP().length+1];
        int[] a = usedIP();
        Arrays.sort(a);
        int i = 2, j = 0;
        String ipBits = classC.substring(0, classC.length() - 4);
        for (int x : a) {
            String unusedIPs = ipBits + i + " to " + ipBits + (x - 1);
            unused[j++] = unusedIPs;
            i = x + 1;
        }
        unused[j] = ipBits + i + " to " + ipBits + "255";
        return unused;
    }


    public int[] usedIP() {
        int count = 0;
        int[] a = new int[connectedHostsIP().length];

        for (String connectedIP1 : connectedHostsIP()) {
            int len = connectedIP1.length();
            char temp = connectedIP1.charAt(--len);
            while (temp != 46) {
                temp = connectedIP1.charAt(--len);
            }
            a[count++] = Integer.parseInt(connectedIP1.substring(len + 1, connectedIP1.length()));
            System.out.println(a[count - 1]);
        }
        return a;
    }

}
