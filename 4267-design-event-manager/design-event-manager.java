class EventManager {

    Map<Integer, Integer> eventIdPriorityMap;
    PriorityQueue<Pair<Integer, Integer>> pq;

    public EventManager(int[][] events) {
        eventIdPriorityMap = new HashMap<>();
        pq = new PriorityQueue<>((v1, v2) -> {
            if(v1.getValue().equals(v2.getValue())) {
                return v1.getKey() - v2.getKey();
            } else {
                return v2.getValue() - v1.getValue();
            }
        });
        for(int[] event : events) {
            pq.add(new Pair(event[0], event[1]));
            eventIdPriorityMap.put(event[0], event[1]);
        }
    }
    
    public void updatePriority(int eventId, int newPriority) {
        pq.add(new Pair(eventId, newPriority));
        eventIdPriorityMap.put(eventId,newPriority);
    }
    
    public int pollHighest() {
        while(!pq.isEmpty()) {
            Pair<Integer, Integer> pair = pq.remove();
            if(pair.getValue().equals(eventIdPriorityMap.get(pair.getKey()))) {
                eventIdPriorityMap.remove(pair.getKey());
                return pair.getKey();
            }
        }
        return -1;
    }
}

/**
 * Your EventManager object will be instantiated and called as such:
 * EventManager obj = new EventManager(events);
 * obj.updatePriority(eventId,newPriority);
 * int param_2 = obj.pollHighest();
 */