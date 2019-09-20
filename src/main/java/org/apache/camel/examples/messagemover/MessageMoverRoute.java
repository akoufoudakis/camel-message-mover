package org.apache.camel.examples.messagemover;

import org.apache.camel.builder.RouteBuilder;
import org.springframework.stereotype.Component;

@Component("msgMover")
public class MessageMoverRoute extends RouteBuilder {

    public void configure() throws Exception {
        from("jms:queue:{{in.queue}}").routeId("msg-mover")
                .log("Message: ${body}")
                .to("jms:queue:{{out.queue}}");
    }

}
