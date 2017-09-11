package Q1.pubV0;

import java.util.HashMap;

public class DrinkPrice {
    public static final String ONE_BEER = "hansa";
    public static final String ONE_CIDER = "grans";
    public static final String A_PROPER_CIDER = "strongbow";
    public static final String GT = "gt";
    public static final String BACARDI_SPECIAL = "bacardi_special";
    private static IngredientPrice ingredient;
    private static HashMap<String, Integer> drinkPrice;
	DrinkPrice(){
		if(ingredient==null)
			ingredient = new IngredientPrice();
		if(drinkPrice == null){
	    	drinkPrice = new HashMap<String, Integer>();
	    	drinkPrice.put(IngredientName.ONE_BEER, 74);
	    	drinkPrice.put(IngredientName.ONE_CIDER, 103);
	    	drinkPrice.put(IngredientName.A_PROPER_CIDER, 110);
	    	drinkPrice.put(IngredientName.GT,  ingredient.getPrice("gin") + ingredient.getPrice("tonicWater") +
	    			ingredient.getPrice("greenStuff"));
	    	drinkPrice.put(BACARDI_SPECIAL,  ingredient.getPrice("rum") + ingredient.getPrice("grenadine") +
	    			ingredient.getPrice("limeJuice") + ingredient.getPrice("gin"));
    	}	
	}
	
	public int getPrice(String s){
		if(!drinkPrice.containsKey(s))
			throw new RuntimeException("No such drink exists");
        
		return drinkPrice.get(s);
	}
}
