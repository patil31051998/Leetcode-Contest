class Solution {
    public List<Boolean> checkIfPrerequisite(int numCourses, int[][] prerequisites, int[][] queries) {
        List<List<Integer>> adjList = getAdjList(numCourses, prerequisites);
        int[] visited = new int[numCourses];
        int i;
        Map<Integer, Set<Integer>> prerequisiteMap = new HashMap<>();
        List<Boolean> result = new ArrayList<>();
        for(i = 0; i < numCourses; i++) {
            getAllprerequisites(i, adjList, prerequisiteMap); 
        }
        for(int[] query : queries) {
            if(prerequisiteMap.get(query[0]).contains(query[1])) {
                result.add(true);
            }
            else {
                result.add(false);
            }
        }
        return result;
    }

    private Set<Integer> getAllprerequisites(int i, List<List<Integer>> adjList, Map<Integer, Set<Integer>> prerequisiteMap) {
        if(prerequisiteMap.containsKey(i)) {
            return prerequisiteMap.get(i);
        }
        Set<Integer> curr = new HashSet<>();
        for(int adj : adjList.get(i)) {
            curr.add(adj);
            curr.addAll(getAllprerequisites(adj, adjList, prerequisiteMap));
        }
        prerequisiteMap.put(i, new HashSet<>(curr));
        return curr;
    }

    private List<List<Integer>> getAdjList(int numCourses, int[][] prerequisites) {
        List<List<Integer>> adjList = new ArrayList<>();
        int i;
        for(i = 0; i < numCourses; i++) {
            adjList.add(new ArrayList<>());
        }
        for(int[] prerequisite : prerequisites) {
            adjList.get(prerequisite[0]).add(prerequisite[1]);
        }
        return adjList;
    }
}