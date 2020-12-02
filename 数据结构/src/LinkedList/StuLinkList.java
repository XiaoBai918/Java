package LinkedList;
//ͷ
public class StuLinkList {
private StuNode head;
public StuLinkList(StuNode head) {
	super();
	this.head = head;
}

public void addAtHead(StuNode node) {//ͷ�巨
	node.next=head.next;
	head.next=node;	
}


public void addAtEnd(StuNode node) {//β�巨
	StuNode p=head;
	while(p.next!=null) {
		p=p.next;//ָ�����һ
	}
	node.next=null;p.next=node;
}

public void insertAfter(StuNode p,StuNode s) {//�����
	s.setNext(p.getNext());
	p.setNext(s);
}

public void insert(StuNode p,StuNode s) {//ǰ����
	if(head==null)return;
	StuNode q=head;
	while(q.getNext()!=null) {
		if(q.getNext()==p) {
			q.setNext(s);
			s.setNext(p);
			break;
		}
		q=q.getNext();
	}
}

public void showDatas() {
	StuNode p=head.next;
	if(p==null) {
		System.out.println(head.data);
	}
	while(p!=null) {
		System.out.println(p.data);
		p=p.next;//ָ������
	}
}



}
