package member;

import java.util.Scanner;

public class MemberService {
	public void memberMain() {
		MemberDB db = new MemberDB();
		MemberDTO dto = new MemberDTO();
		Scanner sc = new Scanner(System.in);
		int num;
		int result = 0;
		String mem_id, mem_pwd, mem_name, mem_phone;
		
		while(true) {
			System.out.println("** 로그인 및 회원가입 **");
			System.out.println("1. 로그인");
			System.out.println("2. 회원가입");
			System.out.println("3. 회원정보수정");
			System.out.println("4. 회원정보삭제");
			System.out.println("5. 종료");
			System.out.print(">>> ");
			num = sc.nextInt();
			switch(num) {
			case 1 :
				System.out.println("* 로 그 인 *");
				System.out.print("아이디 : ");
				mem_id = sc.next();
				result = db.checkId(mem_id);
				if(result == 1) {
					System.out.print("비밀번호 : ");
					mem_pwd = sc.next();
					result = db.login(mem_id, mem_pwd);
					if(result == 1) {
						System.out.println(mem_id + "님 로그인되셨습니다.");
					} else { System.out.println("비밀번호가 틀렸습니다"); }
				} else {
					System.out.println("없는 아이디입니다. 회원가입부터 진행해주세요");
				}
				
				break;
			case 2 : 
				System.out.println("* 회 원 가 입 *");
				while(true) {
					System.out.print("아이디 : ");
					mem_id = sc.next();
					result = db.checkId(mem_id);
					if(result != 1) { break; }
					System.out.println("중복되는 아이디입니다.");
				}
				System.out.print("비밀번호 : ");
				mem_pwd = sc.next();
				System.out.print("이름 : ");
				mem_name = sc.next();
				System.out.print("전화번호 : ");
				mem_phone = sc.next();
				dto.setMem_id(mem_id); dto.setMem_pwd(mem_pwd);
				dto.setMem_name(mem_name); dto.setMem_phone(mem_phone);
				
				db.insertM(dto);
				System.out.println(dto.getMem_name() + "님 회원가입되셨습니다");
				break;
			case 3 : 
				System.out.println("* 회 원 정 보 수 정 *");
				System.out.print("아이디 : ");
				mem_id = sc.next();
				result = db.checkId(mem_id);
				if(result == 1) {
					System.out.println("1. 비밀번호 수정");
					System.out.println("2. 이름 수정");
					System.out.println("3. 전화번호 수정");
					System.out.println("4. 나가기");
					System.out.print(">>> ");
					num = sc.nextInt();
					if(num == 1) {
						System.out.print("수정할 비밀번호 입력 : ");
						mem_pwd = sc.next();
						db.changePwd(mem_id, mem_pwd);
						System.out.println("비밀번호 수정완료");
					} else if(num == 2) {
						System.out.println("수정할 이름 입력 : ");
						mem_name = sc.next();
						db.changeName(mem_id, mem_name);
						System.out.println("이름 수정완료");
					} else if(num == 3) {
						System.out.println("수정할 전화번호 입력 : ");
						mem_phone = sc.next();
						db.changePhone(mem_id, mem_phone);
						System.out.println("전화번호 수정완료");
					} else if(num == 4) { break; }
				} else { System.out.println("없는 회원입니다"); }
				break;
			case 4 : 
				System.out.println("* 회 원 정 보 삭 제 *");
				System.out.print("아이디 : ");
				mem_id = sc.next();
				result = db.checkId(mem_id);
				if(result == 1) {
					System.out.println("삭제하시겠습니까? 1. yes 2. no");
					System.out.println(">>> ");
					num = sc.nextInt();
					if(num == 1) {
						db.deleteM(mem_id);
						System.out.println(mem_id + "님 삭제되셨습니다");
					} else if(num == 2) {
						System.out.println("삭제취소되셨습니다");
					}
				} else {
					System.out.println("없는 회원입니다.");
				}
				break;
			case 5 : 
				return;
			}
		}
	}
}
