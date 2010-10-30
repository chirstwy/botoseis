/*
 * EditParametersDlg.java
 *
 * Created on 18 de Abril de 2008, 19:19
 */
package botoseis.mainGui.admin;

public class EditParametersDlg extends javax.swing.JDialog {

    /** Creates new form EditParametersDlg */
    public EditParametersDlg(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        labelOptionsValues.setEnabled(false);
        prmOptionsValues.setEnabled(false);
        listReturnIndex.setEnabled(false);
        listReturnText.setEnabled(false);
    }

    public boolean getResponseOk() {
        return responseOk;
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        prmName = new javax.swing.JTextField();
        prmDesc = new javax.swing.JTextField();
        prmType = new javax.swing.JComboBox();
        prmDefaultValue = new javax.swing.JTextField();
        labelOptionsValues = new javax.swing.JLabel();
        prmOptionsValues = new javax.swing.JTextField();
        jSeparator1 = new javax.swing.JSeparator();
        btnCancel = new javax.swing.JButton();
        btnOk = new javax.swing.JButton();
        checkKeyValue = new javax.swing.JCheckBox();
        listReturnIndex = new javax.swing.JRadioButton();
        listReturnText = new javax.swing.JRadioButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Configure parameter");

        jLabel1.setText("Name:");

        jLabel2.setText("Description:");

        jLabel3.setText("Type:");

        jLabel4.setText("Default value:");

        prmType.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Text", "Numeric", "Options", "File path", "Multline text" }));
        prmType.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                prmTypeActionPerformed(evt);
            }
        });

        labelOptionsValues.setText("List values:");

        btnCancel.setText("Cancel");
        btnCancel.setMaximumSize(new java.awt.Dimension(75, 23));
        btnCancel.setMinimumSize(new java.awt.Dimension(75, 23));
        btnCancel.setPreferredSize(new java.awt.Dimension(75, 23));
        btnCancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelActionPerformed(evt);
            }
        });

        btnOk.setText("Ok");
        btnOk.setMaximumSize(new java.awt.Dimension(75, 23));
        btnOk.setMinimumSize(new java.awt.Dimension(75, 23));
        btnOk.setPreferredSize(new java.awt.Dimension(75, 23));
        btnOk.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnOkActionPerformed(evt);
            }
        });

        checkKeyValue.setText("key-value pair");

        buttonGroup1.add(listReturnIndex);
        listReturnIndex.setText("Return selected index");

        buttonGroup1.add(listReturnText);
        listReturnText.setText("Return selected text");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(12, 12, 12)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel3)
                            .addComponent(jLabel1)
                            .addComponent(jLabel2))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(prmName, javax.swing.GroupLayout.PREFERRED_SIZE, 176, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(checkKeyValue))
                            .addComponent(prmDesc, javax.swing.GroupLayout.DEFAULT_SIZE, 523, Short.MAX_VALUE)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(prmType, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(listReturnIndex, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(labelOptionsValues)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 13, Short.MAX_VALUE)
                                        .addComponent(prmOptionsValues, javax.swing.GroupLayout.PREFERRED_SIZE, 266, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(listReturnText)))))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(btnOk, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnCancel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(prmDefaultValue, javax.swing.GroupLayout.DEFAULT_SIZE, 523, Short.MAX_VALUE))
                    .addComponent(jSeparator1, javax.swing.GroupLayout.DEFAULT_SIZE, 623, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(prmName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(checkKeyValue))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(prmDesc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(prmOptionsValues, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(labelOptionsValues)
                    .addComponent(prmType, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(listReturnIndex)
                    .addComponent(listReturnText))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(prmDefaultValue, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnOk, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnCancel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    private void prmTypeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_prmTypeActionPerformed
        Object o = prmType.getSelectedItem();
        if (o != null && "Options".equalsIgnoreCase(o.toString())) {
            labelOptionsValues.setEnabled(true);
            prmOptionsValues.setEnabled(true);
            listReturnIndex.setEnabled(true);
            listReturnText.setEnabled(true);
        } else {
            labelOptionsValues.setEnabled(false);
            prmOptionsValues.setEnabled(false);
            listReturnIndex.setEnabled(false);
            listReturnText.setEnabled(false);
        }
    }//GEN-LAST:event_prmTypeActionPerformed

    private void btnOkActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnOkActionPerformed
        responseOk = true;
        setVisible(false);
    }//GEN-LAST:event_btnOkActionPerformed

    private void btnCancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelActionPerformed
        prmName.setText("");
        responseOk = false;
        setVisible(false);
    }//GEN-LAST:event_btnCancelActionPerformed

    public String getParameterName() {
        return prmName.getText();
    }

    public void setParameterName(String s) {
        prmName.setText(s);
    }

    public String getDescription() {
        return prmDesc.getText();
    }

    public void setDescription(String s) {
        prmDesc.setText(s);
    }

    public String getType() {
        return prmType.getSelectedItem().toString();
    }

    public void setType(String s) {
        int i = 0;
        if ("Text".equalsIgnoreCase(s)) {
            i = 0;
        } else if ("Numeric".equalsIgnoreCase(s)) {
            i = 1;
        } else if ("Options".equalsIgnoreCase(s)) {
            i = 2;
        } else if ("FilePath".equalsIgnoreCase(s)) {
            i = 2;
        } else if ("MultLine".equalsIgnoreCase(s)) {
            i = 2;
        }
        prmType.setSelectedIndex(i);
    }

    public String getOptionsValues() {
        return prmOptionsValues.getText();
    }

    public void setOptionsValues(String s) {
        prmOptionsValues.setText(s);
    }
    
    public String isKeyValuPairSelected(){
        String s = "false";
        if(checkKeyValue.isSelected()){
            s = "true";
        }        
        
        return s;
        
    }
    
    public void setKeyValuePairOption(String s){
        if("true".equalsIgnoreCase(s)){
            checkKeyValue.setSelected(true);
        }else{
            checkKeyValue.setSelected(false);
        }
    }
    
    public String getOptionsSelectionType(){
        String ret = botoseis.mainGui.prmview.ProcessParameter.OPTIONS_SELECTION_TEXT;
        if(listReturnIndex.isSelected()){
            ret = botoseis.mainGui.prmview.ProcessParameter.OPTIONS_SELECTION_INDEX;;
        }
        return ret;
    }
    
    public void setOptionsSelectionType(String opt){
        if("ReturnText".equalsIgnoreCase(opt)){
            listReturnText.setSelected(true);
        }else{
            listReturnText.setSelected(true);
        }
    }

    public String getDefaultValue() {
        return prmDefaultValue.getText();
    }

    public void setDefaultValue(String s) {
        prmDefaultValue.setText(s);
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {

            @Override
            public void run() {
                EditParametersDlg dialog = new EditParametersDlg(new javax.swing.JFrame(),
                        true);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {

                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }
    private boolean responseOk = false;
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCancel;
    private javax.swing.JButton btnOk;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JCheckBox checkKeyValue;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JLabel labelOptionsValues;
    private javax.swing.JRadioButton listReturnIndex;
    private javax.swing.JRadioButton listReturnText;
    private javax.swing.JTextField prmDefaultValue;
    private javax.swing.JTextField prmDesc;
    private javax.swing.JTextField prmName;
    private javax.swing.JTextField prmOptionsValues;
    private javax.swing.JComboBox prmType;
    // End of variables declaration//GEN-END:variables
}