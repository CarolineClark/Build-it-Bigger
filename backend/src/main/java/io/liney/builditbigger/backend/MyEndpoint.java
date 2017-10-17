/*
   For step-by-step instructions on connecting your Android application to this backend module,
   see "App Engine Java Endpoints Module" template documentation at
   https://github.com/GoogleCloudPlatform/gradle-appengine-templates/tree/master/HelloEndpoints
*/

package io.liney.builditbigger.backend;

import com.google.api.server.spi.config.Api;
import com.google.api.server.spi.config.ApiMethod;
import com.google.api.server.spi.config.ApiNamespace;
import com.udacity.gradle.jokes.Joker;

@Api(
        name = "myApi",
        version = "v1",
        namespace = @ApiNamespace(
                ownerDomain = "backend.builditbigger.liney.io",
                ownerName = "backend.builditbigger.liney.io",
                packagePath = ""
        )
)
public class MyEndpoint {

    @ApiMethod(name="joke")
    public MyBean joke() {
        MyBean response = new MyBean();
        response.setData(new Joker().getJoke());
        return response;
    }

}
