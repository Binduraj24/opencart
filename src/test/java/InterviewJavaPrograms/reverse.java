package InterviewJavaPrograms;

public class reverse {

	public static void main(String[] args) {
		String name="bindu";
		String reverse="";
		for(int i=name.length()-1;i>=0;i--) {
			reverse+=name.charAt(i);
		}
System.out.println(reverse);
	}

	/*string path="";
	excelutility xl=new exceluitlity(path);
	xl totalrows=xl.getrows("");
	xl totalcols=xl.getcols();
	string logindata[][]=new string[totalrows][totalcels];
	for(i=0;i<totalrows;i++) {
		for(j=o;j<totalcell;j++) {
			login[i-1][j]=x.getcell(shel,i,j);
		}
	}
returndata[][];
}*/
}
