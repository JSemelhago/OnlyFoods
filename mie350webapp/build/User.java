class User {
	private String username;
	private String password;
	private String name;
	private String email;
	private String bio;
	private String location;
	private String photoUrl
	
	public User(String username, String password, String name, String email) {
		this.username = username;
		this.password = password;
		this.name = name;
		this.email = email;
	}
	
	public User(String username, String password, String name, String email, String bio, String location, String photoUrl) {
		this.username = username;
		this.password = password;
		this.name = name;
		this.email = email;
		this.bio = bio;
		this.location = location;
		this.photourl = photourl;
	}
	
	//getters
	public String getUsername{
		return username;
	}
	
	public String getPassword{
		return password;
	}
	
	public String getName{
		return name;
	}
	
	public String getEmail{
		return email;
	}
	
	public String getBio{
		return bio;
	}
	
	public String getLocation{
		return location;
	}
	
	public String getPhotoUrl{
		return photoUrl;
	}
	
	//setters
	public void setUsername(String username){
		this.username = username;
	}
	
	public void setPassword(String password) {
		this.password = password;
	}
	
	public void setName(String name) {
		name = name;
	}
	
	public void setEmail(String email) {
		email = email;
	}
	
	public void setBio(String bio){
		bio = bio;
	}
	
	public void setLocation(String location) {
		location = location;
	}
	
	public void setPhotoUrl(String photoUrl) {
		photoUrl = photoUrl;
	}
}