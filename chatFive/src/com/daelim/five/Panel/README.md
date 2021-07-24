# 완성본

- 시작전에 오늘 완성할 화면을 보여드리겠습니다

## JAVA의 GUI 클래스 : Swing

**GUI란?** 

- 그래픽 사용자 인터페이스(graphical user interface, GUI)
- 입출력 등의 기능을 알기 쉬운 아이콘 같은 그래픽으로 나타낸 것
- HTML과 같은 화면 구현을 해놓은것

**GUI를 구현하기 위한 도구 Swing**

- Java Swing은 운영체제에 영향을 받지 않고 플랫폼이 독립적이며 가벼운 구성 요소를 제공

![https://s3-us-west-2.amazonaws.com/secure.notion-static.com/40047eb8-984e-4974-80c4-31d08acdaf1f/Untitled.png](https://s3-us-west-2.amazonaws.com/secure.notion-static.com/40047eb8-984e-4974-80c4-31d08acdaf1f/Untitled.png)

![https://s3-us-west-2.amazonaws.com/secure.notion-static.com/06881efa-66ad-4afe-8200-39500f2bfd85/Untitled.png](https://s3-us-west-2.amazonaws.com/secure.notion-static.com/06881efa-66ad-4afe-8200-39500f2bfd85/Untitled.png)

### 실습

- 새로운 프로젝트 생성
- Create project from template 체크
- 프로젝트 name : chatFive1
- Base Packeage : com.daelim.five1

- 새로운 패키지 Panel 생성 ( com.daelim.five1.Panel )
- 새로운 클래스 LoginPanel 생성
- extends 키워드 사용 // 다른 클래스 파일을 상속 받음
    - 상속의 주체 = 부모클래스 // 상속받는 클래스 = 자식클래스
    - 자식 클래스는 부모 클래스의 기능을 마음대로 사용할 수 있음
- JPanel 을 상속받음

✨**JPanel 이란?**

- 조각난 프레임으로 생각하면 됨
- 레이아웃 적용과 UI 배치들을 모두 할 수 있음
- 쉽게말해 버튼, 입력창, 화면 창등의 기능을 제공하는 부모 클래스

### 실습2

- 먼저 가벼운 변수 선언으로 시작
    - public String line = "";
    - 접근제어자 : 접근권한, 변수를 사용하는 패키지,클래스,메서드 어디에서나 직접 접근할 수 있는 권한부여하는것과 같음
    - 변수 타입: 문자열을 담는다
    - 변수명
    - 변수값
- 기본 생성자 만들기
    - 생성자란 객체를 생성할 때 항상 실행되는 것으로, 객체를 초기화해주기 위해 맨 처음 실행되는것
    - 🎉객체를 생성한다는것은 실습3에서 알아보겠습니다!🎉
- 생성자 채우기

    ```jsx
    public LoginPanel() {
            JFrame f = new JFrame();

            f.getContentPane().setBackground(Color.ORANGE);
            f.setSize(500, 500);
            f.setLayout(null);
            f.setVisible(true);
        }
    ```

    [JFrame](https://www.notion.so/319cfdfb7061416d94768da0ff7fe7dc)

    ### 실습3

    - 메서드 setView() 생성
    -