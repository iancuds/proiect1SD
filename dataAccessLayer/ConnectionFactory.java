package dataAccessLayer;



public class ConnectionFactory {

    public DBConnection getConnection(boolean test) {
        if (test) {
            return new DBConnection("test_library");
        }
        return new DBConnection("library");
    }

}

