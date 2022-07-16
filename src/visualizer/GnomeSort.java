package visualizer;

public class GnomeSort {
    //Needs a look at
    public void sortWithDelay(int arr[])
    {
        int index = 0;
        int n = arr.length;

        while (index < n) {
            if (index == 0)
                index++;
            if (arr[index] >= arr[index - 1])
                index++;
            else {
                int temp = 0;
                temp = arr[index];
                arr[index] = arr[index - 1];
                arr[index - 1] = temp;
                index--;
                return;
            }

        }
    }

}
