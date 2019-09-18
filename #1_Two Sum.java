public class Solution {
    public int[] twoSum(int[] nums, int target) {
        int[] sorted= new int[nums.length];
        System.arraycopy(nums, 0, sorted, 0, nums.length);
        Arrays.sort(sorted);
        
        int left=0;
        int right= nums.length-1;
        
        while(left+1<right){
            if(sorted[left]+sorted[right]<target){
                left++;
                continue;
            }
            else if(sorted[left]+sorted[right]>target){
                right--;
                continue;
            }
            else{
                break; //found it! sorted[left]+sorted[right]==target
            }
        }
        //find the index in nums 
        int index1 =-1; 
        int index2= -1; 
        
        for(int i=0; i<sorted.length; i++){
            if(nums[i]==sorted[left] || nums[i]==sorted[right]){
                if(index1 == -1){
                    index1=i;
                }
                else{
                    index2=i;
                }
            }
        }
        
        //sort the final result
        int [] result= {index1, index2};
        Arrays.sort(result);
        return result; 
        
    }
}