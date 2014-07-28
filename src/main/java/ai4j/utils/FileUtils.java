package ai4j.utils;

import java.io.*;
import java.nio.charset.Charset;

/**
 * Created with IntelliJ IDEA.
 * User: admin
 * Date: 13.11.13
 * Time: 14:37
 * To change this template use File | Settings | File Templates.
 */
public class FileUtils {

    public static String fileReadLine(String filename){
        String retVal = "";
        try {
            BufferedReader br = new BufferedReader( new InputStreamReader( new FileInputStream( new File(filename) )));
            retVal =  br.readLine();
            br.close();
        } catch (IOException e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        }
        return retVal;
    }

    public static void fileRewrite(String filename, StringBuilder text){
        try {
            FileWriter fw = new FileWriter(filename);
            fw.write(text.toString());
            fw.close();
        } catch (IOException e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        }
    }

    public static void fileAppendText(String filename, StringBuilder text){
        try {
            File file = new File(filename);
            OutputStreamWriter os = new OutputStreamWriter(new FileOutputStream(file), Charset.forName("Cp1251").newEncoder());
            os.write(text.toString());
            os.close();
        } catch (IOException e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        }
    }

    public static void fileAppendNewLine(String filename){
        try {
            BufferedWriter bw= new BufferedWriter(new FileWriter(filename, true));
            bw.newLine();
            bw.close();
        } catch (IOException e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        }
    }

    public static void clearFile(String filePath) {
        try {
            //if (new File(filePath).exists()){
                FileWriter fw = new FileWriter(filePath);
                fw.write("");
                fw.close();
            //}
        } catch (IOException e) {
           System.out.print("Ошибка при выполнении clearFile - файл не найден");
        }
    }

    /**
     * Function to delete file by filename
     * @param filename - name of deleting file
     */
    public static void delFile(String filename){
        File file = new File(filename);
        file.delete();

    }

    public static boolean containsStr(String filename, String s){
        //File file = new File(filename);
        try {
            BufferedReader br = new BufferedReader( new InputStreamReader( new FileInputStream( new File(filename) )));
            String line = null;
            while ( (line = br.readLine()) != null){
                if ( line.contains(s) ){
                    br.close();
                    return true;
                }
            }
            br.close();
        } catch (IOException e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        }
        return false;
    }
}
