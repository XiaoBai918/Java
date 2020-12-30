package ʵѵ��ҵ;

public class TestSparseMatrix {
	public static void main(String[] args) {
		int[][] chessArr1 = { 
				{ 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 }, 
				{ 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0 },
				{ 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 }, 
				{ 2, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
				{ 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 }, 
				{ 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
				{ 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 }, 
				{ 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
				{ 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 }, 
				{ 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
				{ 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
				{ 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
				{ 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
				{ 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
				{ 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
				{ 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
				{ 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
				{ 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
				{ 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
				{ 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
				{ 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
				{ 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
				{ 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 } };
		CompressSparseMatrix csm = Compress(chessArr1);
		System.out.println("ѹ����____________________");
		System.out.println("ϡ�������������" + csm.rows);
		System.out.println("ϡ�������������" + csm.cols);
		System.out.println("ϡ���������Ԫ����" + csm.terms);
		for (Node node : csm.datas) {
			System.out.printf("%-3d%-3d%-3d\n", node.getI(), node.getJ(), node.getV());
		}
		System.out.println("��ԭϡ������____________________");
		int[][] chessArr2=upzipSparmatrix(csm);
		for(int[] row:chessArr2){
			for(int x:row){
				System.out.printf("%-3d",x);
			}
			System.out.println();
		}
				
	}

	// ��ϡ�����ѹ���洢
	public static CompressSparseMatrix Compress(int[][] sparseArr) {
		CompressSparseMatrix csm = new CompressSparseMatrix(getTerms(sparseArr));
		csm.rows = sparseArr.length;
		csm.cols = sparseArr[0].length;
		// �ҳ�ÿ������Ԫ������ֲ���Ϣ�洢��datas
		int index = 0; // �����ʼ˳���Ϊ0
		for (int i = 0; i < csm.rows; i++) {
			for (int j = 0; j < csm.cols; j++) {
				if (sparseArr[i][j] != 0) {
					Node node = new Node(i, j, sparseArr[i][j]);
					csm.datas[index] = node;
					index++;
				}
				if (index >= csm.terms) // ��ǰ����
					break;
			}
		}
		return csm;
	}

	// ��ϡ������ķ���Ԫ�ĸ���
	public static int getTerms(int[][] sparseArr) {
		int terms = 0; // ��ʼ������Ԫ�ĸ���Ϊ0
		for (int i = 0; i < sparseArr.length; i++) {
			for (int j = 0; j < sparseArr[0].length; j++) {
				if (sparseArr[i][j] != 0) {
					terms++;
				}
			}
		}
		return terms;
	}

	// ��ѹ����ϡ�����ԭ�ɶ�ά����
	public static int[][] upzipSparmatrix(CompressSparseMatrix csm) {
		int[][] arr = new int[csm.rows][csm.cols];
		for (Node node : csm.datas) {
			// ����ÿ���ڵ㱣��ķ���Ԫ�����кż�ֵ��������Ԫֵ �ָ�����ά�����Ӧ������λ��
			arr[node.getI()][node.getJ()] = node.getV();
		}
		return arr;

	}

}

