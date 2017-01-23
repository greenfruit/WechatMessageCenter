import org.junit.Test;

/**
 * <p>DESCRIPTION:  类描述
 * <p>CALLED BY:   zhangshouzheng
 * <p>UPDATE BY:   zhangshouzheng
 * <p>CREATE DATE: 2017/1/23
 * <p>UPDATE DATE: 2017/1/23
 *
 * @version 1.0
 * @since java 1.7.0
 */
public class WetherServiceTest {
    @Test
    public void testWeather(){
//        Status json = WeatherService.getSend("北京");
//        Status status = WeatherService.resolveJsonResult(json);
//        System.out.println(json);
    }
    @Test
    public void testSplitString(){
        String input = "天气北京";
        String cityname = input.split("天气")[0];
        if(cityname.equals("")){
            cityname = input.split("天气")[1];
        }
        System.out.println("cityname:"+cityname);
    }
}
