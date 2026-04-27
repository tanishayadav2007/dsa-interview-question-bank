/**
 * Problem: Product of Array Except Self
 *
 * Description:
 * Given an integer array, return an array where each element at index i
 * is the product of all elements in the array except arr[i].
 *
 * Approach (Brute Force):
 * - For each index, multiply all elements except itself
 * - Use nested loops to compute product
 *
 * Time Complexity: O(n^2)
 * Space Complexity: O(1) (excluding output array)
 *
 * Example:
 * Input:  [1, 2, 3, 4]
 * Output: [24, 12, 8, 6]
 */


import java.util.Arrays;
public class ProductOfArray {
    public static int[] product(int[] arr){
        int n=arr.length;
        int[] result=new int[n];
        for(int i=0;i<n;i++){
            int pdt=1;
            for(int j=0;j<n;j++){
                if(i!=j){
                    pdt*=arr[j];
                }
            }
            result[i]=pdt;
        }
        return result;
    }
    public static void main(String[] args) {
        int[] arr={1, 2, 3, 4};
        System.out.println(Arrays.toString(product(arr)));
    }
}
