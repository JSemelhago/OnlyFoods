package com.mie.model;

public class Recipe {
	private int postID;
	private String recipeTitle;
	private String imageUrl;
	private int serving;
	private String difficulty;
	private double prepTime;
	private String ingredients;
	private String instructions;
	private String dishType;
	private String cuisineType;
	private String username;
	private int numberOfLikes;
	
	public Recipe(){
		
	}
	
	public Recipe(int postID, String recipeTitle, String imageUrl, int serving, String difficulty, double prepTime, String ingredients, String instructions, String dishType, String cuisineType, String username) {
		this.postID = postID;
		this.recipeTitle = recipeTitle;
		this.imageUrl = imageUrl;
		this.serving = serving;
		this.difficulty = difficulty;
		//Remind user on front-end to input in minutes
		this.prepTime = prepTime;
		this.ingredients = ingredients;
		this.dishType = dishType;
		this.cuisineType = cuisineType;
		this.username = username;
		this.numberOfLikes = 0;
	}
	
	//Getters
	public int getPostID() {
		return this.postID;
	}
	public String getRecipeTitle() {
		return this.recipeTitle;
	}
	public String getImageUrl() {
		return this.imageUrl;
	}
	public int getServing() {
		return this.serving;
	}
	public String getDifficulty() {
		return this.difficulty;
	}
	public double getPrepTime() {
		return this.prepTime;
	}
	public String getIngredients() {
		return this.ingredients;
	}
	public String getInstructions() {
		return this.instructions;
	}
	public String getDishType() {
		return this.dishType;
	}
	public String getCuisineType() {
		return this.cuisineType;
	}
	public String getUsername() {
		return this.username;
	}
	public int getNumberOfLikes() {
		return this.numberOfLikes;
	}
	
	//Setters
	public void setPostID(int postID) {
		this.postID = postID;
	}
	public void setRecipeTitle(String recipeTitle) {
		this.recipeTitle = recipeTitle;
	}
	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}
	public void setServing(String stringserving) {
		int intserving = Integer.valueOf(stringserving);
		this.serving = intserving;
	}
	public void setDifficulty(String difficulty) {
		this.difficulty = difficulty;
	}
	public void setPrepTime(String stringprepTime) {
		double doublepreptime = Double.valueOf(stringprepTime);
		this.prepTime = doublepreptime;
	}
	public void setIngredients(String ingredients) {
		this.ingredients = ingredients;
	}
	public void setInstructions(String instructions) {
		this.instructions = instructions;
	}
	public void setDishType(String dishType) {
		this.dishType = dishType;
	}
	public void setCuisineType(String cuisineType) {
		this.cuisineType = cuisineType;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	
	public void setNumberOfLikes(int updatedNumberOfLikes) {
		this.numberOfLikes = numberOfLikes;
	}
	
	public void updateRecipeDatabase() {
		String qStr = "UPDATE RecipeDatabase Set RecipeTitle ='" + recipeTitle + "', ImageUrl ='" + imageUrl + "', Serving = '"
				+ serving + "', Difficulty = '" + difficulty +  "', PrepTime = '" + prepTime +  "', Ingredients = '" + ingredients + "', Instructions = '" + instructions + "', DishType = '" + dishType +"', CuisineType = '" + cuisineType +"', Username = '" + username + "' WHERE PostID =" + postID + "; ";
				OnlyFoodsRunner.runUpdate(qStr);
	}
}
