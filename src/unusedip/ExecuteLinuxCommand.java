/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package unusedip;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

/**
 * This file executes a particular Linux Command in shell and gets the output
 * back
 *
 * @author chance
 */
public class ExecuteLinuxCommand implements Runnable{

    String ipCommand, commandOutput, ipAddress;

    ExecuteLinuxCommand(int command) {

        try {
            switch (command) {
                case 1:
                    getIPCommand("wlan0");
                    break;
                case 2:
                    getIPCommand("eth0");
            }
            Runtime.getRuntime().exec("chmod 777 commands.sh");
            ProcessBuilder builder = new ProcessBuilder("./commands.sh");
            Process process = builder.start();
            BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));
            StringBuilder stbuilder = new StringBuilder();
            String line;
            while ((line = reader.readLine()) != null) {
                stbuilder.append(line);
                stbuilder.append(System.getProperty("line.separator"));
            }
            String result = builder.toString();
            System.out.println(builder);
            
//            Thread.sleep(80000);
//            commandOutput.concat(getInputAsString(process.getInputStream()));
//            System.out.println(commandOutput);
//            String[] s = commandOutput.split(" ");
//            System.out.println("After split"+s[5]);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void getIPCommand(String connInterface) {
        ipCommand = "ifconfig" + " " + connInterface;

//        ipCommand = "mkdir newdirNetBeans";
//          ipCommand ="nmap -sP 172.16.30.0/24";
        try {
            initScript(ipCommand);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void initScript(String command) throws IOException {
        File file = new File("commands.sh");
        file.createNewFile();
        try (FileWriter fw = new FileWriter(file)) {
            fw.write(command);
            fw.flush();
        }
    }

    public static void main(String[] args) {
        ExecuteLinuxCommand s = new ExecuteLinuxCommand(1);
    }

//    private String getInputAsString(InputStream is) {
//        try (java.util.Scanner s = new java.util.Scanner(is)) {
//            return s.useDelimiter("\\A").hasNext() ? s.next() : "";
//        }
//    }

    String getOutput() {
        return commandOutput;
    }

    @Override
    public void run() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
