package RadixSort;

class RadixSort {

    private int iter = 0;
    private long time = 0;


    int getMax(int a[], int n) {
        int max = a[0];
        for(int i = 1; i<n; i++) {
            if(a[i] > max)
                max = a[i];
        }
        return max; //maximum element from the array
    }

    int getMin(int a[], int n) {
        int min = a[0];
        for(int i = 1; i<n; i++) {
            if(a[i] < min)
                min = a[i];
        }
        return min; //minimum element from the array
    }


    void countingSort(int a[], int n, int place, int min, int max) // function to implement counting
    {
        int range = max - min + 1;

        int count[] = new int[range];
        int output[] = new int[n];

        for (int i = 0; i < a.length; i++) {
            count[a[i] - min]++;
        }

        for (int i = 1; i < count.length; i++) {
            count[i] += count[i - 1];
        }

        for (int i = a.length - 1; i >= 0; i--) {
            output[count[a[i] - min] - 1] = a[i];
            count[a[i] - min]--;
        }

        for (int i = 0; i < a.length; i++) {
            a[i] = output[i];
        }
    }

    // function to implement radix sort
    void radixsort(int a[], int n) {
        time = System.nanoTime();
        // get maximum element from array
        int min = getMin(a, n);
        int max = getMax(a, n);

        // Apply counting sort to sort elements based on place value
        for (int place = 1; max / place > 0; place *= 10){
            iter++;
            countingSort(a, n, place, min, max);
        }
        time = System.nanoTime() - time;
    }

    public long returnTime() {
        return time;
    }

    public int returnIteration() {
        return iter;
    }

    /* function to print array elements
    void printArray(int a[], int n) {
        for (int i = 0; i < n; ++i)
            System.out.print(a[i] + " ");
    }*/

}