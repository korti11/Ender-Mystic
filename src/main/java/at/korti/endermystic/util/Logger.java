package at.korti.endermystic.util;

import at.korti.endermystic.ModInfo;
import at.korti.endermystic.modintegration.baubles.Baubles;
import at.korti.endermystic.modintegration.cofh.Cofh;
import at.korti.endermystic.modintegration.waila.Waila;
import cpw.mods.fml.common.Loader;
import net.minecraft.client.Minecraft;
import net.minecraftforge.client.MinecraftForgeClient;
import net.minecraftforge.common.ForgeVersion;
import net.minecraftforge.common.MinecraftForge;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.OpenOption;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Korti on 06.06.2015.
 */
public class Logger {

    public enum LoggingLevel {
        INFO,
        WARNING,
        ERROR,
        DEBUG,
    }

    private static Logger instance;
    private final String pattern;
    private final String dirPath = "config/endermystic/log";
    private final String filePath = dirPath + "/" + LocalDateTime.now().format(DateTimeFormatter.ofPattern("dd.MM.yyyy-HH-mm-ss")) + "-Log.txt";
    private File logFile;

    private Logger() {
        pattern = LocalDateTime.now().format(DateTimeFormatter.ofPattern("HH:mm:ss")) + " [%s] %s\n"; //Zbs.: 06.06.2015-14:53:10 [INFO] PreInit mod.
        createDirectories();
        createLoggingFile();
        logFile = new File(filePath);
        writeHeader();
    }

    public static Logger getInstance() {
        if (instance == null) {
            instance = new Logger();
        }

        return instance;
    }

    public void addMessage(LoggingLevel level, String message) {
        try {
            Files.write(logFile.toPath(), String.format(pattern, level.toString(), message).getBytes(), StandardOpenOption.APPEND);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void createDirectories() {
        if (Files.notExists(Paths.get(dirPath))) {
            try {
                Files.createDirectories(Paths.get(dirPath));
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    private void createLoggingFile() {
        try {
            Files.createFile(Paths.get(filePath));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void writeHeader() {
        List<String> header = new ArrayList<>();
        header.add("Name: " + ModInfo.NAME);
        header.add("Version: " + ModInfo.VERSION);
        header.add("OS: " + System.getProperty("os.name") + " " + System.getProperty("os.version") + " " + System.getProperty("os.arch"));
        header.add("Java Version: " + System.getProperty("java.version"));
        header.add("Minecraft Version: " + Loader.MC_VERSION);
        header.add("Minecraft Forge Version: " + ForgeVersion.getVersion());
        if (Loader.isModLoaded(ModInfo.WAILA)) {
            header.add("Waila Version: " + Waila.wailaVersion);
        }
        if (Loader.isModLoaded(ModInfo.BAUBLES)) {
            header.add("Baubles Version: " + Baubles.baublesVersion);
        }
        if (Loader.isModLoaded(ModInfo.COFH)) {
            header.add("CoFH Core Version: " + Cofh.cofhVersion);
        }

        try {
            Files.write(logFile.toPath(), header, StandardOpenOption.APPEND);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
