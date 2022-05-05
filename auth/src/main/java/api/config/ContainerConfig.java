package api.config;

import org.apache.catalina.connector.Connector;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.embedded.tomcat.TomcatServletWebServerFactory;
import org.springframework.boot.web.servlet.server.ServletWebServerFactory;
import org.springframework.context.annotation.Bean;

//■ Apache와 Tomcat을 연동해야 하는 이유
//Tomcat은 WAS 서버이지만 Web 서버의 기능도 갖추고 있는 WAS 서버입니다.
//그러나 톰캣의 Web 서버 기능은 아파치보다 느린 속도처리를 보였고, 이로 인해 정적인 페이지는 Apache가 처리하고, 동적인 페이지를 Tomcat이 처리함으로써 부하를 분산하는 이유에서 Apache와 Tomcat을 연동하였습니다.
//
//그러나 이는 옛날 얘기이고.. 지금은 Tomcat이 많이 발전해 Tomcat 내의 Web 서버가 아파치에 절대 뒤쳐지지
//않을만큼의 역할을 수행합니다.
//그럼에도 불구하고 아직도 Apache와 Tomcat을 연동하여 사용하는 이유는, 아파치 내에서만 설정할 수 있는 부분이라던가 아파치에서 제공하는 유용한 모듈들을 톰캣에서 사용할 수 없기 때문입니다.

public class ContainerConfig {
    @Value("${server.tomcat.ajp.protocol}")
    private String protocol;

    @Value("${server.tomcat.ajp.port}")
    private Integer port;

    @Bean
    public ServletWebServerFactory servletContainer() {
        TomcatServletWebServerFactory tomcat = new TomcatServletWebServerFactory();
        tomcat.addAdditionalTomcatConnectors(createAjpConnector());
        return tomcat;
    }

    private Connector createAjpConnector() {
        Connector ajpConnector = new Connector(protocol);
        ajpConnector.setPort(port);
        ajpConnector.setSecure(false);
        ajpConnector.setAllowTrace(false);
        ajpConnector.setScheme("http");
        return ajpConnector;
    }
}
