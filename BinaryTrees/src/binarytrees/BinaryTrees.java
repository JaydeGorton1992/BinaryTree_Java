/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package binarytrees;

import java.awt.Dimension;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import javax.swing.Action;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextField;

/**
 *
 * @author student
 */
public class BinaryTrees implements WindowListener, ActionListener {

    public static void main(String[] args) {
        // TODO code application logic here
        final BinaryTree theTree = new BinaryTree();
        theTree.addNode(50, "Boss");
        theTree.addNode(25,"Test");
        theTree.preOrderTraverseTree(theTree.root);
        //theTree.inOrderTraverseTree(theTree.root);
        
       System.out.println(theTree.findNode(25) + " Node found with value");
        
      //  theTree.preOrderTraverseTree(theTree.root);
       // 
        //theTree.inOrderTraverseTree(theTree.root);
        //theTree.postOrderTraverseTree(theTree.root);

        DrawBinaryTree myDraw = new DrawBinaryTree(theTree);
        final BinaryTreeGUI frame = new BinaryTreeGUI();


        frame.add(myDraw);
        myDraw.setLayout(null);
        JButton BAdd = new JButton("Add");
        BAdd.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                theTree.addNode(1, "Boss");
                System.out.print(theTree.root.toString() + "Hello");
                frame.repaint();
            }
        });
        BAdd.setSize(new Dimension(10, 10));
        BAdd.setPreferredSize(new Dimension(100, 100));
        BAdd.setLocation(new Point(100, 100));
        // myDraw.add(BAdd);

        final JTextField JTextDelete = new JTextField();

        JTextDelete.setBounds(400, 400, 100, 25);
        JTextDelete.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                int x = Integer.parseInt(JTextDelete.getText());

                theTree.deleteNode(x);
                System.out.print(theTree.root.toString() + "Hello");
                frame.repaint();
            }
        });

       // myDraw.add(JTextDelete);

        final JTextField JTextAdd = new JTextField();
        //    JTextAdd.setSize(new Dimension(100,30));
        JTextAdd.setBounds(300, 100, 100, 25);
        JTextAdd.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {

                int x = Integer.parseInt(JTextAdd.getText());

                theTree.addNode(x, "Boss");
                System.out.print(theTree.root.toString() + "Hello");
                frame.repaint();
            }
        });
        // JTextAdd.
      myDraw.add(JTextAdd);
        //frame.add(JTextAdd);
        frame.setPreferredSize(new Dimension(1000, 1000));
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
    }

    @Override
    public void windowOpened(WindowEvent we) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void windowClosing(WindowEvent we) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void windowClosed(WindowEvent we) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void windowIconified(WindowEvent we) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void windowDeiconified(WindowEvent we) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void windowActivated(WindowEvent we) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void windowDeactivated(WindowEvent we) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        throw new UnsupportedOperationException("Not supported yet.");
    }
}
