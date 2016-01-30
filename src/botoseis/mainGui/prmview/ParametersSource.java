/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package botoseis.mainGui.prmview;

import botoseis.mainGui.workflows.ProcessModel;
import java.util.List;

public interface ParametersSource {
    
    public void saveToFile(String path);
    public void loadFromFile(String path);
    public List<String> getParametersInline();
    public void showParameters(javax.swing.JPanel hp);
    public ParametersSource clone(ProcessModel model);

}
