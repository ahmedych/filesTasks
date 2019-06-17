import java.io.*;
import java.util.*;

public class Task1 {
    public static void main(String[] args) {
        File directory = new File("C:\\Files\\Results");
        directory.mkdirs();
        File notSorted = new File(directory, "notSorted.txt");
        File sorted = new File(directory, "sorted.txt");
        try {
            notSorted.createNewFile();
            sorted.createNewFile();
        } catch (IOException e) {
            e.printStackTrace();
        }
        try (Writer writer = new FileWriter(notSorted)) {
            Random random = new Random();
            for (int i = 0; i < 20; i++) {
                writer.write(Integer.toString(random.nextInt()));
                writer.append(System.lineSeparator());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        try (BufferedReader reader=new BufferedReader(new FileReader(notSorted));
        Writer writer=new FileWriter(sorted)){
            List<Integer>list=new ArrayList<>();
            while (reader.ready()){
                list.add(Integer.parseInt(reader.readLine()));
            }
            Collections.sort(list);
            for (Integer integer :list) {
                writer.write(Integer.toString(integer));
                writer.write(System.lineSeparator());
            }

        }catch (FileNotFoundException e){
            e.printStackTrace();
        }catch (IOException e){
            e.printStackTrace();
        }

    }
}