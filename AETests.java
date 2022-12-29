import static org.junit.jupiter.api.Assertions.*;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;



/**
 * Tests the implementation of CS400Graph for the individual component of Project Three: the
 * implementation of Dijsktra's Shortest Path algorithm.
 */
class AETests {

  private MyGraph<Location, Location.Edge> graph = new MyGraph<Location, Location.Edge>();

  /**
   * Checks the distance/total weight cost from the vertex A to F.
   */
  @Test
  public void testPathCostAtoF() {

    Location locA = new Location("A");
    Location locB = new Location("B");
    Location locC = new Location("C");
    Location locD = new Location("D");
    Location locE = new Location("E");
    Location locF = new Location("F");

    Location.Edge edge1 = new Location.Edge(locB, 6);
    Location.Edge edge2 = new Location.Edge(locC, 2);
    Location.Edge edge3 = new Location.Edge(locD, 5);
    Location.Edge edge4 = new Location.Edge(locE, 1);
    Location.Edge edge5 = new Location.Edge(locC, 2);
    Location.Edge edge6 = new Location.Edge(locB, 3);
    Location.Edge edge7 = new Location.Edge(locF, 1);
    Location.Edge edge8 = new Location.Edge(locE, 3);
    Location.Edge edge9 = new Location.Edge(locA, 4);
    Location.Edge edge10 = new Location.Edge(locA, 1);
    Location.Edge edge11 = new Location.Edge(locD, 1);

    // insert vertices A-F
    graph.insertVertex(locA);
    graph.insertVertex(locB);
    graph.insertVertex(locC);
    graph.insertVertex(locD);
    graph.insertVertex(locE);
    graph.insertVertex(locF);

    // INSERT EDGE
    graph.insertEdge(locA, locB, edge1);
    graph.insertEdge(locA, locC, edge2);
    graph.insertEdge(locA, locD, edge3);
    graph.insertEdge(locB, locE, edge4);
    graph.insertEdge(locB, locC, edge5);
    graph.insertEdge(locC, locB, edge6);
    graph.insertEdge(locC, locF, edge7);
    graph.insertEdge(locD, locE, edge8);
    graph.insertEdge(locE, locA, edge9);
    graph.insertEdge(locF, locA, edge10);
    graph.insertEdge(locF, locD, edge11);


    //
    assertEquals(graph.getPathCost(locA, locF), 3);
  }

  /**
   * Checks the distance/total weight cost from the vertex A to D.
   */
  @Test
  public void testPathCostAtoD() {
    Location locA = new Location("A");
    Location locB = new Location("B");
    Location locC = new Location("C");
    Location locD = new Location("D");
    Location locE = new Location("E");
    Location locF = new Location("F");

    Location.Edge edge1 = new Location.Edge(locB, 6);
    Location.Edge edge2 = new Location.Edge(locC, 2);
    Location.Edge edge3 = new Location.Edge(locD, 5);
    Location.Edge edge4 = new Location.Edge(locE, 1);
    Location.Edge edge5 = new Location.Edge(locC, 2);
    Location.Edge edge6 = new Location.Edge(locB, 3);
    Location.Edge edge7 = new Location.Edge(locF, 1);
    Location.Edge edge8 = new Location.Edge(locE, 3);
    Location.Edge edge9 = new Location.Edge(locA, 4);
    Location.Edge edge10 = new Location.Edge(locA, 1);
    Location.Edge edge11 = new Location.Edge(locD, 1);

    // insert vertices A-F
    graph.insertVertex(locA);
    graph.insertVertex(locB);
    graph.insertVertex(locC);
    graph.insertVertex(locD);
    graph.insertVertex(locE);
    graph.insertVertex(locF);

    // INSERT EDGE
    graph.insertEdge(locA, locB, edge1);
    graph.insertEdge(locA, locC, edge2);
    graph.insertEdge(locA, locD, edge3);
    graph.insertEdge(locB, locE, edge4);
    graph.insertEdge(locB, locC, edge5);
    graph.insertEdge(locC, locB, edge6);
    graph.insertEdge(locC, locF, edge7);
    graph.insertEdge(locD, locE, edge8);
    graph.insertEdge(locE, locA, edge9);
    graph.insertEdge(locF, locA, edge10);
    graph.insertEdge(locF, locD, edge11);

    assertEquals(graph.getPathCost(locA, locD), 4);
  }

