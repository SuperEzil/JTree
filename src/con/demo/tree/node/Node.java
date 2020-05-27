package con.demo.tree.node;

/**
 * Node class
 */
public class Node {
    /** 자신의 깊이값*/
    private int _Level;

    /** 부모 노드*/
    private Node _Left;
    /** 왼쪽 노드(작은)*/
    private Node _Right;
    /** 오른쪽 노드(큰)*/
    private Node _Parent;

    /**
     * 자신의 부모 노드 전달
     * @return
     */
    public Node getParent(){
        return _Parent;
    }

    /**
     * 루트 노드인가?
     * @return
     */
    public boolean	isRoot(){
        return false;
    }

    /**
     * 연결 노드인가?
     * @return
     */
    public boolean	isLeaf(){
        return false;
    }

    /**
     * 형제 노드가 있는지?
     * @return
     */
    public boolean isSibling(){
        return false;
    }
}
