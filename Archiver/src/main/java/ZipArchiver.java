
import net.lingala.zip4j.ZipFile;
import net.lingala.zip4j.model.ZipParameters;

import java.io.File;
import java.io.IOException;

public class ZipArchiver implements Archiver {

    public void archive(File directory, File archive) throws IOException {
        ZipFile zipFile = new ZipFile(archive);
        ZipParameters params = new ZipParameters();
        params.setIncludeRootFolder(false);
        zipFile.addFolder(directory, params);
    }
}
