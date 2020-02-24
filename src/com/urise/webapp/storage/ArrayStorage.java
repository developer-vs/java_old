package com.urise.webapp.storage;

import com.urise.webapp.model.Resume;

import java.util.Arrays;

/**
 * Array based storage for Resumes
 */
public class ArrayStorage {
    private Resume[] storage = new Resume[2];
    private int size;

    public void save(Resume resume) {
        if (size < storage.length) {
            if (get(resume.getUuid()) == null) {
                storage[size] = resume;
                size++;
                System.out.println("\nThe resume has been saved in the database.");
            } else {
                System.out.println("\nThe resume already exists in the database.");
            }
        } else {
            System.out.println("\nThe storage is FULL, the resume cannot be saved in the database.");
        }
    }

    public void update(Resume resume) {
        if (getIndex(resume.getUuid()) != -1) {
            delete(resume.getUuid());
            save(resume);
            System.out.println("\nThe resume has been updated.");
        }
        System.out.println("\nThe resume does not exist in the database.");
    }

    public Resume get(String uuid) {
        int index = getIndex(uuid);

        if (index != -1) {
            return storage[index];
        } else {
            System.out.println("\nThe resume does not exist in the database.");
        }
        return null;
    }

    private int getIndex(String uuid) {
        for (int i = 0; i < size; i++) {
            if (storage[i].toString().equals(uuid)) {
                return i;
            }
        }
        return -1;
    }

    public void delete(String uuid) {
        int index = getIndex(uuid);

        if (index != -1) {
            System.arraycopy(storage, index + 1, storage, index, size - 1 - index);
            storage[size - 1] = null;
            size--;
            System.out.println("\nThe resume has been removed from the database.");
        } else {
            System.out.println("\nThe resume does not exist in the database.");
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