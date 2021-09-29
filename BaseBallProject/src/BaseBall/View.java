package BaseBall;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class View {

	public static void main(String[] args) {
		Random ran = new Random();
		Scanner sc = new Scanner(System.in);
		jdbcDao dao = new jdbcDao();

		// 1.로그인, 회원가입, 종료
		boolean toggle = true;
		while (toggle) {
			System.out.print("[1] 로그인 [2] 회원가입 [3] 종료 >> ");
			int choice = sc.nextInt();

			if (choice == 1) {
				System.out.println("===로그인===");
				System.out.print("ID입력: ");
				String id = sc.next();
				System.out.println("PW입력: ");
				String pw = sc.next();

				userVO vo = new userVO(id, pw);
				userVO info = dao.login(vo);

				if (info != null) {
					System.out.println("로그인 성공 :-) ");

					System.out.println("[1] 선수뽑기 [2] 게임시작 >> "); // 저장된 정보를 읽고 버튼 구성
					int dom = sc.nextInt();

					if (dom == 1) { // 로그인 후 "선수 뽑기" 버튼으로 랜덤 5명 타자 정보 불러오기(이름, 능력치)
									// 버튼 다시 출력해서 게임 시작!
					
						
						ArrayList<playerVO> list = new ArrayList<>();
						
						//playerVO vo2 = new playerVO(name, capa, position);

						list = dao.select();
						int index = ran.nextInt();
						
					for(int i = 0; i < 5; i++) {
						ArrayList<playerVO> list2 = new ArrayList<>();
						list2.add(list.get(index));
					}
						
					}

				} else {
					System.out.println("로그인 실패 :-) ");
				}
				// 2. 로그인성공-> 선수 뽑기, 게임시작 버튼 구성
			} else if (choice == 2) {
				System.out.println("===회원가입===");
				System.out.print("ID입력: ");
				String id = sc.next();
				System.out.print("PW입력: ");
				String pw = sc.next();

				userVO vo = new userVO(id, pw);
				int cnt = dao.register(vo);

				if (cnt > 0) {
					System.out.println("회원가입 성공^_^");
				} else {
					System.out.println("회원가입 실패^_^");
				}
			} else if (choice == 3) {
				System.out.println("프로그램을 종료합니다 ^3^");
				sc.close();
				toggle = false;
				break;
			}
		}

		// 3. 게임플레이 및 결과
		// 4. 선수 추가 등록

	}

}
