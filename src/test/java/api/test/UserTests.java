package api.test;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.github.javafaker.Faker;

import api.endpoints.UserEndPoints;
import api.payload.User;
import io.restassured.response.Response;

public class UserTests 

{
	Faker fake;
	User data;
	
	
	 @BeforeClass
	void dataSetUp()
	{
		 fake=  new Faker();
		 data = new User();			 
		data.setId(fake.idNumber().hashCode());
		data.setUsername(fake.name().username());
		data.setLastname(fake.name().lastName());
		data.setEmail(fake.internet().emailAddress());
		data.setPassword(fake.internet().password());
		data.setPhone(fake.phoneNumber().cellPhone());
		 }
	 @Test(priority=1)
		public void testPostUser() 
	 {
		Response res= UserEndPoints.createUser(data);
		res.then().log().all();
		Assert.assertEquals(res.getStatusCode(),200);
		}
	 
	 @Test(priority=2)
		public void testGetByUserName() 
	 {
		Response res= UserEndPoints.readUser(this.data.getUsername());
		res.then().log().all();
		Assert.assertEquals(res.getStatusCode(),200);
		}
	 
	 @Test(priority=3)
		public void testUpdateByUserName() 
	 {
		 data.setUsername(fake.name().username());
			data.setLastname(fake.name().lastName());
			data.setEmail(fake.internet().emailAddress());
		Response res= UserEndPoints.updateUser(this.data.getUsername(),data);
		res.then().log().body();
		Assert.assertEquals(res.getStatusCode(),200);
		Response responseafterupdate= UserEndPoints.readUser(this.data.getUsername());
		responseafterupdate.then().log().all();
		Assert.assertEquals(responseafterupdate.getStatusCode(),200);
		}
	 
	 @Test(priority=4)
		public void testdeleteByUserName() 
	 {
		Response res= UserEndPoints.deleteUser(this.data.getUsername());
		res.then().log().all();
		Assert.assertEquals(res.getStatusCode(),200);
		}
		
	
}
