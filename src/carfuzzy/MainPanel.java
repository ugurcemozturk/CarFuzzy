package carfuzzy;

import carfuzzy.CarSystem.Output;
import java.awt.event.ActionEvent;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;

/**
 *
 * @author ugurcem
 */
public class MainPanel extends javax.swing.JFrame {

    FIS fis1 = new FIS();
    FIS fis2 = new FIS();
    FIS fis3 = new FIS();
    FIS fis4 = new FIS();
    Rules rules = new Rules();
    Operations o = new Operations();
    CarSystem c = new CarSystem();

    public MainPanel() {
        initComponents();
        setComboBoxes();
        setListeners();
    }

    public final void setComboBoxes() {
        speedCombo1.addItem(CarSystem.Speed.verySlow);
        speedCombo2.addItem(CarSystem.Speed.verySlow);
        speedCombo3.addItem(CarSystem.Speed.verySlow);
        speedCombo4.addItem(CarSystem.Speed.verySlow);
        speedCombo1.addItem(CarSystem.Speed.slow);
        speedCombo2.addItem(CarSystem.Speed.slow);
        speedCombo3.addItem(CarSystem.Speed.slow);
        speedCombo4.addItem(CarSystem.Speed.slow);
        speedCombo1.addItem(CarSystem.Speed.medium);
        speedCombo2.addItem(CarSystem.Speed.medium);
        speedCombo3.addItem(CarSystem.Speed.medium);
        speedCombo4.addItem(CarSystem.Speed.medium);
        speedCombo1.addItem(CarSystem.Speed.fast);
        speedCombo2.addItem(CarSystem.Speed.fast);
        speedCombo3.addItem(CarSystem.Speed.fast);
        speedCombo4.addItem(CarSystem.Speed.fast);
        speedCombo1.addItem(CarSystem.Speed.veryFast);
        speedCombo2.addItem(CarSystem.Speed.veryFast);
        speedCombo3.addItem(CarSystem.Speed.veryFast);
        speedCombo4.addItem(CarSystem.Speed.veryFast);

        distanceCombo1.addItem(CarSystem.Distance.veryClose);
        distanceCombo2.addItem(CarSystem.Distance.veryClose);
        distanceCombo3.addItem(CarSystem.Distance.veryClose);
        distanceCombo4.addItem(CarSystem.Distance.veryClose);
        distanceCombo1.addItem(CarSystem.Distance.close);
        distanceCombo2.addItem(CarSystem.Distance.close);
        distanceCombo3.addItem(CarSystem.Distance.close);
        distanceCombo4.addItem(CarSystem.Distance.close);
        distanceCombo1.addItem(CarSystem.Distance.normal);
        distanceCombo2.addItem(CarSystem.Distance.normal);
        distanceCombo3.addItem(CarSystem.Distance.normal);
        distanceCombo4.addItem(CarSystem.Distance.normal);
        distanceCombo1.addItem(CarSystem.Distance.away);
        distanceCombo2.addItem(CarSystem.Distance.away);
        distanceCombo3.addItem(CarSystem.Distance.away);
        distanceCombo4.addItem(CarSystem.Distance.away);

        speedCombo2.setSelectedIndex(1);
        speedCombo3.setSelectedIndex(2);
        speedCombo4.setSelectedIndex(3);
        distanceCombo2.setSelectedIndex(1);
        distanceCombo3.setSelectedIndex(2);
        distanceCombo4.setSelectedIndex(3);
        setOutputLabels();

    }

    public final void setListeners() {
        speedCombo1.addActionListener((ActionEvent e) -> {
            setOutputLabels();
        });
        speedCombo2.addActionListener((ActionEvent e) -> {
            setOutputLabels();
        });
        speedCombo3.addActionListener((ActionEvent e) -> {
            setOutputLabels();
        });
        speedCombo4.addActionListener((ActionEvent e) -> {
            setOutputLabels();
        });
        distanceCombo1.addActionListener((ActionEvent e) -> {
            setOutputLabels();
        });
        distanceCombo2.addActionListener((ActionEvent e) -> {
            setOutputLabels();
        });
        distanceCombo3.addActionListener((ActionEvent e) -> {
            setOutputLabels();
        });
        distanceCombo4.addActionListener((ActionEvent e) -> {
            setOutputLabels();
        });

    }

