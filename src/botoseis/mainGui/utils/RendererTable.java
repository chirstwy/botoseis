/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package botoseis.mainGui.utils;

import static botoseis.mainGui.workflows.WorkflowJob.COMPLETED;
import static botoseis.mainGui.workflows.WorkflowJob.RUNNING;
import static botoseis.mainGui.workflows.WorkflowJob.STOPPED;
import static java.awt.Color.BLACK;
import static java.awt.Color.BLUE;
import static java.awt.Color.ORANGE;
import static java.awt.Color.RED;
import static java.awt.Color.WHITE;
import static java.awt.Color.YELLOW;
import static java.awt.Color.green;
import java.awt.Component;
import java.awt.Font;
import static java.awt.Font.BOLD;
import static java.awt.Font.PLAIN;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.TableCellRenderer;

/**
 *
 * @author gabriel
 */
public class RendererTable extends DefaultTableCellRenderer implements TableCellRenderer {

    @Override
    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
        Component c = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);

        if (c != null && value != null) {
            if (column == 2) {
                if (value.toString().equals(RUNNING)) {
                    c.setBackground(BLUE);
                    c.setForeground(green);
                } else if (value.toString().equals(ERROR)) {
                    c.setBackground(RED);
                    c.setForeground(BLACK);
                } else if (value.toString().equals(COMPLETED)) {
                    c.setBackground(BLUE);
                    c.setForeground(YELLOW);
                } else if (value.toString().equals(STOPPED)) {
                    c.setBackground(ORANGE);
                    c.setForeground(BLACK);
                }
                c.setFont(new Font("Arial", BOLD, 12));
            } else {
                c.setFont(new Font("Arial", PLAIN, 12));
                c.setBackground(WHITE);
                c.setForeground(BLACK);
            }
        }
        return c;

    }
}
