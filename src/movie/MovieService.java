package movie;

import java.util.ArrayList;
import java.util.Scanner;

import member.MemberDB;
import ticket.TicketDB;
import ticket.TicketDTO;
import ticket.TicketService;

public class MovieService {
	public void movieMain() {
		MovieDB db = new MovieDB();
		MemberDB mdb = new MemberDB();
		TicketDB tdb = new TicketDB();
		MovieDTO dto = new MovieDTO();
		TicketDTO tdto = new TicketDTO();
		TicketService ts = new TicketService();
		Scanner sc = new Scanner(System.in);
		int num;
		String mov_name, mov_place, mem_id, mem_pwd;
		ArrayList<MovieDTO> list;
		
		while(true) {
			System.out.println("** 영 화 예 매 **");
			System.out.println("1. 영화예매");
			System.out.println("2. 영화예매확인 및 취소");
			System.out.println("3. 나가기");
			System.out.print(">>> ");
			num = sc.nextInt();
			switch(num) {
			case 1 :
				System.out.println("* 영화예매 *");
				list = db.movieList();
				for(MovieDTO d : list) {
					System.out.println("----------------");
					System.out.println("영화제목 : " + d.getMov_name());
					System.out.println("영화시간 : " + d.getMov_time());
					System.out.println("영화장소/지역 : " + d.getMov_place() + "/" + d.getMov_area());
					System.out.println("영화좌석 : " + d.getMov_seat() + "석");
				}
				System.out.println("----------------");
				System.out.print("예매할 영화 제목 : ");
				mov_name = sc.next();
				list = db.choiceM(mov_name);
				if(list.size() == 0) { System.out.println("없는 영화제목입니다"); break;}
				for(MovieDTO d : list) {
					System.out.println("----------------");
					System.out.println("영화시간 : " + d.getMov_time());
					System.out.println("영화장소/지역 : " + d.getMov_place() + "/" + d.getMov_area());
					System.out.println("영화좌석 : " + d.getMov_seat() + "석");
				}
				System.out.println("----------------");
				System.out.print("영화 장소 선택 : ");
				mov_place = sc.next();
				list = db.pickM(mov_name, mov_place);
				if(list.size() == 0) { System.out.println("잘못입력"); break; }
				for(MovieDTO d : list) {
					System.out.println("----------------");
					System.out.println("영화제목 : " + d.getMov_name());
					System.out.println("영화시간 : " + d.getMov_time());
					System.out.println("영화장소/지역 : " + d.getMov_place() + "/" + d.getMov_area());					
				}
				System.out.println("----------------");
				System.out.println("영화를 예매하시겠습니까?");
				System.out.println("1. 네 2. 아니오");
				System.out.print(">>> ");
				num = sc.nextInt();
				if(num == 1) {
					System.out.print("아이디 입력 : ");
					mem_id = sc.next();
					System.out.print("비밀번호 입력 : ");
					mem_pwd = sc.next();
					int result = mdb.login(mem_id, mem_pwd);
					if(result == 1) {
						System.out.println("예매완료");
						tdto.setTic_id(mem_id);
						list = db.pickM(mov_name, mov_place);
						for(MovieDTO d : list) {
							tdto.setTic_name(d.getMov_name());
							tdto.setTic_time(d.getMov_time());
							tdto.setTic_place(d.getMov_place());
							tdto.setTic_area(d.getMov_area());
							d.setMov_seat((d.getMov_seat())-1);
							db.seatCount(d);
						}
						tdb.ticketing(tdto);
					} else {
						System.out.println("아이디 또는 비번이 다릅니다");
						break;
					}
				} else if(num == 2) { break; }
				
				break;
			case 2 : 
				ts.ticketMain();
				break;
			case 3 : 
				return;
			}
		}
	}
}
