

//      https://www.geeksforgeeks.org/find-the-minimum-cost-to-cross-the-river/


import java.util.*;
class Main88
{
	static long minimumCost(long price[], int n)
	{
        Arrays.sort(price);

        if(n == 1){
            return price[0];
        }

        long ans = 0;
        for(int i = n - 1; i >= 1; i -= 2){
            if(i == 1){
                ans += price[1];
            }else if(i == 2){
                ans += price[0] + price[1] + price[2];
            }else{
                long f1 = 2 * price[0] + price[i - 1] + price[i];
                long f2 = price[0] + 2 * price[1] + price[i];

                ans += Math.min(f1, f2);
            }
        }

        return ans;
	}
	
	// Driver code
	public static void main (String[] args)
	{
		long price[] = { 30, 40, 60, 70 };
		int n = price.length;
	
		System.out.println(minimumCost(price, n));
	}
}