package ������������;

public class ThreadedBinaryTreeDemo {

	public static void main(String[] args) {
		HeroNode root = new HeroNode(1, "Tom");
		HeroNode node2 = new HeroNode(3, "Jack");
		HeroNode node3 = new HeroNode(6, "Smith");
		HeroNode node4 = new HeroNode(8, "Mary");
		HeroNode node5 = new HeroNode(10, "King");
		HeroNode node6 = new HeroNode(14, "dim");
		root.setLeft(node2);
		root.setRight(node3);
		node2.setLeft(node4);
		node2.setRight(node5);
		node3.setLeft(node6);
		ThreadedBinaryTree threadBinaryTree = new ThreadedBinaryTree();
		threadBinaryTree.setRoot(root);
		threadBinaryTree.ThreadedBinaryTree();
	
	//	System.out.print("ǰ�����:");
	//	threadBinaryTree.preOrder();
		System.out.println("5�Žڵ��ǰ���ڵ㣺"+node5.getLeft());
		System.out.println("5�Žڵ�ĺ�̽ڵ㣺"+node5.getRight());
		
		System.out.println("ʹ���������ķ�ʽ������");
		threadBinaryTree.ThreadedList();
	}

}
//������

class ThreadedBinaryTree {
	private HeroNode root;
	// Ϊ��ʵ������������Ҫ����һ����ǰ�ڵ��preָ��
	// �ڵݹ�ʱ���Ǳ���pre
	private HeroNode pre;

	public void setRoot(HeroNode root) {
		this.root = root;
	}
	public void ThreadedBinaryTree() {
		this.Threaded(root);
	}
	//������������Ķ�����
	public void ThreadedList() {
		HeroNode node = root;
		while(node!=null) {
			//ѭ���ҵ�leftType==1�Ľڵ�
			while(node.getLeftType()==0) {
				node = node.getLeft();
			}
			System.out.println(node);
			//�����ǰ�ڵ����ָ��һֱ�Ǻ�̽ڵ��һֱ���
			while(node.getRightType()==1) {
				node = node.getRight();
				System.out.println(node);
			}
			//�滻�����Ľڵ�
			node = node.getRight();
		}
	}
	// ��������ǰ�ڵ�
	public void Threaded(HeroNode node) {
		if (node == null) {
			return;
		}
		// ������������
		Threaded(node.getLeft());
		// �ýڵ�������
		// ���node����ָ��Ϊ��
		if (node.getLeft() == null) {
			// ��node����ָ��ָ��ǰ���ڵ�pre����ʱpreΪ��
			node.setLeft(pre);
			// ��node��leftType��Ϊ1��ʾ����ָ��ָ��ǰ���ڵ�
			node.setLeftType(1);
		}
		if (pre != null && pre.getRight() == null) {
			//��ʱ��preָ��node��ǰһ������ͨ��pre�����nodeǰһ��������ָ������
			pre.setRight(node);
			pre.setRightType(1);
		}
		//ÿ����һ���ڵ���õ�ǰ�ڵ�ָ����һ���ڵ�
		pre=node;
		// ������������
		Threaded(node.getRight());
	}

	// ǰ�����
	public void preOrder() {
		if (this.root != null) {
			this.root.preOrder();
		} else {
			System.out.println("������Ϊ��");
		}
	}

	// �������
	public void infixOrder() {
		if (this.root != null) {
			this.root.infixOrderr();
		} else {
			System.out.println("������Ϊ��");
		}
	}

	// �������
	public void postOrder() {
		if (this.root != null) {
			this.root.postOrder();
		} else {
			System.out.println("������Ϊ��");
		}
	}

	// ǰ���������
	public HeroNode preOrderSearch(int no) {
		if (root != null) {
			return root.preOrderSearch(no);
		} else {
			return null;
		}
	}

	// �����������
	public HeroNode infixOrderSearch(int no) {
		if (root != null) {
			return root.infixOrderSearch(no);
		} else {
			return null;
		}
	}

	// �����������
	public HeroNode postOrderSearch(int no) {
		if (root != null) {
			return root.postOrderSearch(no);
		} else {
			return null;
		}
	}

	// ɾ���ڵ�
	public void deleteNode(int no) {
		// �ж�root�Ƿ�Ϊ��
		if (root != null) {
			// �ж�root�Ƿ�ΪҪɾ���Ľڵ㣬��Ϊ֮��Ͳ��������root��
			if (root.getNo() == no) {
				root = null;
			} else {
				root.deleteNode(no);
			}
		} else {
			System.out.println("�ö�����Ϊ�գ���");
		}
	}

}

//�����ڵ�
class HeroNode {
	private int no;
	private String name;
	private HeroNode left;
	private HeroNode right;
	// leftType==0,��ʾָ��������������1����ָ��ǰȥ�ڵ�
	// rightType == 0,��ʾָ��������������1�����ָ���̽ڵ�
	private int leftType;
	private int rightType;

	public HeroNode(int no, String name) {
		super();
		this.no = no;
		this.name = name;
	}

	public int getLeftType() {
		return leftType;
	}

	public void setLeftType(int leftType) {
		this.leftType = leftType;
	}

