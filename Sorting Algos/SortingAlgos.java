
public class SortingAlgos
{
    public static void main(String[] args)
    {
        int size = 8;
        //int arr[] = new int[size];
        int arr[] = { 8, 2, 4, 1, 3, 7, 5, 9 };

        bubbleSort(arr);
        display(arr);

        disSort(arr);
        display(arr);

        optimisedBubbleSort(arr);
        display(arr);

        selectionSort(arr);
        display(arr);

        disSort(arr);
        display(arr);

        System.out.println("Sort Method: Merge Sort");
        mergeSort(arr, 0, size-1);
        display(arr);

        disSort(arr);
        display(arr);


    }

    public static void disSort(int[] arr)
    {
        System.out.println("Dis sorting array again");
        int temp[] = { 8, 2, 4, 1, 3, 7, 5, 9 };
        for(int i=0;i<arr.length;i++)
        {
            arr[i] = temp[i];
        }
    }

    public static void display(int[] arr)
    {
        for(int i=0;i<arr.length;i++)
        {
            System.out.printf("%d ", arr[i]);
        }
        System.out.println();
    }

    public static void bubbleSort(int[] arr)
    {
        System.out.println("Sort Method: Bubble Sort");
        int n = arr.length;
        int i = 0, j = 0;
        for(i = 0 ; i<n-1; i++)
        {
            for(j = 0; j< n-1-i; j++)
            {
                if(arr[j] > arr[j+1])
                {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
    }

    public static void optimisedBubbleSort(int[] arr)
    {
        System.out.println("Sort Method: Optimised Bubble Sort");
        int n = arr.length;
        int i = 0, j = 0;
        boolean swap = false;
        for(i = 0 ; i<n-1; i++)
        {
            swap = false;
            for(j = 0; j< n-1-i; j++)
            {
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                    swap = true;
                }
            }
            if(swap == false)
            {
                break;
            }
        }
    }

    public static void selectionSort(int[] arr)
    {
        System.out.println("Sort Method: Selection Sort");
        int n = arr.length;

        int i=0,j=0;

        for(i = 0; i<n-1;i++)
        {
            int min_element_index = i;
            for(j= i+1; j<n;j++)
            {
                if (arr[min_element_index] > arr[j]) {
                    min_element_index = j;
                }
            }

            if(min_element_index != i)
            {
                int temp = arr[i];
                arr[i] = arr[min_element_index];
                arr[min_element_index] = arr[i];
            }
        }
    }

    public static void mergeSort(int[] arr, int left, int right)
    {
        int n = arr.length;

        if(right > left)
        {
            int mid = (right-left)/2 + left;
            mergeSort(arr, left, mid);
            mergeSort(arr, mid + 1, right);
            merge(arr, left, mid, right);
        }
    }

    public static void merge(int[] arr, int left, int mid, int right)
    {
        int[] temp = new int[right - left + 1];
        int i = left, j = mid+1, k = 0;

        for (i = left; i <= mid && j <= right;)
        {
            if (arr[i] > arr[j]) {
                temp[k] = arr[j];
                j++;
            } else {
                temp[k] = arr[i];
                i++;
            }
            k++;
        }

        while(i <= mid)
        {
            temp[k] = arr[i];
            i++;
            k++;
        }

        while(j <= right)
        {
            temp[k] = arr[j];
            j++;
            k++;
        }

        i=left;

        for(k= 0; k < temp.length; k++)
        {
            arr[i] = temp[k];
            i++;
        }
    }

}

