package ʵѵ��ҵ;

public class ArrayBinaryTreeDemo {
	public static void main(String[] args) {
		Character[] cs ={'a','b','c','d','e','f','g','h','i','j','k'};
		ArrayBinaryTree<Character> bt  =new ArrayBinaryTree<>(cs);
		System.out.println("ǰ�����~~");
		bt.preOrder(0);//a bdhiejk cfg
		System.out.println("�������~~");
		bt.infixOrder(0);//hdibjek a fcg 
		System.out.println("�������~~");
		bt.postOrder(0);//hid jke b  fgc a
	}
	

}
