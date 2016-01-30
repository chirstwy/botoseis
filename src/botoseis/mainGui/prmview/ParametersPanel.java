package botoseis.mainGui.prmview;

import static botoseis.mainGui.utils.Utils.getBotoseisROOT;
import botoseis.mainGui.workflows.ParametersGroup;
import botoseis.mainGui.workflows.ProcessModel;
import static java.awt.BorderLayout.WEST;
import java.awt.Component;
import static java.awt.Component.LEFT_ALIGNMENT;
import java.awt.GridBagConstraints;
import static java.awt.GridBagConstraints.HORIZONTAL;
import static java.awt.GridBagConstraints.NORTHWEST;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import static javax.swing.Box.createVerticalBox;
import static javax.swing.JOptionPane.showMessageDialog;
import javax.swing.JPanel;

/*
 * ParametersPanel.java
 *
 * Created on January 6, 2008, 8:57 AM
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */
public class ParametersPanel implements ParametersSource {

    public ParametersPanel(ProcessModel pProc) {

        m_prmPanels = new ArrayList<>();

        List<ParametersGroup> grps = pProc.getParameters();

        ParameterViewFactory pfac = new ParameterViewFactory();

        for (int i = 0; i < grps.size(); i++) {
            javax.swing.JPanel jPanel1 = new javax.swing.JPanel();

            jPanel1.setBorder(new javax.swing.border.TitledBorder(grps.get(i).getGroupName()));
            jPanel1.setLayout(new java.awt.BorderLayout());

            javax.swing.Box grpBox = createVerticalBox();
            grpBox.setAlignmentX(LEFT_ALIGNMENT);

            List<ProcessParameter> prmList = grps.get(i).getParameters();

            ProcessParameter prm;
            for (int j = 0; j < prmList.size(); j++) {
                prm = prmList.get(j);

                ParameterView npv;

                npv = pfac.createParameter(prm);

                npv.setAlignmentX(LEFT_ALIGNMENT);

                grpBox.add(npv);
            }

            jPanel1.add(grpBox, WEST);
            m_prmPanels.add(jPanel1);
        }
    }

    @Override
    public void loadFromFile(String path) {
        File myFile = new File(path);

        try {
            Scanner scanner = new Scanner(myFile);
            Scanner scanner2;

            String line;
            for (JPanel gPanel : m_prmPanels) {
                String grpTitle = ((javax.swing.border.TitledBorder) gPanel.getBorder()).getTitle();
                String aLine = scanner.nextLine();
                //         scanner2 = new Scanner(aLine); // Read group title

                java.awt.Component[] grpsB = gPanel.getComponents();
                for (Component grpsB1 : grpsB) {
                    javax.swing.Box gbox = (javax.swing.Box) grpsB1;
                    java.awt.Component[] prms = gbox.getComponents();
                    for (Component prm : prms) {
                        ParameterView pv = (ParameterView) prm;
                        aLine = scanner.nextLine();
                        scanner2 = new Scanner(aLine);
                        scanner2.useDelimiter("=");
                        String name = scanner2.next();
                        String value = "";
                        if (scanner2.hasNext()) {
                            value = scanner2.next();
                        }
                        pv.setValue(value);
                    }
                }
                scanner.nextLine(); // '/' group end mark

            }
        } catch (FileNotFoundException e) {
            showMessageDialog(null, e.toString());
        }

    }

    @Override
    public void saveToFile(String path) {
        File of = new File(path);
        FileWriter outF;
        try {
            outF = new FileWriter(of);
            for (JPanel gPanel : m_prmPanels) {
                String grpTitle = ((javax.swing.border.TitledBorder) gPanel.getBorder()).getTitle();
                outF.write("&" + grpTitle + "\n");
                java.awt.Component[] grpsB = gPanel.getComponents();
                for (Component grpsB1 : grpsB) {
                    javax.swing.Box gbox = (javax.swing.Box) grpsB1;
                    java.awt.Component[] prms = gbox.getComponents();
                    for (Component prm : prms) {
                        ParameterView pv = (ParameterView) prm;
                        outF.write(pv.getKeyValuePair());
                        outF.write("\n");
                    }
                }
                outF.write("/\n");
            }
            outF.close();
        } catch (IOException ex) {
        }
    }

    @Override
    public void showParameters(javax.swing.JPanel hp) {
        GridBagConstraints c = new GridBagConstraints();
        c.fill = HORIZONTAL;
        c.anchor = NORTHWEST;
        c.weightx = 1;
        c.weighty = 0;
        for (int i = 0; i < m_prmPanels.size(); i++) {
            c.gridx = 0;
            c.gridy = i;
            if (i == m_prmPanels.size() - 1) {
                c.weighty = 1;
            }
            hp.add(m_prmPanels.get(i), c);
        }
    }

    @Override
    public List<String> getParametersInline() {
        List<String> ret = new ArrayList<>();
        for (JPanel gPanel : m_prmPanels) {
            String grpTitle = ((javax.swing.border.TitledBorder) gPanel.getBorder()).getTitle();
            java.awt.Component[] grpsB = gPanel.getComponents();
            for (Component grpsB1 : grpsB) {
                javax.swing.Box gbox = (javax.swing.Box) grpsB1;
                java.awt.Component[] prms = gbox.getComponents();
                for (Component prm : prms) {
                    ParameterView pv = (ParameterView) prm;
                    if (pv.getValue().length() > 0) {
                        String[] sv = pv.getCommandLine().split(" ");
                        ret.addAll(Arrays.asList(sv));
                    }
                }
            }
        }

        return ret;
    }

    @Override
    public ParametersSource clone(ProcessModel model) {
        ParametersPanel pp = new ParametersPanel(model);
        saveToFile(getBotoseisROOT() + "/." + model.getID());
        pp.loadFromFile(getBotoseisROOT() + "/." + model.getID());
        return pp;
    }

    // Variables declaration
    List<javax.swing.JPanel> m_prmPanels;
}
