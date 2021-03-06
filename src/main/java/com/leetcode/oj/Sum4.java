/**
 * Source : http://oj.leetcode.com/problems/4sum
 * Author : Hexiaoqiao
 * Date   : 2014-09-26
 *
 * 0.Problem:
 * Given an array S of n integers, are there elements a, b, c, 
 * and d in S such that a + b + c + d = target? Find all unique 
 * quadruplets in the array which gives the sum of target.
 * 
 * Note:
 * Elements in a quadruplet (a,b,c,d) must be in non-descending 
 * order. (ie, a ≤ b ≤ c ≤ d)
 * The solution set must not contain duplicate quadruplets.
 * For example, given array S = {1 0 -1 0 -2 2}, and target = 0.
 *     A solution set is:
 *     (-1,  0, 0, 1)
 *     (-2, -1, 1, 2)
 *     (-2,  0, 0, 2)
 *     
 * 1.Refer.:同@Sum3
 * 在Sum3的基础上外边增加一重循环
 */
package com.leetcode.oj;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Sum4 {
    public static List<List<Integer>> fourSum(int[] num, int target) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        int n = num.length;
        if (4 > n) return res;
        Arrays.sort(num);
        for (int i = 0; i < n - 3; i++) {
	        for (int j = i + 1; j < n - 2; j++) {
	        	int low = j + 1;
	        	int high = n - 1;
		        int tmp = target - num[i] - num[j];
		        if (low >= n - 1 || low >= high) continue; 
		        while (low < high) {
		        	if (tmp < num[low] + num[high]) {
		        		high = high - 1;
		        	} else if (tmp > num[low] + num[high]) {
		        		low = low + 1;
		        	} else {
		        		List<Integer> l = new ArrayList<Integer>();
		        		l.add(num[i]);
		        		l.add(num[j]);
	        			l.add(num[low]);
	        			l.add(num[high]);
	        			if (!res.contains(l)) res.add(l);
	        			low = low + 1;
	        			high = high - 1;
	        			while (low < n && num[low] == num[low - 1]) low++;
	        			while (high > j && num[high] == num[high + 1]) high--;
		        	}
	        	}	       
	        }
        }
    	return res;
    }
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] num = {1, 0, -1, 0, -2, 2};
		List<List<Integer>> res = fourSum(num,0);
		for (List<Integer> l : res) {
			for (Integer i : l) {
				System.out.print(i + " ");
			}
			System.out.println();
		}
	}

}
