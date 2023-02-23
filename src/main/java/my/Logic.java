package my;

import java.util.*;
import java.util.stream.Collectors;

public class Logic {

    public List<House> fillList(){
        List<House> list = new ArrayList<>();
        list.add(new House( 35, 395.05,  4, 3, "Sokolska"));
        list.add(new House( 65, 546.32,  8, 5, "Oleha Koshovogo"));
        list.add(new House( 165, 150.9,  15, 1, "Sadova"));
        list.add(new House( 12, 605.3,  1, 6, "Bolgarska"));
        list.add(new House( 55, 176.31,  7, 2, "Nahimova"));
        list.add(new House( 42, 300.75,  3, 6, "Sobornosti"));
        list.add(new House( 93, 235.31,  10, 5, "Centralna"));
        list.add(new House( 78, 432.89,  11, 9, "Kostenka"));
        list.add(new House( 15, 274.82,  2, 4, "Kibruka"));
        return list;
    }

    public List<House> AddToList (List<House> list, int addNumberOfApartment, double addArea, int addFloor, int addNumberOfRooms, String addStreet){
        list.add(new House( addNumberOfApartment,addArea,addFloor,addNumberOfRooms,addStreet));
        return list;
    }

    public List<House> remove(List<House> list, int index){
        list.remove(index);
        return list;
    }

    public List<House> searchByNumberOfRooms(List<House> list, int numberOfRooms) {
        return list.stream()
                .filter(house -> house.getNumberOfRooms() == numberOfRooms)
                .sorted(Comparator.comparing(House::getNumberOfRooms).reversed())
                .collect(Collectors.toList());
    }


    public List<House> searchByNumberOfRoomsAndFloorRange(List<House> list, int numberOfRooms, int floorFrom, int floorTo) {
        return list.stream()
                .filter(house -> house.getNumberOfRooms() == numberOfRooms && house.getFloor() >= floorFrom && house.getFloor() <= floorTo)
                .sorted(Comparator.comparing(House::getNumberOfRooms).reversed())
                .collect(Collectors.toList());
    }



    public List<House> searchByArea(List<House> list, double areaBorder) {
        List<House> filteredHouses = new ArrayList<>();

        Map<Integer, Double> areasByFloor = new HashMap<>();

        for (House house : list) {
            areasByFloor.put(house.getFloor(), house.getArea());
        }

        List<Map.Entry<Integer, Double>> sortedAreasByFloor = areasByFloor.entrySet().stream()
                .sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
                .collect(Collectors.toList());

        for (Map.Entry<Integer, Double> entry : sortedAreasByFloor) {
            if (entry.getValue() > areaBorder) {
                for (House house : list) {
                    if (house.getFloor() == entry.getKey()) {
                        filteredHouses.add(house);
                        break;
                    }
                }
            }
        }

        return filteredHouses;
    }

    public List<House> sortByArea(List<House> list) {
        return list.stream()
                .sorted(Comparator.comparing(House::getArea))
                .collect(Collectors.toList());
    }


    public List<House> sortByFloor(List<House> list) {
        Map<Integer, List<House>> floorToHouses = list.stream()
                .collect(Collectors.groupingBy(House::getFloor));

        List<House> sortedHouses = floorToHouses.entrySet().stream()
                .sorted(Map.Entry.<Integer, List<House>>comparingByKey().reversed())
                .flatMap(entry -> entry.getValue().stream())
                .collect(Collectors.toList());

        return sortedHouses;
    }

    public Map<Integer, List<House>> apartmentListOfFloor(List<House> list) {
        Map<Integer, List<House>> floorToHouses = list.stream()
                .collect(Collectors.groupingBy(House::getFloor));

        return floorToHouses;
    }
}
