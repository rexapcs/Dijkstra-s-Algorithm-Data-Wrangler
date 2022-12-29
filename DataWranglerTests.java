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
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class DataWranglerTests {
    /**
     * Tests the calling of DOTLS within DWLocationLoader, ensuring that it correctly loaded vertexs into a list of
     * type LocationInterface.
     */
    @Test
    public void initialization(){
        try{
            DWLocationLoader fileTest = new DWLocationLoader("townGraph.dot");
            List<LocationInterface> list = fileTest.DOTLS("townGraph.dot");
        }
        catch(Exception e) {
            e.printStackTrace();
            assertTrue(false);
        }
    }

    /**
     * Tests four arbitrary values, ensuring that DOTLS() returns a list of locations in the correct
     * order.
     */
    @Test
    public void testIndexes() {
        try{
            DWLocationLoader fileTest = new DWLocationLoader("townGraph.dot");
            List<LocationInterface> list = fileTest.DOTLS("townGraph.dot");

            Assertions.assertEquals(list.get(0).getData(), "home");
            Assertions.assertEquals(list.get(10).getData(), "police_station");
            Assertions.assertEquals(list.get(8).getData(), "friends_house");
            Assertions.assertEquals(list.get(11).getData(), "grocery");
        }
        catch(Exception e) {
            e.printStackTrace();
            assertTrue(false);
        }
    }

    /**
     * Tests the edges leaving from random vertexes within the list, ensuring that they have their
     * corresponding paths.
     */
    @Test
    public void testEdgesLeaving() {
        try{
            DWLocationLoader fileTest = new DWLocationLoader("townGraph.dot");
            List<LocationInterface> list = fileTest.DOTLS("townGraph.dot");
            List<Location.Edge> edges = list.get(0).getEdgesLeaving();
            List<String> compareTo = new ArrayList<>();
            compareTo.add("park1");
            compareTo.add("neighbors_house");
            compareTo.add("corner_store");
            for(int i = 0; i < edges.size(); i++) {
                Assertions.assertEquals(edges.get(i).target.data, compareTo.get(i));
            }
            compareTo.clear();
            compareTo.add("neighbors_house");
            compareTo.add("grandmas_house");
            compareTo.add("inner_city");
            compareTo.add("next_state");
            compareTo.add("country_club");
            edges = list.get(8).getEdgesLeaving();
            for(int i = 0; i < edges.size(); i++) {
                Assertions.assertEquals(edges.get(i).target.data, compareTo.get(i));
            }

        }
        catch(Exception e) {
            assertTrue(false);
        }
    }

    /**
     * Tests to ensure that the size of the list is correct
     */
    @Test
    public void testSize() {
        try{
            DWLocationLoader fileTest = new DWLocationLoader("townGraph.dot");
            List<LocationInterface> list = fileTest.DOTLS("townGraph.dot");
            Assertions.assertEquals(list.size(), 15);
        }
      catch(Exception e) {
      }
    }

    /**
     * Tests to ensure that the weight of found paths are correct
     */
    @Test
    public void testWeight() {
        try{
            DWLocationLoader fileTest = new DWLocationLoader("townGraph.dot");
            List<LocationInterface> list = fileTest.DOTLS("townGraph.dot");
            List<Location.Edge> edges = list.get(1).getEdgesLeaving();
            List<Integer> compareTo = new ArrayList<>();
            compareTo.add(1);
            compareTo.add(3);
            compareTo.add(2);
            compareTo.add(7);
            compareTo.add(5);
            for(int i = 0; i < edges.size(); i++) {
                Assertions.assertEquals(edges.get(i).weight, compareTo.get(i));
            }
            compareTo.clear();
            compareTo.add(3);
            compareTo.add(2);
            compareTo.add(1);
            compareTo.add(2);
            compareTo.add(4);
            edges = list.get(11).getEdgesLeaving();
            for(int i = 0; i < edges.size(); i++) {
                Assertions.assertEquals(edges.get(i).weight, compareTo.get(i));
            }

        }
        catch(Exception e) {
            assertTrue(false);
        }
    }

    /**
     * Checks to see if you can correctly find the shortest path from mem library to memorial union
     */
    @Test
    public void CodeReviewOfAEShortestPath() {
        Location l1 = new Location("Mem library");
        Location l2 = new Location("Grainger");
        Location l3 = new Location("Mem Union");
        Location l4 = new Location("16 Langdon");
        Location.Edge E1 = new Location.Edge(l2, 5);
        Location.Edge E2 = new Location.Edge(l3, 5);
        Location.Edge E3 = new Location.Edge(l3, 2);

        MyGraph<String, Location.Edge> graph = new MyGraph<>();
        l1.setNewEdge(l2, 5);
        l2.setNewEdge(l3, 5);
        l1.setNewEdge(l3, 5);
        graph.insertVertex(l1);
        graph.insertVertex(l2);
        graph.insertVertex(l3);
        graph.insertVertex(l4);
        graph.insertEdge(l1, l2, E1);
        graph.insertEdge(l2, l3, E2);
        graph.insertEdge(l1, l3, E3);
        List<Location> listDestinations = new ArrayList<>();
        listDestinations.add(l3);
        List<List<Location>> shortestPaths = graph.allShortestPaths(l1, listDestinations);
        Assertions.assertEquals(shortestPaths.get(0).get(0).getData() + " " + shortestPaths.get(0).get(1).getData(), "Mem library Mem Union");
    }

    /**
     * Checks that the AE code throws an exception when a path is attempted to be found that is not connected
     */
    @Test
    public void CodeReviewOfAE() {
        Location l1 = new Location("Mem library");
        Location l2 = new Location("Grainger");
        Location l3 = new Location("Mem Union");
        Location l4 = new Location("16 Langdon");
        Location.Edge E1 = new Location.Edge(l2, 5);
        Location.Edge E2 = new Location.Edge(l3, 5);
        Location.Edge E3 = new Location.Edge(l3, 2);

        MyGraph<String, Location.Edge> graph = new MyGraph<>();

        graph.insertVertex(l1);
        graph.insertVertex(l2);
        graph.insertVertex(l3);
        graph.insertVertex(l4);

        List<Location> listDestinations = new ArrayList<>();
        listDestinations.add(l4);
        try {
            List<List<Location>> shortestPaths = graph.allShortestPaths(l1, listDestinations);
            Assertions.assertEquals(shortestPaths.get(0).get(0).getData() + " " + shortestPaths.get(0).get(1).getData(), "Mem library Mem Union");
            Assertions.assertTrue(false);
        }
       catch(Exception e) {

       }
    }

    /**
     * Checks to see if the AE code can properly assemble a graph from the location objects from the DOTLS() method from DW
     */
    @Test
    public void IntegrationTest1() {
        try{
            DWLocationLoader fileTest = new DWLocationLoader("townGraph.dot");
            List<LocationInterface> list = fileTest.DOTLS("townGraph.dot");
            MyGraph<String, Location.Edge> graph = new MyGraph<>();
            for(int i = 0; i < list.size(); i++) {
                graph.insertVertex((Location)list.get(i));
            }
        }
        catch(Exception e) {
            e.printStackTrace();
            assertTrue(false);
        }
    }

    /**
     * Tests to ensure that the AE allShortestPaths method can correctly return the shortest path from home to park1
     */
    @Test
    public void IntegrationTest2() {
        try{
            DWLocationLoader fileTest = new DWLocationLoader("townGraph.dot");
            List<LocationInterface> list = fileTest.DOTLS("townGraph.dot");
            MyGraph<String, Location.Edge> graph = new MyGraph<>();
            for(int i = 0; i < list.size(); i++) {
                graph.insertVertex((Location)list.get(i));

            }
            for(int i = 0; i < list.size(); i++) {
                for (int j = 0; j < list.get(i).getEdgesLeaving().size(); j++) {
                    graph.insertEdge((Location)list.get(i), list.get(i).getEdgesLeaving().get(j).target, list.get(i).getEdgesLeaving().get(j));
                }
            }
            List<Location> listDestinations = new ArrayList<>();
            listDestinations.add((Location)list.get(1));
            List<List<Location>> shortestPaths = graph.allShortestPaths((Location)list.get(0), listDestinations);
            Assertions.assertEquals(shortestPaths.get(0).get(0).getData() + " " + shortestPaths.get(0).get(1).getData(), "home park1");
        }
        catch(Exception e) {
            e.printStackTrace();
            assertTrue(false);
        }
    }
}
