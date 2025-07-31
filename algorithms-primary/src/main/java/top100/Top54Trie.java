package top100;

public class Top54Trie {


    public Top54Trie() {
        root = new Node();
    }

    private Node root;

    public static class Node {
        public int pass;
        public int end;
        public Node[] nexts;

        public Node() {
            this.pass = 0;
            this.end = 0;
            this.nexts = new Node[26];
        }
    }

    public void insert(String word) {
        if (word == null) {
            return;
        }
        char[] chars = word.toCharArray();
        Node node = root;
        node.pass++;
        int path = 0;
        for (char c : chars) {
            path = c - 'a';
            if (node.nexts[path] == null) {
                node.nexts[path] = new Node();
            }
            node = node.nexts[path];
            node.pass++;
        }
        node.end++;
    }

    public boolean search(String word) {
        if (word == null) {
            return false;
        }
        char[] chars = word.toCharArray();
        Node node = root;
        int path = 0;
        for (char c : chars) {
            path = c - 'a';
            if (node.nexts[path] == null) {
                return false;
            }
            node = node.nexts[path];
        }
        return node.end > 0;
    }

    public boolean startsWith(String prefix) {
        if (prefix == null) {
            return false;
        }
        char[] chars = prefix.toCharArray();
        Node node = root;
        int path = 0;
        for (char c : chars) {
            path = c - 'a';
            if (node.nexts[path] == null) {
                return false;
            }
            node = node.nexts[path];
        }
        return node.pass > 0;
    }

    public boolean delete(String word) {
        if (search(word)) {
            char[] chars = word.toCharArray();
            Node node = root;
            node.pass--;
            int path = 0;
            for (char c : chars) {
                path = c - 'a';
                if (--node.nexts[path].pass == 0) {
                    node.nexts[path] = null;
                    return true;
                }
                node = node.nexts[path];
            }
            node.end--;
            return true;
        }
        return false;
    }

}
