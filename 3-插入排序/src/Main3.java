public class Main3{
	
	private static int[] nums = new int[] {2,4,6,3,0,5,1,9,10,8,0,-1};
	
	public static void main(String[] args) {
		Main3 test = new Main3();
		test.insertionSort(nums);
		test.printNums(nums);
	}
	
	// 插入排序
	public void insertionSort(int[] nums) {
		if(nums == null || nums.length == 0) return;
		int len = nums.length;
		for(int i=1;i<len;i++) {	// 假设第一个元素有序
			for(int j=i;j>0;j--) {
				if(nums[j]<nums[j-1]) {
					swap(nums, j, j-1);
				}
			}
		}
	}
	
	private void swap(int[] nums, int i, int j) {
		int tmp = nums[i];
		nums[i] = nums[j];
		nums[j] = tmp;
	}
	
	public void printNums(int[] nums) {
		if(nums == null || nums.length==0) return;
		int len = nums.length;
		for(int i=0;i<len-1;i++) {
			System.out.print(nums[i]+",");
		}
		System.out.println(nums[len-1]);
	}
}