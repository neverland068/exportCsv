package exportCsv;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class exportCsvMain {

	public static void main(String[] args) throws Exception {
		// 输出csv的list
		List<HashMap<Object, Object>> hashMapList = new ArrayList<HashMap<Object, Object>>();
		// 获取要输出的list 手动输出10条数据
		for (int i= 0 ; i < 10; i++) {
			HashMap<Object, Object> hashMap = new HashMap<Object, Object>();
			hashMap.put("KEY", "KEY00" + i);
			hashMap.put("VALUE", "VALUE00" + i);
			hashMap.put("NUMBER", "NUMBER00" + i);
			hashMapList.add(hashMap);
		}
		// 创建csv文件
		File csvFile = new File("D:\\" + "111.csv");
		csvFile.createNewFile();
		// 创建文件输出流
		FileOutputStream fileOutputStream = new FileOutputStream(csvFile);
		// 创建写字节输出流
		OutputStreamWriter outputStreamWriter = new OutputStreamWriter(fileOutputStream);
		// 创建写字节缓冲输出流
		BufferedWriter outputStreamWrite = new BufferedWriter(outputStreamWriter);
		// csv头文件
		outputStreamWrite.write("KEY,VALUE,NUMBER");
		outputStreamWrite.newLine();
		for (HashMap<Object, Object> hashMap : hashMapList) {
			StringBuffer sb1 = new StringBuffer();
			sb1.append(hashMap.get("KEY")).append(",").append(hashMap.get("VALUE")).append(",").append(hashMap.get("NUMBER")).append(",");
			outputStreamWrite.write(sb1.toString());
			outputStreamWrite.newLine();
			System.out.println(sb1);
		}
		outputStreamWrite.flush();
	}
}
