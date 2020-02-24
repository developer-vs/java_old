import com.urise.webapp.model.Resume;
import com.urise.webapp.storage.ArrayStorage;

/**
 * Test for your com.urise.webapp.storage.ArrayStorage implementation
 */
public class MainTestArrayStorage {
    static final ArrayStorage ARRAY_STORAGE = new ArrayStorage();

    public static void main(String[] args) {
        Resume r1 = new Resume();
        r1.setUuid("uuid1");
        Resume r2 = new Resume();
        r2.setUuid("uuid2");
        Resume r3 = new Resume();
        r3.setUuid("uuid3");

        System.out.println("Creating three resumes...");
        ARRAY_STORAGE.save(r1);
        ARRAY_STORAGE.save(r2);
        ARRAY_STORAGE.save(r3);

        System.out.println("Get resume with \"" + r1.getUuid() + "\": " + ARRAY_STORAGE.get(r1.getUuid()));
        System.out.println("Size of storage: " + ARRAY_STORAGE.size());
        System.out.println("Get resume with \"dummy\": " + ARRAY_STORAGE.get("dummy"));
        printAll();

        System.out.println("\nDeleting the resume...");
        ARRAY_STORAGE.delete(r1.getUuid());
        printAll();

        System.out.println("\nTrying to update resume with \"uuid2\" to \"uuid22\"...");
        r2.setUuid("uuid22");
        ARRAY_STORAGE.update(r2);
        printAll();

        System.out.println("\nTrying to update resume with \"uuid3\" to \"uuid33\"...");
        r3.setUuid("uuid33");
        ARRAY_STORAGE.update(r3);
        printAll();

        System.out.println("\nTrying to update resume with \"\"uuid1\" to \"uuid7\"...");
        r1.setUuid("uuid7");
        ARRAY_STORAGE.update(r1);
        printAll();

        System.out.print("\nTrying to clear the database...");
        ARRAY_STORAGE.clear();
        printAll();

        System.out.println("Size: " + ARRAY_STORAGE.size());
    }

    static void printAll() {
        System.out.println("\nGet All");
        for (Resume r : ARRAY_STORAGE.getAll()) {
            System.out.println(r);
        }
    }
}
