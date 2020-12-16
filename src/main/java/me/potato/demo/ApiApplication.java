package me.potato.demo;

import org.eclipse.microprofile.openapi.annotations.OpenAPIDefinition;
import org.eclipse.microprofile.openapi.annotations.info.Contact;
import org.eclipse.microprofile.openapi.annotations.info.Info;
import org.eclipse.microprofile.openapi.annotations.info.License;
import org.eclipse.microprofile.openapi.annotations.tags.Tag;

import javax.ws.rs.core.Application;

@OpenAPIDefinition(
        tags={
                @Tag(name="widget", description="Widget operations."),
                @Tag(name="gasket", description="Operation related to gaskets")
        },
        info=@Info(
                title="Example API",
                version="1.0.1",
                contact=@Contact(
                        name="Example API Support",
                        url="http://example.com/contact",
                        email="help@exanmple.com"
                ),
                license=@License(
                        name="Apache 2.0",
                        url="http://www.apache.org/license/LICENSE-2.0.html")
        )

)
public class ApiApplication extends Application {
}
