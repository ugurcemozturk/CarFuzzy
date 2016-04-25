package carfuzzy;

import org.jfree.chart.ChartPanel;

/**
 *
 * @author ugurcem
 */
public class ResultPanel extends javax.swing.JFrame {

    public ResultPanel() {
        initComponents();
    }

    public void initCharts(FIS[] fis, double defuzzify) {
        ChartPanel aggregationCP = new ChartPanel(fis[0].getAggregationChart());

        final int W = 200;
        final int H = 180;
        for (int i = 0; i < 4; i++) {

            ChartPanel speedCP = new ChartPanel(fis[i].getSpeedChart());
            ChartPanel distanceCP = new ChartPanel(fis[i].getDistanceChart());
            ChartPanel outputCP = new ChartPanel(fis[i].getOutputChart());
            ChartPanel implicationCP = new ChartPanel(fis[i].getImplicationChart());

            initPanel(i, speedCP);
            initPanel(i, distanceCP);
            initPanel(i, outputCP);
            initPanel(i, implicationCP);
            speedCP.setSize(W, H);
            distanceCP.setSize(W, H);
            outputCP.setSize(W, H);
            implicationCP.setSize(W, H);
        }
        aggregationPanel.add(aggregationCP);
        tabPanel.validate();
        rule1Panel.validate();
        rule2Panel.validate();
        rule3Panel.validate();
        rule4Panel.validate();
        setLabels(fis, defuzzify);
        aggregationPanel.validate();
        this.validate();
        this.setVisible(true);
    }

    private void setLabels(FIS[] fis, double defuzzify) {
        defuzzifyLabel.setText(String.valueOf(defuzzify));
        String s = "";
        for (int i = 0; i < 4; i++) {
            s += "      Rule" + (i + 1) + ": If " + fis[i].getSpeed().toString()
                    + " and " + fis[i].getDistance().toString()
                    + " then " + fis[i].getOutput().toString()
                    + "      Speed Input Membership: "
                    + String.format("%.4f", fis[i].getSpeedMembership())
                    + "      Distance Input Membership: "
                    + String.format("%.4f", fis[i].getDistanceMembership())
                    + "\n";
        }
        rulesLabel.setText(s);
    }

    public void initPanel(int i, ChartPanel panel) {
        switch (i) {
            case 0:
                rule1Panel.add(panel);
                break;
            case 1:
                rule2Panel.add(panel);
                break;
            case 2:
                rule3Panel.add(panel);
                break;
            case 3:
                rule4Panel.add(panel);
                break;
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        tabPanel = new javax.swing.JTabbedPane();
        rule1Panel = new javax.swing.JPanel();
        rule2Panel = new javax.swing.JPanel();
        rule3Panel = new javax.swing.JPanel();
        rule4Panel = new javax.swing.JPanel();
        aggregationPanel = new javax.swing.JPanel();
        defuzzifyLabel = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        rulesLabel = new javax.swing.JTextArea();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        tabPanel.setTabPlacement(javax.swing.JTabbedPane.LEFT);

        rule1Panel.setLayout(new java.awt.GridLayout());
        tabPanel.addTab("Rule 1", rule1Panel);

        rule2Panel.setLayout(new java.awt.GridLayout(1, 0));
        tabPanel.addTab("Rule 2", rule2Panel);

        rule3Panel.setLayout(new java.awt.GridLayout(1, 0));
        tabPanel.addTab("Rule 3", rule3Panel);

        rule4Panel.setLayout(new java.awt.GridLayout(1, 0));
        tabPanel.addTab("Rule 4", rule4Panel);

        aggregationPanel.setLayout(new java.awt.GridLayout());
        tabPanel.addTab("tab5", aggregationPanel);

        defuzzifyLabel.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        defuzzifyLabel.setToolTipText("");
        defuzzifyLabel.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createMatteBorder(2, 2, 2, 2, new java.awt.Color(0, 0, 0)), "DEFUZZIFICATION", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Dialog", 1, 12))); // NOI18N

        rulesLabel.setEditable(false);
        rulesLabel.setColumns(20);
        rulesLabel.setFont(new java.awt.Font("Times New Roman", 0, 15)); // NOI18N
        rulesLabel.setRows(5);
        jScrollPane1.setViewportView(rulesLabel);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(tabPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 1092, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 10, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(69, 69, 69)
                .addComponent(jScrollPane1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(defuzzifyLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 244, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(tabPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 558, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(defuzzifyLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel aggregationPanel;
    private javax.swing.JLabel defuzzifyLabel;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JPanel rule1Panel;
    private javax.swing.JPanel rule2Panel;
    private javax.swing.JPanel rule3Panel;
    private javax.swing.JPanel rule4Panel;
    private javax.swing.JTextArea rulesLabel;
    private javax.swing.JTabbedPane tabPanel;
    // End of variables declaration//GEN-END:variables
}
