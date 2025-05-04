package api.endpoints;


/*Swagger URI-> https://petstore.swagger.io
	
	create:https://petstore.swagger.io/v2/user
		get:https://petstore.swagger.io/v2/user/{username}
			update:https://petstore.swagger.io/v2/user/{username}
				delete:https://petstore.swagger.io/v2/user/{username}
				
*/

public class Routes {
	//userModel
	public static String baseURL="https://petstore.swagger.io/v2";
	
	public static String postURL=  baseURL+"/user";
	public static String getURL=  baseURL+"/user/{username}";
	public static String putURL=  baseURL+"/user/{username}";
	public static String deleteURL=  baseURL+"/user/{username}";
	
	//store module
	
	//pet module ----all we can create here in same file
	
	
	

}
