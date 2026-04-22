// Problem: Move Zeroes to End
// Company: Amazon

// Case Study:
// In data processing systems, zero values may represent inactive or null entries.
// To optimize processing, all zero values are moved to the end while maintaining
// the order of non-zero elements.

// Problem Statement:
// Given an array, move all zeroes to the end while maintaining the relative order
// of non-zero elements.

// Approach:
// First count the number of zeroes in the array.
// Then shift all non-zero elements to the front.
// Finally, fill the remaining positions with zeroes.

// Time Complexity: O(n)
// Space Complexity: O(1)

// Example:
// Input: [0, 3, 0, 4, 12]
// Output: [3, 4, 12, 0, 0]


class MoveZero{
    public void move(int[] arr){
        int count=0;
        int n=arr.length;
        for(int i=0;i<n;i++){
            if(arr[i]==0){
                count++;
            }
        }
        int index=0;
        for(int i=0;i<n;i++){
            if(arr[i]!=0){
                arr[index++]=arr[i];
            }
        }
        while(count>0){
            arr[index++]=0;
            count--;
        }
        for(int i=0;i<n;i++){
            System.out.print(arr[i]+" ");
        }
    }
}
public class MoveZeroToEnd {
    public static void main(String[] args) {
        int[] arr={0,3,0,4,12};
        MoveZero zc=new MoveZero();
        zc.move(arr);

    }
}
