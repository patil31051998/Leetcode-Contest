class Node {
    private int data;
    private int index;

    public Node(int data, int index) {
        this.data = data;
        this.index = index;
    }

    public int getData() {
        return data;
    }

    public int getIndex() {
        return index;
    }
}

class Solution {
    public int[] lexicographicallySmallestArray(int[] nums, int limit) {
        List<Node> nodes = new ArrayList<>();
        List<List<Node>> groups = new ArrayList<>();
        int groupCurrInd = 0;
        int i;
        for(i = 0; i < nums.length; i++) {
            nodes.add(new Node(nums[i], i));
        }
        Collections.sort(nodes, (n1, n2) -> {
            if(n1.getData() == n2.getData()) {
                return n1.getIndex() - n2.getIndex();
            }
            else {
                return n1.getData() - n2.getData();
            }
        });
        groups.add(new ArrayList<>());
        groups.get(0).add(nodes.get(0));
        for(i = 1; i < nodes.size(); i++) {
            Node lastNode = groups.get(groupCurrInd).get(groups.get(groupCurrInd).size() - 1);
            Node currNode = nodes.get(i);
            if(currNode.getData() - lastNode.getData() > limit) {
                groupCurrInd++;
                groups.add(new ArrayList<>());
            }
            groups.get(groupCurrInd).add(currNode);
        }
        for(List<Node> group : groups) {
            List<Integer> index = new ArrayList<>();
            for(Node node : group) {
                index.add(node.getIndex());
            }
            Collections.sort(index);
            for(i = 0; i < index.size(); i++) {
                nums[index.get(i)] = group.get(i).getData();
            }
        }
        return nums;
    }
}