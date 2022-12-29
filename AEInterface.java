import java.util.List;

public interface AEInterface {

//  /**
//   * This method gets the shortest path to a given destination(end) from a starting point(start)
//   * through a specific route(route).
//   * 
//   * @param start the starting location
//   * @param route the location to pass through
//   * @param end   the destination
//   * @return the shortest path from start to end through
//   */
//  public List<NodeType> shortestPathThroughRoute(NodeType start, NodeType route, NodeType end);
  
  /**
   * gets the shortest paths from a given location(origin) to all destinations
   * @param origin the starting point
   * @param destinations the different destination to get the shortest paths to
   * @return
   */
  public List<List<Location>> allShortestPaths(Location origin, List<Location> destinations);
}
