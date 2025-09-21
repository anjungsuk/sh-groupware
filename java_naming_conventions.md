# Java Naming Conventions

자바 표준 네이밍 컨벤션은 코드의 가독성과 유지보수성을 높이기 위해 반드시 지켜야 하는 규칙입니다. 이 문서는 클래스, 메서드, 변수, 상수, 패키지 등 자바 주요 요소들의 명명 규칙을 정리한 것입니다.

---

## 1. 패키지 (Package)
- **모두 소문자** 사용
- 일반적으로 도메인 이름을 역순으로 사용
- 예시:
  ```java
  com.company.project.module
  org.springframework.boot
  ```

---

## 2. 클래스 (Class)
- **파스칼 케이스 (PascalCase)** 사용
- 명사 혹은 명사구 형태로 작성
- 예시:
  ```java
  public class UserAccount {}
  public class OrderService {}
  ```

---

## 3. 인터페이스 (Interface)
- **파스칼 케이스 (PascalCase)** 사용
- 보통 형용사 또는 능력을 나타내는 단어 사용
- 예시:
  ```java
  public interface Serializable {}
  public interface Runnable {}
  ```

---

## 4. 메서드 (Method)
- **카멜 케이스 (camelCase)** 사용
- 동사 혹은 동사구 형태로 작성
- 예시:
  ```java
  public void calculateTotal() {}
  public String getUserName() {}
  ```

---

## 5. 변수 (Variable)
- **카멜 케이스 (camelCase)** 사용
- 짧고 의미 있는 이름 사용
- 예시:
  ```java
  int userAge;
  String customerName;
  ```

---

## 6. 상수 (Constant)
- **모두 대문자 + 언더스코어(_)** 사용
- 예시:
  ```java
  public static final int MAX_USERS = 100;
  public static final String DEFAULT_LANGUAGE = "ko";
  ```

---

## 7. 열거형 (Enum)
- **파스칼 케이스 (PascalCase)**로 Enum 타입명 작성
- Enum 상수는 **모두 대문자** 사용
- 예시:
  ```java
  public enum Status {
      ACTIVE,
      INACTIVE,
      PENDING
  }
  ```

---

## 8. 제네릭 타입 변수 (Generic Type Parameter)
- 단일 대문자 사용
- 관례적으로 다음을 사용:
  - `T` → Type
  - `E` → Element
  - `K` → Key
  - `V` → Value
  - `N` → Number
- 예시:
  ```java
  public interface List<E> {}
  public class HashMap<K, V> {}
  ```

---

## 9. 테스트 클래스 (Test Class)
- 대상 클래스명 + `Test`
- 예시:
  ```java
  public class UserServiceTest {}
  ```

---

## 10. 기타 규칙
- 불필요한 약어 사용 지양 (`CustInfo` ❌ → `CustomerInfo` ✅)
- 약어는 **전부 대문자**가 아닌 경우, 첫 글자만 대문자로 사용 (`HttpRequest` ✅, `HTTPRequest` ❌)
- boolean 변수는 `is`, `has`, `can` 등으로 시작 (`isActive`, `hasPermission`, `canExecute`)

---

## 참고
- [Oracle Java Code Conventions](https://www.oracle.com/java/technologies/javase/codeconventions-contents.html)
- [Effective Java (Joshua Bloch)]

