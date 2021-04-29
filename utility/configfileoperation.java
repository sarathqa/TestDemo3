import java.util.Properties;

public class configfileoperation {
	
	
	public static void readfile(){
		
		Properties pro= new Properties();
		FileInputStream fis= new FileInputStream(".\externalfile\config.properties");
		pro.load(fis);
		System.out.println(pro.get("browser"));
		
	}
	
	public static void main(String[] args) {
		readfile();
	}
}
