/*
 * Arrays.sort()�����У�ʹ�ñȽ��������鰴Ҫ���������
 */

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

// �Ƚ������Ƚ��ַ����ĳ���
class LengthComparator implements Comparator<String> {
	public int compare(String str1, String str2) {
		return str1.length()-str2.length();
	}
}

//�Ƚ������Ƚ��ַ����ĳ���
class NumComparator implements Comparator<Integer> {
	public int compare(Integer o1, Integer o2) {
		return o2-o1;
	}
}

public class Main8 {
	public static void main(String[] args) {
		sortTest();
		searchTest();
		equalsTest();
		fillTest();
		asListTest();
		copyOfTest();
	}
	
	public static void sortTest() {
		String[] arr1 = new String[] {"asd21as","DFSA","saqWE2"};
		print(arr1);
		
		// ���ַ������ȶ�arr1�����������򡪡�����1
		Arrays.sort(arr1, new LengthComparator());
		print(arr1);
		
		// ���ַ������ȶ�arr1�����������򡪡�����2��Lambda���ʽ
		Arrays.sort(arr1, (s1, s2)->s1.length()-s2.length());
		print(arr1);

		// sort(int[] a,int fromIndex,int toIndex)���������������ָ����Χ
		Integer b[] = { 1, 3, 2, 7, 6, 5, 4, 9 };
		print(b);
		Arrays.sort(b, 2, 6, new NumComparator());	// index��2��5
		print(b);
		
		// ʹ��lambda���ʽ
		Integer c[] = { 1, 3, 2, 7, 6, 5, 4, 9 };	// ע�����������Integer
		print(c);
		Arrays.sort(c, 2, 6, (o1, o2)->(o2-o1));	// index��2��5
		print(c);

	}
	
	public static void searchTest() {
		// *************���� binarySearch()****************
		char[] e = { 'a', 'f', 'b', 'c', 'e', 'A', 'C', 'B' };
		// ������ٽ��ж��ֲ��ң������Ҳ���
		Arrays.sort(e);
		System.out.println("Arrays.sort(e)" + Arrays.toString(e));
		System.out.println("Arrays.binarySearch(e, 'c')��");
		int s = Arrays.binarySearch(e, 'c');
		System.out.println("�ַ�c�������λ�ã�" + s);
	}
	
	public static void equalsTest() {
		// *************�Ƚ� equals****************
		char[] e = { 'a', 'f', 'b', 'c', 'e', 'A', 'C', 'B' };
		char[] f = { 'a', 'f', 'b', 'c', 'e', 'A', 'C', 'B' };
		/*
		* *Ԫ��������ͬ��������ͬλ�õ�Ԫ����ͬ�� ���⣬��������������ö���null�������Ǳ���Ϊ����ȵ� ��
		*/
		System.out.println("Arrays.equals(e, f):" + Arrays.equals(e, f));
	}
	
	public static void fillTest() {
		// *************���fill(������ʼ��)****************
		int[] g = { 1, 2, 3, 3, 3, 3, 6, 6, 6 };
		// ����������Ԫ�����·���ֵ
		Arrays.fill(g, 3);
		System.out.println("Arrays.fill(g, 3)��");
		// ��������333333333
		print(g);

		int[] h = { 1, 2, 3, 3, 3, 3, 6, 6, 6, };
		// ������ָ����ΧԪ�����·���ֵ
		Arrays.fill(h, 0, 2, 9);
		print(h);
	}
	
	public static void asListTest() {
		// *************ת�б� asList()****************
		int[] arr = new int[] {1,2,3,4,5};
		//�Ƚ�int����ת��Ϊ��ֵ��
		IntStream stream = Arrays.stream(arr);
		//���е�Ԫ��ȫ��װ�䣬ת��Ϊ�� ---->intתΪInteger
		Stream<Integer> integerStream = stream.boxed();
		//����ת��Ϊ����
		Integer[] integers = integerStream.toArray(Integer[]::new);
		List<Integer> res = Arrays.asList(integers);
		System.out.println(res);
		
		// ����2
		List myList = Arrays.stream(arr).boxed().collect(Collectors.toList());
		System.out.println(myList);
	}
	
	public static void copyOfTest() {
		// *************���� copy****************
		// copyOf ����ʵ�����鸴��,hΪ���飬6Ϊ���Ƶĳ���
		int[] h = { 1, 2, 3, 3, 3, 3, 6, 6, 6, };
		int i[] = Arrays.copyOf(h, 6);
		System.out.println("Arrays.copyOf(h, 6);��");
		// ��������123333
		print(i);
		
		// copyOfRange��ָ�������ָ����Χ���Ƶ���������
		int j[] = Arrays.copyOfRange(h, 6, 11);
		System.out.println("Arrays.copyOfRange(h, 6, 11)��");
		// ������66600(h����ֻ��9��Ԫ�������Ǵ�����6������11�������Բ���ľ�Ϊ0)
		print(j);
	}
	public static void print(String[] arr) {
		if(arr == null || arr.length == 0) return;
		int len = arr.length;
		for(int i=0;i<len-1;i++) {
			System.out.print(arr[i]+",");
		}
		System.out.println(arr[len-1]);
	}
	
	public static void print(Integer[] arr) {
		if(arr == null || arr.length == 0) return;
		int len = arr.length;
		for(int i=0;i<len-1;i++) {
			System.out.print(arr[i]+",");
		}
		System.out.println(arr[len-1]);
	}
	
	public static void print(int[] arr) {
		if(arr == null || arr.length == 0) return;
		int len = arr.length;
		for(int i=0;i<len-1;i++) {
			System.out.print(arr[i]+",");
		}
		System.out.println(arr[len-1]);
	}
}


