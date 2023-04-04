/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package binarytrees;

import java.awt.Dimension;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;

/**
 *
 * @author student
 */
public class BinaryTreeGUI extends JFrame {

    static JFrame frame = new BinaryTreeGUI();
    static DrawBinaryTree myDraw = new DrawBinaryTree();

    /**
     * @param args the command line arguments
     */
    public BinaryTreeGUI() {
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                while (true) {
                    try {
                        Thread.sleep(25);
                    } catch (InterruptedException ex) {
                        Logger.getLogger(BinaryTreeGUI.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    paint();
                }
            }
        });
        thread.start();
    }

    public static void paint() {
        myDraw.repaint();
        frame.repaint();
    }
}
