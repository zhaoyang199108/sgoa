package com.bcqsoft.sgoa.common.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.apache.poi.hwpf.extractor.WordExtractor;

public class Test {

	/**
	 * @param args
	 * @throws ClassNotFoundException 
	 * @throws SQLException 
	 * @throws IOException 
	 */
	public static void main(String[] args) throws ClassNotFoundException, SQLException, IOException {
		// TODO Auto-generated method stub
		Class.forName("com.mysql.jdbc.Driver");
		Connection conn = DriverManager
				.getConnection("jdbc:mysql://localhost/sgoa?user=root&password=cq123");
		Statement stmt = conn.createStatement();
		ResultSet rs = stmt
				.executeQuery("select D_FileBody from ewebmessage_t_documentfile WHERE D_ID=228");
		while (rs.next()) {
//			Blob blob = rs.getBlob("D_FileBody");  
//			int bolblen = (int) blob.length();  
//			byte[] data = blob.getBytes(1, bolblen);  
//			String content = new String(data,"utf-8");
//			Blob bb = rs.getBlob(1);
//    		byte[] b = bb.getBytes(1, (int)bb.length());
//            String result = new String(b,"utf-8");
			FileOutputStream fos = new FileOutputStream("D:\\aaa.doc");
	        fos.write(rs.getBytes("D_FileBody"));
	        fos.close();
	        FileInputStream is = new FileInputStream(new File("D:\\aaa.doc"));
	        WordExtractor extrator = new WordExtractor(is); 

	        String text = extrator.getText(); 
			System.out.println(text);
		}
	}

}
