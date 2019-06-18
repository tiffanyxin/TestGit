package secondweek.demo0520;

/**
 * @author Tiffany_xin
 * @time 2019/5/20  18:54
 */
public class ClassJob {
    public static void main(String[] args) {
        Lady lady = new Lady("angel");
        System.out.println(lady.getLname());

        Dog dog = new Dog( "puppy", "male",3,"Pekingese");
        System.out.println(dog.getDsex());

        Cat cat = new Cat("Tom","female",6,"Bob");
        Cat cats = new Cat();
        System.out.println(cat.getCcategory());

        Human richSecondGeneration = new Human("富二代",21,true,"宝马750");
        richSecondGeneration.introduceBMW();

        SunWuKong sunWuKong = new SunWuKong();
        sunWuKong.removeDemon();
        sunWuKong.takeLonggitude();
        ZhuBaJie zheBaJie = new ZhuBaJie();
        zheBaJie.leadAHorse();
        zheBaJie.eatVegetables();
        ShaMonk shaMonk = new ShaMonk();
        shaMonk.takeLuggage();
        shaMonk.readBuddha();
    }
}
