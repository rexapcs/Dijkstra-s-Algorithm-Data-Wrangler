///////////////////////// TOP OF FILE COMMENT BLOCK ////////////////////////////
//
// Title:           A graph implementing Dijkstra's algorithm to find the shortest
//                  path within a graph
// Course:          CS400, Fall, 2022
//
// Author:          Rex Hart
// Email:           rshart@wisc.edu
// Lecturer's Name: Florian Heimerl
//
/////////////////////////////// 80 COLUMNS WIDE ////////////////////////////////
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.io.File;
import java.util.Scanner;



public class DWLocationLoader implements LocationLoaderInterface {
    String locationFile;

    public DWLocationLoader(String file) {
        locationFile = file;
    }

    public String getFile() {
        return locationFile;
    }

    @Override
    public List<LocationInterface> DOTLS(String file_path) throws FileNotFoundException {
        File file = new File(file_path);
        try{
            Scanner scanner = new Scanner(file);

            List<LocationInterface> locationVertex = new ArrayList<>();
            String destination = ""; //string destination
            int weight = -1; //weight of path
            Location location = null; //origin location variable
            Location locationDestination = null; //location variable for destination
            List<Location.Edge> edgesLeaving = new ArrayList<>(); //array list for all edges of an origin
            Location.Edge edgeF = null; //edge
            Location.Edge edgeB = null; //edge
            String weightString = ""; //the weight of a path before turning into an int
            String temp = ""; //temporary variable to store each origin
            String line = ""; //temp to store an entire line to substring through
            List<String> dataList = new ArrayList<>();



            scanner.nextLine(); //goes past first line of file
            while(scanner.hasNextLine()) {
                temp = scanner.next(); //temp variable to store origin

                if(temp.equals("}")) {
                    break;
                }
                if(location == null || !dataList.contains(temp)) {
                    location = new Location(temp);
                    locationVertex.add(location);
                    dataList.add(temp);
                }
                else if(!temp.equals(location.data)) {
                    for(int i = 0; i < locationVertex.size(); i ++) {
                        if(temp.equals(locationVertex.get(i).getData())) {
                            location = (Location) locationVertex.get(i);
                        }
                    }
                }
                scanner.next();
                destination = scanner.next();
                if(locationDestination == null || !dataList.contains(destination)) {
                    locationDestination = new Location(destination);
                    locationVertex.add(locationDestination);
                    dataList.add(destination);
                }
                else if(!destination.equals(locationDestination.data)) {
                    for(int i = 0; i < locationVertex.size(); i ++) {
                        if(destination.equals(locationVertex.get(i).getData())) {
                            locationDestination = (Location) locationVertex.get(i);
                        }
                    }
                }
                line = scanner.nextLine();
                weightString = line.substring(line.indexOf('=')+1, line.indexOf(']'));
                weight = Integer.parseInt(weightString);
                edgeF = new Location.Edge(locationDestination, weight);
                edgeB = new Location.Edge(location, weight);
                if(!location.edgesLeaving.contains(edgeF)) {
                    location.setNewEdge(locationDestination, weight);
                }
                if(!locationDestination.edgesLeaving.contains(edgeB)) {
                    locationDestination.setNewEdge(location, weight);
                }
            }
            scanner.close();
            return locationVertex;
        }
        catch (Exception e) {
            throw e;
        }
    }
    public static void main(String[] args) throws FileNotFoundException {
        DWLocationLoader fileTest = new DWLocationLoader("townGraph.dot");
        List<LocationInterface> list = fileTest.DOTLS("src/townGraph.dot");
       List<Location.Edge> edgesLeaving = list.get(1).getEdgesLeaving();
       for(int i = 0; i < edgesLeaving.size(); i ++) {
           System.out.println(edgesLeaving.get(i).target.data + " " + edgesLeaving.get(i).weight);
       }
    }
}
