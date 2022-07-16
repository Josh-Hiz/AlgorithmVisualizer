package visualizer;

public class BrickSort {

    public void sortWithDelay(int arr[])
    {

        int n = arr.length;
        boolean isSorted = false; // Initially array is unsorted

        while (!isSorted)
        {
            isSorted = true;
            int temp =0;

            // Perform Bubble sort on odd indexed element
            for (int i=1; i<=n-2; i=i+2)
            {
                if (arr[i] > arr[i+1])
                {
                    temp = arr[i];
                    arr[i] = arr[i+1];
                    arr[i+1] = temp;
                    isSorted = false;
                    return;
                }
            }

            // Perform Bubble sort on even indexed element

            int i = 0;
            while(i <= arr.length - 2) {
                if (arr[i] > arr[i+1])
                {
                    temp = arr[i];
                    arr[i] = arr[i+1];
                    arr[i+1] = temp;
                    isSorted = false;
//	                    return;
                }
                i = i + 2;
            }
        }

    }

}
