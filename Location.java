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

public class Location implements LocationInterface{
    //Edge class acting as a vertex
    public static class Edge extends Number {
        public Location target;
        public int weight;

        /**
         *
         * @param target the target of the edge
         * @param weight the weight of the edge
         */
        public Edge(Location target, int weight) {
            this.target = target;
            this.weight = weight;
        }

        /**
         *
         * @return int value of weight
         */
        @Override
        public int intValue() {
            return weight;
        }

        /**
         *
         * @return long value of weight
         */
        @Override
        public long longValue() {
            return weight;
        }

        /**
         *
         * @return float value of weight
         */
        @Override
        public float floatValue() {
            return weight;
        }

        /**
         *
         * @return double value of weight
         */
        @Override
        public double doubleValue() {
            return weight;
        }
    }


    String data; //the data of the location
    List<Edge> edgesLeaving; // a list of the locations leaving this node with edges connecting them

    /**
     *
     * @param data the data of the location
     */
    public Location(String data) {
        this.data = data;
        this.edgesLeaving = new ArrayList<>();
    }

    /**
     * default constructor for location
     */
    public Location() {
        data = "";
        this.edgesLeaving = new ArrayList<>();
    }

    /**
     *
     * @param target the target of the edge being set
     * @param weight the weight of the edge being set
     */
    public void setNewEdge(Location target, int weight) {
        Edge e = new Edge(target, weight);
        edgesLeaving.add(e);
    }

    /**
     *
     * @return the edgesLeaving array
     */
    @Override
    public List<Edge> getEdgesLeaving() {
        return edgesLeaving;
    }

    /**
     *
     * @return the string data of a specified location
     */
    @Override
    public String getData() {
        return data;
    }
}
