package MavenPack;

import java.io.IOException;

public class ExcelRead {

	public static void main(String[] args) throws IOException {
		
		Excel e=new Excel();
		String a=e.read(0,0);
		System.out.println(a);
		String b=e.read(0,1);
		System.out.println(b);
		System.out.println("Change build");
	}
}
