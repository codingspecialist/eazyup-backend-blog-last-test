package shop.mtcoding.blogv2;

class MyController {

    MyService myService = new MyService();

    void home(boolean check) {
        try {
            myService.홈가기(check);
        } catch (Exception e) {
            throw new RuntimeException();
        }

    }
}

class MyService {

    MyRepository myRepository = new MyRepository();

    void 홈가기(boolean check) throws RuntimeException {
        System.out.println(1);
        System.out.println(2);
        System.out.println(3);
        System.out.println(4);
        myRepository.findHome(check);
    }
}

class MyRepository {
    void findHome(boolean check) {
        if (check) {
            System.out.println("조회 완료");
        } else {
            throw new RuntimeException("조회 오류");
        }

    }
}

public class HelloTest {

    public static void main(String[] args) {
        MyController myController = new MyController();
        myController.home(false);
    }
}
