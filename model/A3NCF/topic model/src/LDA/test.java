
package LDA;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

import LDA.Documents.Document;
import util.FileOperator; 

public class test {    
	public ArrayList<test> docs;
	public int userNum;
	public int itemNum;

	public int tword_size; // text words size
	public static HashMap<String, Integer> tword2id; // text words to id
	public static HashMap<Integer, String> id2tword; // id to text word
	
	public test() {
		docs = new ArrayList<test>();

		tword2id = new HashMap<String, Integer>();
		id2tword = new HashMap<Integer, String>();
	}
	
	
	public static void main(String[] args) throws IOException {         
		FileOperator fo = new FileOperator();
		BufferedWriter bw = fo.write(new File("/Users/jieunpark/Desktop/java_workspace/22_2_Modeling_A3NCF/topicmodelresults/A3NCF/tword2id.dat"));
		Iterator<String> it = tword2id.keySet().iterator();
		while (it.hasNext()) {
			String key = it.next();
			int value = tword2id.get(key);
			bw.write(key + "\t" + value);
			bw.newLine();
		}
		bw.close();
	}
	
	public void readDocs(String docPath) throws IOException {
		FileOperator fo = new FileOperator();
		String inputLine = null;
		BufferedReader br = fo.read(new File(docPath));
		while ((inputLine = br.readLine()) != null) {
			String[] parts = inputLine.trim().split(","); // inputLine.trim().split(",") -> trim() 제
			if (parts.length < 4) {
				continue;
			}
			int userIdx = Integer.valueOf(parts[0]);
			int itemIdx = Integer.valueOf(parts[1]);
			if (userNum < userIdx) {
				userNum = userIdx;
			}

			if (itemNum < itemIdx) {
				itemNum = itemIdx;
			}
			//String docContent = parts[3];
			//test doc = new test(userIdx, itemIdx, docContent, tword2id, id2tword);
			//docs.add(doc);
		}
		br.close();
		tword_size = tword2id.size();

		userNum++;
		itemNum++;

		System.out.println("User num: " + userNum);
		System.out.println("Item num: " + itemNum);
	} 

}



/*



	public void readDocs(String docPath) throws IOException {
		FileOperator fo = new FileOperator();
		String inputLine = null;
		BufferedReader br = fo.read(new File(docPath));
		while ((inputLine = br.readLine()) != null) {
			String[] parts = inputLine.trim().split(","); // inputLine.trim().split(",") -> trim() 제
			if (parts.length < 4) {
				continue;
			}
			int userIdx = Integer.valueOf(parts[0]);
			int itemIdx = Integer.valueOf(parts[1]);
			if (userNum < userIdx) {
				userNum = userIdx;
			}

			if (itemNum < itemIdx) {
				itemNum = itemIdx;
			}
			String docContent = parts[3];
			Document doc = new Document(userIdx, itemIdx, docContent, tword2id, id2tword);
			docs.add(doc);
		}
		br.close();
		tword_size = tword2id.size();

		userNum++;
		itemNum++;

		System.out.println("User num: " + userNum);
		System.out.println("Item num: " + itemNum);
	} 
 
*/

/*
public class test {    
	
	public int userNum;
	public int itemNum;
	
	public static void main(String[] args) throws IOException {         
		BufferedReader reader = new BufferedReader(            
				new FileReader("data/index_Patio_Lawn_and_Garden.test.dat")
				);         
		String str;        
		while ((str = reader.readLine()) != null) {            
			System.out.println(str);        
			}         
		reader.close();            
		}
	}
*/
