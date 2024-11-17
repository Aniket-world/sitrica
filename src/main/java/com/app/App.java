package com.app;

import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 * Hello world!
 */
public class App implements Runnable {
    static Thread main_thread;
    static double hrs = 0.0;
    static double min = 0.0;
    static double sec = 0.0;
    private long startTime;
    private static Methods m;

    App() {
        startTime = System.currentTimeMillis();
    }

    public static void main(String[] args) {
        m = new Methods();
        startThread();

        JFrame frame = new JFrame("Sitrica");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setIconImage(Toolkit.getDefaultToolkit().getImage("src\\main\\java\\com\\app\\resources\\image.png"));
        
        JPanel mainPanel = new JPanel();
        
        JLabel namelabel = new JLabel("Name (Use space as separator):");
        
        mainPanel.
        frame.add(mainPanel);

        frame.pack();
        frame.setVisible(true);
        stopThread();
    }

    private static void startThread() {
        if (main_thread == null || !main_thread.isAlive()) {
            main_thread = new Thread(new App());
            main_thread.start();
        }
    }

    private static void stopThread() {
        if (main_thread != null && main_thread.isAlive()) {
            main_thread.interrupt();
            main_thread = null;
        }
        m.write("Hours : " + hrs + ", Minutes : " + min + ", Seconds : " + sec);
    }

    @Override
    public void run() {
        while (!Thread.currentThread().isInterrupted()) {
            long currentTime = System.currentTimeMillis();
            long elapsed = currentTime - startTime;

            hrs = (elapsed / (1000 * 60 * 60)) % 24;
            min = (elapsed / (1000 * 60)) % 60;
            sec = (elapsed / 1000.0) % 60;

            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
    }
}

