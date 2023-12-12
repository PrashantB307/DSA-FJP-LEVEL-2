

//     https://leetcode.com/problems/find-in-mountain-array/description/


class MountainArray {
      public int get(int index) {
        return index;}
      public int length() {
        return 0;}
}

class Solution {
    public int findInMountainArray(int target, MountainArray mountainArr) {
        
        int peak = peakElement(mountainArr);
        int index = binarySearch(mountainArr, target, 0, peak);
        if(index != -1){
            return index;
        }else{
            return binarySearch(mountainArr, target, peak + 1, mountainArr.length() - 1);
        }
    }

    public int peakElement(MountainArray mountainArr){

        int left = 0;
        int right = mountainArr.length() - 1;
        
        while(left < right){
            int mid = left + (right - left) / 2;

            if(mountainArr.get(mid) > mountainArr.get(mid + 1)){
                right = mid;
            }else{
                left = mid + 1;
            }
        }

        return left;
    }

    public int binarySearch(MountainArray mountainArray, int target, int left, int right){

        boolean isAscending = mountainArray.get(left) < mountainArray.get(right);

        while(left <= right){

            int mid = left + (right - left) / 2;
            int midElement = mountainArray.get(mid);

            if(target == midElement){
                return mid;
            }

            if(isAscending){
                if(target > midElement){
                    left = mid + 1;
                }else{
                    right = mid - 1;
                }
            }else{
                if(target > midElement){
                    right = mid - 1;
                }else{
                    left = mid + 1;
                }
            }
        }

        return - 1;
    }
}
