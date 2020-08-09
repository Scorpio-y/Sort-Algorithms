import java.util.ArrayList;

public class Main{
	public static void main(String[] args) {
		int[] m = new int[] {4,2};
		int n = 5;
		
		boolean[] meicha = new boolean[n+1];
		ArrayList<Integer> res = new ArrayList<>();
		
		for(int ele:m) {
			res.add(ele);
			meicha[ele] = true;
		}
		
		int idx = 0;
		for(int i=1;i<=n;i++) {
			if(meicha[i] == false) {
				int len = res.size();
				boolean flag = false;
				for(int j=idx;j<len;j++) {
					if(res.get(j)>i) {
						res.add(j, i);
						flag = true;
						idx = j;
						break;
					}
				}
				if(flag == false) res.add(i);
			}
		}
		
		System.out.println(res);
	}
}