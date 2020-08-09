public class Main1{
	
	private static int[] nums = new int[] {2,4,6,3,0,5,1,9,10,8,0,-1};
	
	public static void main(String[] args) {
		Main1 test = new Main1();
		test.selectionSort(nums);
		test.printNums(nums);
	}
	
	// ѡ������
	public void selectionSort(int[] nums) {
		if(nums == null || nums.length == 0) return;
		int len = nums.length;
		for(int i=0;i<len-1;i++) {
			int minIdx = i;
			for(int j=i+1;j<len;j++) {
				if(nums[j]<nums[minIdx]) {
					minIdx = j;
				}
			}
			swap(nums, i, minIdx);
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