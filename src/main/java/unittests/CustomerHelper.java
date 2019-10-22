package unittests;

import java.util.Random;

public class CustomerHelper {

    public static int generateRandomId() {
        return new Random().nextInt(1000);
    }
}
