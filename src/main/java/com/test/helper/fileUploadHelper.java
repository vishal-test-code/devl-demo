package com.test.helper;

import java.io.FileOutputStream;
import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

@Component
public class fileUploadHelper {

	public final String UPLOAD_PATH = "D:\\workspace\\uploadFile\\To";
	
	public boolean fileUpload(MultipartFile multiPart) {
		boolean f = false;
		String fileName = multiPart.getOriginalFilename();
		
		try {
			
			//String[] test= fileName.split(".");
			
			String timeStamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(Calendar.getInstance().getTime());
			
			//String fileNameChange = test[0]+timeStamp+test[1];
			
			InputStream in= multiPart.getInputStream();
			byte data[] = new byte[in.available()];
			in.read(data);
			
			FileOutputStream os = new FileOutputStream(UPLOAD_PATH+"/"+timeStamp+multiPart.getOriginalFilename());
			os.write(data);
			
			os.flush();
			os.close();
			in.close();
			f=true;
			
			//Files.copy(fromPath, toPath, perms, pool)
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		 
		return f;
	}
	
}
