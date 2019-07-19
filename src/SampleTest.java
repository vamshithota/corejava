import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class SampleTest {
	
	public static void main(String[] args) {
		List<String> existingList = new ArrayList<>();//exixting attachments
		List<String> newList = new ArrayList<>();//new attachments
		existingList.add("1");
		existingList.add("2");
		existingList.add("3");
		newList.add("a");
		newList.add("b");
		newList.add("1");
		List<String> existList = new ArrayList<>(); //List<Attachment> existAttachment
		List<String> deleteList = new ArrayList<>();
		List<String> insertList = new ArrayList<>();
		boolean isExist = true;
		for(String str : newList) {//Attachment att : newAttachmentList
			for(String str1 : existingList) { //Attachment att : existingAttach
				
				if(str.equalsIgnoreCase(str1)) {
					existList.add(str);
					isExist = true;
					break;
				} else if(!str.equalsIgnoreCase(str1)) {
					isExist = false;
				}
			}
			if(!isExist) {
				insertList.add(str);
			}
		}
		
		for(String str2 : existingList) { //Attachment att : existingAttach
			boolean isDelete = true;
			for(String str3 : existList) { //Attachment att : existAttach
				if(str2.equals(str3)) {
					isDelete = false;
				}
			}
			if(isDelete) {
				deleteList.add(str2);
			}
		}
		System.out.println("Array List insert::"+Arrays.toString(insertList.toArray()));
		System.out.println("Array List exist::"+Arrays.toString(existList.toArray()));
		System.out.println("Array List delete::"+Arrays.toString(deleteList.toArray()));
	}

}
