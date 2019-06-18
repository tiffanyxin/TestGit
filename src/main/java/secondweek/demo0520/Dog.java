package secondweek.demo0520;

/**
 * @author Tiffany_xin
 * @time 2019/5/20  19:05
 */
public class Dog {
     private String dname;
     private String dsex;
     private int dage;
     private String dcategory;

     public Dog(String d_name,String d_sex,int d_age,String d_category){
         this.dname = d_name;
         this.dsex = d_sex;
         this.dage = d_age;
         this.dcategory = d_category;
     }

     public String getDname(){
         return dname;
     }

     public void setDname(String dname){
         this.dname = dname;
     }

    public String getDsex() {
        return dsex;
    }

    public void setDsex(String dsex) {
        this.dsex = dsex;
    }

    public int getDage() {
        return dage;
    }

    public void setDage(int dage) {
        this.dage = dage;
    }

    public String getDcategory() {
        return dcategory;
    }

    public void setDcategory(String dcategory) {
        this.dcategory = dcategory;
    }

    //看家
    public void LookAfterHouse(){
        System.out.println("The dog will look after the house!");
    }
    //吃骨头
    public void eatBone(){
        System.out.println("The dog will eat this bone!");
    }
}
