package com.example.demotodolist;

import com.google.auth.oauth2.GoogleCredentials;
import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseOptions;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

@SpringBootApplication
public class DemotodolistApplication {

	public static void main(String[] args) throws IOException {
		ClassLoader classLoader = DemotodolistApplication.class.getClassLoader();

		File file = new File("src/main/resources/serviceAccountKey.json");
		String absolutePath = file.getAbsolutePath();

		FileInputStream serviceAccount =
				new FileInputStream(absolutePath);

		FirebaseOptions options = new FirebaseOptions.Builder()
				.setCredentials(GoogleCredentials.fromStream(serviceAccount))
				.build();

		FirebaseApp.initializeApp(options);


		SpringApplication.run(DemotodolistApplication.class, args);
	}

}
