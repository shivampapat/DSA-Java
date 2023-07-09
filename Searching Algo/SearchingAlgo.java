
public class SearchingAlgo
{
    public static void main(String arg[])
    {
        //int[] arr = {3,6,34,7,32,1,5,7,1,8,9};
        int[] arr = {1,1,3,6,7,8,9,34};
        int target = 1;
        linearSearch(arr, target);
        binarySearch(arr, target);
    }

    private static void linearSearch(int[] arr, int target)
    {
        int i=0;
        for(i = 0; i < arr.length; i++)
        {
            if(arr[i] == target)
            {
                System.out.println(target + " FOUND");
                break;
            }
        }

        if(i == arr.length)
        {
            System.out.println(target + " NOT FOUND");
        }
    }

    private static void binarySearch(int[] arr, int target)
    {

        int left = 0;
        int right = arr.length-1;

        while( left <= right)
        {
            int mid = (right-left)/2 + left;

            if(arr[mid] == target)
            {
                System.out.println(target + " FOUND at index " + mid);
                break;
            }
            else if(arr[mid] > target)
            {
                right = mid-1;
            }
            else{
                left = mid+1;
            }
        }

        if(left > right)
        {
            System.out.println(target + " NOT FOUND");
        }
    }
}