    public void setOutputLabels() {
        outputLabel1.setText((rules.table.get(speedCombo1.getSelectedItem(), distanceCombo1.getSelectedItem())).toString());
        outputLabel2.setText((rules.table.get(speedCombo2.getSelectedItem(), distanceCombo2.getSelectedItem())).toString());
        outputLabel3.setText((rules.table.get(speedCombo3.getSelectedItem(), distanceCombo3.getSelectedItem())).toString());
        outputLabel4.setText((rules.table.get(speedCombo4.getSelectedItem(), distanceCombo4.getSelectedItem())).toString());

    }


    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        JTextSpeed = new javax.swing.JFormattedTextField();
        JTextDistance = new javax.swing.JFormattedTextField();
        speedCombo1 = new javax.swing.JComboBox();
        speedCombo2 = new javax.swing.JComboBox();
        speedCombo3 = new javax.swing.JComboBox();
        speedCombo4 = new javax.swing.JComboBox();
        distanceCombo1 = new javax.swing.JComboBox();
        distanceCombo2 = new javax.swing.JComboBox();
        distanceCombo4 = new javax.swing.JComboBox();
        distanceCombo3 = new javax.swing.JComboBox();
        jLabel2 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jSeparator2 = new javax.swing.JSeparator();
        jSeparator3 = new javax.swing.JSeparator();
        jSeparator4 = new javax.swing.JSeparator();
        outputLabel1 = new javax.swing.JLabel();
        outputLabel2 = new javax.swing.JLabel();
        outputLabel3 = new javax.swing.JLabel();
        outputLabel4 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(254, 254, 254));
        setMaximumSize(new java.awt.Dimension(874, 499));
        addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                speedCombo1MousePressed(evt);
            }
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                formMouseClicked(evt);
            }
        });
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel3.setText("Speed");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 20, -1, -1));

        jLabel4.setText("Distance");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 20, -1, -1));

        jButton1.setText("Analysis");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 200, -1, -1));

        jLabel1.setText("Motor Speed");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 20, -1, -1));

        JTextSpeed.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(new java.text.DecimalFormat("###"))));
        getContentPane().add(JTextSpeed, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 10, 64, -1));

        JTextDistance.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(new java.text.DecimalFormat("###"))));
        getContentPane().add(JTextDistance, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 10, 64, -1));

        speedCombo1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                speedCombo1ActionPerformed(evt);
            }
        });
        getContentPane().add(speedCombo1, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 60, -1, -1));

        getContentPane().add(speedCombo2, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 90, -1, -1));

        getContentPane().add(speedCombo3, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 120, -1, -1));

        getContentPane().add(speedCombo4, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 150, -1, -1));

        getContentPane().add(distanceCombo1, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 60, -1, -1));

        getContentPane().add(distanceCombo2, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 90, -1, -1));

        getContentPane().add(distanceCombo4, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 150, -1, -1));

        distanceCombo3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                speedCombo2MouseClicked(evt);
            }
        });
        getContentPane().add(distanceCombo3, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 120, -1, -1));

        jLabel2.setFont(new java.awt.Font("Times New Roman", 0, 36)); // NOI18N
        jLabel2.setText("If");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 80, 40, 60));

        jLabel7.setFont(new java.awt.Font("Times New Roman", 0, 36)); // NOI18N
        jLabel7.setText("and");
        getContentPane().add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 80, 70, 60));

        jLabel5.setFont(new java.awt.Font("Times New Roman", 0, 36)); // NOI18N
        jLabel5.setText("then");
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 80, 90, 60));
        getContentPane().add(jSeparator2, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 40, 110, 10));
        getContentPane().add(jSeparator3, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 40, 120, 10));
        getContentPane().add(jSeparator4, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 40, 110, 10));

        outputLabel1.setFont(new java.awt.Font("Times New Roman", 3, 15)); // NOI18N
        outputLabel1.setText("jLabel8");
        outputLabel1.setToolTipText("");
        getContentPane().add(outputLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 50, -1, -1));

        outputLabel2.setFont(new java.awt.Font("Times New Roman", 3, 15)); // NOI18N
        outputLabel2.setText("jLabel8");
        outputLabel2.setToolTipText("");
        getContentPane().add(outputLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 80, -1, -1));

        outputLabel3.setFont(new java.awt.Font("Times New Roman", 3, 15)); // NOI18N
        outputLabel3.setText("jLabel8");
        outputLabel3.setToolTipText("");
        getContentPane().add(outputLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 120, -1, -1));

        outputLabel4.setFont(new java.awt.Font("Times New Roman", 3, 15)); // NOI18N
        outputLabel4.setText("jLabel8");
        outputLabel4.setToolTipText("");
        getContentPane().add(outputLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 150, -1, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents
    private boolean areRulesDistinct() {
        List<String> expected = new ArrayList<>();
        List<String> current = new ArrayList<>();

        expected.add(Output.keepPace.toString());
        expected.add(Output.slowDown.toString());
        expected.add(Output.speedUp.toString());
        expected.add(Output.stop.toString());

        current.add(outputLabel1.getText());
        current.add(outputLabel2.getText());
        current.add(outputLabel3.getText());
        current.add(outputLabel4.getText());
        Collections.sort(current);
        return current.equals(expected);
    }
    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        if (checkInputs()) {
            if (areRulesDistinct()) {
                String s = JTextSpeed.getText();
                String d = JTextDistance.getText();
                List<JComboBox> speedCBoxes = new ArrayList<>();
                List<JComboBox> distanceCBoxes = new ArrayList<>();

                speedCBoxes.add(speedCombo1);
                speedCBoxes.add(speedCombo2);
                speedCBoxes.add(speedCombo3);
                speedCBoxes.add(speedCombo4);

                distanceCBoxes.add(distanceCombo1);
                distanceCBoxes.add(distanceCombo2);
                distanceCBoxes.add(distanceCombo3);
                distanceCBoxes.add(distanceCombo4);

                int speed = Integer.parseInt(s);
                int distance = Integer.parseInt(d);

                o.baseSystem(speedCBoxes, distanceCBoxes, speed, distance);
            } else {
                JOptionPane.showMessageDialog(this,
                        "Rules are supposed to be distinct.",
                        "Rule error",
                        JOptionPane.WARNING_MESSAGE);
            }
        }

    }//GEN-LAST:event_jButton1ActionPerformed
    private boolean checkInputs() {
        int s = Integer.parseInt(JTextSpeed.getText());
        int d = Integer.parseInt(JTextDistance.getText());
        if ((s < 0 || s > 200) || (d < 0 || d > 100)) {
            JOptionPane.showMessageDialog(this,
                    "Speed range: 0-200 \nDistance range: 0-100\nTry again.",
                    "Invalid input",
                    JOptionPane.WARNING_MESSAGE);
            return false;
        } else {
            return true;
        }
    }
    private void speedCombo1MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_speedCombo1MousePressed
        // TODO add your handling code here:
    }//GEN-LAST:event_speedCombo1MousePressed

    private void formMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_formMouseClicked
        //
    }//GEN-LAST:event_formMouseClicked

    private void speedCombo2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_speedCombo2MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_speedCombo2MouseClicked

    private void speedCombo1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_speedCombo1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_speedCombo1ActionPerformed

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
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(MainPanel.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MainPanel.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MainPanel.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MainPanel.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MainPanel().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JFormattedTextField JTextDistance;
    private javax.swing.JFormattedTextField JTextSpeed;
    public javax.swing.JComboBox distanceCombo1;
    private javax.swing.JComboBox distanceCombo2;
    private javax.swing.JComboBox distanceCombo3;
    private javax.swing.JComboBox distanceCombo4;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JSeparator jSeparator4;
    private javax.swing.JLabel outputLabel1;
    private javax.swing.JLabel outputLabel2;
    private javax.swing.JLabel outputLabel3;
    private javax.swing.JLabel outputLabel4;
    public javax.swing.JComboBox speedCombo1;
    private javax.swing.JComboBox speedCombo2;
    private javax.swing.JComboBox speedCombo3;
    private javax.swing.JComboBox speedCombo4;
    // End of variables declaration//GEN-END:variables

}
