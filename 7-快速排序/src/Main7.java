public class Main7{
	
	private static int[] nums = new int[] {2,4,6,3,0,5,1,9,10,8,0,-1};
	
	public static void main(String[] args) {
		Main7 test = new Main7();
		test.quickSort(nums);
		test.printNums(nums);
	}
	
	// 快速排序
	public void quickSort(int[] nums) {
		if(nums == null || nums.length == 0) return;
		sort(nums,0,nums.length-1);
	}
	
	private void sort(int[] nums, int left, int right) {
		if(right<=left) return;
		int j = partition(nums, left, right);	// 真正的排序在这里完成
		sort(nums, left, j-1);
		sort(nums, j+1, right);
	}
	
	// 返回分割线索引
	private int partition(int[] nums, int left, int right) {
		int val = nums[left];
		int i = left, j = right;
		while(i<j) {
			while(j>left && nums[j]>=val) j--;
			while(i<right && nums[i]<=val) i++;	// 从左往右找，这里必须是小于等于，否则就是left元素
			if(i<j) swap(nums, i, j);
		}
		swap(nums, left, j);
		return j;
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