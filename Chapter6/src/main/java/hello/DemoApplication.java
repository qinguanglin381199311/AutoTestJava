package hello;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller //把我的类，托管到spring当中来，帮我组织一下就行了，我就不管了，这些活都交给你了
@EnableAutoConfiguration //启用Spring应用程序上下文的自动配置，尝试猜测和配置您可能需要的bean
//@ComponentScan("com.cmp.springboot")
//@RestController
public class DemoApplication {

    @RequestMapping("/")
    @ResponseBody
    // @ResponseBody注解的作用是将controller的方法返回的对象通过适当的转换器转换为指定的格式之后，写入到response对象的body区，
    // 通常用来返回JSON数据或者是XML数据，需要注意的呢，
    // 在使用此注解之后不会再走试图处理器，而是直接将数据写入到输入流中，他的效果等同于通过response对象输出指定格式的数据。

    public String getMethodGet() {
        return "Hello,World，man";
    }

    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);

    }
}