/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package binarytrees;

/**
 *
 * @author student
 */
public class BinaryTree {
 
    Node root;

    public void postOrderTraverseTree(Node focusNode) {
        if (focusNode != null) {
            inOrderTraverseTree(focusNode.leftChild);
            inOrderTraverseTree(focusNode.rightChild);
            System.out.println(focusNode);

        }
    }

    public void preOrderTraverseTree(Node focusNode) {

        if (focusNode != null) {
            System.out.println(focusNode);
            preOrderTraverseTree(focusNode.rightChild);
            preOrderTraverseTree(focusNode.leftChild);
        }
    }

    public void inOrderTraverseTree(Node focusNode) {

        if (focusNode != null) {
            inOrderTraverseTree(focusNode.leftChild);
            System.out.println(focusNode);
            inOrderTraverseTree(focusNode.rightChild);
        }
    }

    public Node findNode(int key) {
        Node focusNode = root;

        while (focusNode.Key != key) {
            if (key < focusNode.Key) {
                focusNode = focusNode.leftChild;
            } else {
                focusNode = focusNode.rightChild;
            }
            if (focusNode == null) {
                return null;
            }
        }
        return focusNode;
    }

    public void addNode(int key, String name) {
        Node newNode = new Node(key, name);
        if (root == null) {
            root = newNode;
            root.x = 0;
            root.y = 0;
        } else {
            Node focusNode = root;
            Node parent;
            while (true) {
                parent = focusNode;
                if (key < focusNode.Key) {
                    focusNode = parent.leftChild;
                    if (focusNode == null) {
                        parent.leftChild = newNode;
                        return;
                    }
                } else {
                    focusNode = focusNode.rightChild;

                    if (focusNode == null) {
                        parent.rightChild = newNode;
                        return;
                    }
                }
            }
        }
    }

    public boolean deleteNode(int key) {
        Node focusNode = root;
        Node parent = root;

        boolean isItALeftChild = true;
        while (focusNode.Key != key) {

            parent = focusNode;
            if (key < focusNode.Key) {
                isItALeftChild = true;
                focusNode = focusNode.leftChild;

            } else {
                isItALeftChild = false;
                focusNode = focusNode.rightChild;
            }

            if (focusNode == null) {
                return false;
            }
        }

        if (focusNode.leftChild == null && focusNode.rightChild == null) {
            if (focusNode == root) {
                root = null;
            } else if (isItALeftChild) {
                parent.leftChild = null;
            } else {
                parent.rightChild = null;
            }

        } else if (focusNode.rightChild == null) {
            if (focusNode == root) {
                root = focusNode.leftChild;
            } else if (isItALeftChild) {
                parent.rightChild = focusNode.leftChild;
            }
        } else if (focusNode.leftChild == null) {
            if (focusNode == root) {
                root = focusNode.rightChild;
            } else if (isItALeftChild) {
                parent.leftChild = focusNode.rightChild;
            } else {
                parent.rightChild = focusNode.rightChild;
            }
        } else {//Test
            Node replacement = getReplacementNode(focusNode);

            if (focusNode == root) {
                root = replacement;
            } else if (isItALeftChild) {
                parent.leftChild = replacement;
            } else {
                parent.rightChild = replacement;
            }
            replacement.leftChild = focusNode.leftChild;

        }
        System.out.println(key + " Node has been deleted");
        return true;
    }

    public Node getReplacementNode(Node replacedNode) {
        Node replacementParent = replacedNode;
        Node replacement = replacedNode;

        Node focusNode = replacedNode.rightChild;

        while (focusNode != null) {
            replacementParent = replacement;
            replacement = focusNode;
            focusNode = focusNode.leftChild;
        }

        if (replacement != replacedNode.rightChild) {

            replacementParent.leftChild = replacement.rightChild;
            replacement.rightChild = replacedNode.rightChild;
        }
        return replacement;
    }
    
    class Node {
        public int x, y;
        int Key;
        String name;
        Node leftChild;
        Node rightChild;

        Node(int Key, String name) {
            this.Key = Key;
            this.name = name;
        }

        @Override
        public String toString() {
            return name + " has a key " + Key;
        }
    }
}

