package aoi;

import java.util.Random;

/**
 * @Author yjy
 * @Date 2023/1/19
 **/
public class SkipList {
    // 结点晋升的概率
    private static final double PROMOTE_RATE = 0.5;
    private Node head;
    private Node tail;
    private int maxLevel;

    public SkipList() {
        head = new Node(Integer.MIN_VALUE);
        tail = new Node(Integer.MAX_VALUE);
        head.right = tail;
        tail.left = head;
    }

    public Node search(int data) {
        Node p = findNode(data);
        if (p.data == data) {
            System.out.println("找到结点: " + p);
            return p;
        }
        System.out.println("未找到结点");
        return null;
    }

    public Node findNode(int data) {
        Node node = head;
        while (true) {
            while (node.right.data != Integer.MAX_VALUE && node.right.data <= data) {
                node = node.right;
            }
            if (node.down == null) {
                break;
            }
            node = node.down;
        }
        return node;
    }

    public void insertNode(int data) {
        Node preNode = findNode(data);
        // 如果data相同,直接返回
        if (preNode.data == data) {
            return;
        }
        Node node = new Node(data);
        appendNode(preNode, node);
        int currentLevel = 0;
        // 决定结点是否"晋升"
        Random random = new Random();
        while (random.nextDouble() < PROMOTE_RATE) {
            // 假如当前层已经是最高层, 则需要增加一层
            if (currentLevel == maxLevel) {
                addLevel();
            }
            // 找到上一层的前置节点
            while (preNode.up == null) {
                preNode = preNode.left;
            }
            preNode = preNode.up;
            // 把晋升的新结点插入到上一层
            Node upperNode = new Node(data);
            appendNode(preNode, upperNode);
            upperNode.down = node;
            node.up = upperNode;
            node = upperNode;
            currentLevel++;
        }
    }

    private void addLevel() {
        maxLevel++;
        Node p1 = new Node(Integer.MIN_VALUE);
        Node p2 = new Node(Integer.MAX_VALUE);
        p1.right = p2;
        p2.left = p1;
        p1.down = head;
        head.up = p1;
        p2.down = tail;
        tail.up = p2;
        head = p1;
        tail = p2;
    }

    private void appendNode(Node preNode, Node node) {
        node.left = preNode;
        node.right = preNode.right;
        preNode.right.left = node;
        preNode.right = node;
    }

    public boolean remove(int data) {
        Node removeNode = search(data);
        if (removeNode == null) {
            return false;
        }
        int currentLevel = 0;
        while (removeNode != null) {
            removeNode.right.left = removeNode.left;
            removeNode.left.right = removeNode.right;
            // 如果不是最底层,切只有无穷小和无穷大节点, 则删除该层
            if (currentLevel != 0 && removeNode.left.data == Integer.MIN_VALUE && removeNode.right.data == Integer.MAX_VALUE) {
                removeLevel(removeNode.left);
            } else {
                currentLevel++;
            }
            removeNode = removeNode.up;
        }
        return true;
    }

    private void removeLevel(Node leftNode) {
        Node rightNode = leftNode.right;
        // 如果删除层是最高层
        if (leftNode.up == null) {
            leftNode.down.up = null;
            rightNode.down.up = null;
        } else {
            leftNode.up.down = leftNode.down;
            leftNode.down.up = leftNode.up;
            rightNode.up.down = rightNode.down;
            rightNode.down.up = rightNode.up;
        }
        maxLevel--;
    }

    public void printList() {
        Node node = head;
        while (node.down != null) {
            node = node.down;
        }
        while (node.right.data != Integer.MAX_VALUE) {
            System.out.print(node.right.data + " ");
            node = node.right;
        }
        System.out.println();
    }

    public static class Node {
        int data;
        Node left;
        Node right;
        Node up;
        Node down;

        public Node(int data) {
            this.data = data;
        }
    }

    public static void main(String[] args) {
        SkipList list = new SkipList();
        list.insertNode(50);
        list.insertNode(15);
        list.insertNode(13);
        list.insertNode(20);
        list.insertNode(100);
        list.insertNode(75);
        list.insertNode(99);
        list.insertNode(76);
        list.insertNode(83);
        list.insertNode(65);
        list.printList();
        list.search(50);
        list.remove(50);
        list.search(50);
    }
}
