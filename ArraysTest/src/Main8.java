/*
 * Arrays.sort()函数中，使用比较器对数组按要求进行排序
 */

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

// 比较器，比较字符串的长度
class LengthComparator implements Comparator<String> {
	public int compare(String str1, String str2) {
		return str1.length()-str2.length();
	}
}

//比较器，比较字符串的长度
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
		
		// 按字符串长度对arr1进行升序排序——方法1
		Arrays.sort(arr1, new LengthComparator());
		print(arr1);
		
		// 按字符串长度对arr1进行升序排序——方法2，Lambda表达式
		Arrays.sort(arr1, (s1, s2)->s1.length()-s2.length());
		print(arr1);

		// sort(int[] a,int fromIndex,int toIndex)按升序排列数组的指定范围
		Integer b[] = { 1, 3, 2, 7, 6, 5, 4, 9 };
		print(b);
		Arrays.sort(b, 2, 6, new NumComparator());	// index从2到5
		print(b);
		
		// 使用lambda表达式
		Integer c[] = { 1, 3, 2, 7, 6, 5, 4, 9 };	// 注意这里必须是Integer
		print(c);
		Arrays.sort(c, 2, 6, (o1, o2)->(o2-o1));	// index从2到5
		print(c);

	}
	
	public static void searchTest() {
		// *************查找 binarySearch()****************
		char[] e = { 'a', 'f', 'b', 'c', 'e', 'A', 'C', 'B' };
		// 排序后再进行二分查找，否则找不到
		Arrays.sort(e);
		System.out.println("Arrays.sort(e)" + Arrays.toString(e));
		System.out.println("Arrays.binarySearch(e, 'c')：");
		int s = Arrays.binarySearch(e, 'c');
		System.out.println("字符c在数组的位置：" + s);
	}
	
	public static void equalsTest() {
		// *************比较 equals****************
		char[] e = { 'a', 'f', 'b', 'c', 'e', 'A', 'C', 'B' };
		char[] f = { 'a', 'f', 'b', 'c', 'e', 'A', 'C', 'B' };
		/*
		* *元素数量相同，并且相同位置的元素相同。 另外，如果两个数组引用都是null，则它们被认为是相等的 。
		*/
		System.out.println("Arrays.equals(e, f):" + Arrays.equals(e, f));
	}
	
	public static void fillTest() {
		// *************填充fill(批量初始化)****************
		int[] g = { 1, 2, 3, 3, 3, 3, 6, 6, 6 };
		// 数组中所有元素重新分配值
		Arrays.fill(g, 3);
		System.out.println("Arrays.fill(g, 3)：");
		// 输出结果：333333333
		print(g);

		int[] h = { 1, 2, 3, 3, 3, 3, 6, 6, 6, };
		// 数组中指定范围元素重新分配值
		Arrays.fill(h, 0, 2, 9);
		print(h);
	}
	
	public static void asListTest() {
		// *************转列表 asList()****************
		int[] arr = new int[] {1,2,3,4,5};
		//先将int数组转换为数值流
		IntStream stream = Arrays.stream(arr);
		//流中的元素全部装箱，转换为流 ---->int转为Integer
		Stream<Integer> integerStream = stream.boxed();
		//将流转换为数组
		Integer[] integers = integerStream.toArray(Integer[]::new);
		List<Integer> res = Arrays.asList(integers);
		System.out.println(res);
		
		// 方法2
		List myList = Arrays.stream(arr).boxed().collect(Collectors.toList());
		System.out.println(myList);
	}
	
	public static void copyOfTest() {
		// *************复制 copy****************
		// copyOf 方法实现数组复制,h为数组，6为复制的长度
		int[] h = { 1, 2, 3, 3, 3, 3, 6, 6, 6, };
		int i[] = Arrays.copyOf(h, 6);
		System.out.println("Arrays.copyOf(h, 6);：");
		// 输出结果：123333
		print(i);
		
		// copyOfRange将指定数组的指定范围复制到新数组中
		int j[] = Arrays.copyOfRange(h, 6, 11);
		System.out.println("Arrays.copyOfRange(h, 6, 11)：");
		// 输出结果66600(h数组只有9个元素这里是从索引6到索引11复制所以不足的就为0)
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


