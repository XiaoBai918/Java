
public class GenericMethodTest {
	public static < E > void printArray( E[] inputArray) {
		for( E element : inputArray ){
			System.out.printf("%s",element);
			
		}
		System.out.println();
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Integer[] intArray = { 1 , 2 , 3 , 4 , 5 };
		Double[] doubleArray = { 1.1 , 2.2 , 3.3 , 4.4 };
		Character[] charArray = { 'H', 'E', 'L' , 'L', 'O' };
		
		System.out.println("��������Ԫ��Ϊ��");
		printArray( intArray );
		
		System.out.println("\n˫������������Ԫ��Ϊ��");
		printArray( doubleArray );
		
		System.out.println("\n�ַ�������Ԫ��Ϊ��");
		printArray( charArray );

	}

}
