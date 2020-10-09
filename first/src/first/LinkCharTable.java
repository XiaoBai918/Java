package first;

public class LinkCharTable {
    private LinkCharNode head = null;
    private int counts = 0;
    public LinkCharNode getHead(){
        return head;
    }
    public void insert(char d){
        if(head == null){
            head = new LinkCharNode();
        }  
        LinkCharNode n = new LinkCharNode();//�����µ������㣬�������ݸ����½��
        n.setData(d);
        if(head.getNext() == null){		//���ͷ���ĺ���޽�㣬ע��ͷ�����������
            head.setNext(n);
        }
        else{
            n.setNext(head.getNext());  	//���ͷ���ĺ�̽�����
            head.setNext(n);
        }
        counts ++;                  	//�����������
    } public void delete(char d){
        if(head == null){
            System.out.println("������������!");
            return;
        }
        LinkCharNode p = head;
        LinkCharNode n = head.getNext();
        while(n != null){
            if(n.getData() == d){
                p.setNext(n.getNext());
            }
            p = n;
            n = n.getNext();
        }
    }
    
    public void print(){
        LinkCharNode n = head.getNext();
        int iCounter = 1;              //������ַ�����
        while(n != null){
            System.out.print(n.getData() + " ");
            n = n.getNext();
            iCounter ++;
        }
        System.out.println();
    }
    public int size(){
        return this.counts;
    }
}
