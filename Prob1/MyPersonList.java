package Prob1;

public class MyPersonList {
    private final int INITIAL_LENGTH = 4;
    private Person[] currentArray;
    private int numOfElements;

    public MyPersonList() {
        currentArray = new Person[INITIAL_LENGTH];
        numOfElements = 0;
    }

    public void add(Person p) {
        if (p == null) return;
        if (numOfElements == currentArray.length)
            resize();
        currentArray[numOfElements++] = p;
    }

    public Person get(int i) {
        if (i < 0 || i >= numOfElements) {
            return null;
        }
        return currentArray[i];
    }

    public void resize() {
        int len = currentArray.length;
        int newLen = 2 * len;
        Person[] newArray = new Person[newLen];
        System.arraycopy(currentArray, 0, newArray, 0, len);
        currentArray = newArray;
    }

    public void insert(Person p, int pos) {
        if (pos > numOfElements || pos < 0) return;
        if (numOfElements == currentArray.length) {
            resize();
        }
        Person[] temp = new Person[currentArray.length];
        System.arraycopy(currentArray, 0, temp, 0, pos);
        temp[pos] = p;
        System.arraycopy(currentArray, pos, temp, pos + 1, numOfElements - pos);
        currentArray = temp;
        ++numOfElements;
    }

    public boolean remove(String lastName) {
        if (numOfElements == 0) return false;
        int index = -1;
        for (int i = 0; i < numOfElements; ++i) {
            if (currentArray[i].getLast().equals(lastName)) {
                index = i;
                break;
            }
        }
        if (index == -1) return false;
        Person[] temp = new Person[currentArray.length];
        System.arraycopy(currentArray, 0, temp, 0, index);
        System.arraycopy(currentArray, index + 1, temp, index, numOfElements - index - 1);
        currentArray = temp;
        --numOfElements;
        return true;
    }

    @Override
    public String toString() {
        StringBuilder p = new StringBuilder();
        for (int i = 0; i < numOfElements; ++i) {
            p.append(currentArray[i].toString()).append(",\n");
        }
        return p.toString();
    }

    public int size() {
        return numOfElements;
    }

    public MyPersonList clone() {
        MyPersonList clonedList = new MyPersonList();
        for (int i = 0; i < numOfElements; i++) {
            clonedList.add(currentArray[i]); // This is a shallow copy, not creating new Person objects.
        }
        return clonedList;
    }

    public static void main(String[] args) {
        MyPersonList ob = new MyPersonList();
        ob.add(new Person("Smith", "John", 25));
        ob.add(new Person("Doe", "Jane", 30));
        ob.add(new Person("Black", "Jack", 35));
        ob.add(new Person("White", "Jill", 40));
        ob.add(new Person("Brown", "Jerry", 45));
        System.out.println(ob.get(0));
        System.out.println(ob.get(-2));
    }
}
