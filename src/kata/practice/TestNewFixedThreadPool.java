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
             	        			.getConnection("jdbc:postgresql://10.221.129.149:26257/xsmlogin", props);
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
			 ResultSet res = db.createStatement()
			            .executeQuery("SELECT PARMS_VALUE FROM ST_ORGAN_PARMS WHERE ORGAN_ID='0' AND PARMS_NAME='NO_IMPRESSIBLE_PARAMETER'");
			 ResultSet res1 = db.createStatement()
			            .executeQuery("SELECT PARMS_VALUE FROM ST_ORGAN_PARMS WHERE ORGAN_ID='0' AND PARMS_NAME='NO_IMPRESSIBLE_PARAMETER'");
			 ResultSet res3 = db.createStatement()
			            .executeQuery("SELECT INNER_OPEN_ID,LOCK_TIME,PSWD_EXPIRED_TIME,MENG_ID,USER_ID ,NICKNAME,USER_TYPE, PASSWORD,IS_MRB,a.COM_ID,SALEDPT_ID,REF_ID,LOGIN_EMAIL,VERIFIED_MAIL,LOGIN_PHONE,VERIFIED_PHONE,NOTIFY_LEVEL,  B.COM_NAME,B.COM_SHORT,B.TYPE AS COM_TYPE,B.PARENT_COM_ID,DOMAIN_URL from ST_USERS A,ST_COM B WHERE A.COM_ID=B.COM_ID AND USER_ID = "+"'"+username+"'"+"\n" + 
			            		"");
			 ResultSet res4 = db.createStatement()
			            .executeQuery("SELECT COM_ID, USER_ID, DOMAIN_URL, IS_IOP_USER FROM ST_USER_PREURL WHERE USER_ID = "+"'"+username+"'");
			 ResultSet res5 = db.createStatement()
			            .executeQuery("SELECT PARMS_VALUE FROM ST_ORGAN_PARMS WHERE ORGAN_ID='11610201' AND PARMS_NAME='CONTROL_ADMIN_LOGIN_IP'");
			 ResultSet res6 = db.createStatement()
			            .executeQuery("SELECT PARMS_VALUE FROM ST_ORGAN_PARMS WHERE ORGAN_ID='11610201' AND PARMS_NAME='FORBIDDEN_UNSAFE_PASSWORD'");
			 ResultSet res7 = db.createStatement()
			            .executeQuery("SELECT PARMS_VALUE FROM ST_ORGAN_PARMS WHERE ORGAN_ID='11610201' AND PARMS_NAME='FORBIDDEN_PASSWORD'");
			 ResultSet res8 = db.createStatement()
			            .executeQuery("SELECT PARMS_VALUE FROM ST_ORGAN_PARMS WHERE ORGAN_ID='11610201' AND PARMS_NAME='DUAL_FACTOR_AUTH_ISMG'");
			 ResultSet res9 = db.createStatement()
			            .executeQuery("SELECT UID,USER_KEY,USER_VALUE FROM USER_PROPERTY WHERE UID='11610201#"+username+"'"+" AND USER_KEY='DUAL_FACTOR_AUTH_PHONE'");
			 ResultSet res10 = db.createStatement()
			            .executeQuery("SELECT PARMS_VALUE FROM ST_ORGAN_PARMS WHERE ORGAN_ID='0' AND PARMS_NAME='XSM_DOMAIN'");
			 ResultSet res11 = db.createStatement()
			            .executeQuery("SELECT PARMS_VALUE FROM ST_ORGAN_PARMS WHERE ORGAN_ID='11610201' AND PARMS_NAME='GRAY_SCALE'");
			 ResultSet res12 = db.createStatement()
			            .executeQuery("SELECT UID,USER_KEY,USER_VALUE FROM USER_PROPERTY WHERE USER_PROPERTY.UID = "+"'"+username+"'");
			 ResultSet res13 = db.createStatement()
			            .executeQuery("SELECT PARMS_VALUE FROM ST_ORGAN_PARMS WHERE ORGAN_ID='11610201' AND PARMS_NAME='XSM_VERSION'");
			 ResultSet res14 = db.createStatement()
			            .executeQuery("SELECT PARMS_VALUE FROM ST_ORGAN_PARMS WHERE ORGAN_ID='11610201' AND PARMS_NAME='IS_PWD_EXPIRED_ALERT'");
			 ResultSet res15 = db.createStatement()
			            .executeQuery("SELECT PARMS_VALUE FROM ST_ORGAN_PARMS WHERE ORGAN_ID='11610201' AND PARMS_NAME='IS_NEED_V6'");
		}catch(Exception e){
			System.out.println(e);
		}finally {
			db.close();
		}
	}
}
