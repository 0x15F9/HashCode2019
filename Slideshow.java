import java.util.ArrayList;

/**
 * Slideshow
 */
public class Slideshow {

    public static void main(String[] args) throws Exception{
        IO io = new IO();
        ArrayList<Image> images = io.getImages("/home/isfaaq/Documents/Projects/HashCode/myOwn/HashCode2019/Datasets/b_lovely_landscapes.txt");
        Integer tab[][] = Operations.tabulate(images);

        System.out.println("---");
        for (int row = 0; row < images.size(); row++) {
            for (int col = 0; col < images.size(); col++) {
                System.out.print(row>=col?" ":tab[row][col]);
            }
            System.out.println();
        }
        System.out.println("---");

        ArrayList<String> result = Operations.formSlideShow(tab, images);

    }
}