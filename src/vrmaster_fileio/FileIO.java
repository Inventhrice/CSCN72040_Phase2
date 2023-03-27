package vrmaster_fileio;

import java.io.IOException;

public interface FileIO <T> {
    public T readFromFile();
    public void writeToFile(T toWrite) throws IOException;
}
