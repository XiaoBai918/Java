package com.bean.sortedbinarytreedemo;
import java.util.Iterator;
import java.util.NoSuchElementException;
 class TreeNode<E> {

    E element;  
    TreeNode<E> parent;  
    TreeNode<E> leftChild;  
    TreeNode<E> rightChild;  


    public TreeNode(E element, TreeNode<E> parent) {  
        this.element = element;  
        this.parent = parent;
    
    }  

    public TreeNode() {  
    }

    public E getElement() {
        return element;
    }

    public void setElement(E element) {
        this.element = element;
    }

    public TreeNode<E> getParent() {
        return parent;
    }

    public void setParent(TreeNode<E> parent) {
        this.parent = parent;
    }

    public TreeNode<E> getLeftChild() {
        return leftChild;
    }

    public void setLeftChild(TreeNode<E> leftChild) {
        this.leftChild = leftChild;
    }

    public TreeNode<E> getRightChild() {
        return rightChild;
    }

    public void setRightChild(TreeNode<E> rightChild) {
        this.rightChild = rightChild;
    }  


}

public class BinarySortTree<E> {
    // ���ڵ�  
    private TreeNode<E> root = null;  
    // ����Ԫ�ظ���  
    private int size = 0;  
    //�չ��췽��
    public BinarySortTree() {  

    }  
    //ͳ�ƶ������еĽڵ���
    public int countSize() {  
        return size;  
    }  
    //��ýڵ�Ԫ�ص�ֵ
    public E getRoot() {  
        return root == null ? null : root.element;  
    }  

    /** 
     * �ݹ�ʵ��: ����ָ��Ԫ��element�Ƿ������д��ڣ��������ʧ��ȷ������ӵ�λ��,���ҳɹ�ֱ�ӷ��� 
     * @param t ��ʾ�Ӵ˽ڵ㿪ʼ���²��� 
     * @param f ����t�ĸ��ڵ� 
     * @param p �����ҳɹ�pָ�������Ԫ�ؽڵ㣬���򷵻ز���·���ϵ����һ���ڵ� 
     */  
    private boolean searchBST(TreeNode<E> t, Object element, TreeNode<E> f, TreeNode<E> p) {  
        if (t == null) {  
            p = f;  
            return false;  
        }  
        Comparable<? super E> e = (Comparable<? super E>) element;  
        int cmp = e.compareTo(t.element);  
        if (cmp < 0) {  
            return searchBST(t.leftChild, element, t, p);  
        } else if (cmp > 0) {  
            return searchBST(t.rightChild, element, t, p);  
        } else {  
            p = t;  
            return true;  
        }  
    }  

    /** 
     * �ǵݹ�ʵ�� 
     */  
    private boolean searchBST(Object element, TreeNode<E>[] p) {  
        Comparable<? super E> e = (Comparable<? super E>) element;  
        TreeNode<E> parent = root;  
        TreeNode<E> pp = null;  
        // ����parent���ڵ�  
        while (parent != null) {  
            int cmp = e.compareTo(parent.element);  
            pp = parent;  
            if (cmp < 0) {  
                parent = parent.leftChild;  
            } else if (cmp > 0) {  
                parent = parent.rightChild;  
            } else {  
                p[0] = parent;  
                return true;  
            }  
        }  
        p[0] = pp;  
        return false;  
    }  

    /** 
     * ���Ȳ��Ҷ���������������Ҳ���ָ��Ԫ�� ����뵽�������� 
     */  
    public boolean add(E element) {  
        TreeNode<E> t = root;  
        if (t == null) {  
            // ������ڵ�Ϊ��  
            root = new TreeNode<E>(element, null);  
            size = 1;  
            return false;  
        }  
        Comparable<? super E> e = (Comparable<? super E>) element;  
        TreeNode[] p = new TreeNode[1];  
        if (!searchBST(element, p)) {  
            // ����ʧ�ܣ�����Ԫ��  
            TreeNode<E> s = new TreeNode<E>(element, p[0]);  
            int cmp = e.compareTo((E) p[0].element);  
            if (cmp < 0) {  
                p[0].leftChild = s;  
            }  
            if (cmp > 0) {  
                p[0].rightChild = s;  
            }  
            size++;  
            return true;  
        }  
        return false;  
    }  

    /** 
     * �Ƴ��ڵ㣬ͬʱ����������ʹ֮Ϊ���������� ʵ��ԭ��  
     * ����Ҫɾ���Ľڵ�Ϊp���丸�ڵ�Ϊf����p��f����ڵ� �������������: 
     * 1.��pΪҶ�ӽڵ㣬ֱ��ɾ��  
     * 2.��p��ֻ��һ�����ӻ���һ���Һ��ӣ���ɾ��p��ʹPL����PRΪf�������� 
     * 3.��p��������������Ϊ�գ��ɶ������������ص��֪��ɾ��pǰ����������˶����� 
     * ���Եõ�һ���������У���ɾȥp��Ϊ�˱�������Ԫ�ص����λ�ò��䣬������������ 
     * ��p��ֱ��ǰ��(��ֱ�Ӻ��)���p��Ȼ��ɾ����ֱ��ǰ����ֱ�Ӻ�̡���ֱ��ǰ������ ����������ص��� 
     */  
    public boolean remove(Object o) {  
        TreeNode<E>[] p = new TreeNode[1];  
        if (searchBST(o, p)) {  
            deleteTreeNode(p[0]); // ���ҳɹ���ɾ��Ԫ��  
            return true;  
        }  
        return false;  
    }  

