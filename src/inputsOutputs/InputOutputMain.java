package inputsOutputs;

import java.util.*;

public class InputOutputMain {

    private static Map<Integer, Location> locations = new HashMap<Integer, Location>();

    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        Map<String, Integer> tempExit = new HashMap<String, Integer>();

        //DESERT
        tempExit = new HashMap<String, Integer>();
        tempExit.put("W", 2);
        tempExit.put("N", 3);
        tempExit.put("E", 4);
        tempExit.put("S", 5);
        locations.put(1, new Location(1, "Sunny and dry desert", null));
        //GRAVEYARD
        tempExit = new HashMap<String, Integer>();
        tempExit.put("N", 3);
        tempExit.put("E", 1);
        tempExit.put("S", 5);
        locations.put(2, new Location(3, "Abandoned city full of zombies", tempExit));
        //LUCKY_FOREST
        tempExit = new HashMap<String, Integer>();
        tempExit.put("W", 2);
        tempExit.put("E", 4);
        tempExit.put("S", 1);
        locations.put(3, new Location(3, "Magical fields of clovers", tempExit));
        //HELL
        tempExit = new HashMap<String, Integer>();
        tempExit.put("S", 5);
        locations.put(4, new Location(4, "Condemned area in the Hell", tempExit));
        //HEAVEN
        tempExit = new HashMap<String, Integer>();
        tempExit.put("W", 2);
        tempExit.put("N", 1);
        locations.put(5, new Location(5, "Blessings in the Heaven", tempExit));

        int loc = 1;
        while(true){
            System.out.println(locations.get(loc).getDescription());
            if(loc == 0){
                break;
            }

            Map<String, Integer> exits = locations.get(loc).getExits();
            System.out.println("Available exits for this location : ");
            for(String exit : exits.keySet()){
                System.out.println(exit + ",");
            }
            System.out.println();

            String direction = scanner.nextLine().toUpperCase();
            HashMap<String, String> directions = new HashMap<String, String>();
            directions.put("NORTH", "N");
            directions.put("EAST", "E");
            directions.put("SOUTH", "S");
            directions.put("WEST", "W");

            String[] directionPhrase = direction.split(" ");
            for(String word : directionPhrase){
                if(directions.containsKey(word)){
                    direction = directions.get(word);
                }
            }
            if(exits.containsKey(direction)){
                loc = exits.get(direction);
            }else{
                System.out.println("You cannot go in that direction");
            }

            if(!locations.containsKey(loc)){
                System.out.println("You cannot go in the direction");
                break;
            }
        }
    }
}
