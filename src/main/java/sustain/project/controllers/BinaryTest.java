//package sustain.project.controllers;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import sustain.project.models.User;
//import sustain.project.service.UserService;
//
//import java.util.List;
//
//public class BinaryTest {
//
//    static String[] a = {"AAA", "BBB", "CCC", "DDD", "EEE", "FFF", "GGG"};
//    static int min = 0;
//    static int max = a.length - 1;
//    static int mid;
//    static String key = "CCC";
//
//    public static void main(String[] args) {
//        System.out.println("Key Found at : " + stringBinarySearch() + " position");
//    }

//    public static int stringBinarySearch() {
//        while (min <= max) {
//            mid = (min + max) / 2;
//            if (a[mid].compareTo(key) < 0) {
//                min = mid + 1;
//            } else if (a[mid].compareTo(key) > 0) {
//                max = mid - 1;
//            } else {
//                return mid;
//            }
//        }
//        return -1;
//    }

//    static int partition(Employee employees[], int start, int end) {
//        Employee temp;
//        Employee pivot = employees[end];
//        int partitionIndex = start;
//        for (int i = start; i < end; i++) {
//            if (employees[i].getFirstName().compareToIgnoreCase(employees[end].getFirstName()) < 1) // getFirstName method to retrieve first name and compare to each in record
//            {
//
//                temp = employees[i];
//                employees[i] = employees[partitionIndex];
//                employees[partitionIndex] = temp;
//
//                partitionIndex++;
//            }
//        }
//
//        temp = employees[partitionIndex];
//        employees[partitionIndex] = employees[end];
//        employees[end] = temp;
//        return partitionIndex;
//    }
//
//    static void quickSort(Employee employees[], int start, int end) {
//        if (start < end) {
//            int partitionIndex = partition(employees, start, end);
//            quickSort(employees, start, partitionIndex - 1);
//            quickSort(employees, partitionIndex + 1, end);
//        }
//    }
//
//}
