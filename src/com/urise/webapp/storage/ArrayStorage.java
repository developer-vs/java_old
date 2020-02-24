package com.urise.webapp.storage;

import com.urise.webapp.model.Resume;

import java.util.Arrays;

/**
 * Array based storage for Resumes
 */
public class ArrayStorage {
    private Resume[] storage = new Resume[1];
    private int size;
    
    public void save(Resume r) {
        try {
            storage[size] = r;
            size++;
        } catch (Exception e) {
            System.out.println("The storage is FULL, the resume can't be added to the database...");
            System.exit(1);
        }
    }
    
    public String update(Resume r) {
        if (get(r.getUuid()) != null) {
            delete(r.getUuid());
            save(r);
            return "has been updated.";
        }
        return "does not exist.";
    }
    
    public Resume get(String uuid) {
        for (int i = 0; i < size; i++) {
            if (storage[i].toString().equals(uuid)) {
                return storage[i];
            }
        }
        return null;
    }
    
    public void delete(String uuid) {
        if (get(uuid) != null) {
            int index = 0;
            for (int i = 0; i < size; i++) {
                if (storage[i].toString().equals(uuid)) {
                    index = i;
                    break;
                }
            }
            System.arraycopy(storage, index + 1, storage, index, size - 1 - index);
            storage[size - 1] = null;
            size--;
        } else {
            System.out.println("Resume does not exist.");
        }
    }
    
    public int size() {
        return size;
    }
    
    public void clear() {
        Arrays.fill(storage, 0, size, null);
        size = 0;
    }
    
    /**
     * @return array, contains only Resumes in storage (without null)
     */
    public Resume[] getAll() {
        return Arrays.copyOfRange(storage, 0, size);
    }
}