import java.util.Scanner;
public class Main {
	private static void quickSort(int[] arr) { //����Լ� ȣ��
		quickSort(arr,0,arr.length-1);
	}

	private static void quickSort(int[] arr,int start ,int end) {
		int part2 = partition(arr,start,end);
		if (start<part2-1){ //���� �κ� ������
			quickSort(arr,start,part2 -1);
		}
		if (part2<end) { //������ �κ� ����
			quickSort(arr,part2,end);
		}
	}
	private static int partition(int[] arr,int start, int end) { //partition ������ �Լ�
		int pivot = arr[(start+end)/2]; //���۰� ���� �߰� ���� ���ذ����� ���� 
		while (start<=end) { //�������� �������� �۰ų� ���� ���� 
			while (arr[start]<pivot) { //�������� ���� ���ذ����� ������ �������� ���������� �̵�
				start++;
			}
			while (arr[end]>pivot) { //������ ���� ���ذ����� ũ�� ������ �������� �̵�
				end--;
			}
			if (start <= end) { //�������� ������ �����ǰų� ������ �ʾ����� swap
				swap (arr,start,end);
				start++;
				end--;
			}
		}
		return start;
	}
	private static void swap(int[] arr,int start, int end) {
		int temp = arr[start];
		arr[start]=arr[end];
		arr[end]=temp;
	}
	public static void main(String[] args) {
		Scanner a= new Scanner(System.in);
		
		int N =a.nextInt();
		int arr[]= new int[N];
		
		for (int i=0;i<N;i++) {
			arr[i]= a.nextInt();
		}
		
		quickSort(arr);
		
		for(int i=0;i<N;i++) {
			System.out.println(arr[i]);
		}
		a.close();
	}

}
