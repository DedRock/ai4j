package ai4j;

/**
 * Created with IntelliJ IDEA.
 * User: AAfrkanov @PerfetTest)
 * Date: 16.11.13
 * Time: 14:55
 * To change this template use File | Settings | File Templates.
 */
public interface IAutoitAdapter {

    //===== User's functions ===========================================================================================
    void sleep(int timeMs);


    void runProgramm(String exeFileName);
    //===== Windows' control functions =================================================================================
    void winClose(String window);
    void winClose(String window, String windowText);
    void winWaitActive(String window);
    void winWaitActive(String window, String windowText);
    void winWaitActive(String window, String windowText, int waitTime);
    void winActivate(String window);
    void winActivate(String window, String windowText);
    //===== Controls' functions
    void controlClick(String winName, String winText, String controlId);
    void isControlExist(String window, String windowText, String controlId);
    void isControlChecked(String window, String windowText, String controlId);

    // Hot keys
    void sendCmd(String cmd); // Autoit command doc: http://www.autoitscript.com/autoit3/docs/appendix/SendKeys.htm

    //===== Cli[board functions ========================================================================================
    void clipPut();
    void clipGet();

    //===== Asserts ====================================================================================================
    void assertTrueControlText(String window, String windowText, String controlId, String testString);
    //void assertTrueCheckBox(String window, String windowText, String controlId);
    //void assertFalseCheckBoxO(String window, String windowText, String controlId);

    // void isWindowExist(String window, String windowText, String controlId)
    //
}
