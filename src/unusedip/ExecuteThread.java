/*
 * Created By chance
 */
package unusedip;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * The main thread to find the IP and to make the commands
 *
 * @author Shobhit Tripathi
 */
public class ExecuteThread implements Runnable {

    public ExecuteThread() {
        shellCommand = "ifconfig wlan0";
    }

    ExecuteThread(int choice) {
        switch (choice) {

            case 1:
                shellCommand = "nmap -sP " + classC;
                break;
            case 2:
                shellCommand = "nmap -sP " + classB;
                break;
            case 3:
                shellCommand = "nmap -sP " + classA;
                break;
        }
    }
    Thread t;
    String result, shellCommand;
    static String classA = "", classB = "", classC = "";
    static String ipAddress = "";

    @Override
    public void run() {
        makeScript();
        try {
            Runtime.getRuntime().exec("chmod 777 commands.sh");//to make executable
            ProcessBuilder builder = new ProcessBuilder("./commands.sh");
            Process process = builder.start();
            BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));
            StringBuilder stbuilder = new StringBuilder();
            String line;
            while ((line = reader.readLine()) != null) {
                stbuilder.append(line);
                stbuilder.append(System.getProperty("line.separator"));
            }
            result = stbuilder.toString();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    public void newThread() {
        t = new Thread(this, "LinuxExecute");
        System.out.println("Thread Created " + t);
        t.start();
    }

    //make the sh script 
    public void makeScript() {
        File file = new File("commands.sh");
        try {
            file.createNewFile();
            try (FileWriter fw = new FileWriter(file)) {
                System.out.println("Writing the command " + shellCommand);
                fw.write(shellCommand);
                fw.flush();
                fw.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void makeScript(String newFile, String writeContent) {
        File file = new File(newFile);
        try {
            file.createNewFile();
            try (FileWriter fw = new FileWriter(file)) {
                fw.write(writeContent);
                fw.flush();
                fw.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void setIP() {
        String[] arr = result.split("\n");
        String inet = arr[1];
        if (inet.substring(10, 19).equalsIgnoreCase("inet addr")) {
            ipAddress = inet.substring(20, 35).trim();
            setClasses();
        } else {
            ipAddress = "0";
        }
        System.out.println("Hence the IP is" + inet.substring(20, 35));
        if (!"0".equals(ipAddress)) {
            setClasses();
        }

    }

    public void setClasses() {

        int count = 0, i = 0;
//        String temp;
        StringBuilder stbuilder = new StringBuilder();
        while (count != 3) {
            stbuilder.append(Character.toString(ipAddress.charAt(i)));

            if (ipAddress.charAt(i) == '.') {
                switch (count) {
                    case 0:
                        classA = stbuilder.toString() + "0.0.0/8";
                        break;
                    case 1:
                        classB = stbuilder.toString() + "0.0/16";
                        break;
                    case 2:
                        classC = stbuilder.toString() + "0/24";
                        break;
                    default:
                        break;
                }
                count++;
            }
            i++;
//            ipAddress.charAt(count);
        }

        //        if(arr[1].t)
        System.out.println("Class A: " + classA + "\nClass B: " + classB + "\nClass C: " + classC);
    }

    public String getOutput() {
        return result;
    }

    public String getIP() {
        return ipAddress;
    }

    public String getClassA() {
        return classA;
    }

    public String getClassB() {
        return classB;
    }

    public String getClassC() {
        return classC;
    }

}
