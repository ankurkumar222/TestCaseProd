package assignments.commonutils;

public class CommonUtility {
	public static void printToConsole(String resultString){
		if(resultString.length()>100){
			System.out.println(resultString.substring(0, 100)+"continue ......");
		}else{
			System.out.println(resultString);
		}
	}
}
