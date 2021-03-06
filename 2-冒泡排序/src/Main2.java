public class Main2{
	
	private static int[] nums = new int[] {2,4,6,3,0,5,1,9,10,8,0,-1};
	
	public static void main(String[] args) {
		Main2 test = new Main2();
		test.bubbleSort(nums);
		test.printNums(nums);
	}
	
	// ð�������Ż���
	public void bubbleSort(int[] nums) {
		if(nums == null || nums.length == 0) return;
		int len = nums.length;
		boolean isSorted = false;
		
		for(int i = len-1; i>0 && !isSorted; i--) {
			isSorted = true;
			for(int j=0; j<i; j++) {
				if(nums[j]>nums[j+1]) {
					isSorted = false;
					swap(nums, j, j+1);
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