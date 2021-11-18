class Recipe {
	private int postID;
	private String recipeTitle;
	private String imageUrl;
	private int serving;
	private String difficulty;
	private double prepTime;
	private String[] ingredients;
	private String instructions;
	private String dishType;
	private String cuisineType;
	private String username;
	
	public Recipe(int postID, String recipeTitle, String imageUrl, int serving, String difficulty, double prepTime, String[] ingredients, String instructions, String dishType, String cuisineType, String username) {
		this.postID = postID;
		this.recipeTitle = recipeTitle;
		this.imageUrl = imageUrl;
		this.serving = serving;
		this.difficulty = difficult;
		//Remind user on front-end to input in minutes
		this.prepTime = prepTime;
		this.ingredients = ingredients;
		this.dishType = dishType;
		this.cuisineType = cuisineType;
		this.username = username;
	}
}
