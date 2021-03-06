package at.korti.endermystic.util;

import at.korti.endermystic.EnderMystic;
import at.korti.endermystic.ModInfo;

import java.io.*;
import java.net.URL;
import java.net.URLConnection;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

/**
 * Created by Korti on 06.06.2015.
 */
public class UpdateChecker {

    public enum UpdateStatus {
        ISUPTODATE,
        ISNOTUPTODATE,
        DISABLED,
        NOSTATUS
    }

    private static UpdateChecker instance;
    private final String updateLink = "https://dl.dropboxusercontent.com/s/vgte6mufofag5f2/version.txt?dl=0";
    private final String dirPath = "config/endermystic";
    private final String filePath = dirPath + "/version.txt";

    private UpdateStatus status;

    private UpdateChecker() {
        status = UpdateStatus.NOSTATUS;
    }

    public static UpdateChecker getInstance() {
        if (instance == null) {
            instance = new UpdateChecker();
        }
        return instance;
    }

    public void checkForUpdate() {
        InputStream inStream = null;
        FileOutputStream fileOutStream = null;
        try {
            createPath();
            URLConnection connection = new URL(updateLink).openConnection();
            inStream = connection.getInputStream();
            fileOutStream = new FileOutputStream(filePath);

            byte[] buffer = new byte[4096];
            int len;

            while ((len = inStream.read(buffer)) > 0) {
                fileOutStream.write(buffer, 0, len);
            }


        } catch (IOException e) {
            e.printStackTrace();
        }
        finally {
            if (inStream != null) {
                try {
                    inStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (fileOutStream != null) {
                try {
                    fileOutStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

        if (Files.exists(Paths.get(filePath))) {
            try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
                String line = reader.readLine();
                boolean checkForUpdate = EnderMystic.config.getBoolean("Update Checker", "Util", true, "Set it to false if you don't want to the check there is an update.");

                if (line.equals(ModInfo.VERSION) && checkForUpdate) {
                    status = UpdateStatus.ISUPTODATE;
                } else if (checkForUpdate) {
                    status = UpdateStatus.ISNOTUPTODATE;
                } else {
                    status = UpdateStatus.DISABLED;
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    private void createPath() {
        if (Files.exists(Paths.get("config"))) {
            try {
                Files.createDirectories(Paths.get(dirPath));
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public UpdateStatus getStatus() {
        return status;
    }

}