  /**
   * Checks the ordered sequence of data within vertices from the vertex A to D.
   */
  @Test
  public void testPathAtoD() {
    Location locA = new Location("A");
    Location locB = new Location("B");
    Location locC = new Location("C");
    Location locD = new Location("D");
    Location locE = new Location("E");
    Location locF = new Location("F");

    Location.Edge edge1 = new Location.Edge(locB, 6);
    Location.Edge edge2 = new Location.Edge(locC, 2);
    Location.Edge edge3 = new Location.Edge(locD, 5);
    Location.Edge edge4 = new Location.Edge(locE, 1);
    Location.Edge edge5 = new Location.Edge(locC, 2);
    Location.Edge edge6 = new Location.Edge(locB, 3);
    Location.Edge edge7 = new Location.Edge(locF, 1);
    Location.Edge edge8 = new Location.Edge(locE, 3);
    Location.Edge edge9 = new Location.Edge(locA, 4);
    Location.Edge edge10 = new Location.Edge(locA, 1);
    Location.Edge edge11 = new Location.Edge(locD, 1);

    // insert vertices A-F
    graph.insertVertex(locA);
    graph.insertVertex(locB);
    graph.insertVertex(locC);
    graph.insertVertex(locD);
    graph.insertVertex(locE);
    graph.insertVertex(locF);

    // INSERT EDGE
    graph.insertEdge(locA, locB, edge1);
    graph.insertEdge(locA, locC, edge2);
    graph.insertEdge(locA, locD, edge3);
    graph.insertEdge(locB, locE, edge4);
    graph.insertEdge(locB, locC, edge5);
    graph.insertEdge(locC, locB, edge6);
    graph.insertEdge(locC, locF, edge7);
    graph.insertEdge(locD, locE, edge8);
    graph.insertEdge(locE, locA, edge9);
    graph.insertEdge(locF, locA, edge10);
    graph.insertEdge(locF, locD, edge11);

    assertEquals(graph.shortestPath(locA, locD).get(0), locA);
    assertEquals(graph.shortestPath(locA, locD).get(1), locC);
    assertEquals(graph.shortestPath(locA, locD).get(2), locF);
    assertEquals(graph.shortestPath(locA, locD).get(3), locD);
  }

  /**
   * Checks the ordered sequence of data within vertices from the vertex A to F.
   */
  @Test
  public void testPathAtoF() {
    Location locA = new Location("A");
    Location locB = new Location("B");
    Location locC = new Location("C");
    Location locD = new Location("D");
    Location locE = new Location("E");
    Location locF = new Location("F");

    Location.Edge edge1 = new Location.Edge(locB, 6);
    Location.Edge edge2 = new Location.Edge(locC, 2);
    Location.Edge edge3 = new Location.Edge(locD, 5);
    Location.Edge edge4 = new Location.Edge(locE, 1);
    Location.Edge edge5 = new Location.Edge(locC, 2);
    Location.Edge edge6 = new Location.Edge(locB, 3);
    Location.Edge edge7 = new Location.Edge(locF, 1);
    Location.Edge edge8 = new Location.Edge(locE, 3);
    Location.Edge edge9 = new Location.Edge(locA, 4);
    Location.Edge edge10 = new Location.Edge(locA, 1);
    Location.Edge edge11 = new Location.Edge(locD, 1);

    // insert vertices A-F
    graph.insertVertex(locA);
    graph.insertVertex(locB);
    graph.insertVertex(locC);
    graph.insertVertex(locD);
    graph.insertVertex(locE);
    graph.insertVertex(locF);

    // INSERT EDGE
    graph.insertEdge(locA, locB, edge1);
    graph.insertEdge(locA, locC, edge2);
    graph.insertEdge(locA, locD, edge3);
    graph.insertEdge(locB, locE, edge4);
    graph.insertEdge(locB, locC, edge5);
    graph.insertEdge(locC, locB, edge6);
    graph.insertEdge(locC, locF, edge7);
    graph.insertEdge(locD, locE, edge8);
    graph.insertEdge(locE, locA, edge9);
    graph.insertEdge(locF, locA, edge10);
    graph.insertEdge(locF, locD, edge11);

    // "[A, C, F]"

    assertEquals(graph.shortestPath(locA, locF).get(0), locA);
    assertEquals(graph.shortestPath(locA, locF).get(1), locC);
    assertEquals(graph.shortestPath(locA, locF).get(2), locF);
  }

