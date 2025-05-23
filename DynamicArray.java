import java.util.*;
class DA {
    private int[] arr;
    private int size;
    private int capacity = 8;
    DA() {
        this.arr = new int[capacity];
    }
    public void add(int val) {
        if (size == capacity) {
            expandArray();
        }
        arr[size++] = val;
    }
    private void expandArray() {
        capacity *= 2;
        arr = Arrays.copyOf(arr, capacity);
    }
    public void display() {
        for (int i = 0; i < size; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }
    public void insert(int pos, int val) {
        if (pos < 0 || pos > size) {
            System.out.println("Invalid position.");
            return;
        }
        if (size == capacity) {
            expandArray();
        }
        for (int i = size - 1; i >= pos; i--) {
            arr[i + 1] = arr[i];
        }
        arr[pos] = val;
        size++;
    }
    public void delete(int pos) {
        if (pos < 0 || pos >= size) {
            System.out.println("Invalid position.");
            return;
        }
        for (int i = pos; i < size - 1; i++) {
            arr[i] = arr[i + 1];
        }
        size--;
    }
    public void Search(int val){
        for(int i = 0;i<size;i++){
            if(arr[i] == val){
                System.out.println("Target fund");
                System.out.println("At index "+i);
            }
        }
    }
    public void getValue(int pos){
        if (pos < 0 || pos >= size) {
            System.out.println("Invalid position.");
            return ;
        }
        System.out.println(arr[pos]);
    }
    public void updateValue(int pos,int value){
        if (pos< 0 || pos >= size) {
            System.out.println("Invalid position.");
            return ;
        }
        arr[pos] = value;
        System.out.println("Value Succesfully updated");
    }
    public void sort(){
        Arrays.sort(arr, 0, size);
        System.out.println("Array sorted successfully.");
    }
}

public class DynamicArray {
    public static void main(String[] args) {
        int val, pos;
        DA d = new DA();
        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.println("************** Menu ******************");
            System.out.println("1. Insert Element");
            System.out.println("2. Display the array");
            System.out.println("3. Insert at specified position");
            System.out.println("4. Delete at specified position");
            System.out.println("5.Search Value");
            System.out.println("6.Get value");
            System.out.println("7.Update Value");
            System.out.println("8.Sort array(after adding all the values sort it)");
            System.out.println("9. Exit");
            System.out.print("Enter your choice: ");
            int choice = sc.nextInt();
            switch (choice) {
                case 1:
                    System.out.print("Enter the value: ");
                    val = sc.nextInt();
                    d.add(val);
                    break;
                case 2:
                    d.display();
                    break;
                case 3:
                    System.out.print("Enter the position: ");
                    pos = sc.nextInt();
                    System.out.print("Enter the value: ");
                    val = sc.nextInt();
                    d.insert(pos, val);
                    break;
                case 4:
                    System.out.print("Enter the position: ");
                    pos = sc.nextInt();
                    d.delete(pos);
                    break;
                case 5:
                    System.out.println("Enter the value to be Searched");
                    val = sc.nextInt();
                    d.Search(val);
                    break;
                case 6:
                    System.out.println("Enter the index value(index starts from '0')");
                    pos = sc.nextInt();
                    d.getValue(pos);
                    break;
                case 7:
                    System.out.println("Enter the index value top be updated ");
                    pos = sc.nextInt();
                    System.out.println("Enter the value");
                    val = sc.nextInt();
                    d.updateValue(pos,val);
                    break;
                case 8:
                    d.sort();
                    break;

                case 9:
                    System.exit(0);
                    break;
                default:
                    System.out.println("You have entered an invalid choice.");
            }
        }
    }
}
