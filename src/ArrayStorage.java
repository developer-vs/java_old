import java.util.Arrays;

/**
 * Array based storage for Resumes
 */
public class ArrayStorage {
    Resume[] storage = new Resume[3];
    private int size;

    void save(Resume r) {
        storage[size] = r;
        size++;
    }

    Resume get(String uuid) {
        for (int i = 0; i < size; i++) {
            if (storage[i].toString().equals(uuid)) {
                return storage[i];
            }
        }
        return null;
    }

    void delete(String uuid) {
        int index = 0;
        for (int i = 0; i < size; i++) {
            if (storage[i].toString().equals(uuid)) {
                index = i;
                break;
            }
        }

        //  [null, 1, 2]  - 2 length
//        System.out.println("storage.length: " + storage.length); // 3
//        System.out.println("storage.length: " + (storage.length-1)); // 2
//        System.out.println("storage.length: " + (storage.length-1-index)); // 2

        //  [0, null, 2]  - 1 length
//        System.out.println("storage.length: " + storage.length); // 3
//        System.out.println("storage.length: " + (storage.length-1)); // 2
//        System.out.println("storage.length: " + (storage.length-1-index)); // 1

//        [0, 1, null]  - 0 length
//        System.out.println("storage.length: " + storage.length); // 3
//        System.out.println("storage.length: " + (storage.length-1)); // 2
//        System.out.println("storage.length: " + (storage.length-1-index)); // 0

//        System.out.println("storage.length: " + (index+(storage.length-1-index-1))); // 1

        // [null, 1, 2]  - 1
        // [0, null, 2]  - 2
        // [0, 1, null]  - 2

//        storage.length - index  - 1
//                 3         0
//      (storage.length - storage.length) - (1 + index)
//             3       -        3         - (1  + 0)
//             3       -        3         - (1  + 1)
//             3       -        3         - (0  + 2)

//                       // [0, 1, null]        3 - 1 - 2         +   2
//                       // [null, 1, 2]        3 - 1 - 0         +   0
//                                              2 - 1 - 2         +   2
        System.arraycopy(storage, (storage.length-1-index+1) + index, storage, index, storage.length-1-index);
        System.out.println(Arrays.toString(storage));

        size--;
    }

    int size() {
        return size;
    }

    void clear() {
        Arrays.fill(storage, 0, size, null);
        size = 0;
    }

    /**
     * @return array, contains only Resumes in storage (without null)
     */
    Resume[] getAll() {
        return Arrays.copyOfRange(storage, 0, size);
    }
}