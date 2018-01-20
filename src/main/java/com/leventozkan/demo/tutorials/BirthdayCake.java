package com.leventozkan.demo.tutorials;

import java.util.Arrays;
import java.util.Scanner;

/*
 * Colleen is turning  years old! Therefore, she has  candles of various heights on her cake, and candle  has height . Because the taller candles tower over the shorter ones, Colleen can only blow out the tallest candles.
	Given the  for each individual candle, find and print the number of candles she can successfully blow out.

Input Format
The first line contains a single integer, , denoting the number of candles on the cake. 
The second line contains  space-separated integers, where each integer  describes the height of candle .
 * */

public class BirthdayCake {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();
		int[] heights = new int[n];
		for (int i = 0; i < n; i++) {
			heights[i] = sc.nextInt();
		}
		System.out.println(solve(heights));

		sc.close();
	}

	static int solve(int[] heights) {
		int maxHeight = Arrays.stream(heights).max().getAsInt();
		return (int) Arrays.stream(heights).filter(height -> height == maxHeight).count();
	}
	

}
