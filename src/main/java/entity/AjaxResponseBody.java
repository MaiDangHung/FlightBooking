
package entity;

import org.codehaus.jackson.map.annotate.JsonView;


public class AjaxResponseBody {
        @JsonView(Views.Public.class)
	String msg;

}
