import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.util.List;
class EmpMain
{
	public static void main(String dt[])
	{
		InputStreamReader isr=null;
		BufferedReader br=null;
		try 
		{
			isr=new InputStreamReader(System.in);
			br=new BufferedReader(isr);
			do
			{
				System.out.println("");
				System.out.println("1. Add Record");
				System.out.println("2. List All");
				System.out.println("3. Search by ID");
				System.out.println("4. Update By ID");
				System.out.println("5. Delete by ID");
				System.out.println("6. Exit");
				System.out.println("\nEnter Your Choice(1-6)=");
				String choice=br.readLine();
				if(choice.equals(""))
				{
					throw new Exception("Kuch toh daal le Marjaneya!!!");
				}
				switch(choice)
				{
					case "1":
					{
						System.out.println("Enter Id");
						int id=Integer.parseInt(br.readLine());
						System.out.println("Enter Name");
						String name=br.readLine();
						System.out.println("Enter Salary");
						double salary=Double.parseDouble(br.readLine());
						EmpBean objbean=new EmpBean();
						objbean.setEmpId(id);
						objbean.setEmpName(name);
						objbean.setEmpSalary(salary);
						if(EmpServices.addEmployee(objbean))
						{
							System.out.println("Record Inserted Successfully");
						}
						else
						{
							System.out.println("Result Not inserted");
						}
						break;
					}
					case "2":
					{	
						List al=EmpServices.getAllEmployees();
						if(al.size()==0)
						{
							System.out.println("||No Record Found");
						}
						else
						{
							for(int i=0;i<al.size();i++)
							{
								EmpBean objbean=(EmpBean)al.get(i);
								System.out.println("||Id= "+objbean.getEmpId());
								System.out.println("||Name= "+objbean.getEmpName());
								System.out.println("||Salary= "+objbean.getEmpSalary());
								System.out.println("------------------------");		
							}
							System.out.println(al.size()+". Record Found!!");
						}
						break;
					}
					case "3":
					{
						System.out.println("Enter Id= ");
						int id=Integer.parseInt(br.readLine());
						EmpBean objbean=EmpServices.searchById(id);
						if(objbean==null)
						{
							System.out.println("No Such Id!!!");
						}
						else 
						{
							System.out.println("Id ="+objbean.getEmpId());
							System.out.println("Name ="+objbean.getEmpName());
							System.out.println("Salary ="+objbean.getEmpSalary());
						}
						break;
					}
					case "4":
					{
						System.out.print("Enter id =");
						int id=Integer.parseInt(br.readLine());
						EmpBean objbean=EmpServices.searchById(id);
						if(objbean==null)
						{
							System.out.println("No Such Record Exist");
						}
						else
						{
							System.out.println("Id ="+objbean.getEmpId());
							System.out.println("Name ="+objbean.getEmpName());
							System.out.println("Salary ="+objbean.getEmpSalary());
							System.out.println("Enter Updated Name =");
							objbean.setEmpName(br.readLine());
							System.out.println("Enter Updated  Salary");
							objbean.setEmpSalary(Double.parseDouble(br.readLine()));
							System.out.println("Record Updated Successfully");
						}
						break;
					}
					case "5":
					{
						System.out.println("Enter ID");
						int id=Integer.parseInt(br.readLine());
						if(EmpServices.deleteById(id))
						{
							System.out.println("Record Deleted Successfully");
						}
						else
						{
							System.out.println("No Such Record");
						}
						break;
					}	
					case "6":
					{
						if(EmpServices.onExit())
						{
							System.out.println("Data Saved Successfully");
						}	
						else
						{
							System.out.println("Data lost for current Session");
						}
						System.out.println("\nThank You!");
						System.exit(0);
					}
					default:
					{
						System.out.println("Invalid choice,Please Try Again");
					}
				}
			}while(true);
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
		finally
		{
			try
			{
				br.close();
				isr.close();
			}
			catch(Exception e)
			{
				System.out.println(e);
			}
		}
	}
}