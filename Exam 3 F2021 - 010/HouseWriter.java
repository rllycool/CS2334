import java.io.*;

public class HouseWriter {
    House house;

    public HouseWriter(House house) {
        this.house = house;
    }

    public void writeHouse(String absoluteFileName) {
        try {
            var file = new File(absoluteFileName);
            var fd = new DataOutputStream(new FileOutputStream(file));
            fd.writeDouble(house.getLocation().get("x"));
            fd.writeDouble(house.getLocation().get("y"));
            fd.writeDouble(house.getArea());
            fd.writeDouble(house.getPricePerSquareFoot());
            fd.writeInt(house.getBuildOn().getDayOfMonth());
            fd.writeInt(house.getBuildOn().getMonth().getValue());
            fd.writeInt(house.getBuildOn().getYear());
            fd.writeInt(house.getId());

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
