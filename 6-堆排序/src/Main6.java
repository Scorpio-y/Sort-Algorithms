public class Main6{
	
	private static int[] nums = new int[] {2,4,6,3,0,5,1,9,10,8,0,-1};
	
	public static void main(String[] args) {
		Main6 test = new Main6();
		test.heapSort(nums);
		test.printNums(nums);
	}
	
	// 堆排序
	/* arr[n]的左节点为arr[2*n+1]，右节点为arr[2*n+2]
	 * arr[n]的父节点为arr[(n-1)/2]
	 */
	public void heapSort(int[] nums) {
		if(nums == null || nums.length == 0) return;
		int N = nums.length-1;	// 长度对应数组的索引
		// 初始化堆，堆顶元素最大，次大元素一定在第2层
		for(int i=N/2; i>=0; i--) {
			sink(nums, i, N);
		}
		
		while(N>0) {
			swap(nums, 0, N--);
			sink(nums, 0, N);	// 因为次大元素一定在第2层，所以只要对nums[0]下沉即可
		}
	}
	
	// 元素下沉
	private void sink(int[] nums, int idx, int N) {
		int son = 2*idx+1;
		while(son<=N) {
			if(son<N && nums[son]<nums[son+1]) {
				son++;
			}
			if(nums[idx]>=nums[son]) {
				break;
			}
			swap(nums, idx, son);	// 这里交换索引为idx和son的元素
			idx = son;	// 不能少，idx需要更新
			son = 2*son+1;
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