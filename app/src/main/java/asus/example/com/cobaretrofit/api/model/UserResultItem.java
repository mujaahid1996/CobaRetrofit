package asus.example.com.cobaretrofit.api.model;

//import javax.annotation.Generated;
import com.google.gson.annotations.SerializedName;

// 2.b buat model dari tabel user
//@Generated("com.robohorse.robopojogenerator")
public class UserResultItem {

	@SerializedName("name")
	private String name;

	@SerializedName("topic")
	private String topic;

	@SerializedName("email")
	private String email;

	@SerializedName("age")
	private String age;

	public UserResultItem(String name, String email, String topic,  String age) {
		this.name = name;
		this.topic = topic;
		this.email = email;
		this.age = age;
	}

	public void setName(String name){
		this.name = name;
	}

	public String getName(){
		return name;
	}

	public void setTopic(String topic){
		this.topic = topic;
	}

	public String getTopic(){
		return topic;
	}

	public void setEmail(String email){
		this.email = email;
	}

	public String getEmail(){
		return email;
	}

	public void setAge(String age){
		this.age = age;
	}

	public String getAge(){
		return age;
	}

	@Override
 	public String toString(){
		return 
			"UserResultItem{" +
			"name = '" + name + '\'' + 
			",topic = '" + topic + '\'' + 
			",email = '" + email + '\'' + 
			",age = '" + age + '\'' + 
			"}";
		}
}