  /**
   * Checks the ordered sequence of data within vertices from the vertex A to E.
   */
  @Test
  public void testPathAtoE() {
    Location locA = new Location("A");
    Location locB = new Location("B");
    Location locC = new Location("C");
    Location locD = new Location("D");
    Location locE = new Location("E");
    Location locF = new Location("F");

    Location.Edge edge1 = new Location.Edge(locB, 6);
    Location.Edge edge2 = new Location.Edge(locC, 2);
    Location.Edge edge3 = new Location.Edge(locD, 5);
    Location.Edge edge4 = new Location.Edge(locE, 1);
    Location.Edge edge5 = new Location.Edge(locC, 2);
    Location.Edge edge6 = new Location.Edge(locB, 3);
    Location.Edge edge7 = new Location.Edge(locF, 1);
    Location.Edge edge8 = new Location.Edge(locE, 3);
    Location.Edge edge9 = new Location.Edge(locA, 4);
    Location.Edge edge10 = new Location.Edge(locA, 1);
    Location.Edge edge11 = new Location.Edge(locD, 1);

    // insert vertices A-F
    graph.insertVertex(locA);
    graph.insertVertex(locB);
    graph.insertVertex(locC);
    graph.insertVertex(locD);
    graph.insertVertex(locE);
    graph.insertVertex(locF);

    // INSERT EDGE
    graph.insertEdge(locA, locB, edge1);
    graph.insertEdge(locA, locC, edge2);
    graph.insertEdge(locA, locD, edge3);
    graph.insertEdge(locB, locE, edge4);
    graph.insertEdge(locB, locC, edge5);
    graph.insertEdge(locC, locB, edge6);
    graph.insertEdge(locC, locF, edge7);
    graph.insertEdge(locD, locE, edge8);
    graph.insertEdge(locE, locA, edge9);
    graph.insertEdge(locF, locA, edge10);
    graph.insertEdge(locF, locD, edge11);

    // "[A, C, B, E]"
    assertEquals(graph.shortestPath(locA, locE).get(0), locA);
    assertEquals(graph.shortestPath(locA, locE).get(1), locC);
    assertEquals(graph.shortestPath(locA, locE).get(2), locB);
    assertEquals(graph.shortestPath(locA, locE).get(3), locE);
  }

