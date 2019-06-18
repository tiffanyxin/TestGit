package thirdweek.demo0528;

/**
 * @author Tiffany_xin
 * @time 2019/5/28  21:20
 */
public class NegativeException extends RuntimeException {
    public NegativeException(){
         super();
    }

    public NegativeException(String message){
        super(message);
    }
}
