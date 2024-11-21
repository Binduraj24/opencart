package InterviewJavaPrograms;

public class Reverseastring {

	public static void main(String[] args)
	{
		
		//appracoh1
	/*	String name="Himabindu";
		String reverse=new StringBuilder(name).reverse().toString();
		System.out.println(reverse);

	}*/


		String name="Himabindu";
		String reverse="";
		for(int i=name.length()-1;i>=0;i--) {
			reverse+=name.charAt(i);
			System.out.println(reverse);
		}
}
}