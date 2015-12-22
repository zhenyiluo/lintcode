class Solution {
    /*
     * @param k : description of k
     * @param nums : array of nums
     * @return: description of return
     */
    public int kthLargestElement(int k, int[] nums) {
        // write your code here
        if (nums == null || nums.length == 0 || k <= 0){
            return 0;
        }
        int size = nums.length;
        return quickSelectionSort(nums, 0, size - 1, size - k);
    }

    private int quickSelectionSort(int[] nums, int start, int end, int k){
        int index = start + (int) (Math.random() * (end - start + 1));
        swap(nums, index, end);
        int pivot = nums[end];
        int left = start;
        int right = end;
        while (left <= right){
            while (left <= right && nums[left] < pivot){
                left++;
            }
            while (left <= right && nums[right] >= pivot){
                right--;
            }
            if (left < right){
                swap(nums, left, right);
            }
        }
        swap(nums, left, end);
        if (left == k){
            return nums[k];
        } else if (left < k){
            return quickSelectionSort(nums, left + 1, end, k);
        } else {
            return quickSelectionSort(nums, start, left - 1, k);
        }
    }

    private void swap(int[] nums, int left, int right){
        int tmp = nums[left];
        nums[left] = nums[right];
        nums[right] = tmp;
    }
}