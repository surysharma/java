package algos;

public class SinglyLinkedList {

    ListNode node;

    public void add(String item){
        if (node == null) {
            this.node = new ListNode(item, null);
        } else {
            this.node = new ListNode(item, this.node);
        }
    }

    public boolean add(String newStr, String after){
        ListNode currentNode = this.node;
        while(currentNode != null) {
            if (currentNode.data.equals(after)) {

                ListNode newNode = new ListNode(newStr, currentNode.previous);
                currentNode.previous = newNode;
                return true;
            }
            currentNode = currentNode.previous;
        }
        return false;
    }

    public boolean remove(String str) {

        if (this.node== null || this.node.previous == null) {
            return false;
        }

        ListNode currentNode = this.node.previous;
        ListNode followingNode = this.node;

        if (followingNode.data.equals(str)){
            this.node = currentNode;
            return true;
        }

        while (currentNode != null) {
            if (currentNode.data.equals(str)) {
                followingNode.previous = currentNode.previous;
                currentNode = null;
                return true;
            }
            followingNode = currentNode;
            currentNode = currentNode.previous;
        }

        return false;
    }


    public void print() {
        ListNode currentNode = this.node;
        if (currentNode !=null) {
            while(currentNode != null) {
                System.out.println(" " + currentNode.data);
                currentNode = currentNode.previous;
            }
        }
    }

    public String next() {
        if (this.node != null) {
            return this.node.data;
        } else {
            return null;
        }
    }



    static class ListNode {
        public String data;
        public ListNode previous;

        public ListNode(){}

        public ListNode(String data, ListNode previous) {
            this.data = data;
            this.previous = previous;
        }

    }


    public static void main(String[] args) {

        SinglyLinkedList list = new SinglyLinkedList();

        list.add("b");
        list.add("a");
        list.add("k");
        list.add("a");
        list.add("d");
        list.add("c");
        list.add("a");


        list.print();

        System.out.println("Inserted? : " + list.add("z", "k"));

        list.print();

        System.out.println("Removed? : " + list.remove("k"));

        list.print();
    }

}
