import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Main10 {

	public static void main(String[] args) {
		// ����תList
		array2list();
		// Listת����
		list2array();
		// int[]תInteger[]
		int2Integer();
		//Integer[]תint[]
		integer2int();
	}
	
	public static void array2list() {
		int[] arr = new int[] {1,2,3,4,5};
		List<Integer> list = Arrays.stream(arr).boxed().collect(Collectors.toList());	// ����ʹ��
		System.out.println(list);
		System.out.println(list.getClass());
		
		List list2 = Arrays.asList(Arrays.stream(arr).boxed());
		System.out.println(list2);
		System.out.println(list2.getClass());
	}
	
	public static void list2array() {
		List<Integer> list = new ArrayList<>();
		list.add(1);
		list.add(2);
		list.add(3);
		list.add(4);
		list.add(5);
		Integer[] arr = list.toArray(new Integer[0]);
		print(arr);
		
		int[] arr2 = Arrays.stream(list.toArray(new Integer[0])).mapToInt(Integer::valueOf).toArray();
		print(arr2);
	}
	
	public static void int2Integer() {
		int[] arr = new int[] {1,2,3,4,5};
		Integer[] res = Arrays.stream(arr).boxed().toArray(Integer[]::new);
		print(res);
	}
	
	public static void integer2int() {
		Integer[] arr = new Integer[] {1,2,3,4,5};
		int[] res = Arrays.stream(arr).mapToInt(Integer::valueOf).toArray();
		print(res);
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
