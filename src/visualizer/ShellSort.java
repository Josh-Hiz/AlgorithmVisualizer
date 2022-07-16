package visualizer;

public class ShellSort {

    //IN PROGRESS

    /* function to sort arr using shellSort */
    public void sortWithDelay(int arr[])
    {
        int n = arr.length;

        for (int gap = n/2; gap > 0; gap /= 2)
        {

            for (int i = gap; i < n; i += 1)
            {

                int temp = arr[i];


                int j = i;

                if(j >= gap && arr[j - gap] > temp) {

                    arr[j] = arr[j - gap];
                    j -= gap;

                }

                arr[j] = temp;

            }
        }


    }

}
