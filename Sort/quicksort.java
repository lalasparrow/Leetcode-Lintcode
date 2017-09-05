import java.io.*;
import java.util.*;

public class Solution{
	public static void quicksort(int[] array){
		quicksort(array, 0, array.length - 1);
	}
	public static void quicksort(int[] array, int left, int right){
		if (left >= right) {
			return;
		}
		int pivot = array[(left + right) / 2];
		int index = partition(array, left, right, pivot);
		quicksort(array, left, index - 1);
		quicksort(array, index, right);
	}

	public static int partition(int[] array, int left, int right, int pivot){
		while(left <= right){
			while(array[left] < pivot){
				left++;
			}
			while(array[right] > pivot){
				right--;
			}
			//剩下的left肯定比pivot大，right肯定比pivot小

			if(left <= right){
				swap(array, left, right);
				left++;
				right--;
			}
		}

		return left;
	}

	private void swap(int[] array, int i, int j){
		int tmp = array[i];
		array[i] = array[j];
		array[j] = tmp;
	}
}