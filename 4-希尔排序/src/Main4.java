public class Main4{
	
	private static int[] nums = new int[] {2,4,6,3,0,5,1,9,10,8,0,-1};
	
	public static void main(String[] args) {
		Main4 test = new Main4();
		test.shellSort(nums);
		test.printNums(nums);
	}
	
	// ϣ�����򣬲��������������
	public void shellSort(int[] nums) {
		if(nums == null || nums.length == 0) return;
		int len = nums.length;
		int h = 1;
		while(h < len/3) {
			h = h*3+1;	// 1,4,13,40,...
		}
		
		while(h>0) {
			for(int i=h;i<len;i++) {
				for(int j=i;j>=h;j-=h) {
					if(nums[j]<nums[j-h]) {
						swap(nums,j,j-h);
					}
				}
			}
			h /= 3;
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