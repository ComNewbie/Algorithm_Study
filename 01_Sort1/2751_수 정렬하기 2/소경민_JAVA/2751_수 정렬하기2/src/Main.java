import java.util.Scanner;
public class Main {
	
	private static void mergeSort(int[] arr) { //�������� ����Լ� ȣ��
		int temp[] = new int[arr.length];
		mergeSort(arr,temp,0,arr.length-1);
	}
	private static void mergeSort(int[] arr,int[] temp,int start,int end) {
		if (start<end) { 
			int mid = (start+end)/2;
			mergeSort(arr,temp,start,mid); //�߰��� �������� ����� ���� ��������
			mergeSort(arr,temp,mid+1,end); //�߰��� �������� ����� ���� ��������
			merge(arr,temp,start,mid,end); //���� �Լ��� ���� �� �κ��� ����			
		}
	}
	private static void merge(int[] arr,int[] temp, int start,int mid,int end) {
		for (int i =start;i<=end;i++) {
			temp[i]=arr[i];
		}
		int part1 = start; //���� ������
		int part2 = mid+1; //���� ������
		int index = start;
		while (part1 <= mid && part2 <= end) { //������ ��� ������ �� �� ���� �ݺ�
			if (temp[part1] <= temp[part2]) { //������ ������ ������ �������� �ӽð����� ������ �� ��ĭ�ڷ� �̵�
				arr[index] = temp[part1];
				part1++;
			}
			else { //������ ������ ������ �������� �ӽð����� ������ �� ��ĭ�ڷ� �̵�
				arr[index] = temp[part2];
				part2++;
			}
			index++; //�ӽð����� ����Ǹ� 1 ����
		}
		for (int i=0;i <= mid-part1;i++) { //���ʿ� ���� ���������� �ӽð����� �ڿ� ���̱�
			arr[index+i] = temp[part1+i];
		}
	}
	public static void main(String[] args) {
		Scanner a = new Scanner(System.in);
		
		int N = a.nextInt();
		int arr[]= new int[N];
		
		for (int i=0;i<arr.length;i++) {
			arr[i]=a.nextInt();
		}
		
		mergeSort(arr);
		
		for(int data : arr) {
			System.out.println(data);
		}
		
		a.close();
	}

}
