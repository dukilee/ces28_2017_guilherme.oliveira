package Q1.pubV0;

import java.util.HashMap;

public class IngredientPrice {
    private static HashMap<String, Integer> ingredientPrice;
    
    public IngredientPrice(){
    	if(ingredientPrice==null){
    		ingredientPrice = new HashMap<String, Integer>();
	    	ingredientPrice.put("rum", 65);
	    	ingredientPrice.put("grenadine", 10);
	    	ingredientPrice.put("limeJuice", 10);
	    	ingredientPrice.put("greenStuff", 10);
	    	ingredientPrice.put("tonicWater", 20);
	    	ingredientPrice.put("gin", 85);
    	}
    }
    
    public int getPrice(String s){
    	return ingredientPrice.get(s);
    }
}
