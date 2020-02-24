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
        
        System.out.println("Get r1: " + ARRAY_STORAGE.get(r1.getUuid()));
        System.out.println("Size of storage: " + ARRAY_STORAGE.size());
        System.out.println("Get dummy: " + ARRAY_STORAGE.get("dummy"));
        printAll();
        
        System.out.println("\nDeleting the resume...");
        ARRAY_STORAGE.delete(r1.getUuid());
        System.out.print("The resume with \"" + r1.getUuid() + "\" has been deleted.");
        printAll();
        
        
        System.out.println("\nTrying to update resume with \"" + r2.getUuid() + "\" to \"uuid22\"...");
        r2.setUuid("uuid22");
        System.out.print("The resume " + ARRAY_STORAGE.update(r2));
        printAll();
        
        System.out.println("\nTrying to update resume with \"" + r3.getUuid() + "\" to \"uuid33\"...");
        r3.setUuid("uuid33");
        System.out.print("The resume " + ARRAY_STORAGE.update(r3));
        printAll();
        
        System.out.println("\nTrying to update resume with \"" + r1.getUuid() + "\" to \"uuid7\"...");
        r1.setUuid("uuid7");
        System.out.print("The resume " + ARRAY_STORAGE.update(r1));
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
