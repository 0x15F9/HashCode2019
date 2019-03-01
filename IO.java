import java.util.ArrayList;
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;

/**
 * IO
 * I/O Operations
 */
public class IO {

    //** Get Images and store in an arraylist of Images */
    public ArrayList<Image> getImages(String filepath) throws FileNotFoundException {
        ArrayList<Image> images = new ArrayList<>();    
        Scanner fs = new Scanner(new File(filepath));
        int count = 0;
        
        fs.nextLine();

        while (fs.hasNext()) {
            images.add(new Image(String.valueOf(count), fs.nextLine()));
            count++;
        }

        for (Image img : images) {
            System.out.println(img.toString());
        }

        fs.close();
        return images;
    }
}