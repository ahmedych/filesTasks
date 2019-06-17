import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class Task4 {
    public static void main(String[] args) {
        File directory = new File("C:\\Files\\Results");
        directory.mkdirs();
        File file=new File(directory,"Main.java");
        try(Scanner scanner=new Scanner(file)){
            String[] words=scanner.useDelimiter("\\Z").next().split("\\W");
            List<String> listWords= Arrays.asList(words);
            ListIterator<String>iterator=listWords.listIterator();
            while (iterator.hasNext()){
                String s=iterator.next();
                if(s.length() > 2)
                    iterator.set(s.toUpperCase());
            }
            for (String s :listWords) {
                System.out.println(s);
            }


        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}
