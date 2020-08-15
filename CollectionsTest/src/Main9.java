/*
 * CollectionsһЩ�����Ĳ���
 */

import java.util.ArrayList;
import java.util.Collections;

public class Main9 {

	public static void main(String[] args) {
		test1();
		System.out.println();
		test2();
	}
	
	public static void test1() {
		ArrayList<Integer> arrayList = new ArrayList<Integer>();
		arrayList.add(-1);
		arrayList.add(3);
		arrayList.add(3);
		arrayList.add(-5);
		arrayList.add(7);
		arrayList.add(4);
		arrayList.add(-9);
		arrayList.add(-7);
		System.out.println("ԭʼ����:");
		System.out.println(arrayList);

		Collections.reverse(arrayList);
		System.out.println("Collections.reverse(arrayList):");
		System.out.println(arrayList);

		// ��distanceΪ����ʱ����list��distance��Ԫ�������Ƶ�ǰ�档��distanceΪ����ʱ���� list��ǰdistance��Ԫ�������Ƶ����档
		Collections.rotate(arrayList, 4);
		System.out.println("Collections.rotate(arrayList, 4):");
		System.out.println(arrayList);

		// void sort(List list),����Ȼ�������������
		Collections.sort(arrayList);
		System.out.println("Collections.sort(arrayList):");
		System.out.println(arrayList);

		// void sort(List list, Comparator c),����Ȼ����Ľ�������
		Collections.sort(arrayList, (o1,o2)->o2-o1);	// lambda���ʽ
		System.out.println("Collections.sort(arrayList, (o1, o2)->o2-o1):");
		System.out.println(arrayList);
				
		// void shuffle(List list),�������
		Collections.shuffle(arrayList);
		System.out.println("Collections.shuffle(arrayList):");
		System.out.println(arrayList);

		// void swap(List list, int i , int j),������������λ�õ�Ԫ��
		Collections.swap(arrayList, 2, 5);
		System.out.println("Collections.swap(arrayList, 2, 5):");
		System.out.println(arrayList);
	}
	
	public static void test2() {
		ArrayList<Integer> arrayList = new ArrayList<Integer>();
		arrayList.add(-1);
		arrayList.add(3);
		arrayList.add(3);
		arrayList.add(-5);
		arrayList.add(7);
		arrayList.add(4);
		arrayList.add(-9);
		arrayList.add(-7);
		ArrayList<Integer> arrayList2 = new ArrayList<Integer>();
		arrayList2.add(-3);
		arrayList2.add(-5);
		arrayList2.add(7);
		System.out.println("ԭʼList:");
		System.out.println(arrayList);
		
		System.out.println("Listת����");
		print(arrayList.toArray(new Integer[0]));

		System.out.println("Collections.max(arrayList):");
		System.out.println(Collections.max(arrayList));

		System.out.println("Collections.min(arrayList):");
		System.out.println(Collections.min(arrayList));

		System.out.println("Collections.replaceAll(arrayList, 3, -3):");
		Collections.replaceAll(arrayList, 3, -3);
		System.out.println(arrayList);

		System.out.println("Collections.frequency(arrayList, -3):");
		System.out.println(Collections.frequency(arrayList, -3));

		System.out.println("Collections.indexOfSubList(arrayList, arrayList2):");
		System.out.println(Collections.indexOfSubList(arrayList, arrayList2));

		System.out.println("Collections.binarySearch(arrayList, 7):");
		// ��List���ж��ֲ��ң�����������List�����������
		Collections.sort(arrayList);
		System.out.println("���������:");
		System.out.println(arrayList);
		System.out.println(Collections.binarySearch(arrayList, 7));
	}
	
	public static void print(Integer[] arr) {
		if(arr == null || arr.length == 0) return;
		int len = arr.length;
		for(int i=0;i<len-1;i++) {
			System.out.print(arr[i]+",");
		}
		System.out.println(arr[len-1]);
	}
}
