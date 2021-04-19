package verify.exam07;

import java.io.BufferedReader;
import java.io.FileReader;

public class AddLineNumberExample {
	public static void main(String[] args) throws Exception {
		String filePath = "C:dev\\workspace\\git\\javaLab\\chap18Lab\\src\\sec05\\exam04_bufferedreader\\BufferedReaderExample.java";
		
		FileReader fr = new FileReader(filePath);
		BufferedReader br = new BufferedReader(fr);
		
		int rowNumber = 0;
		String rowData;
		while( (rowData=br.readLine())!= null ) {
			System.out.println(++rowNumber + ": " + rowData);//rowData 가 어디서들어오냐
		}
		
		br.close(); fr.close();
	}
}
