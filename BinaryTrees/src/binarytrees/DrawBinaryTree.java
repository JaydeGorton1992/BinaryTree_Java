/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package binarytrees;

import java.awt.Color;
import java.awt.Graphics;
import java.util.Random;
import javax.swing.JPanel;

/**
 *
 * @author student
 */
public class DrawBinaryTree extends JPanel {

    public BinaryTree Tree;

    public DrawBinaryTree() {
        Tree = null;
    }

    public DrawBinaryTree(BinaryTree DrawTree) {
        Tree = DrawTree;

    }

    public void DrawTree() {
    }

    public void DrawTree(BinaryTree.Node focusNode, Graphics g) {

        if (focusNode != null && focusNode == Tree.root) {
            focusNode.x = 125;
            focusNode.y = 125;
        } else {
        
        }
        g.drawOval(focusNode.x, focusNode.y, 10, 10);

        String Ntext = String.valueOf(focusNode.Key);
        g.drawString(Ntext, focusNode.x, focusNode.y);
        if (focusNode.rightChild != null) {
            focusNode.rightChild.y = focusNode.y + 50;
            focusNode.rightChild.x = focusNode.x + 50;
            DrawTree(focusNode.rightChild, g);
        }

        if (focusNode.leftChild != null) {
            focusNode.leftChild.x = focusNode.x - 50;
            focusNode.leftChild.y = focusNode.y + 50;
            DrawTree(focusNode.leftChild, g);
        }
    }

    @Override
    public void paint(Graphics g) {
        g.setColor(Color.RED);
        DrawTree(Tree.root, g);
        //g.drawOval(0, 0, 10, 10);




    }

    private class DrawNode {

        int Key;
        int x, y, width, height;
        DrawNode leftChild;
        DrawNode rightChild;

        DrawNode(int Key, String name) {
            this.Key = Key;
            x = 0;
            y = 0;
        }
    }
}