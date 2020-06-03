package con.demo.tree;

import con.demo.tree.node.Node;

import java.util.Random;

public class Tree {


/*
(문) 100만개의 정수형 LIST (중복된 수도 있음, 정렬되 있지 않음)

        다음 메소드를 가지는 클래스 작성
        속도를 감안한 처리 방식 고민
        로우 데이타 보다 가공된 상태 고민

        1. exists (n: Int) => Boolean : 해당 값이  존재 유무
        2. range(-10, 100) : -10 ~ 100사이값 수집 (중복된 값도 모두 수집)
        3. count([3, 90, -10, 20]) : [0, 10, 20, 0] 각 수어진 수의 갯수 수집
        4. take(10) : 최대 값 10개 수집 (중복시 다음값 수집해서 총 10개)
        5. filter("1*") : 10진수 n로 시작하는 수 수집 (1, 100, 1000, -1, -1000 등등)
        6. filter("*3") : 10진수 n로 끝난는 수 수집 (3, 203, 33, -3, -4332320003 등등)
        7. filter("5")  : 10진수 자릿수 수 수집 (10000, -20032, 98033, -43011, ...
*/


    private Node mNode = null;


    /**
     *
     * @param range 난수 생성 범위(-2,147,483,648 ~2,147,483,647) 중 생성됨.
     *
     */
    public Tree(int range) {
        Random generator = new Random();

        for (int i = 0; i < range; i++) {
          //int numb = generator.nextInt(range);
          int numb = generator.nextInt();
          if (Main.DEBUG_MODE){
                System.out.println(String.format("Random index(%d): %d", i, numb));
          }

            if (mNode == null) {
                mNode = new Node(numb);
            }else{
                if (!mNode.isRoot())
                    mNode = mNode.getRoot();
                mNode.addNode(new Node(numb));
            }
        }

        System.out.println("complete");
    }


    /*정렬
     1. root node가 변경될수 있다. 0이 아닌 경우
     2. leaf node들은 언제든 레벨이 바뀔수 있다. & 부모와 자식도 바뀔수 있다.
     */
}
