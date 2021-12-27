import java.io.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;

public class CityBuilder {
    public static void main(String[] args) {
        try {
            House house = new House(1., 1.9, 123., 8000., LocalDate.now());
            System.out.println(house);
        } catch (InvalidPricePerSquareFootExcpetion e) {
            System.out.println(e);
        } catch (InvalidAreaException e) {
            System.out.println(e);
        }
        Double[] sqFootage = {1000., 800., 1456.0, 3000.0};
        Double[] taxRate = {0.09, 0.08, 0.1, 0.075};
        Double[] pricePerSquareFoot = {111., 123.0, 99.1, 80.075};
        try {
            House house = new House(0.1, 1.1, 123., 8000., LocalDate.now());
            Random random = new Random();
            ArrayList<Integer> selection = new ArrayList<>();

            for (int i = 0; i < 18; ++i) selection.add(random.nextInt(3));

            for (Integer i : selection) System.out.println("i: " + i);

            List<House> list = new LinkedList<>();
            for (int i = 1; i < sqFootage.length; ++i) {
                House h = new House(0.1 + i, 0.1 + i, 124. + i, sqFootage[i], LocalDate.of(2000 + i, 3+ i, i));
                list.add(h);
            }
            int index = 0;
            File file = new File(".");
            String str = file.getAbsolutePath();
            for (House hs : list) {
                System.out.println(hs);
                System.out.println(Integer.toString(2, 2));
                String d = String.format("%02d", index);
                var fileName = str + "/house" + d + ".dat";
                HouseWriter hw = new HouseWriter(hs);
                hw.writeHouse(fileName);
                ++index;
            }
        /*    
        Traverser recursive = new Traverser();
        double areas = recursive.sumSearchedValue(streetStart, CORE_FILE_NAME);
        System.out.println("Total Area: " + areas);
        */
        } catch (InvalidPricePerSquareFootExcpetion | InvalidAreaException e) {
            System.out.println(e);
        }
    }
    
}