class MyConnection {
    private boolean isOpen;

    public void open() {
        isOpen = true;
        System.out.println("Connection opened.");
    }

    public void doWork() throws Exception {
        if (!isOpen) {
            throw new IllegalStateException("Connection is not open.");
        }
        // Simulate an exception during work
        System.out.println("Performing some work...");
        throw new Exception("Something went wrong while working.");
    }

    public void close() {
        if (isOpen) {
            isOpen = false;
            System.out.println("Connection closed.");
        } else {
            System.out.println("Connection was already closed.");
        }
    }
}

public class ResourceCleanup {
    public static void main(String[] args) {
        MyConnection connection = new MyConnection();
        try {
            connection.open();
            connection.doWork();
        } catch (Exception e) {
            System.out.println("Exception caught: " + e.getMessage());
        } finally {
            // Ensures resource cleanup
            connection.close();
        }
    }
}
