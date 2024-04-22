class Solution {
    Map<String, List<String>> adjacencyList = new HashMap<>();
    List<List<String>> mergedAccountList = new ArrayList<>();
    Set<String> visited = new HashSet<>();
    // Solution 1: DFS
    public List<List<String>> accountsMerge(List<List<String>> accounts) {
        // 1. create adjacencyList
        for(List<String> acc : accounts){
            String firstEmail = acc.get(1);
            if(!adjacencyList.containsKey(firstEmail)){
                adjacencyList.put(firstEmail, new ArrayList<>());
            }
            for(int i = 2; i < acc.size(); i++){
                String email = acc.get(i);
                adjacencyList.get(firstEmail).add(email);
                if(!adjacencyList.containsKey(email)){
                    adjacencyList.put(email, new ArrayList<>());
                }
                adjacencyList.get(email).add(firstEmail);
            }
        }

        // 2. traverse through first email accounts to merge account with DFS
        for(List<String> acc : accounts){
            String accountName = acc.get(0);
            String firstEmail = acc.get(1);
            if(!visited.contains(firstEmail)){
                List<String> mergedAccount = new ArrayList<>();

                // add account name to 0th index
                mergedAccount.add(accountName);
                mergeAccountWithDFS(mergedAccount, firstEmail);

                // after merged with DFS for firstEmail related account
                Collections.sort(mergedAccount.subList(1, mergedAccount.size()));
                mergedAccountList.add(mergedAccount);
            }
        }
        return mergedAccountList;
    }

    private void mergeAccountWithDFS(List<String> mergeAccount, String email){
        // mark email with visited
        visited.add(email);
        mergeAccount.add(email);
        
        for(String neighbor : adjacencyList.get(email)){
            if(!visited.contains(neighbor)){
                mergeAccountWithDFS(mergeAccount, neighbor);
            }
        }
    }
}