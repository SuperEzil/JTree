package con.demo.tree;

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


import javax.swing.*;

public class Main {
    public static final boolean DEBUG_MODE = true;

    public static void main(String[] args) {

        System.out.println("Hello World!!");

        Tree tree = new Tree(10);

    }

}


