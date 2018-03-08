import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.io.*;
class EmpServices
{
	private static ArrayList<EmpBean> al;//Data Layer
	static
	{
		FileInputStream fis=null;
		ObjectInputStream ois=null;
		try
		{
			fis=new FileInputStream("empdetails.txt");
			ois=new ObjectInputStream(fis);//for deserialization
			al=(ArrayList)ois.readObject();
		}
		catch(FileNotFoundException e)
		{
			al=new ArrayList<EmpBean>();
		}
		catch(Exception e)
		{
			System.out.println("Exception "+e);
		}
		finally
		{
			try
			{
				ois.close();
				fis.close();	
			}
			catch(Exception e)
			{
			}
		}
	}
	public static boolean addEmployee(EmpBean objbean)
	{
		if(searchById(objbean.getEmpId())==null)
		{
			al.add(objbean);
			return true;
		}
		return false;	
	}
	public static List getAllEmployees()
	{
		/*List is Interface for array list so can have its object*/
		List temp= Collections.unmodifiableList(al);//unmodifilable list
		return temp;
	}
	public static EmpBean searchById(int id)
	{
		for(int i=0;i<al.size();i++)
		{
			EmpBean objbean=al.get(i);
			if(id==(objbean.getEmpId()))
			{
				return objbean;
			}
		}
		return null;
	}
	public static boolean deleteById(int id)
	{
		EmpBean objbean=searchById(id);
		if(objbean!=null)
		{
			al.remove(objbean);
			return true;
		}
		return false;
	}
	public static boolean onExit()
	{
		FileOutputStream fos=null;
		ObjectOutputStream oos=null;
		try
		{
			fos= new FileOutputStream("empdetails.txt");
			oos= new ObjectOutputStream(fos);//Serialization
			oos.writeObject(al);
			return true;
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
		finally
		{
			try
			{
				oos.close();
				fos.close();
			}
			catch(Exception e)
			{
			}
		}
		return false;
	}
}