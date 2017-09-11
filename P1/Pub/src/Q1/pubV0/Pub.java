package Q1.pubV0;

public class Pub {
    private static DrinkPrice drinkPrice;
    Pub(){
    	if(drinkPrice == null)
    		drinkPrice = new DrinkPrice();
    }
    
    public int computeCost(String drink, boolean student, int amount) {

        if (checkIfThereIsTooMuch(drink, amount)) {
            throw new RuntimeException("Too many drinks, max 2.");
        }
        
        int price = drinkPrice.getPrice(drink);
        
        if (checkStudentDiscount(drink, student)) {
            price = priceWithDiscount(price);
        }
        
        return price*amount;
    }
    
    private boolean checkIfThereIsTooMuch(String drink, int amount){
    	return amount > 2 && (drink == IngredientName.GT || drink == IngredientName.BACARDI_SPECIAL);
    }
    
    private boolean checkStudentDiscount(String drink, boolean student){
    	return student && (drink == IngredientName.ONE_CIDER || drink == IngredientName.ONE_BEER
        		|| drink == IngredientName.A_PROPER_CIDER);
    }
    
    private int priceWithDiscount(int price){
    	return (int) (price - price/10);
    }

}
