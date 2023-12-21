package sv.bank.util;

public class AppConstants {

	private AppConstants() {
	}

	// Code Errors
	public static final Long CODE_SUCCESS = 200L;
	public static final Long CODE_NOT_FOUND = 404L;
	public static final Long CODE_ERROR = 500L;

	public static final Long CODE_ERROR_INTERNAL = 500L;

	// Messages errors
	public static final String MSG_GENERIC_ERROR = "Ocurrio un Error al Consultar Cliente ";
	public static final String MSG_ERROR_INTERNAL = "Ocurrio un Error Procesando la Solicitud";
	public static final String CLIENT_NOT_FOUND = "Cliente No Encontrado, Intenta Con Otro";
	public static final String ID_NOT_FOUND = "ID del cliente no puede ser nulo";
	public static final String ACCOUNT_NULL = "ID de la cuenta no puede ser nulo";

	// Messages responses
	public static final String API_RESPONSE_CODE_OK_VALUE = "Proceso terminado exitosamente";
	public static final String API_RESPONSE_CODE_BAD_REQUEST_VALUE = "Solicitud incorrecta";
	public static final String API_RESPONSE_CODE_CONFLICT_VALUE = "Ocurrio un error realizando consulta";
	public static final String API_RESPONSE_CODE_INTERNAL_SERVER_ERROR_VALUE = "Error interno del servidor";

}
