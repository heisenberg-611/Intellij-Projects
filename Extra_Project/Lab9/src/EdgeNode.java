public class EdgeNode {
    int toV;
    int weight;
    EdgeNode next;

    EdgeNode(int toV, int weight, EdgeNode next) {
        this.toV = toV;
        this.weight = weight;
        this.next = next;
    }
}