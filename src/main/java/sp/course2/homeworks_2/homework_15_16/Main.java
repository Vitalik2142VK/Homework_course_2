package sp.course2.homeworks_2.homework_15_16;

public class Main {
    private static void swapElements(Integer[] arr, int indexA, int indexB) {
        int tmp = arr[indexA];
        arr[indexA] = arr[indexB];
        arr[indexB] = tmp;
    }

//    //sort_1
//    private static void sort1(Integer[] arr) {
//        Integer[] intArr = Arrays.copyOf(arr, arr.length);
//        for (int i = 0; i < intArr.length - 1; i++) {
//            for (int j = 0; j < intArr.length - 1; j++) {
//                if (intArr[j] > intArr[j + 1])
//                    swapElements(intArr, j, j+1);
//            }
//        }
//
//        //System.out.println(Arrays.toString(intArr));
//    }
//
//    //sort_2
//    private static void sort2(Integer[] arr) {
//        Integer[] intArr = Arrays.copyOf(arr, arr.length);
//        int minElInx;
//        for (int i = 0; i < intArr.length - 1; i++) {
//            minElInx = i;
//            for (int j = i + 1; j < intArr.length; j++) {
//                if (intArr[j] < intArr[minElInx])
//                    minElInx = j;
//            }
//            swapElements(intArr, i, minElInx);
//        }
//
//        //System.out.println(Arrays.toString(intArr));
//    }
//
//    //sort_3
//    private static void sort3(Integer[] arr) {
//        Integer[] intArr = Arrays.copyOf(arr, arr.length);
//        int temp;
//        for (int i = 1; i < intArr.length; i++) {
//            temp = intArr[i];
//            int j = i;
//            while (j > 0 && intArr[j - 1] >= temp) {
//                intArr[j] = intArr[j - 1];
//                j--;
//            }
//            intArr[j] = temp;
//        }
//
//        //System.out.println(Arrays.toString(intArr));
//    }

    public static void main(String[] args) {
//        Random random = new Random();
//
//        Integer[] arr = new Integer[100000];
//        for (int i = 0; i < arr.length; i++) {
//            arr[i] = random.nextInt() % 100000;
//        }
//
//        long start = System.currentTimeMillis();
//        sort1(arr);
//        System.out.println(System.currentTimeMillis() - start);
//        System.out.println("\n-----#####-----\n");
//
//        long start_2 = System.currentTimeMillis();
//        sort2(arr);
//        System.out.println(System.currentTimeMillis() - start_2);
//        System.out.println("\n-----#####-----\n");
//
//        long start_3 = System.currentTimeMillis();
//        sort3(arr);
//        System.out.println(System.currentTimeMillis() - start_3);
//        System.out.println("\n-----#####-----\n");
        Integer[] integer = new Integer[]{5, 1, 8, 12, 6, 4, 54, 23, 67, 15};

        ListInteger listInteger = new ArrayListInteger(integer);
        System.out.println(listInteger.contains(67));

    }
}
