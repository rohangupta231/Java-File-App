import java.io.Serializable;
class EmpBean implements Serializable
{
	private int empid;
	private String empname;
	private double empsalary;
	public int getEmpId()
	{
		return this.empid;
	}
	public String getEmpName()
	{
		return this.empname;
	}
	public double getEmpSalary()
	{
		return this.empsalary;
	}
	public void setEmpId(int empid)
	{
		this.empid=empid;
	}
	public void setEmpName(String empname)
	{
		this.empname=empname;
	}
	public void setEmpSalary(double empsalary)
	{
		this.empsalary=empsalary;
	}
}
