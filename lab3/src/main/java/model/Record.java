package model;

public class Record {

    private int id;
    private String stname ;
    private String course ;
    private int fee;


    public Record (int id, String stname, String course, int fee)
    {

        this.id=id;
        this.stname=stname;
        this.course=course;
        this.fee=fee;
    }


    public int GetId()
    {
        return id;
    }

     public void SetId(int id)
    {
        this.id=id;
    }


    public String GetStname()
    {
        return stname;
    }

     public void SetStname(String stname)
    {
        this.stname=stname;
    }

    public String GetCourse()
    {
        return course;
    }

     public void SetCourse(String course)
    {
        this.course=course;
    }


    public int GetFee()
    {
        return fee;
    }

     public void SetFee(int fee)
    {
        this.fee=fee;
    }



    }