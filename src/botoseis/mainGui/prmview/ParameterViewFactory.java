/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package botoseis.mainGui.prmview;

import static botoseis.mainGui.prmview.ProcessParameter.FILE_PATH;
import static botoseis.mainGui.prmview.ProcessParameter.MULTLINE_TEXT;
import static botoseis.mainGui.prmview.ProcessParameter.NUMERIC;
import static botoseis.mainGui.prmview.ProcessParameter.OPTIONS;
import static botoseis.mainGui.prmview.ProcessParameter.TEXT;

public class ParameterViewFactory {

    public ParameterViewFactory() {
    }

    public ParameterView createParameter(ProcessParameter prm) {
        ParameterView newP = null;

        if (prm.type.equalsIgnoreCase(FILE_PATH)) {
            newP = new FilePathParameterView(prm);
        } else if (prm.type.equalsIgnoreCase(MULTLINE_TEXT)) {
        } else if (prm.type.equalsIgnoreCase(NUMERIC)) {
            newP = new NumericParameterView(prm);
        } else if (prm.type.equalsIgnoreCase(OPTIONS)) {
            newP = new OptionsParameterView(prm);
        } else if (prm.type.equalsIgnoreCase(TEXT)) {
            newP = new TextParameterView(prm);
        }

        return newP;

    }
}
