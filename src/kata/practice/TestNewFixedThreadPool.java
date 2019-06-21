package kata.practice;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
 

public class TestNewFixedThreadPool {
	static long startTime=0;
	static long endTime=0;
	static int nums=1500;
	public static Long username;
	static int i=0;
	static List<Integer> listNums=new ArrayList<Integer>();
	
	public TestNewFixedThreadPool(Long username) {
		this.username=username;
	}
    public static void main(String[] args) throws InterruptedException {
        ExecutorService fixedThreadPool = Executors.newFixedThreadPool(10);
        for (int i = 1; i <= 10; i++) {
            fixedThreadPool.execute(new Runnable() {
                @Override
                public void run() {
                    try {
                    	 Class.forName("org.postgresql.Driver");
             	        Properties props = new Properties();
             	       props.setProperty("user", "root");
             	        props.setProperty("sslmode", "disable");
             	        	Connection db = DriverManager
             	        			.getConnection("jdbc:postgresql://xxxx:xxxx/xsmlogin", props);
             	        	tanslation(db);
             	    endTime = System.currentTimeMillis();
             	  System.out.println("程序运行时间： "+(endTime-startTime)+"ms"); 
                    } catch (SQLException | ClassNotFoundException e) {
                        e.printStackTrace();
                    }
                }
            });
        }
        Thread.sleep(10000);
    	Double tps =(double) (nums*1000/(endTime-startTime));
    	System.out.println("tps="+tps+"/s");
    	System.out.println(listNums.size());
    }
    private static void tanslation(Connection db) throws SQLException {
		try {
			i++;
			System.out.println("welcome user");
			listNums.add(1);
		}catch(Exception e){
			System.out.println(e);
		}finally {
			db.close();
		}
	}
}
