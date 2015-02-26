package mongodb;
import java.net.UnknownHostException;
import java.util.List;

import com.mongodb.*;

public class MongoDBJDBC {
	
	public static void insertdata(){
		
		
	}
	

	public static void main(String[] args)  {
		// TODO Auto-generated method stub
		
		try {
		MongoClient client = new MongoClient ("10.0.0.55", 27017);
		DB db= client.getDB("mydb");
		boolean auth= db.authenticate("rajesh", "Chicago2014".toCharArray()) ;
		
		  // MongoClientURI uri  = new MongoClientURI("mongodb://rajesh:Chicago2014@10.0.0.55:27017/mydb"); 
	      // client = new MongoClient(uri);
	      // DB db = client.getDB(uri.getDatabase());
		 System.out.println("connected to mydb data base -->> " + db.getName());
		 
		 DBCollection emp = db.getCollection("emp");
		 System.out.println(" \n collection name -->> " + emp.getName());
		 System.out.println(" \n connectionpoint name -->> " +client.getConnectPoint().toString() );
		 List<String> dbs =client.getDatabaseNames();
		 for(String databases : dbs){
			 
			 System.out.println(" \n data base name -->> " + databases );
			 
		 }
		
		 
		 BasicDBObject nineties = new BasicDBObject();
		 nineties.put("fname", "fdsf");
		 nineties.put("lname", "mklopo"); 
		 nineties.put("emp_id", 11);
		 emp.insert(nineties);
		 System.out.println("\n --- inserted data into emp collection --- ");
		 
		 BasicDBObject findquery = new BasicDBObject("emp_id", new BasicDBObject("$gte",1));
		 DBCursor docs = emp.find(findquery);
		 System.out.println(" \n got the findquery results");
		 
		 while(docs.hasNext()){
	            DBObject doc = docs.next();
	            System.out.println(
	                 doc.get("fname") + " | " + doc.get("lname") + " | " + doc.get("emp_id") + " \n " 
	            );
	        }
		 
		 
		
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		


	}

}
