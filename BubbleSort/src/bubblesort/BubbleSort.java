/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bubblesort;

/**
 *
 * @author nemesis
 */
public class BubbleSort {

    /**
     * @param args the command line arguments
     */
    public static final String ANSI_BLUE = "\u001B[34m";
    public static void bubbleSort(int arr[])
    {
        int n = arr.length;
        for (int i = 0; i < n-1; i++) {
            int phase = i+1;
            System.out.println("\n"+ANSI_BLUE+"Phase "+phase);
            for (int j = 0; j < n-i-1; j++) {
                System.out.println("key: "+arr[j]);
                if (arr[j] > arr[j+1])
                {
                    // swap arr[j+1] and arr[j]
                    int temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                }
                printArray(arr);
            }
            
        }
        
    }
 
    /* Prints the array */
    public static void printArray(int arr[])
    {
        int n = arr.length;
        for (int i=0; i<n; ++i)
            System.out.print(arr[i] + " ");
        System.out.println();
    }
 
    public static void main(String[] args) {
        int arr[] = {32, 51, 27, 85, 66};
        System.out.println(ANSI_BLUE+"Given array");
        printArray(arr);
        
        bubbleSort(arr);
        
        System.out.println("\n"+ANSI_BLUE+"Sorted array");
        printArray(arr);
        System.out.println("");
    }
    
}
