package chapter5;

import com.sun.javafx.scene.NodeHelper;

import java.util.Stack;

/**
 * @author guofucheng
 * @version 1.0
 * @date 2020/5/20 5:26 下午
 */
public class PreInPosTraversal {

    public static class Node{
        public Node left;
        public Node right;
        public int value;

        public Node(int value){
            this.value = value;
        }
    }

    //递归二叉树前序遍历
    public static void preOrderRecur(Node head) {
        if (head == null)
            return;
        System.out.println(head.value);
        preOrderRecur(head.left);
        preOrderRecur(head.right);
    }

    //递归二叉树中遍历
    public static void inOrderRecur(Node head) {
        if (head == null)
            return;
        inOrderRecur(head.left);
        System.out.println(head.value);
        inOrderRecur(head.right);
    }

    //递归二叉树后序遍历
    public static void posOrderRecur(Node head) {
        if (head == null)
            return;
        posOrderRecur(head.left);
        posOrderRecur(head.right);
        System.out.println(head.value);
    }

    //非递归二叉树前序遍历
    public static void preOrderUnRecur(Node head) {
        Stack<Node> stack = new Stack<>();
        if (head != null)
            stack.push(head);
        while(!stack.isEmpty()) {
            head = stack.pop();
            System.out.println(head.value);
            if (head.right != null)
                stack.push(head.right);
            if (head.left != null)
                stack.push(head.left);
        }
    }

    //非递归二叉树中序遍历
    public static void inOrderUnRecur(Node head) {
        Stack<Node> stack = new Stack<>();
        while (head != null || !stack.isEmpty()) {
            if(head != null){
                stack.push(head);
                head = head.left;
            }else {
                head = stack.pop();
                System.out.println(head.value);
                head = head.right;
            }
        }
    }

    //非递归二叉树后序遍历
    public static void posOrderUnRecur(Node head) {
        Stack<Node> stack1 = new Stack<>();
        Stack<Node> stack2 = new Stack<>();

        if (head != null)
            stack1.push(head);
        while(!stack1.isEmpty()){
            head = stack1.pop();
            stack2.push(head);
            if (head.left != null)
                stack1.push(head.left);
            if (head.right != null)
                stack1.push(head.right);
        }

        while(!stack2.isEmpty()){
            System.out.println(stack2.pop().value);
        }
    }

    public static void main(String[] args) {
        Node head = new Node(1);
        head.left = new Node(2);
        head.right = new Node(3) ;
        head.left.left = new Node(4);
        head.left.right = new Node(5);
        head.right.left = new Node(6);
        head.right.right = new Node(7);
        //preOrderRecur(head);
        //inOrderRecur(head);
        //posOrderRecur(head);
        //preOrderUnRecur(head);
        inOrderUnRecur(head);
        //posOrderUnRecur(null);
    }
}
