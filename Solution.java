
// https://leetcode.com/problems/median-of-two-sorted-arrays/

class Solution {
    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        double median = 0.0;
        int medIndex = 0;
        boolean even = false;
        
// [1,2,5]
// [2,4,10]
        if ((nums1.length + nums2.length) % 2 == 0) {
            even = true;
            medIndex = (nums1.length + nums2.length) / 2 ;
        } else {
            medIndex = ((nums1.length + nums2.length) / 2) ;
        }

        int i = 0;
        int j = 0;
        int c = 0;
        int val = 0;
        int prev = -1;


if (nums1.length == 0) {
    for (int jj = j; jj < nums2.length && c <= medIndex; jj++) {
        val = nums2[jj];
        if (even && c == medIndex - 1) {
            prev = val;
        }
        c++;
        
    }
    if (even) {
        return (double)(val + prev) / 2;
    } else {
        return val;
    }
} else  if (nums2.length == 0){
    for (int ii = i; ii < nums1.length && c <= medIndex; ii++) {
        val = nums1[ii];
        if (even && c == medIndex - 1) {
            prev = val;
        }
        c++;
        
    }
    if (even) {
        return (double)(val + prev) / 2;
    } else {
        return val;
    }                 
}
        while(c <= medIndex) {

              
                if (nums1[i] < nums2[j]) {
                    val = nums1[i];
                    if (even && c == medIndex - 1) {
                        prev = val;
                    }
                    c++;
                    
                    if (i == nums1.length - 1) {
                        for (int jj = j; jj < nums2.length && c <= medIndex; jj++) {
                            val = nums2[jj];
                            if (even && c == medIndex - 1) {
                                prev = val;
                            }
                            c++;
                            
                        }
                        if (even) {
                            return (double)(val + prev) / 2;
                        } else {
                            return val;
                        }
                        
                    }
                    i++;
                    // break;
                } else {
                    val = nums2[j];
                    if (even && c == medIndex - 1) {
                        prev = val;
                    }
                    c++;
                    if (j == nums2.length - 1) {
                        for (int ii = i; ii < nums1.length && c <= medIndex; ii++) {
                            val = nums1[ii];
                            if (even && c == medIndex - 1) {
                                prev = val;
                            }
                            c++;
                            
                        }
                        if (even) {
                            if (val == prev || prev == -1) {
                                return val;
                            }
                            return (double)(val + prev) / 2;
                        } else {
                            return val;
                        }                    }
                    j++;
                    // break;
                }                 
            
            
        }

        if (even) {
            return (double)(val + prev) / 2;
        } else {
            return val;
        }   
     }


    public static void main(String[] args) {

        double test3 = findMedianSortedArrays(new int[] {1,2,2}, new int[] {1,2,3});
        double test1 = findMedianSortedArrays(new int[] {1,2,5}, new int[] {2,4,10});
        double test2 = findMedianSortedArrays(new int[] {1,2}, new int[] {3,4});
        

        System.out.println(test3);
        System.out.println(test1);
        System.out.println(test2);


        // Prints "Hello, World" to the terminal window.
        System.out.println("Solved!");
    }

}