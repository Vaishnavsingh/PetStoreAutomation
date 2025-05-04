package api.endpoints;

import io.restassured.http.ContentType;
import static io.restassured.RestAssured.given;

import api.payload.User;
import io.restassured.response.Response;

//created to perform CRUD ops
public class UserEndPoints {
	
	
	public static Response createUser(User payload)
	{
		Response res=given()
		.contentType(ContentType.JSON)
		.accept(ContentType.JSON)
		.body(payload)
		.when()
		.post(Routes.postURL);
		return res;
		

	}
	public static Response readUser(String userName)
	{
		Response res=given()
				.pathParam("username", userName)
		
		.when()
		.get(Routes.getURL);
		return res;
		

	}
	
	public static Response updateUser(String username, User payload)
	{
		Response res=given()
		.contentType(ContentType.JSON)
		.accept(ContentType.JSON)
		.pathParam("username", username)
		.body(payload)
		.when()
		.put(Routes.putURL);
		return res;
		

	}
	public static Response deleteUser(String userName)
	{
		Response res=given()
				.pathParam("username", userName)
		
		.when()
		.delete(Routes.deleteURL);
		return res;
		

	}

}
