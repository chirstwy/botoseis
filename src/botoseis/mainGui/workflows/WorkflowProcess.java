/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package botoseis.mainGui.workflows;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import javax.swing.JTextArea;
import static botoseis.mainGui.workflows.WorkflowJob.COMPLETED;
import static botoseis.mainGui.workflows.WorkflowJob.ERROR;
import static botoseis.mainGui.workflows.WorkflowJob.RUNNING;
import static botoseis.mainGui.workflows.WorkflowJob.STARTING;
import static botoseis.mainGui.workflows.WorkflowJob.STOPPED;
import java.io.IOException;
import static java.lang.String.valueOf;
import static java.lang.System.currentTimeMillis;
import static java.lang.System.getProperty;
import java.util.List;

/**
 *
 * @author gabriel
 */
public class WorkflowProcess {

    public WorkflowProcess(ProcessModel pModel, botoseis.mainGui.prmview.ParametersSource prmSource) {
        m_prmSource = prmSource;
        m_execStatus = STARTING;
        m_model = pModel;
        lengthProcessed = 0L;

        last = false;
    }

    public void start(String homeDir) {

        lengthProcessed = 0;
        m_timeStop = 0;

        try {
            List<String> cmd = m_prmSource.getParametersInline();
            cmd.add(0, m_model.getExecutablePath());
            pb = new ProcessBuilder(cmd);
            pb.directory(new java.io.File(homeDir));
            m_proc = pb.start();
        } catch (Exception e) {
        }

        status = RUNNING;
        flowLog.append("\nProcess started: " + this.getTitle() + " \n");
        Thread log = new Thread() {

            @Override
            public void run() {

                try {
                    int b = m_proc.getErrorStream().read();
                    do {
                        flowLog.append(valueOf((char) b));

                        if (flowLog.checkError()) {
                            status = ERROR;
                        }
                        if (status.equals(STOPPED)) {
                            break;
                        }

                        b = m_proc.getErrorStream().read();
                    } while (b >= 0);

//                    if (last) {
//                        m_timeStop = System.currentTimeMillis();
//                    }
                    if (!status.equals(STOPPED)) {
                        status = COMPLETED;
                    }
                } catch (Exception e) {
//                    e.printStackTrace();
                }
            }
        };
        log.start();

        Thread output;
        output = new Thread() {

            @Override
            public void run() {

                try {
                    if (input != null) {
                        try (BufferedOutputStream buffout = new BufferedOutputStream(getOutStream());
                                BufferedInputStream buffInp = new BufferedInputStream(input)) {
                            int b = 0;
                            byte[] len = new byte[1024];
                            do {
                                if (status.equals(STOPPED)) {
                                    break;
                                }
                                b = buffInp.read(len);
                                if (b >= 0) {
                                    buffout.write(len, 0, b);
                                    lengthProcessed += len.length;
                                }
                            } while (b >= 0);
                        }
                    }

                    if (last) {
                        BufferedInputStream buffInp = new BufferedInputStream(getInputStream());
                        int b;
                        while ((b = buffInp.read()) >= 0) {
                            m_console.append(valueOf((char) b));
                        }
                        m_console.append("---------------------------- END ---------------------------------");
                        m_console.append("\n\n");
                        m_timeStop = currentTimeMillis();
                        status = COMPLETED;
                        getInputStream().close();
                        getErrorStream().close();
                        getOutStream().close();
                        input.close();
                    }

                } catch (Exception e) {
//                    e.printStackTrace();
                    try {
                        getInputStream().close();
                        getErrorStream().close();
                        getOutStream().close();
                        input.close();
                        m_timeStop = currentTimeMillis();
                        m_console.append("---------------------------- END ---------------------------------");
                        m_console.append("\n\n");
                    } catch (IOException ioe) {
                    }
                    status = STOPPED;
                }
            }
        };
        output.start();

    }

    @Override
    public WorkflowProcess clone() {
        WorkflowProcess wp = new WorkflowProcess(m_model, m_prmSource.clone(m_model));
        wp.setReviewed(reviewed);
        wp.m_flowID = m_flowID;
        return wp;
    }

    public botoseis.mainGui.prmview.ParametersSource getParametersSource() {
        return m_prmSource;
    }

    public ProcessModel getModel() {
        return m_model;
    }

    public String getWorkflowID() {
        return m_flowID;
    }

    public void setWorkflowID(String s) {
        m_flowID = s;
    }

    public String getModelID() {
        return m_model.getID();
    }

    public String getLastCmdLine() {
        return m_lastCmdLine;
    }

    public String getTitle() {
        return m_model.getTitle();
    }

    public void setTimeStop(Long value) {
        m_timeStop = value;
    }

    public void stop() {
        try {
            m_proc.getErrorStream().close();
            m_proc.getInputStream().close();
            m_proc.getOutputStream().close();
            status = STOPPED;
            m_proc.destroy();
        } catch (IOException ioe) {
        }
    }

    public boolean isReviewed() {
        return reviewed;
    }

    public void setReviewed(boolean reviewed) {
        this.reviewed = reviewed;
    }

    public String getStrReviewd() {
        if (this.isReviewed()) {
            return "true";
        } else {
            return "false";
        }
    }

    public boolean getBoReviewd(String str) {
        return str.equalsIgnoreCase("true");
    }

    public OutputStream getOutStream() {
        return m_proc.getOutputStream();
    }

    public Long getLentghProcessed() {
        return lengthProcessed;
    }

    public InputStream getInputStream() {
        return m_proc.getInputStream();
    }

    public void setInputStream(InputStream input) {
        this.input = input;
    }

    public InputStream getErrorStream() {
        return m_proc.getErrorStream();
    }

    public void setFlowLog(WorkflowLogDlg flowLog) {
        this.flowLog = flowLog;
    }

    public void setLast(boolean last) {
        this.last = last;
    }

    public long getTimeStop() {
        return m_timeStop;
    }

    public String getStatus() {
        return status;
    }

    public void open(String homeDir) {
        String flowID = m_flowID.replace("/", "-");
        String fsep = getProperty("file.separator");
        String nlFile = homeDir + fsep + flowID + ".nl";
        m_prmSource.loadFromFile(nlFile);
    }

    public void save(String homeDir) {
        String flowID = m_flowID.replace("/", "-");
        String fsep = getProperty("file.separator");
        String nlFile = homeDir + fsep + flowID + ".nl";
        m_prmSource.saveToFile(nlFile);
    }
    private ProcessBuilder pb;
    private Process m_proc = null;
    private final String m_execStatus;
    private String m_flowID;
    private final ProcessModel m_model;
    private final botoseis.mainGui.prmview.ParametersSource m_prmSource;
    private String m_lastCmdLine;
    //-------------------------------
    private boolean reviewed;
    private WorkflowLogDlg flowLog;
    private InputStream input;
    private long lengthProcessed;
    private String status;
    private boolean last;
    private long m_timeStop;
    private JTextArea m_console;

    void setConsole(JTextArea m_console) {
        this.m_console = m_console;
    }
    //-------------------------------//
}
