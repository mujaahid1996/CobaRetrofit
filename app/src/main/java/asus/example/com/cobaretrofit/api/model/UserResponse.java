package asus.example.com.cobaretrofit.api.model;

import java.util.List;
//import javax.annotation.Generated;
import com.google.gson.annotations.SerializedName;

// 2.a buat response dari tabel user
//@Generated("com.robohorse.robopojogenerator")
public class UserResponse {

	@SerializedName("result")
	private List<UserResultItem> result;

	public void setResult(List<UserResultItem> result){
		this.result = result;
	}

	public List<UserResultItem> getResult(){
		return result;
	}

	@Override
 	public String toString(){
		return 
			"UserResponse{" +
			"result = '" + result + '\'' + 
			"}";
		}
}