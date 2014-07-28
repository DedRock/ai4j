package ai4j.utils;

import java.awt.*;
import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.StringSelection;
import java.awt.datatransfer.Transferable;
import java.awt.datatransfer.UnsupportedFlavorException;
import java.io.IOException;

/**
 * Created with IntelliJ IDEA.
 * User: Afrikanov
 * Date: 04.02.14
 * Time: 9:42
 * To change this template use File | Settings | File Templates.
 */
public class ClipBoard {

    /**
     * Function to Get String from ClipBoard
     * @return
     */
    public static String clipGet(){
        String retVal = "";

        Transferable transferable = Toolkit.getDefaultToolkit().getSystemClipboard().getContents(null);

        if (transferable != null && transferable.isDataFlavorSupported(DataFlavor.stringFlavor)) {
            try {
                retVal = (String) transferable.getTransferData(DataFlavor.stringFlavor);
            } catch (UnsupportedFlavorException e) {
                System.out.println("Error: UnsupportedFlavorException");
                e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
            } catch (IOException e) {
                System.out.println("Error: IOException");
                e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
            }
        }
        return retVal;
    }

    /**
     * Function to copy String text to clipboard
     * @param text
     */
    public static void clipPut(String text){
        StringSelection ss = new StringSelection(text);
        Toolkit.getDefaultToolkit().getSystemClipboard().setContents(ss, null);
    }
}
