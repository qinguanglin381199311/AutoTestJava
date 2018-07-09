import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication //把这个类托管到SpringBootApplication中
@ComponentScan("com.cmp") //意思就是你要扫描哪个组件（也就是说要扫描哪个包下的类）
public class Application {

    public static void main(String[] args){
        SpringApplication.run(Application.class,args); //固定写法
    }
}