    private void deleteTreeNode(TreeNode<E> p) {  
        size--;  
        if (p.leftChild != null && p.rightChild != null) { // ���p������������Ϊ�գ��ҵ���ֱ�Ӻ�̣��滻p  
            TreeNode<E> s = successor(p);  
            p.element = s.element;  
            p = s;  
        }  
        TreeNode<E> replacement = (p.leftChild != null ? p.leftChild : p.rightChild);  

        if (replacement != null) { // �����������������һ��Ϊ��  
            replacement.parent = p.parent;  
            if (p.parent == null) // ���pΪroot�ڵ�  
                root = replacement;  
            else if (p == p.parent.leftChild) // ���p������  
                p.parent.leftChild = replacement;  
            else  
                p.parent.rightChild = replacement; // ���p���Һ���  

            p.leftChild = p.rightChild = p.parent = null; // p��ָ�����  

        } else if (p.parent == null) { // ���ȫ��ֻ��һ���ڵ�  
            root = null;  
        } else { // ����������Ϊ��,pΪҶ�ӽڵ�  
            if (p.parent != null) {  
                if (p == p.parent.leftChild)  
                    p.parent.leftChild = null;  
                else if (p == p.parent.rightChild)  
                    p.parent.rightChild = null;  
                p.parent = null;  
            }  
        }  

    }  

    /** 
     * ���������������ʽ������ʱ��t��ֱ�Ӻ�� 
     */  
    static <E> TreeNode<E> successor(TreeNode<E> t) {  
        if (t == null)  
            return null;  
        else if (t.rightChild != null) {  
            TreeNode<E> p = t.rightChild; // ���ң�Ȼ������ֱ����ͷ  
            while (p.leftChild != null)  
                p = p.leftChild;  
            return p;  
        } else { // rightChildΪ�գ����t��p������������pΪt��ֱ�Ӻ��  
            TreeNode<E> p = t.parent;  
            TreeNode<E> ch = t;  
            while (p != null && ch == p.rightChild) {  
                ch = p; // ���t��p�������������������������ֱ�Ӻ��  
                p = p.parent;  
            }  
            return p;  
        }  
    }  

    public Iterator<E> itrator() {  
        return new BinarySortIterator();  
    }  

    /** 
     * ����������������ĵ����� 
     */  
    private class BinarySortIterator implements Iterator<E> {  
        TreeNode<E> next;  
        TreeNode<E> lastReturned;  

        public BinarySortIterator() {  
            TreeNode<E> s = root;  
            if (s != null) {  
                while (s.leftChild != null) {  
                    s = s.leftChild; // �ҵ���������ĵ�һ��Ԫ��  
                }  
            }  
            next = s; // ����next  
        }  

        @Override  
        public boolean hasNext() {  
            return next != null;  
        }  

        @Override  
        public E next() {  
            TreeNode<E> e = next;  
            if (e == null)  
                throw new NoSuchElementException();  
            next = successor(e);  
            lastReturned = e;  
            return e.element;  
        }  

        @Override  
        public void remove() {  
            if (lastReturned == null)  
                throw new IllegalStateException();  
            if (lastReturned.leftChild != null && lastReturned.rightChild != null)  
                next = lastReturned;  
            deleteTreeNode(lastReturned);  
            lastReturned = null;  
        }  
    }  


    // ���Դ���
    public static void main(String[] args) {  
        BinarySortTree<Integer> tree = new BinarySortTree<Integer>();  
       // tree.add(62);  
        //tree.add(15);  
       // tree.add(68);  
        //tree.add(12);  
        tree.add(13); 
        tree.add(2);  
        tree.add(18);
        tree.add(29);
        tree.add(4);  
        tree.add(6);  
        tree.add(79);   
    

        System.out.println("root=" + tree.getRoot());  
        System.out.println("�����������������");
        Iterator<Integer> it = tree.itrator();  
        while (it.hasNext()) {  
            System.out.print(it.next()+"\t");  
        }  
        System.out.println();
        System.out.println(tree.countSize()); 
        System.out.println("����һ���ڵ� 68");
        tree.add(68);
        System.out.println("root=" + tree.getRoot());  
        System.out.println("�����������������");
        Iterator<Integer> it2 = tree.itrator();  
        while (it2.hasNext()) {  
            System.out.print(it2.next()+"\t");  
        }  
        System.out.println();
        System.out.println(tree.countSize());  
        System.out.println("ɾ��18");
        tree.remove(18);
        System.out.println("root=" + tree.getRoot());  
        System.out.println("�����������������");
        Iterator<Integer> it3 = tree.itrator();  
        while (it3.hasNext()) {  
            System.out.print(it3.next()+"\t");  
        }  
        System.out.println();
        System.out.println(tree.countSize()); 
//        tree.remove(18);
     //   tree.remove(65);
      //  tree.remove(68);
     //   tree.remove(79);
    //    System.out.println("root=" + tree.getRoot());  
     //   System.out.println("�����������������");
     //   Iterator<Integer> it4 = tree.itrator();  
      //  while (it4.hasNext()) {  
        //    System.out.print(it4.next()+"\t");  
     //   }  
    //    System.out.println();
    //    System.out.println(tree.countSize()); 
    }  

}