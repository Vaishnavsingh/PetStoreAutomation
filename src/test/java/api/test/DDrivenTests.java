package api.test;

import org.testng.Assert;
import org.testng.annotations.Test;

import api.endpoints.UserEndPoints;
import api.payload.User;
import api.utilities.DataProviders;
import io.restassured.response.Response;

public class DDrivenTests {
	
	
	@Test(priority=1,dataProvider="Data",dataProviderClass= DataProviders.class)
	public void testPostRequest(String id,String uname,String fname,String lname,String email,String pwd,String phone)
	{
		User data=new User();
		data.setId(Integer.parseInt(id));
		data.setUsername(uname);
		data.setFirstname(fname);
		data.setLastname(lname);
		data.setEmail(email);
		data.setPassword(pwd);
		data.setPhone(phone);
		
		Response res= UserEndPoints.createUser(data);
		res.then().log().all();
		Assert.assertEquals(res.getStatusCode(),200);
	}
	
	@Test(priority=1,dataProvider="UserNames",dataProviderClass= DataProviders.class)
	public void testDeleteRequest(String uname)
	{
		
		Response res= UserEndPoints.deleteUser(uname);
		res.then().log().all();
		Assert.assertEquals(res.getStatusCode(),200);
	}

}
