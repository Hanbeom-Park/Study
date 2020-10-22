#### Exception 처리

------

- business Exception의 경우 로직이 바로 종료되도록 처리해야함

- try catch 의 경우 최대한 예외를 발생시켜 종료

- 리턴 타입을 ResponseEntity\<Error>로 추론하기 쉽도록 해야한다.

  ------

  - ErrorCode를 Enum으로 처리
    - 하나의 파일로 정리를 해서 관리를 쉽게 함
    - 각 도메인별로 에러코드를 관리하는편이 좋음

  ```java
  public enum ErrorCode {
  	...
  	SUCCESS("S00", "성공"),
  	NULL_OBJECT("E01", "데이터 불일치"),
  	NO_DATA("E02", "데이터 불일치"),
  	INVALID_DATA("E10", "잘못된 데이터"),
  	TCP_CLIENT_ERROR("E20", "보험사 연결 오류"),
  	TRASNFORM_ERROR("E30", "데이터 변환 오류"),
  	FIELD_REQUIRED("E40", "필수값 오류"),
  	ECOD_ERROR("E50", "암호화 오류"),
  	...
  	private final String code;
  
  	private final String message;
  	
  	private ErrorCode(String code, String message) {
  		this.code = code;
  		this.message = message;
  	}
  
  	public String getCode() {
  		return code;
  	}
  
  	public String getMessage() {
  		return message;
  	}
  }
  
  ```

  - Business용 Exception 생성

  ```java
  import lombok.Getter;
  
  @Getter
  public class BaseException extends RuntimeException {
  
  	private static final String COLON = ":";
  	private static final String START_TAG = "[";
  	private static final String END_TAG = "]";
  
  	private final ErrorCode errorCode;
  
  	private final Object[] args;
  
  	public BaseException(ErrorCode errorCode, Object... args) {
  		super(makeErrorMessage(errorCode.getMessage(), args));
  		this.errorCode = errorCode;
  		this.args = args;
  	}
  
  	private static String makeErrorMessage(String message, Object... args) {
  		...
  
  		return sb.toString();
  	}
  
  }
  ```

  - @ControllerAdvice 설정
    - 컨트롤러에서 발생하는 에러는 @ControllerAdvice로 오게된다
    - 해당 에러에 맞게 @ExceptionHandler 설정 후 처리

  ```java
  @Slf4j
  @ControllerAdvice
  @RestController
  public class GlobalExceptionHandler {
  
  	@Getter
  	private class ErrorResponse {
  		private String rspnCd;
  		private String rspnInfo;
  
  		public ErrorResponse(String rspnCd, String rspnInfo) {
  			this.rspnCd = rspnCd;
  			this.rspnInfo = rspnInfo;
  		}
  
  		public ErrorResponse(int rspnCd, String rspnInfo) {
  			this(String.valueOf(rspnCd), rspnInfo);
  		}
  	}
  	@ExceptionHandler(value = BaseException.class)
  	public Object handleBaseException(BaseException e) {
  		log.error("", e);
  		return new ErrorResponse(e.getErrorCode().getCode(), e.getMessage());
  	}
  
  	@ExceptionHandler(value = Exception.class)
  	public Object handleException(Exception e) {
  		log.error("", e);
  		return new ErrorResponse(HttpStatus.INTERNAL_SERVER_ERROR.value(), ErrorCode.INTERNAL_SERVER_ERROR.getMessage());
  	}
  
  }
  ```

  - Java Bean Validation
    - 어노테이션을 활용하여 exception  발생 가능

  ```java
  public class User {
   
      @NotNull(message = "Name cannot be null")
      private String name;
   
      @AssertTrue
      private boolean working;
   
      @Size(min = 10, max = 200, message 
        = "About Me must be between 10 and 200 characters")
      private String aboutMe;
   
      @Min(value = 18, message = "Age should not be less than 18")
      @Max(value = 150, message = "Age should not be greater than 150")
      private int age;
   
      @Email(message = "Email should be valid")
      private String email;
   
      // standard setters and getters 
  }
  ```

  
