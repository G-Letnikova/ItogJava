//import java.io.FileWriter;
//import java.io.IOException;
//import java.util.ArrayList;
//import java.util.Arrays;
//import java.util.PriorityQueue;
//import java.util.Random;
//
//public class Program {
//    public static void main(String[] args) {
//        Toy lego = new Toy(1, 2, "Lego");
//        Toy robot = new Toy(2, 2, "Robot");
//        Toy doll = new Toy(3, 6, "Doll");
//        Toy[] toys = new Toy[]{lego, robot, doll};
//
//
//        ArrayList<Integer> arrayToysId = new ArrayList<>();
//
//        for (Toy t : toys) {
//            for (int j = 0; j < t.getWeight(); j++) {
//                arrayToysId.add(t.getId());
//            }
//        }
//
//        PriorityQueue<Integer> pQueue = new PriorityQueue<>();
//        pQueueLoad(pQueue, arrayToysId);
//
//        System.out.println(pQueue);
//        int tryCount = 10;
//        Integer[] result = new Integer[tryCount];
//        int win = 0;
//
//        for (int i = 0; i < tryCount; i++) {
//            win = getWin(pQueue, arrayToysId);
//            result[i] = win;
//            pQueue.clear();
//            pQueueLoad(pQueue, arrayToysId);
//        }
//        System.out.println(Arrays.toString(result));
//        saveResult(result);
//
//    }
//
//    public static void pQueueLoad(PriorityQueue<Integer> pQ, ArrayList<Integer> arr) {
//        for (int el : arr) {
//            pQ.add(el);
//        }
//    }
//
//    public static int getWin(PriorityQueue<Integer> pQ, ArrayList<Integer> arr) {
//        int count = new Random().nextInt(1, arr.size() + 1);
//        int win = 0;
//        for (int j = 0; j < count; j++) {
//            win = pQ.poll();
//        }
//        return win;
//
//    }
//    public static void saveResult(Integer[] result){
//        try (FileWriter writer = new FileWriter("result.txt", false)){
//            writer.write(Arrays.toString(result));
//        }
//        catch (IOException ex) {
//            System.out.println(ex.getMessage());
//        }
//    }
//}


//-------------------------------------------------------------------------------------------------------
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Random;

public class Program {
    public static void main(String[] args) {
        Toy lego = new Toy(1, 2, "Lego");
        Toy robot = new Toy(2, 2, "Robot");
        Toy doll = new Toy(3, 6, "Doll");
        Toy[] toys = new Toy[]{lego, robot, doll};



        PriorityQueue<Integer> pQueue = new PriorityQueue<>();
        pQueueLoad(pQueue, toys);

        System.out.println(pQueue);
        int tryCount = 10;
        Integer[] result = new Integer[tryCount];

        for (int i = 0; i < tryCount; i++) {
            result[i]  = getWin(pQueue);
            pQueue.clear();
            pQueueLoad(pQueue, toys);
        }
        System.out.println(Arrays.toString(result));
        saveResult(result);
    }


    public static void pQueueLoad(PriorityQueue<Integer> pQ, Toy[] toys) {
        for (Toy t : toys) {
            for (int j = 0; j < t.getWeight(); j++) {
                pQ.add(t.getId());
            }
        }
    }
        public static Integer getWin(PriorityQueue<Integer> pQ) {
            int count = new Random().nextInt(1, pQ.size() + 1);
            Integer win = 0;
            for (int j = 0; j < count; j++) {
                win = pQ.poll();
            }
            return win;
        }

        public static void saveResult(Integer[] res) {
            try (FileWriter writer = new FileWriter("result.txt", false)){
                writer.write(Arrays.toString(res));
            }
            catch (IOException ex) {
                System.out.println(ex.getMessage());
            }
        }
    }