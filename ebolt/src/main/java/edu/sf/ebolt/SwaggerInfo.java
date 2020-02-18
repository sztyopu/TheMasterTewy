package edu.sf.ebolt;

import java.util.Collections;

import org.springframework.context.annotation.Configuration;


import com.sf.springmvc.appinfo.SafApiInfo;
import com.sf.util.ApplicationVersion;
import com.sf.util.Version;

import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;

/**
 * ApiInfo
 *
 * @author vi
 */
@Configuration
public class SwaggerInfo implements SafApiInfo {

	private static final Version VERSION = ApplicationVersion.getVersion(EboltApplication.class, "edu.sf",
			"ebolt");

	@Override
	public ApiInfo apiInfo() {
		final Contact contact = new Contact("Shiwaforce.com Zrt.", "https://www.shiwaforce.com", null);
		return new ApiInfo("SF Ebolt", "To handle SF Human resources", VERSION.toString(), null, contact,
				null, null, Collections.emptyList());
	}

}
