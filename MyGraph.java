import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;

public class MyGraph<NodeType, EdgeType> extends CS400Graph<Location, Location.Edge>
    implements AEInterface {


  // protected Hashtable<NodeType, Vertex> vertices;
  //
  // public MyGraph() {
  // vertices = new Hashtable<>();
  // }
  //
  // public MyGraph(List<LocationInterface> locList) {
  //
  // vertices = new Hashtable<>();
  //
  // for (int i = 0; i < locList.size(); i++) {
  // vertices.put(locList.get(i), locList.get(i).getData());
  // }
  // }

  List<LocationInterface> locList = new ArrayList<>();



  @Override
  public List<List<Location>> allShortestPaths(Location origin, List<Location> destinations) {
    List<List<Location>> finalList = new ArrayList<>();
    for (int i = 0; i < destinations.size(); i++) {
      // if (destinations.get(i) == origin) {
      // continue;
      // }
      finalList.add((shortestPath(origin, destinations.get(i))));
    }
    return finalList;// TODO Auto-generated method stub
  }



  // @Override
  // public List<Object> shortestPathThroughRoute(Object start, Object route, Object end) {
  // List<Object> firstPath = shortestPath(start, route);
  // List<Object> secondPath = shortestPath(route, end);
  //
  // List<Object> finalPath = new ArrayList<>();
  //
  // for (int i = 0; i < firstPath.size(); i++) {
  // finalPath.add(firstPath.get(i));
  // }
  //
  // for (int i = 0; i < secondPath.size(); i++) {
  // finalPath.add(secondPath.get(i));
  // }
  // // TODO Auto-generated method stub
  // return finalPath;
  // }

}

