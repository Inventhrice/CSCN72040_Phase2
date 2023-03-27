package vrmaster_fileio;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import vrmaster_database.Database;

public class FileIODatabase implements FileIO <Database> {
    String filename;

    @Override
    public void writeToFile(Database toWrite) throws IOException {
        try(ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(filename))) {
            out.writeObject(toWrite);
            out.close();
        }
        catch(IOException e) {
            e.printStackTrace();
        }       
    }

    @Override
    public Database readFromFile() {
        Database database = new Database();

        try(ObjectInputStream in = new ObjectInputStream(new FileInputStream(filename)))
        {
            database = (Database) in.readObject();
        }
        catch(IOException e) {
            e.printStackTrace();
        }
        catch(ClassNotFoundException e) {
            e.printStackTrace();
        }

        return database;
    }

    public String getFilename() {
        return filename;
    }

    public void setFilename(String filename) {
        this.filename = filename;
    }
}
