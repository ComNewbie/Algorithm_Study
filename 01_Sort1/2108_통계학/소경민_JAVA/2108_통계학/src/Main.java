import java.util.Scanner;
import java.util.Arrays;
public class Main {

	public static void main(String[] args) {
		Scanner a = new Scanner(System.in);
		
		int N = Integer.parseInt(a.nextLine());
		int[] num= new int[N];
		int max = Integer.MIN_VALUE; //���� Ƚ��
		int mode=0; //�ֺ�
		int[] index=new int[8001];
		
		for(int i=0;i<N;i++) {
			num[i]=a.nextInt();
		}
		int sum=0; //���� 
		for (int i=0;i<N;i++) {
			sum = num[i]+sum;
		}
		Arrays.sort(num); //num�迭 ���������� ��
		System.out.println((int)Math.round((double)sum/N)); //������
		System.out.println(num[Math.round(N/2)]); //�߾Ӱ�
		
		// �ֺ�
		for(int i=0;i<num.length;i++) {
			index[num[i]+4000]++;
		}
		for(int i=0;i<index.length;i++) {
			if(index[i]>max&&index[i]!=0) {
			mode = i;
			max=index[i]; 
			}
		}
		if(mode==8000) { //�ֺ��� 4000�̸� �״�� ��� �ƴϸ� �ֺ� �� �ι�°�� ���� �� ���
			 System.out.println(mode-4000);
		}
		else {
			for(int j=mode+1;j<index.length;j++) {
	        	if(max==index[j]) {
	            	System.out.println(j-4000);
	            	break;
	        	}
	        	else if(j==index.length-1) {
	            	System.out.println(mode-4000);
	            	break;
	        	}
	    	}
		}
		System.out.println(num[N-1]-num[0]); //����
		a.close();
	}

}
