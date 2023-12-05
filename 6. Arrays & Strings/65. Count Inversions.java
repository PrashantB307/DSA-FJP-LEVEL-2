

//    https://practice.geeksforgeeks.org/problems/inversion-of-array-1587115620/1

//    https://www.codingninjas.com/studio/problems/count-inversions_615?leftPanelTab=1



class Solution
{
    static long ans = 0;
    static long inversionCount(long arr[], long N)
    {
        ans = 0;
        mergerSort(arr, 0, arr.length - 1);
        return ans;
    }

    static long[] mergerSort(long[] arr, int lo, int hi){
        if(lo == hi){
            long[] barr = new long[1];
            barr[0] = arr[(int)lo];
            return barr;
        }

        int mid = (lo + hi) / 2;

        long[] fh = mergerSort(arr, lo, mid);          // fh = first half
        long[] sh = mergerSort(arr, mid + 1, hi);      // sh = second half
        long[] cSortedArr = mergeTwoSortedArr(fh, sh); 

        return cSortedArr;
    }

    static long[] mergeTwoSortedArr(long[] fh, long[] sh){

        long[] res = new long[fh.length + sh.length];

        int i = 0;
        int j = 0;
        int k = 0;
        
        while(i < fh.length && j < sh.length){
            if(fh[i] <= sh[j]){
                res[k] = fh[i];
                i++;
                k++;
            }else{
                res[k] = sh[j];

                ans += (fh.length - i);

                j++;
                k++;
            }
        }

        while(i < fh.length){
            res[k] = fh[i];
            i++;
            k++;
        }

        while(j < sh.length){
            res[k] = sh[j];
            j++;
            k++;
        }

        return res;
    }
}