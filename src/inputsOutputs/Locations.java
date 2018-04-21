package inputsOutputs;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.util.*;

public class Locations implements Map<Integer, Location> {

    private static Map<Integer, Location> locations = new HashMap<Integer, Location>();

    public static void main(String[] args) throws IOException{
        try(FileWriter localFile = new FileWriter("locations.txt");
            FileWriter directionsFile = new FileWriter("directions.txt")){
            localFile.write("\tID\tDESCRIPTION\t\t\t\tNUMBER OF EXTIS\n\n");
            for(Location location : locations.values()){
                localFile.write("\t" + location.getLocationID() + "\t"
                                + location.getDescription() + "\t\t\t\t"
                                + location.getExits().size() + "\n");
               for(String direction : location.getExits().keySet()){
                   directionsFile.write(location.getLocationID() + "\t"
                                        + direction + "\t"
                                        + location.getExits().get(direction) + "\n");
               }
            }
        }
//        FileWriter localFile = null;
//        try{
//            localFile = new FileWriter("locations.txt");
//            for(Location location : locations.values()) {
//                localFile.write("\n" + location.getLocationID() + "\t" + location.getDescription());
//            }
//        }finally{
//            System.out.println("FINALLY BLOCK");
//            if (localFile != null) {
//                System.out.println("CLOSING THE FILE");
//                localFile.close();
//            }
//        }
    }

    //static initialisation
    static {
        Scanner scanner = null;
        try{
            scanner = new Scanner(new FileReader("locations.txt"));
            scanner.useDelimiter("\t");
            while(scanner.hasNextLine()){
                int loc = scanner.nextInt();
                scanner.skip(scanner.delimiter());
                String description = scanner.nextLine();
                System.out.println("Imported loc: " + loc + "\t" + description);
                Map<String, Integer> tempExit = new HashMap<>();
                locations.put(loc, new Location(loc, description, tempExit));
            }
        }catch(IOException e){
            e.printStackTrace();
        }
        finally{
            if(scanner != null){
                scanner.close();
            }
        }

//        Map<String, Integer> tempExit = new HashMap<String, Integer>();
//
//        //DESERT
//        tempExit = new HashMap<String, Integer>();
//        tempExit.put("W", 2);
//        tempExit.put("N", 3);
//        tempExit.put("E", 4);
//        tempExit.put("S", 5);
//        locations.put(1, new Location(1, "Sunny and dry desert", tempExit));
//        //GRAVEYARD
//        tempExit = new HashMap<String, Integer>();
//        tempExit.put("N", 3);
//        tempExit.put("E", 1);
//        tempExit.put("S", 5);
//        locations.put(2, new Location(3, "Abandoned city full of zombies", tempExit));
//        //LUCKY_FOREST
//        tempExit = new HashMap<String, Integer>();
//        tempExit.put("W", 2);
//        tempExit.put("E", 4);
//        tempExit.put("S", 1);
//        locations.put(3, new Location(3, "Magical fields of clovers", tempExit));
//        //HELL
//        tempExit = new HashMap<String, Integer>();
//        tempExit.put("S", 5);
//        locations.put(4, new Location(4, "Condemned area in the Hell", tempExit));
//        //HEAVEN
//        tempExit = new HashMap<String, Integer>();
//        tempExit.put("W", 2);
//        tempExit.put("N", 1);
//        locations.put(5, new Location(5, "Blessings in the Heaven", tempExit));

    }

    @Override
    public int size() {
        return locations.size();
    }

    @Override
    public boolean isEmpty() {
        return locations.isEmpty();
    }

    @Override
    public boolean containsKey(Object key) {
        return locations.containsKey(key);
    }

    @Override
    public boolean containsValue(Object value) {
        return locations.containsValue(value);
    }

    @Override
    public Location get(Object key) {
        return locations.get(key);
    }

    @Override
    public Location put(Integer key, Location value) {
        return locations.put(key, value);
    }

    @Override
    public Location remove(Object key) {
        return locations.remove(key);
    }

    @Override
    public void putAll(Map<? extends Integer, ? extends Location> m) {}

    @Override
    public void clear() {
        locations.clear();
    }

    @Override
    public Set<Integer> keySet() {
        return locations.keySet();
    }

    @Override
    public Collection<Location> values() {
        return locations.values();
    }

    @Override
    public Set<Entry<Integer, Location>> entrySet() {
        return locations.entrySet();
    }
}
