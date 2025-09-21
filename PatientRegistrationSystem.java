package project;
import java.util.*;
import java.sql.*;


// PatientDeatils...

class PatientDetails{
	protected String read;
	protected  int PatientID;
	protected String FirstName;
	protected String LastName;
	protected String DOB;
	protected String Gender;
	protected String MobileNumber;
	protected String Email;
	protected String Bloodgroup;
	public String getread() {return read;}
	public void setread(String read) {this.read=read;}
	public int getPatientID() {return PatientID;}
	public void setPatientID(int PatientID) { this.PatientID=PatientID;}
	public String getFirstName() {return FirstName;}
	public void setFirstName(String FirstName) { this.FirstName=FirstName;}
	public String getLastName() {return LastName;}
	public void setLastName(String LastName) { this.LastName=LastName;}
	public String getDOB() {return DOB;}
	public void setDOB(String DOB) { this.DOB=DOB;}
	public String getGender() {return Gender;}
	public void setGender(String Gender) { this.Gender=Gender;}
	public String getMobileNumber() {return MobileNumber;}
	public void setMobileNumber(String MobileNumber) { this.MobileNumber=MobileNumber;}
	public String getEmail() {return Email;}
	public void setEmail(String Email) {this.Email=Email;}
	public String getBloodgroup() {return Bloodgroup;}
	public void setBloodgroup(String Bloodgroup) { this.Bloodgroup=Bloodgroup;}
	
}
//PatientDAO (Patient Data Access)

class PatientDAO{
	final String url="jdbc:mysql://localhost:3306/patientregistrationsystem";
	final String username="root";
	final String password="Naveen@2006";
	
//	PatientDetails Inserting method 
	public void InsertPatientDetails(PatientDetails p)	{
	try { Connection con=DriverManager.getConnection(url, username, password);
	
	String sql="INSERT INTO Patients (PatientID, FirstName, LastName, DOB, Gender, PhoneNumber, Email, BloodGroup) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
	PreparedStatement st=con.prepareStatement(sql);
	st.setInt(1,p.getPatientID());
	st.setString(2,p.getFirstName());
	st.setString(3,p.getLastName());
	st.setString(4,p.getDOB());
	st.setString(5,p.getGender());
	st.setString(6,p.getMobileNumber());
	st.setString(7,p.getEmail());
	st.setString(8,p.getBloodgroup());
    int Rowinserted=st.executeUpdate();
	if(Rowinserted>0) {	System.out.println("Patient Registered Successfully...");	}
	}catch(Exception e) {System.out.println(e);}
    }
//	To delete PatientDetails Method
	public void DeletePatientDetails(PatientDetails p)
	{
		try {Connection con=DriverManager.getConnection(url, username, password);
		String sql="delete  from Patients where PatientID=?";
		PreparedStatement stDelete=con.prepareStatement(sql); 		
		stDelete.setInt(1,p.getPatientID());
		int Rowdeleted=stDelete.executeUpdate();
		if(Rowdeleted>0) {System.out.println("PatientID "+ p.getPatientID()+ " deleted succussfully...");	}
		else {System.out.println("The Patient ID " +p.getPatientID()+" already deleted...");	}
		
		}catch(Exception e) {System.out.println(e);	}
	}
//	To Read the table
//	public void PatientDetails(PatientDetails p) {
//		String sql="select * from ?";
//		try {Connection con=DriverManager.getConnection(url, username, password);
//		PreparedStatement st1=con.prepareStatement(sql);
//		st1.setString(1, p);
//		
//		
//		}catch(Exception e) {
//			System.out.println(e);
//		}
//		
//	}
}

// Patient Registration System Main function
public class PatientRegistrationSystem
{
	
	public static void main(String[] args) 
	{
		// Creating Object for PatientDetails Class
		PatientDetails p=new PatientDetails();		
		// Creating Object for PatientDAO class
		PatientDAO pd=new PatientDAO();		
		Scanner scan=new Scanner(System.in);
		
		
		// Sending Patient Details
		System.out.println("What you want to do [ADD or SEARCH or DELETE or UPDATE or READ]:");
		String input=scan.nextLine();
			
		if(input.equalsIgnoreCase("ADD") || input.equalsIgnoreCase("SEARCH") || input.equalsIgnoreCase("DELETE") || input.equalsIgnoreCase("UPDATE") || input.equalsIgnoreCase("READ"))
		{
			switch(input.toUpperCase()) {
				
				case "ADD":
					System.out.println("Enter PatientID:");
					p.setPatientID(scan.nextInt());
					scan.nextLine();
					System.out.println("Enter your FirstName:");
					p.setFirstName(scan.nextLine());
					System.out.println("Enter your LastName:");
					p.setLastName(scan.nextLine());			
					System.out.println("Enter your DOB:");
					p.setDOB(scan.nextLine());			
					System.out.println("Enter your Gender:");
					p.setGender(scan.nextLine());			
					System.out.println("Enter your Mobile Number:");
					p.setMobileNumber(scan.nextLine());			
					System.out.println("Enter your MailID:");
					p.setEmail(scan.nextLine());		
					System.out.println("Enter your Blood Group:");
					p.setBloodgroup(scan.nextLine());
					pd.InsertPatientDetails(p);
					break;
					
				case "DELETE":
					System.out.println("Enter the Patient ID you want to delete:");
					int delete=scan.nextInt();					
					p.setPatientID(delete);	
					pd.DeletePatientDetails(p);
					break;
					
				case "READ":
					System.out.println("Enter the table you want to read:");
					String Read=scan.nextLine();
					p.setread(Read);
					
					
										
				
			}
		}else {
			System.out.println("Invalid operation...");
		}
						
	}
						
			
			
}
