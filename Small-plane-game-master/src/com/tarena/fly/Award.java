package com.tarena.fly;
/**
 * ����
 */
public interface Award {
	//������ȫ��д
	int DOUBLE_FIRE = 0;  //˫������
	int LIFE = 1;   //1����
	/** ��ý�������(�����0��1) */
	int getType();
}
