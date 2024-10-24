package commonUtils;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class JsonUtils {

	static JSONObject jsonObject;
	
	public JsonUtils()
	{
		
		
	}
   
    public static void getValueFromJsonFile(String jsonFilePath, String jpath) throws IOException {
           
         BufferedReader reader = new BufferedReader(new FileReader(jsonFilePath)) ;
            StringBuilder jsonBuilder = new StringBuilder();
            String line;
            while ((line = reader.readLine()) != null) {
                jsonBuilder.append(line);
                
            }
            // Convert the StringBuilder to a string
            String jsonString = jsonBuilder.toString();

            // Parse the JSON string into a JSONArray
            
            if(jsonString.startsWith("[")) {
            JSONArray jsonArray = new JSONArray(jsonString);

            // Now you can use the JSONArray
            System.out.println("JSON Array: " + jsonArray.toString());
            
            // Example: Iterating through the JSONArray
            for (int i = 0; i < jsonArray.length(); i++) {
                try {
					jsonObject = jsonArray.getJSONObject(i);
				} catch (JSONException e) {

					e.printStackTrace();
				}
                System.out.println("Object " + i + ": " + jsonObject.toString());
            }
            }
            else {
            	
            	  JSONObject jsonobj = new JSONObject(jsonString);

                  // Now you can use the JSONArray
                  System.out.println("JSON Array: " + jsonobj.toString());
                  
                  // Example: Iterating through the JSONArray
                  for (int i = 0; i < jsonobj.length(); i++) {
                      try {
      					jsonObject = jsonobj;
      				} catch (JSONException e) {

      					e.printStackTrace();
      				}
                      System.out.println("Object " + i + ": " + jsonObject.toString());
                  }
            	
            }

            
            String value = getValueByJPath(jsonObject, jpath);
            System.out.println("Json value for jpath is : " + value);
            
        }
            
    
    private static String getValueByJPath(Object responseJson, String jpath) {
        Object obj = responseJson;

        for (String s : jpath.split("/")) {
            if (!s.isEmpty()) {
                try {
                    // If it's a JSONObject key (no array index)
                    if (!s.contains("[") && !s.contains("]")) {
                        if (obj instanceof JSONObject) {
                            obj = ((JSONObject) obj).get(s);
                        } else if (obj instanceof JSONArray) {
                            throw new JSONException("Expected JSONObject but found JSONArray");
                        } else {
                            throw new JSONException("Unexpected type at " + s + ": " + obj.getClass().getSimpleName());
                        }
                    }
                    // If it's a JSONArray (contains array index)
                    else if (s.contains("[") && s.contains("]")) {
                        String arrayKey = s.split("\\[")[0]; // Key before the array index
                        int index = Integer.parseInt(s.split("\\[")[1].replaceAll("]", "")); // Extract index

                        if (obj instanceof JSONObject) {
                            Object arrayObject = ((JSONObject) obj).get(arrayKey);

                            if (arrayObject instanceof JSONArray) {
                                JSONArray jsonArray = (JSONArray) arrayObject;

                                if (jsonArray.length() > index) {
                                    obj = jsonArray.get(index);
                                } else {
                                    System.out.println("Index out of bounds: " + index + " for array: " + arrayKey);
                                    return null; // Handle index out of bounds
                                }
                            } else {
                                throw new JSONException("Expected JSONArray but found " + arrayObject.getClass().getSimpleName());
                            }
                        } else if (obj instanceof JSONArray) {
                            // If the current object is already a JSONArray (no need to fetch it via a key)
                            JSONArray jsonArray = (JSONArray) obj;

                            if (jsonArray.length() > index) {
                                obj = jsonArray.get(index);
                            } else {
                                System.out.println("Index out of bounds: " + index);
                                return null; // Handle index out of bounds
                            }
                        } else {
                            throw new JSONException("Expected JSONObject or JSONArray but found " + obj.getClass().getSimpleName());
                        }
                    }
                } catch (JSONException e) {
                    System.out.println("Error accessing key or array: " + s);
                    e.printStackTrace();
                    return null; // Return null if any key or array access fails
                }
            }
        }

        // Handle non-object types (e.g., strings, numbers)
        if (obj instanceof JSONObject || obj instanceof JSONArray) {
            return obj.toString();
        } else {
            return String.valueOf(obj); // Convert to string for primitive types
        }
    }

}
