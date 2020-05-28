package con.demo.tree.node;

/**
 * Node class
 */
public class Node {

    private static int _Count = 0;
    {
        _Count++;
    }
    /** 자신의 깊이값*/
    private int _Level = 0;
    private int _ValueCount = 0;

    /** 부모 노드*/
    private Node _Left;
    /** 왼쪽 노드(작은)*/
    private Node _Right;
    /** 오른쪽 노드(큰)*/
    private Node _Parent;

    /** 자신의 값 */
    private final int _Number;
    public Node(int number) {
        this._Number = number;
    }

    /**
     * 자신의 부모 노드 전달
     * @return
     */
    public Node getParent(){
        return _Parent;
    }

    public void setParent(Node _Parent) {
        this._Parent = _Parent;
    }

    public Node getLeft() { return _Left;  }
    public Node getRight() { return _Right; }

    public int getNumber() { return _Number; }

    public int getLevel() {return _Level; }
    public void setLevel(int _Level) {this._Level = _Level; }

    /**
     * 루트 노드인가?
     * @return
     */
    public boolean	isRoot(){
        if (getParent() == null)
            return true;

        return false;
    }

    /**
     * 연결 노드인가?
     * @return
     */
    public boolean	isLeaf(){
        if (getParent() != null && getChildCount() >= 1)
            return true;

        return false;
    }

    /**
     * 형제 노드가 있는지?
     * @return
     */
    public boolean isSibling(){
        if (!isRoot()){
             if(getParent().getChildCount() >= 2)
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
    public int addNode(Node node){
        //1. 최상의 루트로 등록 되어야 하는 경우
        // 재귀함수 구조로 변경 필요
        switch (this.compare(node)){
            case LARGE ->addChild(node);
            case LEFT -> {
                if (isRoot()){
                    setParent(node);
                }else{
                    getParent().parentChanged(node);
                }
            }
            case SAME -> plusValue();
        }
        //2. R로 저정되어야 하는가?
        //3. L로 저정되어야 하는가?



        return getLevel();
    }

    private void addChild(Node node) {
        if (isLeaf()){
            switch (getRight().compare(node)){
                case LARGE -> addLeft(node);
                case LEFT -> {
                    this._Left = getRight();
                    this._Right = node;
                }
                case SAME -> getRight().plusValue();
            }
        }else{
            addRight(node);
        }
    }

    /**
     * 부모 변경
      * @param node
     */
    private void parentChanged(Node node) {
        this._Parent = node;
        switch (node.compare(this)){
            case LARGE -> node.addRight(this);
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
     * @param node 대상 노드
     * @return {@link Compare }
     */
    private Compare compare(Node node) {
        if (this._Number > node.getNumber()) {
            return Compare.LARGE;
        }else if (this._Number < node.getNumber()){
            return Compare.LEFT;
        }
        return Compare.SAME;
    }


    //
    public int addLeft(Node node){
        this._Left = node;
        this._Left.setLevel(this._Level++);

        return this._Left.getLevel();
    }

    public int addRight(Node node){
        this._Right = node;
        this._Right.setLevel(this._Level++);

        return this._Right.getLevel();
    }

    ////////////////// modify Level/////////////////////////

}
