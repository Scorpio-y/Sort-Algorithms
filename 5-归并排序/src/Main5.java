public class Main5{
	
	private static int[] nums = new int[] {2,4,6,3,0,5,1,9,10,8,0,-1};
	
	public static void main(String[] args) {
		Main5 test = new Main5();
		test.mergeSort(nums);
		test.printNums(nums);
	}
	
	// �鲢����
	public void mergeSort(int[] nums) {
		if(nums == null || nums.length == 0) return;
		int[] tmp = new int[nums.length];
		sort(nums, 0, nums.length-1, tmp);
	}
	
	// �ݹ�
	private void sort(int[] nums, int left, int right, int[] tmp) {
		if(left<right) {
			int mid = left + (right-left)/2;
			sort(nums, left, mid, tmp);
			sort(nums, mid+1, right, tmp);
			merge(nums, left, mid, right, tmp);
		}
	}
	
	// �ϲ�������������
	private void merge(int[] nums, int left, int mid, int right, int[] tmp) {
		int ptrl = left, ptrr = mid+1;
		for(int ptrt=left; ptrt<=right; ptrt++) {
			if(ptrl>mid) tmp[ptrt] = nums[ptrr++];	// �����������
			else if(ptrr>right) tmp[ptrt] = nums[ptrl++];	// �ұ���������
			else if(nums[ptrl]<nums[ptrr]) tmp[ptrt] = nums[ptrl++];
			else tmp[ptrt] = nums[ptrr++];
		}
		
		// tmp���鿽����nums����
		for(int i=left; i<=right; i++) {
			nums[i] = tmp[i];
		}
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