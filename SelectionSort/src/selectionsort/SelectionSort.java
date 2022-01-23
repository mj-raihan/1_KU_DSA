/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package selectionsort;

/**
 *
 * @author nemesis
 */
public class SelectionSort {

    /**
     * @param args the command line arguments
     */
    public static final String ANSI_BLUE = "\u001B[34m";
    
    public static void selectionSort(int[] arr){  
        for (int i = 0; i < arr.length - 1; i++)  
        {  
            int index = i; 
            System.out.println("\nkey: "+ arr[index]);
            for (int j = i + 1; j < arr.length; j++){  
                if (arr[j] < arr[index]){  
                    index = j;//searching for lowest index              
                }  
            }
            System.out.println("smallest: "+ arr[index]);
            
            
            int smallerNumber = arr[index];   
            arr[index] = arr[i];  
            arr[i] = smallerNumber;
            
            int phase = i+1;
            System.out.print(ANSI_BLUE + "Phase " + phase + ": ");
            printArray(arr);
        }  
    }  
    
    /* print array of size n */
    public static void printArray(int arr[])
    {
        int n = arr.length;
        for (int i = 0; i < n; ++i)
            System.out.print(arr[i] + " ");
        System.out.println();
    }
    
    public static void main(String[] args) {
        // TODO code application logic here
        
        int[] arr1 = {17, 12, 18, 5, 7, 8, 10};
        
        System.out.println("Givven array");   
        printArray(arr1);
          
        selectionSort(arr1); 
         
        System.out.println("\nSelection Sort");  
        printArray(arr1);
    }
    
    
    
}
