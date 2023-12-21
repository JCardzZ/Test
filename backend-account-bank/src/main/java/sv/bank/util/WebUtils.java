package sv.bank.util;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

@Component
public class WebUtils {

	public String getHeaderByName(HttpHeaders httpHeaders, String name) {
		String result = null;
		if (httpHeaders == null)
			return result;
		return httpHeaders.toSingleValueMap().get(name);
	}

	public <T> ResponseEntity<T> createCustomizedResponse(T body, Long statusCode) {
		HttpStatus httpStatus = HttpStatus.valueOf(statusCode.intValue());
		if (body == null)
			return new ResponseEntity<>(httpStatus);
		return new ResponseEntity<>(body, httpStatus);
	}

}