  @Test
  public void IntegrationAllShortestPath1() {
    Location locA = new Location("A");
    Location locB = new Location("B");
    Location locC = new Location("C");
    Location locD = new Location("D");
    Location locE = new Location("E");
    Location locF = new Location("F");

    Location.Edge edge1 = new Location.Edge(locB, 6);
    Location.Edge edge2 = new Location.Edge(locC, 2);
    Location.Edge edge3 = new Location.Edge(locD, 5);
    Location.Edge edge4 = new Location.Edge(locE, 1);
    Location.Edge edge5 = new Location.Edge(locC, 2);
    Location.Edge edge6 = new Location.Edge(locB, 3);
    Location.Edge edge7 = new Location.Edge(locF, 1);
    Location.Edge edge8 = new Location.Edge(locE, 3);
    Location.Edge edge9 = new Location.Edge(locA, 4);
    Location.Edge edge10 = new Location.Edge(locA, 1);
    Location.Edge edge11 = new Location.Edge(locD, 1);

    // insert vertices A-F
    graph.insertVertex(locA);
    graph.insertVertex(locB);
    graph.insertVertex(locC);
    graph.insertVertex(locD);
    graph.insertVertex(locE);
    graph.insertVertex(locF);

    // INSERT EDGE
    graph.insertEdge(locA, locB, edge1);
    graph.insertEdge(locA, locC, edge2);
    graph.insertEdge(locA, locD, edge3);
    graph.insertEdge(locB, locE, edge4);
    graph.insertEdge(locB, locC, edge5);
    graph.insertEdge(locC, locB, edge6);
    graph.insertEdge(locC, locF, edge7);
    graph.insertEdge(locD, locE, edge8);
    graph.insertEdge(locE, locA, edge9);
    graph.insertEdge(locF, locA, edge10);
    graph.insertEdge(locF, locD, edge11);

    List<Location> locList = new ArrayList<>();
    locList.add(locB);
    locList.add(locC);
    locList.add(locD);
    locList.add(locE);
    locList.add(locF);

    List<List<Location>> listOfPaths = graph.allShortestPaths(locA, locList);


    assertEquals(listOfPaths.get(0).get(0), locA);
    assertEquals(listOfPaths.get(0).get(1), locC);
    assertEquals(listOfPaths.get(0).get(2), locB);
  }

  @Test
  public void IntegrationAllShortestPath2() {
    Location locA = new Location("A");
    Location locB = new Location("B");
    Location locC = new Location("C");
    Location locD = new Location("D");
    Location locE = new Location("E");
    Location locF = new Location("F");

    Location.Edge edge1 = new Location.Edge(locB, 6);
    Location.Edge edge2 = new Location.Edge(locC, 2);
    Location.Edge edge3 = new Location.Edge(locD, 5);
    Location.Edge edge4 = new Location.Edge(locE, 1);
    Location.Edge edge5 = new Location.Edge(locC, 2);
    Location.Edge edge6 = new Location.Edge(locB, 3);
    Location.Edge edge7 = new Location.Edge(locF, 1);
    Location.Edge edge8 = new Location.Edge(locE, 3);
    Location.Edge edge9 = new Location.Edge(locA, 4);
    Location.Edge edge10 = new Location.Edge(locA, 1);
    Location.Edge edge11 = new Location.Edge(locD, 1);

    // insert vertices A-F
    graph.insertVertex(locA);
    graph.insertVertex(locB);
    graph.insertVertex(locC);
    graph.insertVertex(locD);
    graph.insertVertex(locE);
    graph.insertVertex(locF);

    // INSERT EDGE
    graph.insertEdge(locA, locB, edge1);
    graph.insertEdge(locA, locC, edge2);
    graph.insertEdge(locA, locD, edge3);
    graph.insertEdge(locB, locE, edge4);
    graph.insertEdge(locB, locC, edge5);
    graph.insertEdge(locC, locB, edge6);
    graph.insertEdge(locC, locF, edge7);
    graph.insertEdge(locD, locE, edge8);
    graph.insertEdge(locE, locA, edge9);
    graph.insertEdge(locF, locA, edge10);
    graph.insertEdge(locF, locD, edge11);

    List<Location> locList = new ArrayList<>();
    locList.add(locB);
    locList.add(locC);
    locList.add(locD);
    locList.add(locE);
    locList.add(locF);

    List<List<Location>> listOfPaths = graph.allShortestPaths(locA, locList);


    assertEquals(listOfPaths.get(1).get(0), locA);
    assertEquals(listOfPaths.get(1).get(1), locC);
  }
}

