package ru.mirea;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class Frame extends JFrame {
    private Frame(){
        super("Работа с файлами");
        setLayout(null);
        setSize(505, 380);
        setResizable(false);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        JPanel middlePanel = new JPanel ();
        JLabel label = new JLabel("Введите текст:");
        label.setBounds(10, 0, 100, 20);
        JTextArea textArea = new JTextArea(12, 40);
        textArea.setLineWrap(true);
        textArea.setWrapStyleWord(true);
        textArea.setBounds(10, label.getHeight() + 5, 480, 200);
        JScrollPane scroll = new JScrollPane (textArea);
        scroll.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
        middlePanel.add(scroll);
        middlePanel.setBounds(10, label.getHeight() + 5, 480, 200);


        JButton b1 = new JButton("Вывод информации из файла на экран");
        JButton b2 = new JButton("Заменить информацию в файле на информацию, введённую с клавиатуры");
        JButton b3 = new JButton("Добавить в конец исходного файла текст, введённый с клавиатуры");
        b1.setBounds(40, textArea.getY() + textArea.getHeight() + 15,400, 30);
        b2.setBounds(10, b1.getY() + b1.getHeight() + 5,480, 30);
        b3.setBounds(10, b2.getY() + b2.getHeight() + 5,480, 30);

        JFileChooser fc = new JFileChooser();

        b1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Functions.printFile(fc, textArea);
            }
        });
        b2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Functions.writeFile(false, fc, textArea);
            }
        });
        b3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Functions.writeFile(true, fc, textArea);
            }
        });

        //setLayout(new BorderLayout());
        getContentPane().add(label);
        getContentPane().add(middlePanel);
        //getContentPane().add(textArea);
        getContentPane().add(b1);
        getContentPane().add(b2);
        getContentPane().add(b3);
    }

    public static void main(String[] args) {
            new Frame().setVisible(true);
    }
}
