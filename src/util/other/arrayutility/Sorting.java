package util.other.arrayutility;

public class Sorting {
	public static void mergeSortReverse(int[] arr) {
		if (arr.length <= 1) {
			return;
		}

		int mid = arr.length / 2;
		int[] leftArr = new int[mid];
		int[] rightArr = new int[arr.length - mid];

		for (int i = 0; i < mid; i++) {
			leftArr[i] = arr[i];
		}
		int k = 0;
		for (int j = mid; j < arr.length; j++) {
			rightArr[k] = arr[j];
			k++;
		}

		mergeSortReverse(leftArr);
		mergeSortReverse(rightArr);
		mergeReverse(leftArr, rightArr, arr);
	}

	public static void mergeReverse(int[] leftArr, int[] rightArr, int[] arr) {
		int i = 0, j = 0, k = 0;

		while (i < leftArr.length && j < rightArr.length) {
			if (leftArr[i] > rightArr[j]) {
				arr[k] = leftArr[i];
				k++;
				i++;
			} else {
				arr[k] = rightArr[j];
				k++;
				j++;
			}
		}

		while (i < leftArr.length) {
			arr[k] = leftArr[i];
			k++;
			i++;
		}

		while (j < rightArr.length) {
			arr[k] = rightArr[j];
			k++;
			j++;
		}
	}

}
