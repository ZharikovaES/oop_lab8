package ru.mirea;

import javax.swing.*;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class Functions {
    public static void printFile(JFileChooser filechooser, JTextArea textarea) {
        int ret = filechooser.showDialog(null, "Открыть файл");
        if(ret == JFileChooser.APPROVE_OPTION) {
            File file = filechooser.getSelectedFile();
            try(FileReader reader = new FileReader(file)) {
                StringBuilder s = new StringBuilder();
                int c;
                while((c = reader.read()) != -1) {
                    s.append((char)c);
                }
                textarea.setText(s.toString());
            }
            catch(IOException ex){
                JOptionPane.showMessageDialog(null, ex.toString());
            }
        }
    }
    public static void writeFile(Boolean T, JFileChooser filechooser, JTextArea textarea) {
        int ret = filechooser.showDialog(null, "Открыть файл");
        if(ret == JFileChooser.APPROVE_OPTION) {
            File file = filechooser.getSelectedFile();
            try(FileWriter writer = new FileWriter(file, T)) {
                writer.write(textarea.getText());
            }
            catch(IOException ex){
                JOptionPane.showMessageDialog(null, ex.toString());
            }
        }
    }

}
