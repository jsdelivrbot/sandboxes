package hello;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
@EnableAspectJAutoProxy
public class Application {

	@Autowired
	private ApplicationContext appContext;

//	@Bean
//	public TestImpl test() {
//		return new TestImpl();
//	}
//
//	@Bean
//	public TestAspect testAspect() {
//		return new TestAspect();
//	}

	@RequestMapping("/")
	public String home(TestImpl test) {
		//TODO: could not get AOP to work when using the constructor injector for this method.  It could
		// be because there is a different context for the beans created by the restcontroller that are
		//then injected into this method, instead of the context where the aspect was loaded.
//		test.testMethod1();
//		test.testMethod2();
		TestImpl impl = appContext.getBean(TestImpl.class);
		impl.testMethod1();
		impl.testMethod2();
		return "Hello Docker World";
	}


	public static void main(String[] args) {
//		AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext();
//		ctx.register(AspectConfig.class);
//		ctx.refresh();
//
//		TestImpl test = ctx.getBean(TestImpl.class);
//		test.testMethod1();

		SpringApplication.run(Application.class, args);
	}
}