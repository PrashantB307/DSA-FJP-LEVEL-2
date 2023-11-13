


//     https://www.codingninjas.com/studio/problems/minimum-swaps-to-make-identical-array_3843992?leftPanelTab=0


import java.util.* ;

class GFG {
	public static int minimumSwaps(int n, int[] A, int[] B) {
		HashMap<Integer, Integer> map = new HashMap<>();
		for(int i = 0; i < n; i++){
			map.put(B[i], i);
		}

		int ans = 0;
		boolean[] vis = new boolean[n];

		for(int i = 0; i < n; i++){
			if(vis[i] == true || map.get(A[i]) == i){
				continue;
			}

			vis[i] = true;
			int csum = 0;
			int j = i; 
			do{
				j = map.get(A[j]);
				vis[j] = true;
				csum++;
			}while(j != i);

			ans += csum - 1;
		}

		return ans;
	}
}
