import java.util.*;


public class vas {

    // ════════════════════════════════════════════════════════
    //  MAIN MENU
    // ════════════════════════════════════════════════════════
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("╔══════════════════════════════════════════════════════╗");
        System.out.println("║     DSA Practice Project — Vehicle Auction System    ║");
        System.out.println("║       Covering CO1, CO2, CO3, CO4, CO5, CO6         ║");
        System.out.println("╚══════════════════════════════════════════════════════╝");

        boolean running = true;
        while (running) {
            System.out.println("\n━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━");
            System.out.println("  SELECT MODULE:");
            System.out.println("━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━");
            System.out.println("  [1] CO1 — Searching & Sorting");
            System.out.println("  [2] CO2 — Arrays & Linked Lists");
            System.out.println("  [3] CO3 — Stacks, Queues & Heaps");
            System.out.println("  [4] CO4 — Hash Tables & Collections");
            System.out.println("  [5] Run ALL Modules (Full Demo)");
            System.out.println("  [0] Exit");
            System.out.println("━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━");
            System.out.print("  Enter choice: ");

            int choice = -1;
            try { choice = Integer.parseInt(sc.nextLine().trim()); }
            catch (Exception e) { System.out.println("  Invalid input.\n"); continue; }

            switch (choice) {
                case 1 -> runCO1();
                case 2 -> runCO2();
                case 3 -> runCO3();
                case 4 -> runCO4();
                case 5 -> { runCO1(); runCO2(); runCO3(); runCO4(); }
                case 0 -> { System.out.println("\n  Goodbye! Happy Coding.\n"); running = false; }
                default -> System.out.println("  Invalid choice. Try again.\n");
            } 
        }
        sc.close();
    }


    // ════════════════════════════════════════════════════════
    //  CO1 — SEARCHING & SORTING
    // ════════════════════════════════════════════════════════

    static int[]    CO1_prices = {850000, 150000, 3500000, 65000, 1800000,
                                  1200000, 450000, 2800000, 95000, 550000};
    static String[] CO1_names  = {
        "Mahindra Thar", "RE Classic 350", "Mercedes C-Class",
        "Honda Activa", "Mahindra Scorpio N",
        "TATA LPT Truck", "Maruti Ertiga",
        "BharatBenz Tipper", "TVS Apache", "Maruti Swift"
    };

    static void runCO1() {
        System.out.println("\n╔══════════════════════════════════════════════════╗");
        System.out.println("║    CO1 — Searching & Sorting Algorithms          ║");
        System.out.println("╚══════════════════════════════════════════════════╝");
        System.out.print("  Vehicle Prices: ");
        for (int p : CO1_prices) System.out.print("Rs." + p/1000 + "K ");
        System.out.println();

        // 1. Linear Search
        System.out.println("\n[1] LINEAR SEARCH  O(n)");
        System.out.println("  Target: RE Classic 350");
        int idx = linearSearch(CO1_names, "RE Classic 350");
        System.out.println("  Found at index: " + idx + " -> Price: Rs." + (idx >= 0 ? CO1_prices[idx] : "N/A"));
        System.out.println("  Target: Toyota Fortuner (not in list)");
        idx = linearSearch(CO1_names, "Toyota Fortuner");
        System.out.println("  Result: " + (idx == -1 ? "Not Found" : "Found at " + idx));

        // 2. Binary Search
        System.out.println("\n[2] BINARY SEARCH  O(log n)");
        int[] sortedPrices = CO1_prices.clone();
        mergeSort(sortedPrices, 0, sortedPrices.length - 1);
        printArray("  Sorted Prices", sortedPrices);
        int target = 1200000;
        int bIdx = binarySearch(sortedPrices, target);
        System.out.println("  Searching Rs." + target + " -> " + (bIdx >= 0 ? "Found at index " + bIdx : "Not found"));

        // 3. Bubble Sort
        System.out.println("\n[3] BUBBLE SORT  O(n^2)");
        int[] a1 = CO1_prices.clone(); bubbleSort(a1);
        printArray("  Sorted (Asc)", a1);

        // 4. Selection Sort
        System.out.println("\n[4] SELECTION SORT  O(n^2)");
        int[] a2 = CO1_prices.clone(); selectionSort(a2);
        printArray("  Sorted (Asc)", a2);

        // 5. Insertion Sort
        System.out.println("\n[5] INSERTION SORT  O(n^2)");
        int[] a3 = CO1_prices.clone(); insertionSort(a3);
        printArray("  Sorted (Asc)", a3);

        // 6. Merge Sort
        System.out.println("\n[6] MERGE SORT  O(n log n)");
        int[] a4 = CO1_prices.clone(); mergeSort(a4, 0, a4.length - 1);
        printArray("  Sorted (Asc)", a4);

        // 7. Quick Sort
        System.out.println("\n[7] QUICK SORT  O(n log n) avg");
        int[] a5 = CO1_prices.clone(); quickSort(a5, 0, a5.length - 1);
        printArray("  Sorted (Asc)", a5);

        System.out.println("\n  +------------------+-------------+--------------+");
        System.out.println("  | Algorithm        | Time        | Space        |");
        System.out.println("  +------------------+-------------+--------------+");
        System.out.println("  | Linear Search    | O(n)        | O(1)         |");
        System.out.println("  | Binary Search    | O(log n)    | O(1)         |");
        System.out.println("  | Bubble Sort      | O(n^2)      | O(1)         |");
        System.out.println("  | Selection Sort   | O(n^2)      | O(1)         |");
        System.out.println("  | Insertion Sort   | O(n^2)      | O(1)         |");
        System.out.println("  | Merge Sort       | O(n log n)  | O(n)         |");
        System.out.println("  | Quick Sort       | O(n log n)  | O(log n)     |");
        System.out.println("  +------------------+-------------+--------------+");
        System.out.println("\n  CO1 Complete.");
    }

    // --- Searching ---
    static int linearSearch(String[] arr, String key) {
        for (int i = 0; i < arr.length; i++)
            if (arr[i].equalsIgnoreCase(key)) return i;
        return -1;
    }

    static int binarySearch(int[] arr, int key) {
        int lo = 0, hi = arr.length - 1;
        while (lo <= hi) {
            int mid = lo + (hi - lo) / 2;
            if (arr[mid] == key) return mid;
            else if (arr[mid] < key) lo = mid + 1;
            else hi = mid - 1;
        }
        return -1;
    }

    // --- Sorting ---
    static void bubbleSort(int[] arr) {
        int n = arr.length;
        for (int i = 0; i < n - 1; i++) {
            boolean swapped = false;
            for (int j = 0; j < n - i - 1; j++) {
                if (arr[j] > arr[j+1]) {
                    int t = arr[j]; arr[j] = arr[j+1]; arr[j+1] = t;
                    swapped = true;
                }
            }
            if (!swapped) break;
        }
    }

    static void selectionSort(int[] arr) {
        int n = arr.length;
        for (int i = 0; i < n - 1; i++) {
            int minIdx = i;
            for (int j = i+1; j < n; j++)
                if (arr[j] < arr[minIdx]) minIdx = j;
            int t = arr[minIdx]; arr[minIdx] = arr[i]; arr[i] = t;
        }
    }

    static void insertionSort(int[] arr) {
        int n = arr.length;
        for (int i = 1; i < n; i++) {
            int key = arr[i], j = i - 1;
            while (j >= 0 && arr[j] > key) { arr[j+1] = arr[j]; j--; }
            arr[j+1] = key;
        }
    }

    static void mergeSort(int[] arr, int l, int r) {
        if (l < r) {
            int m = l + (r - l) / 2;
            mergeSort(arr, l, m);
            mergeSort(arr, m+1, r);
            merge(arr, l, m, r);
        }
    }

    static void merge(int[] arr, int l, int m, int r) {
        int n1 = m-l+1, n2 = r-m;
        int[] L = new int[n1], R = new int[n2];
        System.arraycopy(arr, l, L, 0, n1);
        System.arraycopy(arr, m+1, R, 0, n2);
        int i = 0, j = 0, k = l;
        while (i < n1 && j < n2) arr[k++] = (L[i] <= R[j]) ? L[i++] : R[j++];
        while (i < n1) arr[k++] = L[i++];
        while (j < n2) arr[k++] = R[j++];
    }

    static void quickSort(int[] arr, int lo, int hi) {
        if (lo < hi) {
            int pi = partition(arr, lo, hi);
            quickSort(arr, lo, pi-1);
            quickSort(arr, pi+1, hi);
        }
    }

    static int partition(int[] arr, int lo, int hi) {
        int pivot = arr[hi], i = lo - 1;
        for (int j = lo; j < hi; j++) {
            if (arr[j] <= pivot) { i++; int t = arr[i]; arr[i] = arr[j]; arr[j] = t; }
        }
        int t = arr[i+1]; arr[i+1] = arr[hi]; arr[hi] = t;
        return i + 1;
    }

    static void printArray(String label, int[] arr) {
        System.out.print(label + ": [ ");
        for (int x : arr) System.out.print("Rs." + x/1000 + "K ");
        System.out.println("]");
    }


    // ════════════════════════════════════════════════════════
    //  CO2 — LINKED LISTS
    // ════════════════════════════════════════════════════════

    // Vehicle Node (used by all list types)
    static class VehicleNode {
        int id; String name; int price;
        VehicleNode next, prev;
        VehicleNode(int id, String name, int price) {
            this.id = id; this.name = name; this.price = price;
        }
        public String toString() {
            return String.format("[ID:%d | %-22s | Rs.%,d]", id, name, price);
        }
    }

    // --- Singly Linked List ---
    static class SinglyLinkedList {
        VehicleNode head; int size = 0;

        void insertEnd(int id, String name, int price) {   // O(n)
            VehicleNode node = new VehicleNode(id, name, price);
            if (head == null) { head = node; }
            else { VehicleNode cur = head; while (cur.next != null) cur = cur.next; cur.next = node; }
            size++;
        }

        void insertFront(int id, String name, int price) { // O(1)
            VehicleNode node = new VehicleNode(id, name, price);
            node.next = head; head = node; size++;
        }

        boolean deleteById(int id) {                        // O(n)
            if (head == null) return false;
            if (head.id == id) { head = head.next; size--; return true; }
            VehicleNode cur = head;
            while (cur.next != null) {
                if (cur.next.id == id) { cur.next = cur.next.next; size--; return true; }
                cur = cur.next;
            }
            return false;
        }

        VehicleNode search(String name) {                   // O(n)
            VehicleNode cur = head;
            while (cur != null) { if (cur.name.equalsIgnoreCase(name)) return cur; cur = cur.next; }
            return null;
        }

        void traverse(String label) {
            System.out.println("\n  " + label);
            VehicleNode cur = head; int i = 1;
            while (cur != null) { System.out.println("  " + i++ + ". " + cur); cur = cur.next; }
            System.out.println("  Total: " + size + " nodes");
        }

        void reverse() {                                    // O(n)
            VehicleNode prev = null, cur = head;
            while (cur != null) { VehicleNode nxt = cur.next; cur.next = prev; prev = cur; cur = nxt; }
            head = prev;
        }

        boolean hasCycle() {                                // Floyd's O(n)
            VehicleNode slow = head, fast = head;
            while (fast != null && fast.next != null) {
                slow = slow.next; fast = fast.next.next;
                if (slow == fast) return true;
            }
            return false;
        }

        void createCycle(int targetId) {
            VehicleNode target = null, tail = null, cur = head;
            while (cur != null) {
                if (cur.id == targetId) target = cur;
                if (cur.next == null) tail = cur;
                cur = cur.next;
            }
            if (tail != null && target != null) tail.next = target;
        }
    }

    // --- Doubly Linked List ---
    static class DoublyLinkedList {
        VehicleNode head, tail; int size = 0;

        void insertEnd(int id, String name, int price) {   // O(1)
            VehicleNode node = new VehicleNode(id, name, price);
            if (tail == null) { head = tail = node; }
            else { tail.next = node; node.prev = tail; tail = node; }
            size++;
        }

        boolean deleteById(int id) {                        // O(n)
            VehicleNode cur = head;
            while (cur != null) {
                if (cur.id == id) {
                    if (cur.prev != null) cur.prev.next = cur.next; else head = cur.next;
                    if (cur.next != null) cur.next.prev = cur.prev; else tail = cur.prev;
                    size--; return true;
                }
                cur = cur.next;
            }
            return false;
        }

        void traverseForward() {
            System.out.println("\n  Doubly List -- Forward:");
            VehicleNode cur = head; int i = 1;
            while (cur != null) { System.out.println("  " + i++ + ". " + cur); cur = cur.next; }
        }

        void traverseBackward() {
            System.out.println("\n  Doubly List -- Backward:");
            VehicleNode cur = tail; int i = 1;
            while (cur != null) { System.out.println("  " + i++ + ". " + cur); cur = cur.prev; }
        }
    }

    // --- Circular Linked List ---
    static class CircularLinkedList {
        VehicleNode head; int size = 0;

        void insert(int id, String name, int price) {
            VehicleNode node = new VehicleNode(id, name, price);
            if (head == null) { head = node; node.next = head; }
            else {
                VehicleNode cur = head;
                while (cur.next != head) cur = cur.next;
                cur.next = node; node.next = head;
            }
            size++;
        }

        void traverse() {
            if (head == null) return;
            System.out.println("\n  Circular Linked List:");
            VehicleNode cur = head; int i = 1;
            do {
                System.out.println("  " + i++ + ". " + cur + (cur.next == head ? " <-- loops to HEAD" : ""));
                cur = cur.next;
            } while (cur != head);
        }
    }

    static void runCO2() {
        System.out.println("\n╔══════════════════════════════════════════════════╗");
        System.out.println("║    CO2 — Arrays & Linked Lists (ADTs)            ║");
        System.out.println("╚══════════════════════════════════════════════════╝");

        // Singly LL
        System.out.println("\n>> SINGLY LINKED LIST");
        SinglyLinkedList sll = new SinglyLinkedList();
        sll.insertEnd(1,  "Maruti Swift",        550000);
        sll.insertEnd(2,  "Mahindra Scorpio N", 1800000);
        sll.insertEnd(3,  "Tata Nexon EV",      1500000);
        sll.insertEnd(4,  "RE Classic 350",       150000);
        sll.insertEnd(5,  "Honda Activa 6G",       65000);
        sll.insertFront(0,"Mercedes-Benz C",    3500000);
        sll.traverse("After Insertions:");

        System.out.println("\n  Searching: Tata Nexon EV");
        VehicleNode found = sll.search("Tata Nexon EV");
        System.out.println("  " + (found != null ? "Found: " + found : "Not found"));

        System.out.println("\n  Deleting ID=4 (RE Classic 350)...");
        System.out.println("  Status: " + (sll.deleteById(4) ? "Deleted OK" : "Not found"));
        sll.traverse("After Deletion:");

        System.out.println("\n  Reversing list...");
        sll.reverse();
        sll.traverse("After Reverse:");

        System.out.println("\n  Floyd's Cycle Detection:");
        System.out.println("  Cycle exists? --> " + sll.hasCycle());
        sll.createCycle(1);
        System.out.println("  After making cycle --> " + sll.hasCycle());

        // Doubly LL
        System.out.println("\n>> DOUBLY LINKED LIST");
        DoublyLinkedList dll = new DoublyLinkedList();
        dll.insertEnd(1, "Toyota Fortuner",  3500000);
        dll.insertEnd(2, "Hyundai Creta",    1200000);
        dll.insertEnd(3, "TVS Apache RTR",    110000);
        dll.insertEnd(4, "TATA LPT Truck",  1800000);
        dll.traverseForward();
        dll.traverseBackward();
        System.out.println("\n  Deleting ID=2 (Hyundai Creta)...");
        dll.deleteById(2);
        dll.traverseForward();

        // Circular LL
        System.out.println("\n>> CIRCULAR LINKED LIST");
        CircularLinkedList cll = new CircularLinkedList();
        cll.insert(1, "Maruti Ertiga",    750000);
        cll.insert(2, "Bajaj Pulsar",     100000);
        cll.insert(3, "Eicher Pro Truck",1800000);
        cll.traverse();

        System.out.println("\n  CO2 Complete.");
    }


    // ════════════════════════════════════════════════════════
    //  CO3 — STACKS, QUEUES, HEAPS
    // ════════════════════════════════════════════════════════

    // --- Stack ---
    static class BidStack {
        static class BidRecord {
            String vehicle; int amount;
            BidRecord(String v, int a) { vehicle = v; amount = a; }
            public String toString() { return String.format("%-22s -> Rs.%,d", vehicle, amount); }
        }
        private BidRecord[] stack; private int top = -1; private int capacity;
        BidStack(int cap) { capacity = cap; stack = new BidRecord[cap]; }

        boolean push(String v, int amt) {
            if (top == capacity - 1) { System.out.println("  Stack Overflow!"); return false; }
            stack[++top] = new BidRecord(v, amt); return true;
        }
        BidRecord pop() {
            if (top == -1) { System.out.println("  Stack Underflow!"); return null; }
            return stack[top--];
        }
        BidRecord peek() { return top == -1 ? null : stack[top]; }
        boolean isEmpty() { return top == -1; }
        void display() {
            System.out.println("  Stack (top to bottom):");
            for (int i = top; i >= 0; i--) System.out.println("  " + (top-i+1) + ". " + stack[i]);
        }
    }

    // --- Queue ---
    static class BuyerQueue {
        private String[] queue; private int front = 0, rear = -1, size = 0, capacity;
        BuyerQueue(int cap) { capacity = cap; queue = new String[cap]; }

        boolean enqueue(String buyer) {
            if (size == capacity) { System.out.println("  Queue Full!"); return false; }
            rear = (rear + 1) % capacity; queue[rear] = buyer; size++; return true;
        }
        String dequeue() {
            if (size == 0) { System.out.println("  Queue Empty!"); return null; }
            String val = queue[front]; front = (front + 1) % capacity; size--; return val;
        }
        String peek() { return size == 0 ? null : queue[front]; }
        void display() {
            System.out.print("  Queue [front->rear]: ");
            int cur = front;
            for (int i = 0; i < size; i++) { System.out.print(queue[(front + i) % capacity] + " | "); }
            System.out.println();
        }
    }

    // --- Min Heap ---
    static class MinHeap {
        private int[] heap; private String[] names; private int size, capacity;
        MinHeap(int cap) { capacity = cap; heap = new int[cap]; names = new String[cap]; size = 0; }

        void insert(int price, String name) {            // O(log n)
            if (size == capacity) return;
            heap[size] = price; names[size] = name;
            int i = size++;
            while (i > 0 && heap[i] < heap[(i-1)/2]) {
                int p = (i-1)/2;
                int tmp = heap[i]; heap[i] = heap[p]; heap[p] = tmp;
                String ts = names[i]; names[i] = names[p]; names[p] = ts;
                i = p;
            }
        }

        void extractMin() {                               // O(log n)
            if (size == 0) return;
            System.out.println("  Cheapest: Rs." + String.format("%,d", heap[0]) + " -- " + names[0]);
            heap[0] = heap[--size]; names[0] = names[size];
            int i = 0;
            while (true) {
                int l = 2*i+1, r = 2*i+2, s = i;
                if (l < size && heap[l] < heap[s]) s = l;
                if (r < size && heap[r] < heap[s]) s = r;
                if (s == i) break;
                int t = heap[i]; heap[i] = heap[s]; heap[s] = t;
                String ts = names[i]; names[i] = names[s]; names[s] = ts;
                i = s;
            }
        }

        void display() {
            System.out.print("  Heap: [ ");
            for (int i = 0; i < size; i++) System.out.print("Rs." + heap[i]/1000 + "K ");
            System.out.println("]  Min=" + names[0] + " Rs." + String.format("%,d", heap[0]));
        }
    }

    // --- AuctionBid for PriorityQueue ---
    static class AuctionBid implements Comparable<AuctionBid> {
        String bidder; int amount;
        AuctionBid(String b, int a) { bidder = b; amount = a; }
        public int compareTo(AuctionBid o) { return Integer.compare(o.amount, this.amount); } // max-heap
        public String toString() { return String.format("%-12s -> Rs.%,d", bidder, amount); }
    }

    static void runCO3() {
        System.out.println("\n╔══════════════════════════════════════════════════╗");
        System.out.println("║    CO3 — Stacks, Queues, Heaps                   ║");
        System.out.println("╚══════════════════════════════════════════════════╝");

        // Stack
        System.out.println("\n>> STACK -- Bid Undo History (LIFO)");
        BidStack stack = new BidStack(5);
        stack.push("Maruti Swift",       600000);
        stack.push("Tata Nexon EV",     1550000);
        stack.push("Mahindra Scorpio",  1900000);
        stack.push("Mercedes-Benz C",   3600000);
        stack.display();
        System.out.println("  Top: " + stack.peek());
        System.out.println("\n  Undoing last 2 bids:");
        System.out.println("  Undone: " + stack.pop());
        System.out.println("  Undone: " + stack.pop());
        stack.display();

        // Queue
        System.out.println("\n>> QUEUE -- Buyer Waiting List (FIFO)");
        BuyerQueue q = new BuyerQueue(6);
        q.enqueue("Arjun Sharma");
        q.enqueue("Priya Reddy");
        q.enqueue("Mohammed Ali");
        q.enqueue("Sneha Rao");
        q.display();
        System.out.println("  Served: " + q.dequeue());
        System.out.println("  Served: " + q.dequeue());
        System.out.println("  Next: " + q.peek());
        q.enqueue("Kiran Patel");
        q.display();

        // Deque
        System.out.println("\n>> DEQUE -- VIP Priority Lane");
        Deque<String> deque = new ArrayDeque<>();
        deque.addLast("Regular: Raj Kumar");
        deque.addLast("Regular: Meena Iyer");
        deque.addFirst("VIP: Diamond Member");
        deque.addFirst("VIP: CEO Client");
        System.out.println("  Deque: " + deque);
        System.out.println("  Poll front: " + deque.pollFirst());
        System.out.println("  Poll back:  " + deque.pollLast());
        System.out.println("  Remaining:  " + deque);

        // Min Heap
        System.out.println("\n>> MIN-HEAP -- Cheapest Vehicle  O(log n) insert");
        MinHeap mh = new MinHeap(10);
        mh.insert(850000,  "Mahindra Thar");
        mh.insert(65000,   "Honda Activa");
        mh.insert(1800000, "Scorpio N");
        mh.insert(150000,  "RE Classic");
        mh.insert(3500000, "Mercedes C");
        mh.insert(95000,   "TVS Apache");
        mh.display();
        System.out.println("  Extracting 3 cheapest:");
        mh.extractMin(); mh.extractMin(); mh.extractMin();

        // Priority Queue (Max-Heap)
        System.out.println("\n>> PRIORITY QUEUE (MAX-HEAP) -- Highest Bidder First");
        PriorityQueue<AuctionBid> pq = new PriorityQueue<>();
        pq.add(new AuctionBid("Arjun",  950000));
        pq.add(new AuctionBid("Priya", 1750000));
        pq.add(new AuctionBid("Kiran",  620000));
        pq.add(new AuctionBid("Sneha", 2100000));
        pq.add(new AuctionBid("Rahul", 1100000));
        System.out.println("  Processing bids (highest first):");
        int rank = 1;
        while (!pq.isEmpty()) System.out.println("  #" + rank++ + " " + pq.poll());

        System.out.println("\n  +---------------------+------------+----------+");
        System.out.println("  | Structure           | Insert     | Remove   |");
        System.out.println("  +---------------------+------------+----------+");
        System.out.println("  | Stack               | O(1)       | O(1)     |");
        System.out.println("  | Queue               | O(1)       | O(1)     |");
        System.out.println("  | Deque               | O(1)       | O(1)     |");
        System.out.println("  | Min/Max Heap        | O(log n)   | O(log n) |");
        System.out.println("  | Priority Queue      | O(log n)   | O(log n) |");
        System.out.println("  +---------------------+------------+----------+");
        System.out.println("\n  CO3 Complete.");
    }


    // ════════════════════════════════════════════════════════
    //  CO4 — HASH TABLES & JAVA COLLECTIONS
    // ════════════════════════════════════════════════════════

    static class Vehicle {
        String regNo, name; int price, wheels;
        Vehicle(String r, String n, int p, int w) { regNo=r; name=n; price=p; wheels=w; }
        public String toString() {
            return String.format("[%s] %-22s Rs.%,7d  %dW", regNo, name, price, wheels);
        }
    }

    // Hash Table with Chaining
    static class ChainHashTable {
        static class Entry { String key; Vehicle val; Entry next; Entry(String k, Vehicle v){key=k;val=v;} }
        private Entry[] table; private int capacity, size=0;
        ChainHashTable(int cap) { capacity=cap; table=new Entry[cap]; }

        private int hash(String key) {
            int h = 0;
            for (char c : key.toCharArray()) h = (h * 31 + c) % capacity;
            return Math.abs(h);
        }
        void put(String key, Vehicle val) {               // avg O(1)
            int idx = hash(key);
            Entry cur = table[idx];
            while (cur != null) { if (cur.key.equals(key)){cur.val=val;return;} cur=cur.next; }
            Entry e = new Entry(key, val); e.next = table[idx]; table[idx] = e; size++;
        }
        Vehicle get(String key) {                          // avg O(1)
            Entry cur = table[hash(key)];
            while (cur != null) { if (cur.key.equals(key)) return cur.val; cur=cur.next; }
            return null;
        }
        boolean remove(String key) {                       // avg O(1)
            int idx = hash(key); Entry cur=table[idx], prev=null;
            while (cur != null) {
                if (cur.key.equals(key)) {
                    if (prev==null) table[idx]=cur.next; else prev.next=cur.next;
                    size--; return true;
                }
                prev=cur; cur=cur.next;
            }
            return false;
        }
        void display() {
            System.out.println("  Hash Table (chaining) capacity=" + capacity + " size=" + size + ":");
            for (int i = 0; i < capacity; i++) {
                if (table[i] != null) {
                    System.out.print("  Bucket[" + String.format("%2d",i) + "]: ");
                    Entry cur = table[i];
                    while (cur != null) { System.out.print(cur.key + " -> "); cur=cur.next; }
                    System.out.println("null");
                }
            }
        }
    }

    // Open Addressing (Linear Probing)
    static class OpenHashTable {
        private String[] keys; private int[] prices; private boolean[] deleted;
        private int capacity, size=0;
        OpenHashTable(int cap) { capacity=cap; keys=new String[cap]; prices=new int[cap]; deleted=new boolean[cap]; }

        private int hash(String k) { int h=0; for(char c:k.toCharArray()) h=(h*31+c)%capacity; return Math.abs(h); }

        void put(String key, int price) {                  // avg O(1)
            if (size >= capacity) return;
            int idx = hash(key);
            while (keys[idx]!=null && !deleted[idx] && !keys[idx].equals(key)) idx=(idx+1)%capacity;
            if (keys[idx]==null || deleted[idx]) size++;
            keys[idx]=key; prices[idx]=price; deleted[idx]=false;
        }
        int get(String key) {                              // avg O(1)
            int idx=hash(key), start=idx;
            while (keys[idx]!=null) {
                if (!deleted[idx] && keys[idx].equals(key)) return prices[idx];
                idx=(idx+1)%capacity; if(idx==start) break;
            }
            return -1;
        }
        boolean remove(String key) {                       // lazy delete O(1)
            int idx=hash(key), start=idx;
            while (keys[idx]!=null) {
                if (!deleted[idx] && keys[idx].equals(key)) { deleted[idx]=true; size--; return true; }
                idx=(idx+1)%capacity; if(idx==start) break;
            }
            return false;
        }
        void display() {
            System.out.println("  Open Addressing (linear probe) capacity=" + capacity + ":");
            for (int i=0;i<capacity;i++) {
                if (keys[i]!=null && !deleted[i])
                    System.out.printf("  Slot[%2d]: %-12s -> Rs.%,d%n", i, keys[i], prices[i]);
                else if (deleted[i])
                    System.out.printf("  Slot[%2d]: <deleted>%n", i);
            }
        }
    }

    static void runCO4() {
        System.out.println("\n╔══════════════════════════════════════════════════╗");
        System.out.println("║    CO4 — Hash Tables & Java Collections          ║");
        System.out.println("╚══════════════════════════════════════════════════╝");

        // Chaining Hash Table
        System.out.println("\n>> HASH TABLE WITH CHAINING -- Vehicle Registry");
        ChainHashTable cht = new ChainHashTable(7);
        cht.put("TN01AB1234", new Vehicle("TN01AB1234", "Maruti Swift",        550000, 4));
        cht.put("MH02CD5678", new Vehicle("MH02CD5678", "Mahindra Scorpio N", 1800000, 4));
        cht.put("KA03EF9012", new Vehicle("KA03EF9012", "RE Classic 350",      150000, 2));
        cht.put("DL04GH3456", new Vehicle("DL04GH3456", "Honda Activa 6G",      65000, 2));
        cht.put("TS05IJ7890", new Vehicle("TS05IJ7890", "Tata Nexon EV",      1500000, 4));
        cht.display();

        System.out.println("\n  Lookup TN01AB1234:");
        Vehicle v = cht.get("TN01AB1234");
        System.out.println("  " + (v != null ? v : "Not found"));
        System.out.println("  Lookup UNKNOWN: " + (cht.get("UNKNOWN") != null ? "Found" : "Not found"));

        System.out.println("  Delete KA03EF9012: " + cht.remove("KA03EF9012"));
        System.out.println("  After delete lookup: " + (cht.get("KA03EF9012") != null ? "Found" : "Not found"));

        // Open Addressing
        System.out.println("\n>> OPEN ADDRESSING (Linear Probing)");
        OpenHashTable oat = new OpenHashTable(11);
        oat.put("Swift",  550000); oat.put("Scorpio", 1800000);
        oat.put("Activa",  65000); oat.put("Nexon",  1500000); oat.put("Apache", 95000);
        oat.display();
        System.out.println("\n  Search Nexon: Rs." + String.format("%,d", oat.get("Nexon")));
        System.out.println("  Search Fortuner: " + (oat.get("Fortuner")==-1 ? "Not found" : "Found"));
        System.out.println("  Delete Activa: " + oat.remove("Activa"));
        oat.display();

        // Java HashMap
        System.out.println("\n>> JAVA HashMap -- O(1) avg");
        Map<String,Integer> bidMap = new HashMap<>();
        bidMap.put("Arjun", 1200000); bidMap.put("Priya", 1850000);
        bidMap.put("Kiran",  600000); bidMap.put("Sneha", 2100000);
        System.out.println("  All bids: " + bidMap);
        bidMap.put("Priya", 2200000);
        System.out.println("  Priya updated: Rs." + String.format("%,d", bidMap.get("Priya")));

        // Java LinkedHashMap
        System.out.println("\n>> JAVA LinkedHashMap -- Insertion Order Preserved");
        Map<String,Integer> lhm = new LinkedHashMap<>();
        lhm.put("Lot-1", 550000); lhm.put("Lot-2", 150000);
        lhm.put("Lot-3", 1800000); lhm.put("Lot-4", 65000);
        System.out.println("  Ordered: " + lhm);

        // Java TreeMap
        System.out.println("\n>> JAVA TreeMap -- Sorted by Key");
        TreeMap<Integer,String> tm = new TreeMap<>();
        tm.put(550000,"Maruti Swift"); tm.put(3500000,"Mercedes C");
        tm.put(65000,"Honda Activa"); tm.put(1800000,"Scorpio N"); tm.put(150000,"RE Classic");
        System.out.println("  Vehicles sorted by price:");
        tm.forEach((price,name) -> System.out.printf("  Rs.%,8d -> %s%n", price, name));
        System.out.println("  Cheapest : Rs." + String.format("%,d",tm.firstKey()) + " -- " + tm.firstEntry().getValue());
        System.out.println("  Costliest: Rs." + String.format("%,d",tm.lastKey())  + " -- " + tm.lastEntry().getValue());

        // Java Collections
        System.out.println("\n>> JAVA Collections -- List, Sort, Shuffle");
        List<String> list = new ArrayList<>(Arrays.asList(
            "Maruti Swift","Tata Nexon EV","Honda Activa","Scorpio N","TVS Apache","Mercedes C"));
        System.out.println("  Original: " + list);
        Collections.sort(list);
        System.out.println("  Sorted:   " + list);
        Collections.shuffle(list);
        System.out.println("  Shuffled: " + list);

        System.out.println("\n  +------------------------+-----------+------------+");
        System.out.println("  | Structure              | Avg Case  | Worst Case |");
        System.out.println("  +------------------------+-----------+------------+");
        System.out.println("  | Chaining Hash (get)    | O(1)      | O(n)       |");
        System.out.println("  | Open Addr Hash (get)   | O(1)      | O(n)       |");
        System.out.println("  | Java HashMap           | O(1)      | O(n)       |");
        System.out.println("  | Java TreeMap           | O(log n)  | O(log n)   |");
        System.out.println("  | ArrayList (get)        | O(1)      | O(1)       |");
        System.out.println("  +------------------------+-----------+------------+");
        System.out.println("\n  CO4 Complete.");
    }
}
