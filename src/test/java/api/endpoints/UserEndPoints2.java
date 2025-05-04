package api.endpoints;

import io.restassured.http.ContentType;
import static io.restassured.RestAssured.given;

import java.util.ResourceBundle;

import api.payload.User;
import io.restassured.response.Response;

//created to perform CRUD ops
public class UserEndPoints2 {
	
	
	static ResourceBundle getURL()
	{
		ResourceBundle routes=	ResourceBundle.getBundle("routes");//Load properties file
		return routes;
	}
	public static Response createUser(User payload)
	{
		String post = getURL().getString("post_url");
		Response res=given()
		.contentType(ContentType.JSON)
		.accept(ContentType.JSON)
		.body(payload)
		.when()
		.post(post);
		return res;
		

	}
	public static Response readUser(String userName)
	{
		String get = getURL().getString("get_url");
		Response res=given()
				.pathParam("username", userName)
		
		.when()
		.get(get);
		return res;
		

	}
	
	public static Response updateUser(String username, User payload)
	{
		String update = getURL().getString("update_url");
		Response res=given()
		.contentType(ContentType.JSON)
		.accept(ContentType.JSON)
		.pathParam("username", username)
		.body(payload)
		.when()
		.put(update);
		return res;
		

	}
	public static Response deleteUser(String userName)
	{
		String delete = getURL().getString("delete_url");
		Response res=given()
				.pathParam("username", userName)
		
		.when()
		.delete(delete);
		return res;
		

	}

}
