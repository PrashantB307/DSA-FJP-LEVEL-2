

//    https://leetcode.com/problems/range-sum-query-mutable/


class NumArray {

    class Node {
        int str; int end;
        Node left; Node right;
        int val;
    }

    Node root;
    Node construct(int[] nums, int lo, int hi){
        if(lo == hi){
            Node node = new Node();
            node.str = node.end = lo;
            node.left = node.right = null;
            node.val = nums[lo];

            return node;
        }

        Node node = new Node();
        node.str = lo;
        node.end = hi;

        int mid = (lo + hi) / 2;
        node.left = construct(nums, lo, mid);
        node.right = construct(nums, mid + 1, hi);

        node.val = node.left.val + node.right.val;
       
        return node;

    }

    public NumArray(int[] nums) {
        root = construct(nums, 0, nums.length - 1);
    }

    void update(Node node, int idx, int val){
        if(node.str == node.end){
            node.val = val;
            return;
        }

        int mid = (node.str + node.end) / 2;
        if(idx <= mid){
            update(node.left, idx, val);
        }else{
            update(node.right, idx, val);
        }

        node.val = node.left.val + node.right.val;
    }

    public void update(int index, int val) {
        update(root, index, val);
    }

    int query(Node node, int qs, int qe){
        if(qs > node.end || qe < node.str){
            return 0;
        }else if(node.str >= qs && node.end <= qe){
            return node.val;
        }else{
            int lval = query(node.left, qs, qe);
            int rval = query(node.right, qs, qe);

            return lval + rval;
        }

    }
    
    public int sumRange(int left, int right) {
        return query(root, left, right);
    }
} 


//XXXXXXXXXXXXXXXXXXXXXXX    Fenwik tree    XXXXXXXXXXXXXXXXXXXXXXXX


class NumArray2 {
    class FenwickTree {
        int[] arr;
        FenwickTree(int[] nums){
            arr = new int[nums.length + 1];
            for(int i = 0; i < nums.length; i++){
                this.update(i + 1, nums[i]);
            }
        }
        
        private int rsb(int x){
            return x & (-x);
        }
        
        public int getSum(int pos){
            int res = 0;
            
            while(pos > 0){
                res += arr[pos];
                pos = pos - rsb(pos);
            }
            
            return res;
        }
        
        public void update(int pos, int val){
            while(pos < arr.length){
                arr[pos] += val;
                pos = pos + rsb(pos);
            }
        }
    }
    
    FenwickTree ft;
    int[] oarr;
    public NumArray2(int[] nums) {
        ft = new FenwickTree(nums);
        oarr = nums;
    }
    
    public void update(int index, int val) {
        int delta = val - oarr[index]; 
        ft.update(index + 1, delta);
        oarr[index] = val;
    }
    
    public int sumRange(int left, int right) {
        int lpos = left + 1;
        int rpos = right + 1;
    
        int suml = ft.getSum(lpos - 1);
        int sumr = ft.getSum(rpos);
        return sumr - suml;
    }
}