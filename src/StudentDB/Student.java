package StudentDB;

public class Student
{
    private String name;
    private int id;
    private int year;


    public void setName(String name)
    {
        this.name = name;
    }

    public void setId(int id)
    {
        this.id = id;
    }

    public void setYear(int year)
    {
        this.year = year;
    }


    public String getName()
    {
        return name;
    }

    public int getId() 
    {
        return id;
    }

    public int getYear()
    {
        return year;
    }
}