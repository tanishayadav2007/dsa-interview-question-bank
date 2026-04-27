// Problem: Majority Element
// Company: Amazon

// Case Study:
// In an election system, votes are stored in an array where each
// number represents a candidate ID. The system must determine
// if any candidate has received more than half of the total votes.

// Problem Statement:
// Given an array, find the element that appears more than n/2 times.
// If no such element exists, return "No Majority".

// Approach (Boyer-Moore Voting Algorithm):
// Step 1: Find a candidate using voting technique
// Step 2: Verify if the candidate appears more than n/2 times
//
// Logic:
// Maintain a count and a candidate
// If count becomes 0 → update candidate
// If element equals candidate → increment count
// Else → decrement count

// Time Complexity: O(n)
// Space Complexity: O(1)

// Example:
// Input: [3, 2, 3]
// Output: 3
// Explanation:
// Element 3 appears 2 times out of 3 (> n/2), so it is the majority element.


public class MajorityElement {
    public static String majority(int[] arr){
        int count=0;
        int candidate=0;
        for(int num:arr){
            if(count==0){
                candidate=num;
            }
            if(num==candidate){
                count++;
            }
            else{
                count--;
            }
        }
        count=0;
        for(int num:arr){
            if(candidate==num){
                count++;
            }
        }
        if(count>arr.length/2){
            return String.valueOf(candidate);
        }
        else{
            return "No Majority";
        }
    }
    public static void main(String[] args) {
        int[] arr={3,2,3};
        System.out.println(majority(arr));
    }
}