	public int getRightType() {
		return rightType;
	}

	public void setRightType(int rightType) {
		this.rightType = rightType;
	}

	public int getNo() {
		return no;
	}

	public void setNo(int no) {
		this.no = no;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public HeroNode getLeft() {
		return left;
	}

	public void setLeft(HeroNode left) {
		this.left = left;
	}

	public HeroNode getRight() {
		return right;
	}

	public void setRight(HeroNode right) {
		this.right = right;
	}

	@Override
	public String toString() {
		return "HeroNode [no=" + no + ", name=" + name + "]";
	}

	// ǰ�����
	public void preOrder() {
		System.out.println(this);// ��������ڵ�
		if (this.left != null) {
			this.left.preOrder();
		}
		if (this.right != null) {
			this.right.preOrder();
		}
	}

	// �������
	public void infixOrderr() {
		if (this.left != null) {
			this.left.infixOrderr();
		}
		System.out.println(this);// ������ڵ�
		if (this.right != null) {
			this.right.infixOrderr();
		}
	}

	// �������
	public void postOrder() {
		if (this.left != null) {
			this.left.postOrder();
		}
		if (this.right != null) {
			this.right.postOrder();
		}
		System.out.println(this);
	}

	// ǰ������Ĳ���
	@SuppressWarnings("unused")
	public HeroNode preOrderSearch(int no) {
		System.out.println("����ǰ���������");
		if (this.no == no) {
			return this;
		}
		HeroNode resNode = null;
		// �жϸýڵ�����ӽڵ��Ƿ�Ϊ�գ������Ϊ�գ���������еݹ����
		if (this.left != null) {
			resNode = this.left.preOrderSearch(no);
		}
		if (resNode != null) {// ˵���������Ѿ��ҵ�
			return resNode;
		}
		// ���ҽ���ǰ��ݹ����
		if (this.right != null) {
			resNode = this.right.preOrderSearch(no);
		}
		return resNode;
	}

	// �����������
	@SuppressWarnings("null")
	public HeroNode infixOrderSearch(int no) {

		HeroNode resNode = null;
		if (this.left != null) {// �жϵ�ǰ�ڵ�����ӽڵ��Ƿ�Ϊ�գ���Ϊ�գ�������ݹ�
			resNode = this.left.infixOrderSearch(no);
		}
		if (resNode != null) {
			return resNode;
		}
		System.out.println("����������ҡ���");
		// �Ƚϵ�ǰ�ڵ�
		if (this.no == no) {
			return this;
		}
		if (this.right != null) {
			resNode.right.infixOrderr();
		}
		return resNode;
	}

	// �����������
	public HeroNode postOrderSearch(int no) {

		HeroNode resNode = null;
		if (this.left != null) {
			resNode = this.left.postOrderSearch(no);
		}
		if (resNode != null) {// ����ݹ��ҵ�
			return resNode;
		}
		// ���������ݹ���������������
		if (this.right != null) {
			resNode = this.right.postOrderSearch(no);
		}
		if (resNode != null) {// ���ҵݹ��ҵ�
			return resNode;
		}
		// �������������û���ҵ������жϵ�ǰ�ڵ�
		System.out.println("���������ҡ���");
		if (this.no == no) {
			return this;
		}
		return resNode;
	}

	// �ݹ�ɾ��ָ���ڵ�
	// ˼·
	/*
	 * 1. ��Ϊ���ǵĶ������ǵ���ģ������������жϵ�ǰ�����ӽ���Ƿ���Ҫɾ����㣬������ȥ�жϵ�ǰ�������ǲ�����Ҫɾ�����.
	 * 2.�����ǰ�������ӽ�㲻Ϊ�գ��������ӽ�� ����Ҫɾ����㣬�ͽ�this.left = null; ���Ҿͷ���(�����ݹ�ɾ��)
	 * 3.�����ǰ�������ӽ�㲻Ϊ�գ��������ӽ�� ����Ҫɾ����㣬�ͽ�this.right= null ;���Ҿͷ���(�����ݹ�ɾ��)
	 * 4.�����2�͵�3��û��ɾ����㣬��ô���Ǿ���Ҫ�����������еݹ�ɾ�� 5. �����4��Ҳû��ɾ����㣬��Ӧ�������������еݹ�ɾ��.
	 * 
	 */
	public void deleteNode(int no) {
		// �����ǰ�������ӽ�㲻Ϊ�գ��������ӽ�� ����Ҫɾ����㣬�ͽ�this.left = null; ���Ҿͷ���(�����ݹ�ɾ��)
		if (this.left != null && this.left.no == no) {
			this.left = null;
			return;
		}
		// �����ǰ�������ӽ�㲻Ϊ�գ��������ӽ�� ����Ҫɾ����㣬�ͽ�this.right= null ;���Ҿͷ���(�����ݹ�ɾ��)
		if (this.right != null && this.right.no == no) {
			this.right = null;
			return;
		}
		// �����������еݹ�ɾ��
		if (this.left != null) {
			this.left.deleteNode(no);
		}
		// �����������еݹ�ɾ��
		if (this.right != null) {
			this.right.deleteNode(no);
		}
	}
}
