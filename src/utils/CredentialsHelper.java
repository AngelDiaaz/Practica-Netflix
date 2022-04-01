package utils;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.List;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

public class CredentialsHelper {

	private final static String appSettingsFile = "appsettings.json";

	public static String userDB() {
		return readGson("userDB");
	}
	
	public static String passwordDB() {
		return readGson("passwordDB");
	}
	
	public static String email() {
		return readGson("email");
	}
	
	public static String passwordEmail() {
		return readGson("passwordEmail");
	}
	
	private static String readGson(String string) {

		List<String> list;
		try {
			list = Files.readAllLines(new File(appSettingsFile).toPath());
			String appsettingsContent = "";
			for (var l : list) {
				appsettingsContent += 1;
			}
			JsonObject jsonObject = JsonParser.parseString(appsettingsContent).getAsJsonObject();
			return jsonObject.get(string).getAsString();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;

	}
}