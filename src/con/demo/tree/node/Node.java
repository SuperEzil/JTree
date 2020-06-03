package con.demo.tree.node;

/**
 * Node class
 */
public class Node {

    private static int _Count = 0;

    {
        _Count++;
    }

    /**
     * 자신의 깊이값
     */
    private int _Level = 0;
    private int _ValueCount = 0;

    /**
     * 부모 노드
     */
    private Node _Left;
    /**
     * 왼쪽 노드(작은)
     */
    private Node _Right;
    /**
     * 오른쪽 노드(큰)
     */
    private Node _Parent;

    /**
     * 자신의 값
     */
    private final int _Number;

    public Node(int number) {
        this._Number = number;
    }

    /**
     * 자신의 부모 노드 전달
     *
     * @return
     */
    public Node getParent() {
        return _Parent;
    }

    public void setParent(Node _Parent) {
        this._Parent = _Parent;
    }

    public Node getLeft() {
        return _Left;
    }

    public Node getRight() {
        return _Right;
    }

    public int getNumber() {
        return _Number;
    }

    public Number getNumberLine() {
        if (_Number >= 0)
            return Number.POSITIVE; // 양수

        return Number.NEGATIVE; // 음수
    }

    public int getLevel() {
        return _Level;
    }

    public void setLevel(int _Level) {
        this._Level = _Level;
    }

    /**
     * 루트 노드인가?
     *
     * @return
     */
    public boolean isRoot() {
        if (getParent() == null)
            return true;

        return false;
    }

    public Node getRoot() {
        Node tmp = this;
        while (true) {
            if (tmp.getParent() == null) {
                return tmp;
            } else {
                tmp = tmp.getParent();
            }
        }
    }

    /**
     * 연결 노드인가?
     *
     * @return
     */
    public boolean isLeaf() {
        if (getParent() != null && getChildCount() >= 1)
            return true;

        return false;
    }

    /**
     * 형제 노드가 있는지?
     *
     * @return
     */
    public boolean isSibling() {
        if (!isRoot()) {
            if (getParent().getChildCount() >= 2)
                return true;
        }
        return false;
    }

    /**
     * 자식 노드 갯수 반환
     */
    private int getChildCount() {
        int count = 0;

        if (_Left != null)
            count++;

        if (_Right != null)
            count++;
        return count;
    }

    ////////////////// add child/////////////////////////
    public int addNode(Node node) {
        if (isRoot() && getNumberLine() == Number.NEGATIVE && node.getNumberLine() == Number.POSITIVE){     // 루트이면서 음수인 경우에 추가 노드가 양수인 경우
            setParent(node);
        }else{
            switch (this.compare(node)) {
                case RIGHT ->{
                    if (getRight() == null){
                        addRight(node);
                    }else{
                        getRight().addNode(node);
                    }
                }
                case LEFT -> {
                    if (isRoot() && node.getNumberLine() == Number.POSITIVE){
                        setParent(node);
                    }else if(getLeft() == null){
                        addLeft(node);
                    }else {
                        getLeft().addNode(node);
                    }
                }
                case SAME -> this.plusValue();
            }

        }

        return getLevel();
    }

    private void addChild(Node node) {
    }



    /**
     * 부모 변경
     *
     * @param node
     */
    private void parentChanged(Node node) {
        this._Parent = node;
        switch (node.compare(this)) {
            case RIGHT -> node.addRight(this);
            case LEFT -> node.addLeft(this);
            case SAME -> node.plusValue();
        }
    }

    /**
     * 동일값 카운트 올림
     */
    private void plusValue() {
        _ValueCount++;
    }

    /**
     * 노드 비교
     *
     * @param node 대상 노드
     * @return {@link Compare }
     */
    private Compare compare(Node node) {
        if (this._Number > node.getNumber()) {
            return Compare.LEFT;
        } else if (this._Number < node.getNumber()) {
            return Compare.RIGHT;
        }
        return Compare.SAME;
    }


    //
    public int addLeft(Node node) {
        node.setParent(this);
        this._Left = node;
        this._Left.setLevel(this._Level++);

        return this._Left.getLevel();
    }

    public int addRight(Node node) {

        node.setParent(this);
        this._Right = node;
        this._Right.setLevel(this._Level++);

        return this._Right.getLevel();
    }

    ////////////////// modify Level/////////////////////////

}
