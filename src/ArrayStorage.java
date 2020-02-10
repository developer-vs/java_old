import java.util.Arrays;

/**
 * Array based storage for Resumes
 */
public class ArrayStorage {
    Resume[] storage = new Resume[10000];

    void save(Resume r) {
        storage[size()] = r;
    }

    Resume get(String uuid) {
        Resume resume = null;
        for(int i = 0; i < size(); i++) {
            if(storage[i].toString().equals(uuid)) {
                resume = storage[i];
                break;
            }
        }
        return resume;
    }

    void delete(String uuid) {
        int curSize = size();
        for(int i = 0; i < curSize; i++) {
            if(storage[i].toString().equals(uuid)) {
                storage[i] = null;
                break;
            }
        }
        for(int i = 0; i < curSize - 1; i++) {
            Resume temp = storage[i + 1];
            storage[i + 1] = storage[i];
            storage[i] = temp;
        }
    }

    int size() {
        int counter = 0;
        for (Resume resume : storage) {
            if (resume != null) {
                counter++;
            } else {
                break;
            }
        }
        return counter;
    }

    void clear() {
        Arrays.fill(storage, 0, size(), null);
    }

    /**
     * @return array, contains only Resumes in storage (without null)
     */
    Resume[] getAll() {
        return Arrays.copyOfRange(storage, 0, size());
    }
}