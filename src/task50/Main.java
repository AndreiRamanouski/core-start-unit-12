package task50;

import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.Scanner;

public class Main {
    private Map<Integer, Location> locations = new HashMap();
    private static Map<String, String> mapToFindDirection = new HashMap();

    static {
        mapToFindDirection.put("NORTH", "N");
        mapToFindDirection.put("SOUTH", "S");
        mapToFindDirection.put("QUIT", "Q");
        mapToFindDirection.put("EAST", "E");
        mapToFindDirection.put("WEST", "W");
    }

    public Main() {
        locations.put(0, new Location(0, "You are sitting in front of a computer learning Java"));
        locations.put(1, new Location(1, "You are standing at the end of a road before a small brick building"));
        locations.put(2, new Location(2, "You are at the top of a hill"));
        locations.put(3, new Location(3, "You are inside a building, a well house for a small spring"));
        locations.put(4, new Location(4, "You are in a valley beside a stream"));
        locations.put(5, new Location(5, "You are in the forest"));

        locations.get(1).addExit("W", 2);
        locations.get(1).addExit("E", 3);
        locations.get(1).addExit("S", 4);
        locations.get(1).addExit("N", 5);

        locations.get(2).addExit("N", 5);

        locations.get(3).addExit("W", 1);

        locations.get(4).addExit("N", 1);
        locations.get(4).addExit("W", 2);

        locations.get(5).addExit("S", 1);
        locations.get(5).addExit("W", 2);
    }

    public static void main(String[] args) {
        Main main = new Main();
        main.command();
    }

    public void command() {

        // write code here

        Scanner scanner = new Scanner(System.in);
        int tempLocation = 1;
        while (true){
            if(tempLocation == 0){
                System.out.println(locations.get(tempLocation).getDescription());
                break;
            }
            System.out.println(locations.get(tempLocation).getDescription());

            printAvailableOptions(tempLocation, locations);

            String enteredValue = scanner.nextLine();

            String valueInMap = findValueInMap(enteredValue);

            if (valueInMap.isEmpty()){
                System.out.println("You cannot go in that direction");
                continue;
            }
            tempLocation = (Integer) locations.get(tempLocation).getExits().get(valueInMap);
            System.out.println("Temp location " + tempLocation);
        }

    }

    private void printAvailableOptions(int tempLocation, Map<Integer, Location> locations) {
        System.out.print("Available exits are ");
        for (Object s : locations.get(tempLocation).getExits().keySet()){
            System.out.print(s +", ");
        }
        System.out.println();
    }

    public String findValueInMap(String stringToProcess) {
        if(stringToProcess.isEmpty() || stringToProcess == null){
            return "";
        }
        String returnedValue = "";
        String[] splitStringToProcess = stringToProcess.split(" ");
        for (String splitString : splitStringToProcess) {
            for (String s : mapToFindDirection.keySet()) {
                if (s.equalsIgnoreCase(splitString)){
                returnedValue =  mapToFindDirection.get(s.toUpperCase(Locale.ROOT));}
            }
        }
        return returnedValue;
    }
}