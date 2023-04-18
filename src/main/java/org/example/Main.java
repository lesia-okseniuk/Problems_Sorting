import java.util.*;

public class Main {
    public static void main(String[] args) {
        Main main = new Main();
        main.run();
    }

    private void run() { // Problem "Sort evens and odds" https://www.eolymp.com/en/problems/8236
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] arr = new int[n];

        // зчитування чисел у масив
        for (int i = 0; i < n; i++) {
            arr[i] = scanner.nextInt();
        }

        // розділення чисел на непарні та парні
        List<Integer> oddList = new ArrayList<>();
        List<Integer> evenList = new ArrayList<>();
        for (int num : arr) {
            if (num % 2 != 0) {
                oddList.add(num);
            } else {
                evenList.add(num);
            }
        }

        // сортування непарних чисел в порядку зростання
        Collections.sort(oddList);

        // сортування парних чисел в порядку спадання
        Collections.sort(evenList, Collections.reverseOrder());

        // об'єднання відсортованих списків
        List<Integer> sortedList = new ArrayList<>();
        sortedList.addAll(oddList);
        sortedList.addAll(evenList);

        // виведення відсортованого масиву
        for (int num : sortedList) {
            System.out.print(num + " ");
        }
    }


    private void run4() { // Problem "Sorting" https://www.eolymp.com/en/contests/29772/problems/346655
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = scanner.nextInt();
        }

        Arrays.sort(arr);

        for (int i = 0; i < n; i++) {
            System.out.print(arr[i] + " ");
        }
    }

    private void run3() { // Problem "Tricky Sorting" https://www.eolymp.com/en/contests/29772/problems/346654
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt(); // Введення кількості чисел
        List<Integer> numbers = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            numbers.add(scanner.nextInt()); // Введення чисел в список
    }
        // Сортування списку згідно з умовою
        Collections.sort(numbers, new Comparator<Integer>() {
            @Override
            public int compare(Integer a, Integer b) {
                int lastDigitA = a % 10; // Остання цифра числа a
                int lastDigitB = b % 10; // Остання цифра числа b
                if (lastDigitA != lastDigitB) {
                    return Integer.compare(lastDigitA, lastDigitB); // Сортування за останньою цифрою
                } else {
                    return Integer.compare(a, b); // Сортування за числами
                }
            }
        });

        // Виведення відсортованої послідовності
        for (Integer number : numbers) {
            System.out.print(number + " ");
        }
    }
    private void run2() { // Problem "Sorting Time" https://www.eolymp.com/en/problems/972
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        PriorityQueue<Time> queue = new PriorityQueue<>(); // Пріоритетна черга
        for (int i = 0; i < n; i++) {
            queue.add(new Time(in.nextInt(), in.nextInt(), in.nextInt()));
        }

        while (!queue.isEmpty()) {
            System.out.println(queue.poll());
        }
    }

    private void run1() { // Problem "Josephus" https://www.eolymp.com/en/problems/971
        Scanner scanner = new Scanner(System.in);
        try {
            int N = scanner.nextInt();
            int k = scanner.nextInt();
            int survivor = findSurvivor(N, k);
            System.out.println(survivor);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            scanner.close();
        }
    }




        public static int findSurvivor (int N, int k){
            int[] circle = new int[N]; // Створення масиву для імітації кола людей
            for (int i = 0; i < N; i++) {
                circle[i] = i + 1; // Надання кожній людині номера в цьому колі
            }

            int index = 0;
            while (N > 1) { // Повторювати, доки не залишиться одна людина
                index = (index + k - 1) % N; // Вираховуємо індекс k-тої людини
                for (int i = index; i < N - 1; i++) {
                    circle[i] = circle[i + 1]; // Зміщуємо людей, що залишилися, ліворуч
                }
                N--;
            }

            return circle[0]; // Повертаємо номер людини, що вижила
        }

    }

class Time implements Comparable<Time> {
    int h;
    int m;
    int s;

    public Time(int h, int m, int s) {
        this.h = h;
        this.m = m;
        this.s = s;
    }

    @Override
    public String toString() {
        return h + " " + m + " " + s;
    }

    @Override
    public int compareTo(Time other) {
        int k = Integer.compare(h, other.h);
        if (k!=0) return k;
        k = Integer.compare(m, other.m);
        if (k!=0) return k;
        return Integer.compare(s, other.s);
    }
}