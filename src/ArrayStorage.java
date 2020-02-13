import java.util.Arrays;

/**
 * Array based storage for Resumes
 */
public class ArrayStorage {
    Resume[] storage = new Resume[4];
    private int size = size();

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
        Resume[] rightPart = Arrays.copyOfRange(storage, index + 1, size);
        if (rightPart.length != 0) {
            System.arraycopy(rightPart, 0, storage, index, rightPart.length);
        }
        storage[size - 1] = null;
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