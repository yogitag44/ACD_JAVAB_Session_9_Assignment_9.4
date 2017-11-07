import java.util.Comparator;   //comparator class to use the compare the functionality
import java.util.TreeSet;			//treeSet is a collection which is like hashmap but arrange all the element in sorted way
 
 class UserDefineComparator {    //simple class
 
    public static void main(String a[]){   //main class
        //By using name comparator (String comparison)
        TreeSet<EmployeeTest> nameComp = new TreeSet<EmployeeTest>(new MyGenralizedComparator());   //created object of Treeset having value of EmployeeTest class
        
        //Adding elements to the TreeSet using its object created above
        nameComp.add(new EmployeeTest("Ram",3000,"Designer"));   
        nameComp.add(new EmployeeTest("Tom",9400,"Developer"));
        nameComp.add(new EmployeeTest("Crish",2000,"Programmer"));
        nameComp.add(new EmployeeTest("Tom",9400,"Manager"));
        nameComp.add(new EmployeeTest("Suresh",11000,"Developer"));
        nameComp.add(new EmployeeTest("Ajay",3000,"Developer"));
        
        //for loop, till the elements are there in the set of object
        for(EmployeeTest e:nameComp){
            System.out.println(e);   //and printing all the elements one by one
        }
    }
}
 
class MyGenralizedComparator implements Comparator<EmployeeTest>{   //Comparing all the existing elements to sort them in proper way
 
    @Override
    public int compare(EmployeeTest e1, EmployeeTest e2) {   //overriding existing method compare to get two values
           int namecompare =  e1.getName().compareTo(e2.getName());   //integer variable to compare Name
            int salarycompare = e1.getSalary() - e2.getSalary();		//integer variable to compare Salary
        int designationcompare = e1.getDesignation().compareTo(e2.getDesignation()); //integer variable to compare Designation
 
        // 3-level comparison using if-else block
        if(salarycompare == 0) {    //If salary is Zero than return name on top
            return ((namecompare == 0) ? designationcompare : namecompare);
        }
        else {  //else return salary for comparision
            return salarycompare;
        }
    }
}   
 
class EmployeeTest{  // Class to get and set all the properties
     
	//Variable declaration
    private String name;
    private int salary;
    private String designation;
     
    //Three parameter construct of main class EmployeeTest
    public EmployeeTest(String n, int s, String des){
    	
    	//Assigning same variable as above to the constructor
        this.name = n;
        this.salary = s;
        this.designation = des;
    }
     
    //Get and Set method to get all the details of the employee and Return so that they can be set
    
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public int getSalary() {
        return salary;
    }
    public void setSalary(int salary) {
        this.salary = salary;
    }
    public String getDesignation() {
        return designation;
    }
    public void setDesignation(String designation) {
        this.designation = designation;
    }
    public String toString(){   //Final to string method to convert all the data into string
        return "Name: "+this.name+"-- Salary: "+this.salary+"-- Designation: "+this.designation;
    }
}