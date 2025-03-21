class Solution {
    public List<String> findAllRecipes(String[] recipes, List<List<String>> ingredients, String[] supplies) {
        Set<String> recipesSet = new HashSet<>();
        Set<String> suppliesSet = new HashSet<>();
        Map<String, Boolean> recipeCheckMap = new HashMap<>();
        Map<String, List<String>> recipeIngredientsMap = new HashMap<>();
        int i;
        List<String> result = new ArrayList<>();
        Set<String> visited = new HashSet<>();

        for(String recipe : recipes) {
            recipesSet.add(recipe);
        }
        for(String supplie : supplies) {
            suppliesSet.add(supplie);
        }
        for(i = 0; i < recipes.length; i++) {
            recipeIngredientsMap.put(recipes[i], ingredients.get(i));
        }
        
        for(String recipe : recipes) {
            if(isRecipePossible(recipe, recipeIngredientsMap, recipesSet, suppliesSet, recipeCheckMap, visited)) {
                recipeCheckMap.put(recipe, true);
            }
        }

        for(Map.Entry<String, Boolean> entry : recipeCheckMap.entrySet()) {
            if(entry.getValue()) {
                result.add(entry.getKey());
            }
        }

        return result;
    }

    private boolean isRecipePossible(String recipe, Map<String, List<String>> recipeIngredientsMap,
             Set<String> recipesSet, Set<String> suppliesSet, Map<String, Boolean> recipeCheckMap,
             Set<String> visited) {
        if(visited.contains(recipe)) {
            return false;
        }
        visited.add(recipe);
        for(String ingredient : recipeIngredientsMap.get(recipe)) {
            if(suppliesSet.contains(ingredient)) {
                continue;
            }
            else if(recipesSet.contains(ingredient)) {
                if(recipeCheckMap.containsKey(ingredient)) {
                    if(recipeCheckMap.get(ingredient)) {
                        continue;
                    }
                    else {
                        return false;
                    }
                }
                boolean res = isRecipePossible(ingredient, recipeIngredientsMap, recipesSet, suppliesSet, recipeCheckMap, visited);
                recipeCheckMap.put(ingredient, res);
                if(!res) {
                    return false;
                }
            }
            else {
                return false;
            }
        }
        return true;
    }
}

