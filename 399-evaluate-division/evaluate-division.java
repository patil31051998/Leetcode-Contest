class Node {
    int data;
    double value;

    public Node(int data, double value) {
        this.data = data;
        this.value = value;
    }
}
class Solution {

    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        Map<String, Integer> edgeMapping = getEdgeMapping(equations);
        List<List<Node>> adjList = getAdjList(equations, values, edgeMapping);
        double[] result = new double[queries.size()];
        // System.out.println(edgeMapping);
        // for(List<Node> adj : adjList) {
        //     for(int k = 0; k < adj.size(); k++) {
        //         System.out.println(adj.get(k).data + ":" + adj.get(k).value);
        //     }
        //     System.out.println();
        // }
        int i;
        for(i = 0; i < queries.size(); i++) {
            int start =  edgeMapping.getOrDefault(queries.get(i).get(0), -1);
            int end =  edgeMapping.getOrDefault(queries.get(i).get(1), -1);
            if(start == -1 || end == -1) {
                result[i] = -1.0;
            }
            else if(start == end) {
                result[i] = 1.0;
            }
            else {
                Set<Integer> visited = new HashSet<>();
                double curr = dfs(start, end, adjList, visited);
                result[i] = curr >= (double)Math.pow(10, 7) ? -1.0 : curr;
            }
        }
        return result;
    }

    private double dfs(int start, int end, List<List<Node>> adjList, Set<Integer> visited) {
        visited.add(start);
        if(start == end) {
            return 1.0;
        }
        double min = (double) Math.pow(10, 9);
        for(Node adj : adjList.get(start)) {
            if(!visited.contains(adj.data)) {
                min = Math.min(min, adj.value * dfs(adj.data, end, adjList, visited));
            }
        }
        return min;
    }

    private List<List<Node>> getAdjList(List<List<String>> equations, double[] values,
                Map<String, Integer> edgeMapping) {
        List<List<Node>> adjList = new ArrayList<>();
        int i;
        for(i = 0; i < edgeMapping.size(); i++) {
            adjList.add(new ArrayList<>());
        }
        for(i = 0; i < equations.size(); i++) {
            int start =  edgeMapping.get(equations.get(i).get(0));
            int end =  edgeMapping.get(equations.get(i).get(1));
            adjList.get(start).add(new Node(end, values[i]));
            adjList.get(end).add(new Node(start, 1 / values[i]));
        }
        return adjList;
    }

    private Map<String, Integer> getEdgeMapping(List<List<String>> equations) {
        int counter = 0;
        Map<String, Integer> edgeMapping = new HashMap<>();
        for(List<String> equation : equations) {
            if(!edgeMapping.containsKey(equation.get(0))) {
                edgeMapping.put(equation.get(0), counter++);
            }
            if(!edgeMapping.containsKey(equation.get(1))) {
                edgeMapping.put(equation.get(1), counter++);
            }
        }
        return edgeMapping;
    }
}