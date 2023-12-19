import java.io.*;

public class Utils {

    /**.*/
    public static String readContentFromFile(String path) {
        StringBuilder content = new StringBuilder();
        String s = "";

        try (BufferedReader reader = new BufferedReader(new FileReader(path))) {
            String file;
            while ((file = reader.readLine()) != null) {
                content.append(file);
                s += file + "\n";
            }
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return s;
    }

    /**.*/
    public static void writeContentToFile(String content, String path) {
        try {
            BufferedWriter bufferedWriter = new BufferedWriter((new FileWriter(path)));
            bufferedWriter.write(content);
            bufferedWriter.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**.*/
    private static void clearFileContent(String path) throws IOException {
        try (BufferedWriter clearWriter = new BufferedWriter(new FileWriter(path, false))) {
            clearWriter.write("");
        }
    }

    /**.*/
    public static void appendContentToFile(String content, String path) {
        try {
            String s = readContentFromFile(path);
            BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(path));
            bufferedWriter.write(s + "\n" + content);
            bufferedWriter.close();
        } catch (IOException exception) {
            exception.printStackTrace();
        }
    }

    /**.*/
    public static File findFileByName(String folderPath, String fileName) {
        File folder = new File(folderPath);
        if (folder.exists() && folder.isDirectory()) {
            File[] files = folder.listFiles();
            if (files != null) {
                for (File file : files) {
                    if (file.isFile() && file.getName().equals(fileName)) {
                        return file;
                    }
                }
            }
        }
        return null;
    }
}
