import java.io.*;
import java.time.LocalDate;

public class HouseReader {
    private House house;

    public HouseReader(String houseFile) {
        readHouse(houseFile);
    }

    public House getHouse() {
        return house;
    }

    public void readHouse(String absoluteFileName) {
        // FIXME
        // read values to construct a house, here you will deal with exceptions, and stream creation
        // for inspiration, maybe look at the implementation of HouseWriter 
        //  use readHouseValues(DataInputStream fd) 
    }

    private void readHouseValues(DataInputStream fd) throws IOException, InvalidPricePerSquareFootExcpetion, InvalidAreaException {
        // FIXME
        // create a house object using these values
        // as you may see, when you read a house, you want to use the value of id that was written to a file
        
        // house = new House(x, y, ppsf, area, LocalDate.of(year, month, day), id);
    }
}

