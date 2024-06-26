import java.io.IOException;
import java.util.ArrayList;
import java.util.NoSuchElementException;

public class GraphTest {

    /**
     * Loest das SSSP-Proplem mit Hilfe des Algortihmus von Bellman-Ford.
     *
     * @param g      der Graph
     * @param source id des Startknotes
     * @return Array mit Weglaengen; Element i gibt die Laenge eines kuerzesten
     * Weges von dem Knoten mit der id source zu dem Knoten mit id i an
     */
    public static double[] sssp(Graph g, int source) {

        double[] distances = new double[g.numNodes()];
        ArrayList<Edge> edges=g.getEdges();
       

        //Setzen aller Distanzen auf INFINITY
        for(int i=0;i<distances.length;++i){
            distances[i]=Double.POSITIVE_INFINITY;
            
        }
        distances[source]=0;

        //relax all edges v-1 times 
        for(int i=1;i<g.numNodes()-1;++i){

            for(int j=0;j<g.getEdges().size();++j){

                   int src = edges.get(j).getSrc().getId();
                   int dst =edges.get(j).getDst().getId();
                   int weight =edges.get(j).getWeight();
                   
                   
                   if(distances[src]!= Double.POSITIVE_INFINITY && distances[src] + weight < distances[dst]){
                       distances[dst]=distances[src] + weight;
                   }
                

            }
        }

        //check for negative circles
        for(int i=0;i<g.getEdges().size();++i){

            int src = edges.get(i).getSrc().getId();
            int dst = edges.get(i).getDst().getId();
            int weight =edges.get(i).getWeight();

            //wenn es immernoch einen kürzeren weg von src nach dst gibt, existiert ein negativer Zyklus
            if(distances[src] + weight < distances[dst]){
                System.out.println("FEHLER: negativer Zyklus gefunden");
            }
        }
        return distances;

       
    
    }

    public static void main(String[] args) throws NumberFormatException, IOException, NoSuchElementException {
        if (args.length != 2) {
            fatal("Falsche Anzahl an Parametern");
        }

        Graph g = new Graph();
        try {
            g = Graph.fromFile(args[0]);
        } catch (IOException e) {
            fatal("Angegebene Datei konnte nicht gelesen werden.");
        } catch (IllegalArgumentException e) {
            fatal("Graph Datei konnte auf Grund eines Formatierungsfehlers nicht gelesen werden.");
        }

        if (g.getNodes().isEmpty()) {
            fatal("Leerer Graph.");
        }

        // Fuehre Bellman-Ford-Algorithmus aus
        int nodenumber = -1;
        try {
            nodenumber = Integer.parseInt(args[1]);
        } catch (NumberFormatException ex) {
            fatal("Zweiter Parameter muss ein Integer sein");
        }
        if (g.getNode(nodenumber) == null) {
            fatal("Ungueltiger Startknoten angegeben: " + args[1]);
        }
        double[] minCost = sssp(g, nodenumber);
        ArrayList<Node> nodes = g.getNodes();
        Node s = g.getNode(nodenumber), e = s;
        double maxDist = 0d;
        for (Node n : nodes) {
            if (nodes.size() <= 20) {
                System.out.println("Abstand von Knoten " + n.getId() + " zu Knoten " + s.getId() + ": " + minCost[n.getId()]);
            }
            if (minCost[n.getId()] != Double.POSITIVE_INFINITY && minCost[n.getId()] > maxDist) {
                maxDist = minCost[n.getId()];
                e = n;
            }
        }
        System.out.println("Der maximale Abstand ist " + maxDist + " fuer Knoten " + e.getId());
    }

    private static void fatal(String message) {
        System.err.println("FEHLER: " + message);
        System.err.println("Aufruf: java GraphTest <filename> <nodenumber>");
        System.exit(1);
    }
}
