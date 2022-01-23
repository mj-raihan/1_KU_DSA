/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mergesort;

/**
 *
 * @author nemesis
 */
public class MergeSort {

    /**
     * @param args the command line arguments
     */
    public static final String ANSI_BLUE = "\u001B[34m";
    public static boolean explain= true;

    public static void merge(int arr[], int low, int m, int high)
    {
        // Find sizes of two subarrays to be merged
        int n1 = m - low + 1;
        int n2 = high - m;
        
        if (explain) {
        System.out.println("\n(Inside merge)low, mid, high: "+low+" "+m+" "+high);
        System.out.println("n1, n2: "+n1+" "+n2);
        }
  
        /* Create temp arrays */
        int L[] = new int[n1];
        int R[] = new int[n2];
  
        /*Copy data to temp arrays*/
        for (int i = 0; i < n1; ++i)
            L[i] = arr[low + i];
        for (int j = 0; j < n2; ++j)
            R[j] = arr[m + 1 + j];
        
        if (explain) {
        System.out.print("L: ");
        printArray(L);
        System.out.print("R: ");
        printArray(R);
        }
        // Initial indexes of first L[] and second R[] subarrays
        int i = 0, j = 0;
  
        // Initial index of merged subarray array
        int k = low;
        while (i < n1 && j < n2) {
            if (L[i] <= R[j]) {
                arr[k] = L[i];
                i++;
            }
            else {
                arr[k] = R[j];
                j++;
            }
            k++;
        }
  
        
        while (i < n1) { /* Copy remainingof L[]*/
            arr[k] = L[i];
            i++;
            k++;
        }
  
        while (j < n2) { /* Copy remainingof R[]*/
            arr[k] = R[j];
            j++;
            k++;
        }
        
        
    }
  
    // Main function that sorts arr[l..r] using
    // merge()
    public static void sort(int arr[], int low, int high, String flag)
    {
        if (low < high) {
            // Find the middle point
            int m =low + (high-low)/2;
            
            if (explain) {
                System.out.println("\n\nlow, mid, high, flag: "+low+" "+m+" "+high+" "+flag);
            for (int i = low; i < high+1; i++)
                System.out.print(arr[i] + " ");
        }

  
//             Sort first 
            sort(arr, low, m, "1st");
//           and second halvs
            sort(arr, m + 1, high, "2nd"); 
            
//             Merge the sorted halves
            merge(arr, low, m, high);
            System.out.print(ANSI_BLUE+"Merge: ");
            printArray(arr);

        }
    }
  
    /* A utility function to print array of size n */
    public static void printArray(int arr[])
    {
        int n = arr.length;
        for (int i = 0; i < n; ++i)
            System.out.print(arr[i] + " ");
        System.out.println();
    }
    
    public static void main(String[] args) {
        // TODO code application logic here
        
        int arr[] = {5, 2, 4, 6, 1, 3, 9, 7};
  
        System.out.println("Given Array");
        printArray(arr);
        System.out.println("");
 
        sort(arr, 0, arr.length - 1, "call");
  
        System.out.println("\nSorted array");
        printArray(arr);
        System.out.println("");
        
    }
    
}
