import java.util.Arrays;

/**
 * Array based storage for Resumes
 */
public class ArrayStorage {
    Resume[] storage = new Resume[10000];
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
        int resumeID = 0;
        for (int i = 0; i < size; i++) {
            if (storage[i].toString().equals(uuid)) {
                resumeID = i;
                break;
            }
        }
        System.arraycopy(storage, resumeID + 1, storage, resumeID, size);
        size--;
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
        size = 0;
    }

    /**
     * @return array, contains only Resumes in storage (without null)
     */
    Resume[] getAll() {
        return Arrays.copyOfRange(storage, 0, size);
    }
}