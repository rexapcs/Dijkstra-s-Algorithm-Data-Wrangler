// --== CS400 Fall 2022 File Header Information ==--
// Name: Rex Hart
// Email: rshart@wisc.edu
// Team: DR
// TA: Surabhi Gupta
// Lecturer: Florian Heimerl
// Notes to Grader: <optional extra notes>

import java.util.List;

public interface LocationInterface {
	List<Location.Edge> getEdgesLeaving();

	String getData();
	 class Edge{
		public Edge(Location target, double weight){
		}
	 }
}
