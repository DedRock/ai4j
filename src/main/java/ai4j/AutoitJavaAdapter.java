package ai4j;

import ai4j.utils.FileUtils;
import ai4j.IAutoitAdapter;
import ai4j.utils.PropFileReader;

import java.io.IOException;

public class AutoitJavaAdapter implements IAutoitAdapter {

    private StringBuilder scriptText;
    private String scriptFileName = "AutoitInstScript.au3";
    protected String AutoitRunnerExe;

    /**
     * Constructor
     */
    public AutoitJavaAdapter(){
        scriptText = new StringBuilder();
        AutoitRunnerExe = PropFileReader.getPropValue("autoIt", "AutoItExe");
    }

    /**
     * Reset ScriptText
     */
    public void resetScriptText() {
        scriptText.setLength(0);
    }

    /**
     * Function to get script text
     * @return
     */
    public StringBuilder getScriptText() {
        return scriptText;
    }

    /**
     * Function to run script with current text
     */
    public void runScript(){

        FileUtils.clearFile(scriptFileName.toString());
        FileUtils.fileAppendText(scriptFileName, scriptText);
        try {
            Process curTestProcess = Runtime.getRuntime().exec( new String[]{AutoitRunnerExe, scriptFileName.toString()} );
            curTestProcess.waitFor();
            resetScriptText();
        } catch (InterruptedException e) {
            System.out.println("Ошибка ожидания выполнения скрипта");
        } catch (IOException e) {
            System.out.println("Не найден AutoIt3.exe. Проверьте путь до него в autoIt.properties");
        }
    }

    /*********************************************************************************************************
     * Realization methods of IAutoitAdapter
     *********************************************************************************************************/
    @Override
    public void sleep(int timeMs) {
        scriptText.append("Sleep(").append(Integer.toString(timeMs)).append(")\n");
    }

    @Override
    public void controlClick(String winName, String winText, String controlId) {
        scriptText.append("ControlClick(\"").append(winName).append("\", \"").append(winText).append("\", \"").append(controlId).append("\")\n ");
    }

    @Override
    public void runProgramm(String exeFileName) {
        scriptText.append("Run(\"").append(exeFileName).append("\")\n");
    }

    @Override
    public void winClose(String window) {
        scriptText.append("WinClose(\"").append(window).append("\")\n");
    }

    @Override
    public void winClose(String window, String windowText) {
        scriptText.append("WinClose(\"").append(window).append("\", \"").append(windowText).append("\")\n");
    }

    @Override
    public void winWaitActive(String window) {
        //scriptText.append("IF NOT ");
        scriptText.append("WinWaitActive(\"").append(window).append("\")\n ");
    }

    @Override
    public void winWaitActive(String window, String windowText) {
        scriptText.append("WinWaitActive(\"").append(window).append("\", \"").append(windowText).append("\")\n ");
    }

    @Override
    public void winWaitActive(String window, String windowText, int waitTime) {
        scriptText.append("WinWaitActive(\"").append(window).append("\", \"").append(windowText).append("\", \"").append(Integer.toString(waitTime)).append("\")\n");
    }

    @Override
    public void winActivate(String window) {
        scriptText.append("WinActivate(\"").append(window).append(" \")\n");
    }

    @Override
    public void winActivate(String window, String windowText) {
        scriptText.append("WinActivate(\"").append(window).append("\",\"").append(windowText).append(" \")\n");
    }

    @Override
    public void assertTrueControlText(String window, String windowText, String controlId, String testString) {
        scriptText.append("IF ").append("ControlGetText(\"").append(window).append("\",\"").append(windowText).append("\",\"").append(controlId).append("\") = \"").append(testString).append("\" THEN\n");
    }

    @Override
    public void isControlExist(String window, String windowText, String controlId) {
       // check visible of control.    ControlCommand
        scriptText.append("IF NOT ").append("ControlCommand(").append(window).append("\",\"").append(windowText).append("\",\"").append(controlId).append("\",\"IsVisible\", \"\") THEN \n");
    }

    @Override
    public void isControlChecked(String window, String windowText, String controlId) {
        scriptText.append("IF NOT ").append("ControlCommand(").append(window).append("\",\"").append(windowText).append("\",\"").append(controlId).append("\",\"IsChecked\", \"\") THEN \n");
    }

    @Override
    public void sendCmd(String cmd) {
        scriptText.append("Send(\"" + cmd + "\")\n");
    }

    @Override
    public void clipPut() {
        scriptText.append("Send(\"^{INS}\")\n");
    }

    @Override
    public void clipGet() {
        scriptText.append("Send(\"+{INS}\")\n");
    }

}
