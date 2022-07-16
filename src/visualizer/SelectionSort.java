package visualizer;

public class SelectionSort {

    private int i = 1;
    private int j = 0;

    public void sortWithDelay(int arr[])
    {
        int n = arr.length;

        if(i < n) {

            int min_index = i;

            for(int j = i + 1; j < n; j++) {
                if(arr[j] < arr[min_index]) {
                    min_index = j;
                }
            }
            int temp = arr[min_index];
            arr[min_index] = arr[i];
            arr[i] = temp;
            ++i;
        }
    }

}
