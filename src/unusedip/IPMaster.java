package unusedip;

import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultListModel;
import javax.swing.JFrame;
import javax.swing.ListSelectionModel;

/**
 *The main GUI form with all the components is here
 * @author chance
 */
public class IPMaster extends JFrame {

    ExecuteThread et;
    ExecuteNmapThread nmapThread;

    public void scanNetwork() {
        int choice = 1;
        String time ="80to 120";
        if (classARButton.isSelected()) {
            choice = 3;
            time = "180 to 200";
        } else if (classBRButton.isSelected()) {
            choice = 2;
            time ="300 to 480";
        }
        scanStatusLabel.setText("Scan Started This may take upto: "+time+" seconds or less");
        nmapThread = new ExecuteNmapThread(choice);
        nmapThread.newThread();
        while (nmapThread.t.isAlive()) {
            try {
                Thread.sleep(100);
            } catch (InterruptedException ex) {
                Logger.getLogger(execMain.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        scanStatusLabel.setText("Done IP are diplayed: ");
    }

    public IPMaster() {
        initComponents();
        classCRButton.setSelected(true);
        refreshNetwork();
        if (!et.getIP().equalsIgnoreCase("0")) {
            IPStatus.setText("The connected IP is " + et.getIP());
        } else {
            IPStatus.setText("Connect to network First");
        }

    }

    public final void refreshNetwork() {
        et = new ExecuteThread();
        et.newThread();
        while (et.t.isAlive()) {
            try {
                Thread.sleep(100);
            } catch (InterruptedException ex) {
                Logger.getLogger(execMain.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        et.setIP();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jRadioButton3 = new javax.swing.JRadioButton();
        buttonGroup1 = new javax.swing.ButtonGroup();
        jMenuBar2 = new javax.swing.JMenuBar();
        jMenu3 = new javax.swing.JMenu();
        jMenu4 = new javax.swing.JMenu();
        jPanel1 = new javax.swing.JPanel();
        IPStatus = new javax.swing.JLabel();
        scanTypeLabel = new javax.swing.JLabel();
        classCRButton = new javax.swing.JRadioButton();
        classBRButton = new javax.swing.JRadioButton();
        classARButton = new javax.swing.JRadioButton();
        refreshButton = new javax.swing.JButton();
        IPPanel = new javax.swing.JPanel();
        tabbedIP = new javax.swing.JTabbedPane();
        connectedIPTab = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        connectedIPJList = new javax.swing.JList(new DefaultListModel());
        scanStatusLabel = new javax.swing.JLabel();
        UnusedIPTab = new javax.swing.JPanel();
        ConnectedStatusLabel = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        unusedJList = new javax.swing.JList(new DefaultListModel());
        showUnusedIPButton = new javax.swing.JButton();
        startScanButton = new javax.swing.JButton();
        AbortScanButton = new javax.swing.JButton();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();
        jMenuItem2 = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();

        jRadioButton3.setText("jRadioButton3");

        jMenu3.setText("File");
        jMenuBar2.add(jMenu3);

        jMenu4.setText("Edit");
        jMenuBar2.add(jMenu4);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setSize(new java.awt.Dimension(0, 0));

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Network Scan"));

        IPStatus.setText("Connect to network First");

        scanTypeLabel.setText("Scan Class Type:");

        buttonGroup1.add(classCRButton);
        classCRButton.setText("Class C");

        buttonGroup1.add(classBRButton);
        classBRButton.setText("Class B");

        buttonGroup1.add(classARButton);
        classARButton.setText("Class A");

        refreshButton.setText("Refresh");
        refreshButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                refreshButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(scanTypeLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(classCRButton, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(IPStatus, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(classBRButton, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(classARButton, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(156, 156, 156))
                    .addComponent(refreshButton, javax.swing.GroupLayout.Alignment.TRAILING))
                .addGap(22, 22, 22))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(IPStatus)
                            .addComponent(refreshButton))
                        .addGap(48, 48, 48)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(classCRButton)
                            .addComponent(classBRButton)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(77, 77, 77)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(classARButton)
                            .addComponent(scanTypeLabel))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        IPPanel.setBorder(javax.swing.BorderFactory.createTitledBorder("Hosts IP"));

        jScrollPane1.setViewportView(connectedIPJList);

        scanStatusLabel.setText("Start Scan to see the connected hosts");

        javax.swing.GroupLayout connectedIPTabLayout = new javax.swing.GroupLayout(connectedIPTab);
        connectedIPTab.setLayout(connectedIPTabLayout);
        connectedIPTabLayout.setHorizontalGroup(
            connectedIPTabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, connectedIPTabLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1)
                .addContainerGap())
            .addGroup(connectedIPTabLayout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(scanStatusLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(471, 471, 471))
        );
        connectedIPTabLayout.setVerticalGroup(
            connectedIPTabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, connectedIPTabLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(scanStatusLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 11, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 214, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        tabbedIP.addTab("Connected Hosts", connectedIPTab);

        ConnectedStatusLabel.setText("This only works for Class C Scans");

        jScrollPane2.setViewportView(unusedJList);

        javax.swing.GroupLayout UnusedIPTabLayout = new javax.swing.GroupLayout(UnusedIPTab);
        UnusedIPTab.setLayout(UnusedIPTabLayout);
        UnusedIPTabLayout.setHorizontalGroup(
            UnusedIPTabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(UnusedIPTabLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(ConnectedStatusLabel)
                .addContainerGap(517, Short.MAX_VALUE))
            .addGroup(UnusedIPTabLayout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addComponent(jScrollPane2)
                .addContainerGap())
        );
        UnusedIPTabLayout.setVerticalGroup(
            UnusedIPTabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(UnusedIPTabLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(ConnectedStatusLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 213, Short.MAX_VALUE)
                .addContainerGap())
        );

        tabbedIP.addTab("Unused IPs", UnusedIPTab);

        showUnusedIPButton.setText("Show Unused IP");
        showUnusedIPButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                showUnusedIPButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout IPPanelLayout = new javax.swing.GroupLayout(IPPanel);
        IPPanel.setLayout(IPPanelLayout);
        IPPanelLayout.setHorizontalGroup(
            IPPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(IPPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(tabbedIP))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, IPPanelLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(showUnusedIPButton)
                .addContainerGap())
        );
        IPPanelLayout.setVerticalGroup(
            IPPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(IPPanelLayout.createSequentialGroup()
                .addComponent(tabbedIP, javax.swing.GroupLayout.PREFERRED_SIZE, 303, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(showUnusedIPButton)
                .addGap(0, 35, Short.MAX_VALUE))
        );

        startScanButton.setText("Start Scan");
        startScanButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                startScanButtonActionPerformed(evt);
            }
        });

        AbortScanButton.setText("Abort Scan");

        jMenu1.setText("File");

        jMenuItem1.setText("jMenuItem1");
        jMenu1.add(jMenuItem1);

        jMenuItem2.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F4, java.awt.event.InputEvent.ALT_MASK));
        jMenuItem2.setText("Quit");
        jMenu1.add(jMenuItem2);

        jMenuBar1.add(jMenu1);

        jMenu2.setText("Edit");
        jMenuBar1.add(jMenu2);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(IPPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(250, 250, 250)
                        .addComponent(startScanButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(AbortScanButton)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {AbortScanButton, startScanButton});

        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(IPPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(startScanButton)
                    .addComponent(AbortScanButton)))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void refreshButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_refreshButtonActionPerformed
        refreshNetwork();
        if (!et.getIP().equalsIgnoreCase("0")) {

            IPStatus.setText("The connected IP is " + et.getIP());
        } else {
            IPStatus.setText("Connect to network First");
        }
    }//GEN-LAST:event_refreshButtonActionPerformed

    private void startScanButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_startScanButtonActionPerformed
        scanNetwork();
        for (String ip : nmapThread.connectedHostsIP()) {
            System.out.println("Fetched " + ip);
        }

        DefaultListModel listModel = (DefaultListModel) connectedIPJList.getModel();
        listModel.removeAllElements();
        connectedIPJList.setModel(listModel);
        for (String ip : nmapThread.connectedHostsIP()) {
            listModel.addElement(ip);
        }

//         connectedIPJList.setVisibleRowCount(5);
        connectedIPJList.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);
//         add(connectedIPJList);
    }//GEN-LAST:event_startScanButtonActionPerformed

    private void showUnusedIPButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_showUnusedIPButtonActionPerformed
        if (nmapThread == null) {
            javax.swing.JOptionPane.showMessageDialog(this, "Please Scan The network First");
        } else {
            DefaultListModel listModel = (DefaultListModel) unusedJList.getModel();
            listModel.removeAllElements();
            unusedJList.setModel(listModel);
            for (String ip : nmapThread.unusedIP()) {
                listModel.addElement(ip);
            }
            tabbedIP.setSelectedIndex(1);
        }
    }//GEN-LAST:event_showUnusedIPButtonActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(IPMaster.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new IPMaster().setVisible(true);
            }
        });

    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton AbortScanButton;
    private javax.swing.JLabel ConnectedStatusLabel;
    private javax.swing.JPanel IPPanel;
    private javax.swing.JLabel IPStatus;
    private javax.swing.JPanel UnusedIPTab;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JRadioButton classARButton;
    private javax.swing.JRadioButton classBRButton;
    private javax.swing.JRadioButton classCRButton;
    private javax.swing.JList<String> connectedIPJList;
    private javax.swing.JPanel connectedIPTab;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenu jMenu4;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuBar jMenuBar2;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JRadioButton jRadioButton3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JButton refreshButton;
    private javax.swing.JLabel scanStatusLabel;
    private javax.swing.JLabel scanTypeLabel;
    private javax.swing.JButton showUnusedIPButton;
    private javax.swing.JButton startScanButton;
    private javax.swing.JTabbedPane tabbedIP;
    private javax.swing.JList<String> unusedJList;
    // End of variables declaration//GEN-END:variables
}
